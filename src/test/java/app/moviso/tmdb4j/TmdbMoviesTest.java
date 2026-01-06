package app.moviso.tmdb4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.moviso.tmdb4j.model.core.AccountStates;
import app.moviso.tmdb4j.model.core.MovieResultsPage;
import app.moviso.tmdb4j.model.core.ReviewResultsPage;
import app.moviso.tmdb4j.model.core.responses.ResponseStatus;
import app.moviso.tmdb4j.model.core.video.VideoResults;
import app.moviso.tmdb4j.model.core.watchproviders.ProviderResults;
import app.moviso.tmdb4j.model.movies.AlternativeTitles;
import app.moviso.tmdb4j.model.movies.Credits;
import app.moviso.tmdb4j.model.movies.ExternalIds;
import app.moviso.tmdb4j.model.movies.Images;
import app.moviso.tmdb4j.model.movies.KeywordResults;
import app.moviso.tmdb4j.model.movies.MovieDb;
import app.moviso.tmdb4j.model.movies.MovieListResultsPage;
import app.moviso.tmdb4j.model.movies.ReleaseDateResults;
import app.moviso.tmdb4j.model.movies.Translations;
import app.moviso.tmdb4j.model.movies.changes.ChangeResults;
import app.moviso.tmdb4j.testutil.AbstractJsonMappingValidator;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import app.moviso.tmdb4j.tools.TmdbResponseCode;
import app.moviso.tmdb4j.tools.appendtoresponse.MovieAppendToResponse;
import app.moviso.tmdb4j.util.JsonUtil;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbMovies.TMDB_METHOD_MOVIE;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbMovies}.
 */
public class TmdbMoviesTest extends AbstractTmdbApiTest<TmdbMovies> {
    @Override
    public TmdbMovies createApiToTest() {
        return getTmdbApi().getMovies();
    }

    /**
     * Tests {@link TmdbMovies#getDetails(int, String, MovieAppendToResponse...)} with an expected result.
     */
    @Test
    public void testGetDetails() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/details.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieDb movie = getApiToTest().getDetails(123, "en-US");
        assertNotNull(movie);

