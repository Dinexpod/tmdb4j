package app.moviso.tmdb4j;

import java.io.IOException;

import app.moviso.tmdb4j.model.rated.RatedMovieResultsPage;
import app.moviso.tmdb4j.model.rated.RatedTvEpisodeResultsPage;
import app.moviso.tmdb4j.model.rated.RatedTvSeriesResultsPage;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import app.moviso.tmdb4j.tools.sortby.AccountSortBy;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbGuestSessions.TMDB_METHOD_GUEST_SESSIONS;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbGuestSessions}.
 */
public class TmdbGuestSessionsTest extends AbstractTmdbApiTest<TmdbGuestSessions> {
    @Override
    public TmdbGuestSessions createApiToTest() {
        return getTmdbApi().getGuestSessions();
    }

    /**
     * Tests the {@link TmdbGuestSessions#getRatedMovies(int, String, Integer, AccountSortBy)} with an expected result.
     */
    @Test
    public void testGetRatedMovies() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/guest_sessions/rated_movies.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_GUEST_SESSIONS + "/1/rated/movies?language=en&page=1&sort_by=created_at.desc";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        RatedMovieResultsPage ratedMovieResultsPage = getApiToTest().getRatedMovies(1, "en", 1, AccountSortBy.CREATED_AT_DESC);
        assertNotNull(ratedMovieResultsPage);
        validateAbstractJsonMappingFields(ratedMovieResultsPage);
    }

    /**
     * Tests the {@link TmdbGuestSessions#getRatedTvSeries(int, String, Integer, AccountSortBy)} with an expected result.
     */
    @Test
    public void testGetRatedTvSeries() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/guest_sessions/rated_tv.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_GUEST_SESSIONS + "/1/rated/tv?language=en&page=1&sort_by=created_at.desc";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        RatedTvSeriesResultsPage ratedTvSeriesResultsPage = getApiToTest().getRatedTvSeries(1, "en", 1, AccountSortBy.CREATED_AT_DESC);
        assertNotNull(ratedTvSeriesResultsPage);
        validateAbstractJsonMappingFields(ratedTvSeriesResultsPage);
    }

    /**
     * Tests the {@link TmdbGuestSessions#getRatedTvEpisodes(int, String, Integer, AccountSortBy)} with an expected result.
     */
    @Test
    public void testGetRatedTvEpisodes() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/guest_sessions/rated_tv_episodes.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_GUEST_SESSIONS +
            "/1/rated/tv/episodes?language=en&page=1&sort_by=created_at.desc";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        RatedTvEpisodeResultsPage ratedTvEpisodesResultsPage = getApiToTest().getRatedTvEpisodes(1, "en", 1,
            AccountSortBy.CREATED_AT_DESC);
        assertNotNull(ratedTvEpisodesResultsPage);
        validateAbstractJsonMappingFields(ratedTvEpisodesResultsPage);
    }
}
