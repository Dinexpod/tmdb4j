package app.moviso.tmdb4j;

import app.moviso.tmdb4j.model.find.FindResults;
import app.moviso.tmdb4j.tools.ApiUrl;
import app.moviso.tmdb4j.tools.TmdbException;
import app.moviso.tmdb4j.tools.model.time.ExternalSource;

/**
 * The movie database api for find. See the
 * <a href="https://developer.themoviedb.org/reference/find-by-id">documentation</a> for more info.
 */
public class TmdbFind extends AbstractTmdbApi {
    protected static final String TMDB_METHOD_FIND = "find";

    /**
     * Create a new TmdbFind instance to call the find related TMDb API methods.
     */
    TmdbFind(TmdbApi tmdbApi) {
        super(tmdbApi);
    }

    /**
     * <p>Find data by external ID's.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/find-by-id">documentation</a> for more info.</p>
     *
     * @param externalId     The external id of the movie, TV show or people.
     * @param externalSource The external source of the id.
     * @param language       nullable - The language to query the results in. Default: en-US.
     * @return The find results
     */
    public FindResults findById(String externalId, ExternalSource externalSource, String language) throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_FIND, externalId)
            .addPathParam("external_source", externalSource.getValue())
            .addLanguage(language);
        return mapJsonResult(apiUrl, FindResults.class);
    }
}