        AbstractJsonMappingValidator abstractJsonMappingValidator = new AbstractJsonMappingValidator(movie);
        List<String> filteredModel = new ArrayList<>();
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.accountStates");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.alternativeTitles");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.credits");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.changes");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.externalIds");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.images");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.keywords");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.recommendations");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.releaseDates");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.lists");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.reviews");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.similar");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.translations");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.videos");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.watchProviders");

        abstractJsonMappingValidator.validateNullFields(filteredModel);
        abstractJsonMappingValidator.validateEmptyCollections();
        abstractJsonMappingValidator.validateNullContainingCollection();
        abstractJsonMappingValidator.validateEmptyMaps();
        abstractJsonMappingValidator.validateNullContainingMaps();
        abstractJsonMappingValidator.validateNewItems();
    }

    /**
     * Tests {@link TmdbMovies#getDetails(int, String, MovieAppendToResponse...)} with appended responses, with an expected result.
     */
    @Test
    public void testGetDetailsWithAppendToResponse() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/details_with_append_to_response.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123?language=en-US&append_to_response=account_states%2C" +
            "alternative_titles%2Ccredits%2Cchanges%2Cexternal_ids%2Cimages%2Ckeywords%2Clists%2Crecommendations%2Crelease_dates%2C" +
            "reviews%2Csimilar%2Ctranslations%2Cvideos%2Cwatch%2Fproviders";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieDb movie = getApiToTest().getDetails(123, "en-US", MovieAppendToResponse.values());
        assertNotNull(movie);
        validateAbstractJsonMappingFields(movie);
    }

    /**
     * Tests {@link TmdbMovies#getAccountStates(int, String, String)} with an expected result.
     */
    @Test
    public void testGetAccountStates() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/account_states.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/account_states?session_id=123";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        AccountStates accountStates = getApiToTest().getAccountStates(123, "123", null);
        assertNotNull(accountStates);
        validateAbstractJsonMappingFields(accountStates);
    }

    /**
     * Tests {@link TmdbMovies#getAccountStates(int, String, String)} with an expected result.
     */
    @Test
    public void testGetAlternativeTitles() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/alternative_titles.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/alternative_titles?country=US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        AlternativeTitles alternativeTitles = getApiToTest().getAlternativeTitles(123, "US");
        assertNotNull(alternativeTitles);
        validateAbstractJsonMappingFields(alternativeTitles);
    }

    /**
     * Tests {@link TmdbMovies#getChanges(int, String, String, Integer)} with an expected result.
     */
    @Test
    public void testGetChanges() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/changes.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/changes";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ChangeResults changeResults = getApiToTest().getChanges(123, null, null, null);
        assertNotNull(changeResults);
        validateAbstractJsonMappingFields(changeResults);
    }

    /**
     * Tests {@link TmdbMovies#getCredits(int, String)} with an expected result.
     */
    @Test
    public void testGetCredits() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/credits.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/credits?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        Credits credits = getApiToTest().getCredits(123, "en-US");
        assertNotNull(credits);
        validateAbstractJsonMappingFields(credits);
    }

    /**
     * Tests {@link TmdbMovies#getExternalIds(int)} with an expected result.
     */
    @Test
    public void testGetExternalIds() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/external_ids.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/external_ids";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ExternalIds externalIds = getApiToTest().getExternalIds(123);
        assertNotNull(externalIds);
        validateAbstractJsonMappingFields(externalIds);
    }

    /**
     * Tests {@link TmdbMovies#getImages(int, String, String...)} with an expected result.
     */
    @Test
    public void testGetImages() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/images.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/images?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        Images images = getApiToTest().getImages(123, "en-US");
        assertNotNull(images);
        validateAbstractJsonMappingFields(images);
    }

    /**
     * Tests {@link TmdbMovies#getKeywords(int)} with an expected result.
     */
    @Test
    public void testGetKeywords() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/keywords.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/keywords";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        KeywordResults keywords = getApiToTest().getKeywords(123);
        assertNotNull(keywords);
        validateAbstractJsonMappingFields(keywords);
    }

    /**
     * Tests {@link TmdbMovies#getLatest()} with an expected result.
     */
    @Test
    public void testGetLatest() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/latest.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/latest";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieDb movie = getApiToTest().getLatest();
        assertNotNull(movie);

        AbstractJsonMappingValidator abstractJsonMappingValidator = new AbstractJsonMappingValidator(movie);
        List<String> filteredModel = new ArrayList<>();
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.accountStates");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.alternativeTitles");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.credits");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.changes");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.externalIds");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.images");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.keywords");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.recommendations");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.releaseDates");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.lists");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.reviews");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.similar");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.translations");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.videos");
        filteredModel.add("app.moviso.tmdb4j.model.movies.MovieDb.watchProviders");

        abstractJsonMappingValidator.validateNullFields(filteredModel);
        abstractJsonMappingValidator.validateEmptyCollections();
        abstractJsonMappingValidator.validateNullContainingCollection();
        abstractJsonMappingValidator.validateEmptyMaps();
        abstractJsonMappingValidator.validateNullContainingMaps();
        abstractJsonMappingValidator.validateNewItems();
    }

    /**
     * Tests {@link TmdbMovies#getLists(int, String, Integer)} with an expected result.
     */
    @Test
    public void testGetLists() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/lists.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/lists?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieListResultsPage lists = getApiToTest().getLists(123, "en-US", null);
        assertNotNull(lists);
        validateAbstractJsonMappingFields(lists);
    }

    /**
     * Tests {@link TmdbMovies#getRecommendations(int, String, Integer)} with an expected result.
     */
    @Test
    public void testGetRecommendations() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/recommendations.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/recommendations?language=en-US&page=1";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieResultsPage recommendations = getApiToTest().getRecommendations(123, "en-US", 1);
        assertNotNull(recommendations);
        validateAbstractJsonMappingFields(recommendations);
    }

    /**
     * Tests {@link TmdbMovies#getReleaseDates(int)} with an expected result.
     */
    @Test
    public void testGetReleaseDates() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/release_dates.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/release_dates";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ReleaseDateResults releaseDates = getApiToTest().getReleaseDates(123);
        assertNotNull(releaseDates);
        validateAbstractJsonMappingFields(releaseDates);
    }

    /**
     * Tests {@link TmdbMovies#getReviews(int, String, Integer)} with an expected result.
     */
    @Test
    public void testGetReviews() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/reviews.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/reviews?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ReviewResultsPage reviews = getApiToTest().getReviews(123, "en-US", null);
        assertNotNull(reviews);
        validateAbstractJsonMappingFields(reviews);
    }

    /**
     * Tests {@link TmdbMovies#getSimilar(int, String, Integer)} with an expected result.
     */
    @Test
    public void testGetSimilar() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/similar.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/similar?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieResultsPage similar = getApiToTest().getSimilar(123, "en-US", null);
        assertNotNull(similar);
        validateAbstractJsonMappingFields(similar);
    }

    /**
     * Tests {@link TmdbMovies#getTranslations(int)} with an expected result.
     */
    @Test
    public void testGetTranslations() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/translations.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/translations";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        Translations translations = getApiToTest().getTranslations(123);
        assertNotNull(translations);
        validateAbstractJsonMappingFields(translations);
    }

    /**
     * Tests {@link TmdbMovies#getVideos(int, String)} with an expected result.
     */
    @Test
    public void testGetVideos() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/videos.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/videos?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        VideoResults videos = getApiToTest().getVideos(123, "en-US");
        assertNotNull(videos);
        validateAbstractJsonMappingFields(videos);
    }

    /**
     * Tests {@link TmdbMovies#getWatchProviders(int)} with an expected result.
     */
    @Test
    public void testGetWatchProviders() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movies/watch_providers.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/watch/providers";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ProviderResults watchProviders = getApiToTest().getWatchProviders(123);
        assertNotNull(watchProviders);
        validateAbstractJsonMappingFields(watchProviders);
    }

    /**
     * Tests {@link TmdbMovies#addRating(int, String, String, double)} with an expected result.
     */
    @Test
    public void testAddRating() throws IOException, TmdbException {
        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("value", 2.1);
        String jsonBody = JsonUtil.toJson(requestBody);

        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/rating";
        String body = TestUtils.readTestFile("api_responses/movies/add_rating.json");
        when(getTmdbUrlReader().readUrl(url, jsonBody, RequestType.POST)).thenReturn(body);

        ResponseStatus responseStatus = getApiToTest().addRating(123, null, null, 2.1);
        assertNotNull(responseStatus);
        validateAbstractJsonMappingFields(responseStatus);
        assertEquals(TmdbResponseCode.SUCCESS, responseStatus.getStatusCode());
    }

    /**
     * Tests {@link TmdbMovies#deleteRating(int, String, String)} with an expected result.
     */
    @Test
    public void testDeleteRating() throws IOException, TmdbException {
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE + "/123/rating";
        String body = TestUtils.readTestFile("api_responses/movies/delete_rating.json");
        when(getTmdbUrlReader().readUrl(url, null, RequestType.DELETE)).thenReturn(body);

        ResponseStatus responseStatus = getApiToTest().deleteRating(123, null, null);
        assertNotNull(responseStatus);
        validateAbstractJsonMappingFields(responseStatus);
        assertEquals(TmdbResponseCode.ITEM_DELETED, responseStatus.getStatusCode());
    }
}
