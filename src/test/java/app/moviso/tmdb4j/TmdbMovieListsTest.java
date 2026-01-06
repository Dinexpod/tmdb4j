package app.moviso.tmdb4j;

import java.io.IOException;

import app.moviso.tmdb4j.model.core.MovieResultsPage;
import app.moviso.tmdb4j.model.movielists.MovieResultsPageWithDates;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbMovieLists.TMDB_METHOD_MOVIE_LISTS;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbMovieLists}.
 */
public class TmdbMovieListsTest extends AbstractTmdbApiTest<TmdbMovieLists> {
    @Override
    public TmdbMovieLists createApiToTest() {
        return getTmdbApi().getMovieLists();
    }

    /**
     * Test {@link TmdbMovieLists#getNowPlaying(String, Integer, String)} with an expected result.
     */
    @Test
    public void testGetNowPlaying() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movie_lists/now_playing.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE_LISTS + "/now_playing?language=en-US&page=1";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieResultsPageWithDates movieResultsPageWithDates = getApiToTest().getNowPlaying("en-US", 1, null);
        assertNotNull(movieResultsPageWithDates);
        validateAbstractJsonMappingFields(movieResultsPageWithDates);
    }

    /**
     * Test {@link TmdbMovieLists#getPopular(String, Integer, String)} with an expected result.
     */
    @Test
    public void testGetPopular() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movie_lists/popular.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE_LISTS + "/popular?language=en-US&page=1";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieResultsPage movieResultsPage = getApiToTest().getPopular("en-US", 1, null);
        assertNotNull(movieResultsPage);
        validateAbstractJsonMappingFields(movieResultsPage);
    }

    /**
     * Test {@link TmdbMovieLists#getTopRated(String, Integer, String)} with an expected result.
     */
    @Test
    public void testGetTopRated() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movie_lists/top_rated.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE_LISTS + "/top_rated?language=en-US&page=1";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieResultsPage movieResultsPage = getApiToTest().getTopRated("en-US", 1, null);
        assertNotNull(movieResultsPage);
        validateAbstractJsonMappingFields(movieResultsPage);
    }

    /**
     * Test {@link TmdbMovieLists#getUpcoming(String, Integer, String)} with an expected result.
     */
    @Test
    public void testGetUpcoming() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/movie_lists/upcoming.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE_LISTS + "/upcoming?language=en-US&page=1";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieResultsPageWithDates movieResultsPageWithDates = getApiToTest().getUpcoming("en-US", 1, null);
        assertNotNull(movieResultsPageWithDates);
        validateAbstractJsonMappingFields(movieResultsPageWithDates);
    }
}
