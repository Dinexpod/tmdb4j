package app.moviso.tmdb4j;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import app.moviso.tmdb4j.model.configuration.Configuration;
import app.moviso.tmdb4j.model.configuration.Country;
import app.moviso.tmdb4j.model.configuration.Job;
import app.moviso.tmdb4j.model.configuration.Timezone;
import app.moviso.tmdb4j.model.core.Language;
import app.moviso.tmdb4j.tools.ApiUrl;
import app.moviso.tmdb4j.tools.TmdbException;

/**
 * The movie database api for configuration. See the
 * <a href="https://developer.themoviedb.org/reference/configuration-details">documentation</a> for more info.
 */
public class TmdbConfiguration extends AbstractTmdbApi {
    protected static final String TMDB_METHOD_CONFIGURATION = "configuration";

    /**
     * Create a new TmdbConfig instance to call the config related TMDb API methods.
     */
    TmdbConfiguration(TmdbApi tmdbApi) {
        super(tmdbApi);
    }

    /**
     * <p>Query the API configuration details.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/configuration-details">documentation</a> for more info.</p>
     *
     * @return The configuration details
     * @throws TmdbException If there was an error making the request or mapping the response.
     */
    public Configuration getDetails() throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_CONFIGURATION);
        return mapJsonResult(apiUrl, Configuration.class);
    }

    /**
     * <p>Get the list of countries (ISO 3166-1 tags) used throughout TMDB.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/configuration-countries">documentation</a> for more info.</p>
     *
     * @param language nullable - The language to query the results in. Default: en-US.
     * @return The configuration details
     * @throws TmdbException If there was an error making the request or mapping the response.
     */
    public List<Country> getCountries(String language) throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_CONFIGURATION, "countries")
            .addLanguage(language);
        return mapJsonResult(apiUrl, new TypeReference<>() {
        });
    }

    /**
     * <p>Get the list of jobs and departments we use on TMDb.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/configuration-jobs">documentation</a> for more info.</p>
     *
     * @return The list of jobs and departments
     * @throws TmdbException If there was an error making the request or mapping the response.
     */
    public List<Job> getJobs() throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_CONFIGURATION, "jobs");
        return mapJsonResult(apiUrl, new TypeReference<>() {
        });
    }

    /**
     * <p>Get the list of languages (ISO 639-1 tags) used throughout TMDB.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/configuration-languages">documentation</a> for more info.</p>
     *
     * @return The list of languages
     * @throws TmdbException If there was an error making the request or mapping the response.
     */
    public List<Language> getLanguages() throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_CONFIGURATION, "languages");
        return mapJsonResult(apiUrl, new TypeReference<>() {
        });
    }

    /**
     * <p>Get the list of languages (ISO 639-1 tags) used throughout TMDB.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/configuration-primary-translations">documentation</a>
     * for more info.</p>
     *
     * @return The list of languages
     * @throws TmdbException If there was an error making the request or mapping the response.
     */
    public List<String> getPrimaryTranslations() throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_CONFIGURATION, "primary_translations");
        return mapJsonResult(apiUrl, new TypeReference<>() {
        });
    }

    /**
     * <p>Get the list of timezones used throughout TMDB.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/configuration-timezones">documentation</a> for more info.</p>
     *
     * @return The list of timezones
     * @throws TmdbException If there was an error making the request or mapping the response.
     */
    public List<Timezone> getTimezones() throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_CONFIGURATION, "timezones");
        return mapJsonResult(apiUrl, new TypeReference<>() {
        });
    }
}
