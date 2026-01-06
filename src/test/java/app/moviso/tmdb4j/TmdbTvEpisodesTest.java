package app.moviso.tmdb4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.moviso.tmdb4j.model.core.AccountStates;
import app.moviso.tmdb4j.model.core.responses.ResponseStatus;
import app.moviso.tmdb4j.model.core.video.VideoResults;
import app.moviso.tmdb4j.model.tv.core.ChangeResults;
import app.moviso.tmdb4j.model.tv.core.Translations;
import app.moviso.tmdb4j.model.tv.episode.EpisodeCredits;
import app.moviso.tmdb4j.model.tv.episode.ExternalIds;
import app.moviso.tmdb4j.model.tv.episode.Images;
import app.moviso.tmdb4j.model.tv.episode.TvEpisodeDb;
import app.moviso.tmdb4j.testutil.AbstractJsonMappingValidator;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import app.moviso.tmdb4j.tools.TmdbResponseCode;
import app.moviso.tmdb4j.tools.appendtoresponse.TvEpisodesAppendToResponse;
import app.moviso.tmdb4j.util.JsonUtil;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbTvEpisodes.TMDB_METHOD_TV_EPISODE;
import static app.moviso.tmdb4j.TmdbTvSeasons.TMDB_METHOD_TV_SEASON;
import static app.moviso.tmdb4j.TmdbTvSeries.TMDB_METHOD_TV;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbTvEpisodes}.
 */
public class TmdbTvEpisodesTest extends AbstractTmdbApiTest<TmdbTvEpisodes> {
    @Override
    public TmdbTvEpisodes createApiToTest() {
        return getTmdbApi().getTvEpisodes();
    }

    /**
     * Tests {@link TmdbTvEpisodes#getDetails(int, int, int, String, TvEpisodesAppendToResponse...)} with an expected result.
     */
    @Test
    public void testGetDetails() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episodes/details.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/123/" + TMDB_METHOD_TV_SEASON + "/1/" + TMDB_METHOD_TV_EPISODE +
            "/1?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        TvEpisodeDb tvEpisode = getApiToTest().getDetails(123, 1, 1, "en-US");
        assertNotNull(tvEpisode);

        AbstractJsonMappingValidator abstractJsonMappingValidator = new AbstractJsonMappingValidator(tvEpisode);
        List<String> filteredModel = new ArrayList<>();
        filteredModel.add("app.moviso.tmdb4j.model.tv.episode.TvEpisodeDb.accountStates");
        filteredModel.add("app.moviso.tmdb4j.model.tv.episode.TvEpisodeDb.credits");
        filteredModel.add("app.moviso.tmdb4j.model.tv.episode.TvEpisodeDb.externalIds");
        filteredModel.add("app.moviso.tmdb4j.model.tv.episode.TvEpisodeDb.images");
        filteredModel.add("app.moviso.tmdb4j.model.tv.episode.TvEpisodeDb.translations");
        filteredModel.add("app.moviso.tmdb4j.model.tv.episode.TvEpisodeDb.videos");

