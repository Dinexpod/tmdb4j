package app.moviso.tmdb4j.tools;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import app.moviso.tmdb4j.model.core.responses.TmdbResponseException;
import lombok.AllArgsConstructor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to make requests to the movie database api.
 */
@AllArgsConstructor
public class TmdbHttpClient implements TmdbUrlReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(TmdbHttpClient.class);

    private static final int MAX_ATTEMPTS = 3;

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .build();

    private final String apiKey;

    @Override
    public String readUrl(String url, String jsonBody, RequestType requestType) throws TmdbResponseException {
        LOGGER.debug("TMDB API: making request, of type: {}, to: {}", requestType, url);

        TmdbResponseException lastException = new TmdbResponseException(
                "TMDB request failed after " + MAX_ATTEMPTS + " attempts"
        );

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            try {
                TmdbHttpResponse response = sendRequest(url, jsonBody, requestType);
                String responseBody = response.body() == null ? "" : response.body();
                boolean jsonResponse = isJsonResponse(response);

                if (jsonResponse) {
                    return responseBody;
                }

                if (isTransient(response.statusCode()) && attempt < MAX_ATTEMPTS) {
                    sleepBeforeRetry(attempt);
                    continue;
                }

                lastException = new TmdbResponseException(buildNonJsonResponseMessage(response, responseBody));
                break;
            }
            catch (IOException exception) {
                lastException = new TmdbResponseException(exception);
                if (attempt < MAX_ATTEMPTS) {
                    try {
                        sleepBeforeRetry(attempt);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                        throw new TmdbResponseException(interruptedException);
                    }
                    continue;
                }

                break;
            }
            catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                throw new TmdbResponseException(exception);
            }
        }

        throw lastException;
    }

    private TmdbHttpResponse sendRequest(String url, String jsonBody, RequestType requestType) throws IOException {
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json");

        switch (requestType) {
            case GET -> requestBuilder.get();
            case POST -> requestBuilder.post(RequestBody.create(jsonBody == null ? "" : jsonBody, JSON));
            case DELETE -> requestBuilder.delete();
            default -> throw new RuntimeException("Invalid request type: " + requestType);
        }

        try (Response response = HTTP_CLIENT.newCall(requestBuilder.build()).execute()) {
            ResponseBody responseBody = response.body();
            String body = responseBody == null ? "" : responseBody.string();
            String contentType = response.header("Content-Type");

            return new TmdbHttpResponse(response.code(), contentType == null ? "" : contentType, body);
        }
    }

    private boolean isJsonResponse(TmdbHttpResponse response) {
        String body = response.body();
        if (body == null || body.isBlank()) {
            return false;
        }

        String contentType = response.contentType();

        return contentType.toLowerCase(Locale.ROOT).contains("application/json") || looksLikeJson(body);
    }

    private boolean looksLikeJson(String body) {
        String trimmed = body.trim();
        return trimmed.startsWith("{") || trimmed.startsWith("[");
    }

    private boolean isTransient(int statusCode) {
        return statusCode == 429 || statusCode == 500 || statusCode == 502 || statusCode == 503 || statusCode == 504;
    }

    private void sleepBeforeRetry(int attempt) throws InterruptedException {
        long backoffMillis = attempt * 500L;
        LOGGER.info("TMDB API: transient non-JSON response. Waiting {} ms before retrying.", backoffMillis);
        Thread.sleep(backoffMillis);
    }

    private String buildNonJsonResponseMessage(TmdbHttpResponse response, String responseBody) {
        return "TMDB returned non-JSON response. HTTP status=" + response.statusCode()
                + ", Content-Type=" + response.contentType()
                + ", Body preview=" + preview(responseBody);
    }

    private String preview(String body) {
        String oneLineBody = body.replaceAll("\\s+", " ").trim();
        if (oneLineBody.length() <= 500) {
            return oneLineBody;
        }

        return oneLineBody.substring(0, 500);
    }

    private record TmdbHttpResponse(int statusCode, String contentType, String body) {
    }
}
