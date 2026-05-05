package app.moviso.tmdb4j;

import app.moviso.tmdb4j.model.credits.CreditDetails;
import app.moviso.tmdb4j.tools.ApiUrl;
import app.moviso.tmdb4j.tools.TmdbException;

/**
 * The movie database api for credit details. See the
 * <a href="https://developer.themoviedb.org/reference/credit-details">documentation</a> for more info.
 */
public class TmdbCredits extends AbstractTmdbApi {
    protected static final String TMDB_METHOD_CREDIT = "credit";

    /**
     * Create a new TmdbCredits instance to call the credit related TMDb API methods.
     */
    TmdbCredits(TmdbApi tmdbApi) {
        super(tmdbApi);
    }

    /**
     * <p>Get a movie or TV credit details by ID.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/credit-details">documentation</a> for more info.</p>
     *
     * @param creditId The credit id.
     * @param language nullable - The language to query the results in. Default: en-US.
     * @return The credit details.
     * @throws TmdbException If there was an error making the request or mapping the response.
     */
    public CreditDetails getDetails(String creditId, String language) throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_CREDIT, creditId)
            .addLanguage(language);
        return mapJsonResult(apiUrl, CreditDetails.class);
    }
}