        abstractJsonMappingValidator.validateNullFields(filteredModel);
        abstractJsonMappingValidator.validateEmptyCollections();
        abstractJsonMappingValidator.validateNullContainingCollection();
        abstractJsonMappingValidator.validateEmptyMaps();
        abstractJsonMappingValidator.validateNullContainingMaps();
        abstractJsonMappingValidator.validateNewItems();
    }

    /**
     * Tests {@link TmdbTvEpisodes#getDetails(int, int, int, String, TvEpisodesAppendToResponse...)} with an expected result,
     * with append to response.
     */
    @Test
    public void testGetDetailsWithAppendToResponse() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episodes/details_with_append_to_response.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/123/" + TMDB_METHOD_TV_SEASON + "/1/" + TMDB_METHOD_TV_EPISODE +
            "/1?language=en-US&append_to_response=account_states%2Ccredits%2Cexternal_ids%2Cimages%2Ctranslations%2Cvideos";

        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        TvEpisodeDb tvEpisode = getApiToTest().getDetails(123, 1, 1, "en-US", TvEpisodesAppendToResponse.values());
        assertNotNull(tvEpisode);
        validateAbstractJsonMappingFields(tvEpisode);
    }

    /**
     * Tests {@link TmdbTvEpisodes#getAccountStates(int, int, int, String, String)} with an expected result.
     */
    @Test
    public void testGetAccountStates() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episodes/account_states.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/123/" + TMDB_METHOD_TV_SEASON + "/1/" + TMDB_METHOD_TV_EPISODE +
            "/1/account_states";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        AccountStates accountStates = getApiToTest().getAccountStates(123, 1, 1, null, null);
        assertNotNull(accountStates);
        validateAbstractJsonMappingFields(accountStates);
    }

    /**
     * Tests {@link TmdbTvEpisodes#getChanges(int)} with an expected result.
     */
    @Test
    public void testGetChanges() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episodes/changes.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/" + TMDB_METHOD_TV_EPISODE + "/1/changes";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ChangeResults changeResults = getApiToTest().getChanges(1);
        assertNotNull(changeResults);
        validateAbstractJsonMappingFields(changeResults);
    }

    /**
     * Tests {@link TmdbTvEpisodes#getCredits(int, int, int, String)} with an expected result.
     */
    @Test
    public void testGetCredits() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episodes/credits.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/123/" + TMDB_METHOD_TV_SEASON + "/1/" + TMDB_METHOD_TV_EPISODE +
            "/1/credits?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        EpisodeCredits credits = getApiToTest().getCredits(123, 1, 1, "en-US");
        assertNotNull(credits);
        validateAbstractJsonMappingFields(credits);
    }

    /**
     * Tests {@link TmdbTvEpisodes#getExternalIds(int, int, int)} with an expected result.
     */
    @Test
    public void testGetExternalIds() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episodes/external_ids.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/123/" + TMDB_METHOD_TV_SEASON + "/1/" + TMDB_METHOD_TV_EPISODE +
            "/1/external_ids";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ExternalIds externalIds = getApiToTest().getExternalIds(123, 1, 1);
        assertNotNull(externalIds);
        validateAbstractJsonMappingFields(externalIds);
    }

    /**
     * Tests {@link TmdbTvEpisodes#getImages(int, int, int, String, String...)} with an expected result.
     */
    @Test
    public void testGetImages() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episodes/images.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/123/" + TMDB_METHOD_TV_SEASON + "/1/" + TMDB_METHOD_TV_EPISODE +
            "/1/images?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        Images images = getApiToTest().getImages(123, 1, 1, "en-US");
        assertNotNull(images);
        validateAbstractJsonMappingFields(images);
    }

    /**
     * Tests {@link TmdbTvEpisodes#getTranslations(int, int, int)} with an expected result.
     */
    @Test
    public void testGetTranslations() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episodes/translations.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/123/" + TMDB_METHOD_TV_SEASON + "/1/" + TMDB_METHOD_TV_EPISODE +
            "/1/translations";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        Translations translations = getApiToTest().getTranslations(123, 1, 1);
        assertNotNull(translations);
        validateAbstractJsonMappingFields(translations);
    }

    /**
     * Tests {@link TmdbTvEpisodes#getVideos(int, int, int, String, String...)} with an expected result.
     */
    @Test
    public void testGetVideos() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episodes/videos.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/123/" + TMDB_METHOD_TV_SEASON + "/1/" + TMDB_METHOD_TV_EPISODE +
            "/1/videos?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        VideoResults videoResults = getApiToTest().getVideos(123, 1, 1, "en-US");
        assertNotNull(videoResults);
        validateAbstractJsonMappingFields(videoResults);
    }

    /**
     * Tests {@link TmdbTvEpisodes#addRating(int, int, int, String, String, double)} with an expected result.
     */
    @Test
    public void testAddRating() throws IOException, TmdbException {
        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("value", 2.1);
        String jsonBody = JsonUtil.toJson(requestBody);

        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/123/" + TMDB_METHOD_TV_SEASON + "/1/" + TMDB_METHOD_TV_EPISODE +
            "/1/rating";
        String body = TestUtils.readTestFile("api_responses/tv_episodes/add_rating.json");
        when(getTmdbUrlReader().readUrl(url, jsonBody, RequestType.POST)).thenReturn(body);

        ResponseStatus responseStatus = getApiToTest().addRating(123, 1, 1, null, null, 2.1);
        assertNotNull(responseStatus);
        validateAbstractJsonMappingFields(responseStatus);
        assertEquals(TmdbResponseCode.SUCCESS, responseStatus.getStatusCode());
    }

    /**
     * Tests {@link TmdbTvEpisodes#deleteRating(int, int, int, String, String)} with an expected result.
     */
    @Test
    public void testDeleteRating() throws IOException, TmdbException {
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV + "/123/" + TMDB_METHOD_TV_SEASON + "/1/" + TMDB_METHOD_TV_EPISODE +
            "/1/rating";
        String body = TestUtils.readTestFile("api_responses/tv_episodes/delete_rating.json");
        when(getTmdbUrlReader().readUrl(url, null, RequestType.DELETE)).thenReturn(body);

        ResponseStatus responseStatus = getApiToTest().deleteRating(123, 1, 1, null, null);
        assertNotNull(responseStatus);
        validateAbstractJsonMappingFields(responseStatus);
        assertEquals(TmdbResponseCode.ITEM_DELETED, responseStatus.getStatusCode());
    }
}
