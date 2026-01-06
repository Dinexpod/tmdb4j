package app.moviso.tmdb4j;

import java.util.List;

import app.moviso.tmdb4j.model.collections.CollectionInfo;
import app.moviso.tmdb4j.model.collections.Images;
import app.moviso.tmdb4j.model.collections.Translation;
import app.moviso.tmdb4j.model.collections.Translations;
import app.moviso.tmdb4j.tools.ApiUrl;
import app.moviso.tmdb4j.tools.TmdbException;

/**
 * The movie database api for collections. See the
 * <a href="https://developer.themoviedb.org/reference/collection-details">documentation</a> for more info.
 */
public class TmdbCollections extends AbstractTmdbApi {
    protected static final String TMDB_METHOD_COLLECTION = "collection";

    /**
     * Create a new TmdbCollections instance to call the collections related TMDb API methods.
     */
    TmdbCollections(TmdbApi tmdbApi) {
        super(tmdbApi);
    }

    /**
     * <p>Get collection details by ID.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/collection-details">documentation</a> for more info.</p>
     *
     * @param collectionId The collection id.
     * @param language     nullable - The language to query the results in. Default: en-US.
     * @return The collection info.
     * @throws TmdbException If there was an error making the request or mapping the response.
     */
    public CollectionInfo getDetails(Integer collectionId, String language) throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_COLLECTION, collectionId)
            .addLanguage(language);
        return mapJsonResult(apiUrl, CollectionInfo.class);
    }

    /**
     * <p>Get the images that belong to a collection.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/collection-images">documentation</a> for more info.</p>
     *
     * @param collectionId         The collection id.
     * @param language             nullable - The language to query the results in. Default: en-US.
     * @param includeImageLanguage nullable - Specify a comma separated list of ISO-639-1 values to query, for example: en,it
     * @return The images.
     * @throws TmdbException If there was an error making the request or mapping the response.
     */
    public Images getImages(Integer collectionId, String language, String... includeImageLanguage) throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_COLLECTION, collectionId, "images")
            .addLanguage(language)
            .addQueryParamCommandSeparated("include_image_language", includeImageLanguage);
        return mapJsonResult(apiUrl, Images.class);
    }

    /**
     * <p>Get all translations for a collection.</p>
     * <p>See the <a href="https://developer.themoviedb.org/reference/collection-translations">documentation</a> for more info.</p>
     *
     * @param collectionId The collection id.
     * @return The translations.
     * @throws TmdbException If there was an error making the request or mapping the response.
     */
    public List<Translation> getTranslations(Integer collectionId) throws TmdbException {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_COLLECTION, collectionId, "translations");
        return mapJsonResult(apiUrl, Translations.class).getTranslations();
    }
}
