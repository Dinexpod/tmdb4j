package app.moviso.tmdb4j;

import java.io.IOException;

import app.moviso.tmdb4j.model.core.MovieResultsPage;
import app.moviso.tmdb4j.model.core.TvSeriesResultsPage;
import app.moviso.tmdb4j.model.core.multi.MultiResultsPage;
import app.moviso.tmdb4j.model.core.popularperson.PopularPersonResultsPage;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import app.moviso.tmdb4j.tools.model.time.TimeWindow;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbTrending.TMDB_METHOD_TRENDING;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbTrending}.
 */
public class TmdbTrendingTest extends AbstractTmdbApiTest<TmdbTrending> {
    @Override
    public TmdbTrending createApiToTest() {
        return getTmdbApi().getTrending();
    }

    /**
     * Tests {@link TmdbTrending#getAll(TimeWindow, String)} with an expected result.
     */
    @Test
    public void testGetAll() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/trending/all.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TRENDING + "/all/week?language=en-US&page=1";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MultiResultsPage allResults = getApiToTest().getAll(TimeWindow.WEEK, "en-US");
        assertNotNull(allResults);
        validateAbstractJsonMappingFields(allResults);
    }

    /**
     * Tests {@link TmdbTrending#getMovies(TimeWindow, String)} with an expected result.
     */
    @Test
    public void testGetMovies() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/trending/movies.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TRENDING + "/movie/week?language=en-US&page=1";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieResultsPage movieResults = getApiToTest().getMovies(TimeWindow.WEEK, "en-US");
        assertNotNull(movieResults);
        validateAbstractJsonMappingFields(movieResults);
    }

    /**
     * Tests {@link TmdbTrending#getPeople(TimeWindow, String)} with an expected result.
     */
    @Test
    public void testGetPeople() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/trending/people.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TRENDING + "/person/week?language=en-US&page=1";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        PopularPersonResultsPage peopleResults = getApiToTest().getPeople(TimeWindow.WEEK, "en-US");
        assertNotNull(peopleResults);
        validateAbstractJsonMappingFields(peopleResults);
    }

    /**
     * Tests {@link TmdbTrending#getTv(TimeWindow, String)} with an expected result.
     */
    @Test
    public void testGetTv() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/trending/tv.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TRENDING + "/tv/week?language=en-US&page=1";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        TvSeriesResultsPage tvResults = getApiToTest().getTv(TimeWindow.WEEK, "en-US");
        assertNotNull(tvResults);
        validateAbstractJsonMappingFields(tvResults);
    }
}
