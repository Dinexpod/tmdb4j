package app.moviso.tmdb4j;

import java.io.IOException;
import java.util.List;

import app.moviso.tmdb4j.model.core.MovieResultsPage;
import app.moviso.tmdb4j.model.core.TvSeriesResultsPage;
import app.moviso.tmdb4j.model.core.multi.Multi;
import app.moviso.tmdb4j.model.core.multi.MultiMovie;
import app.moviso.tmdb4j.model.core.multi.MultiPerson;
import app.moviso.tmdb4j.model.core.multi.MultiResultsPage;
import app.moviso.tmdb4j.model.core.multi.MultiTvSeries;
import app.moviso.tmdb4j.model.core.popularperson.PopularPersonResultsPage;
import app.moviso.tmdb4j.model.search.CollectionResultsPage;
import app.moviso.tmdb4j.model.search.CompanyResultsPage;
import app.moviso.tmdb4j.model.search.KeywordResultsPage;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbSearch}.
 */
public class TmdbTvSearchTest extends AbstractTmdbApiTest<TmdbSearch> {
    @Override
    public TmdbSearch createApiToTest() {
        return getTmdbApi().getSearch();
    }

    /**
     * Tests {@link TmdbSearch#searchCollection(String, String, Boolean, Integer, String)} with an expected result.
     */
    @Test
    public void testSearchCollection() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/search/collection.json");
        String url = TMDB_API_BASE_URL + "search/collection?query=batman&language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        CollectionResultsPage collectionResultsPage = getApiToTest().searchCollection("batman", "en-US", null, null, null);
        assertNotNull(collectionResultsPage);
        validateAbstractJsonMappingFields(collectionResultsPage);
    }

    /**
     * Tests {@link TmdbSearch#searchCompany(String, Integer)} with an expected result.
     */
    @Test
    public void testSearchCompany() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/search/company.json");
        String url = TMDB_API_BASE_URL + "search/company?query=amici+films";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        CompanyResultsPage companyResultsPage = getApiToTest().searchCompany("amici films", null);
        assertNotNull(companyResultsPage);
        validateAbstractJsonMappingFields(companyResultsPage);
    }

    /**
     * Tests {@link TmdbSearch#searchKeyword(String, Integer)} with an expected result.
     */
    @Test
    public void testSearchKeyword() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/search/keyword.json");
        String url = TMDB_API_BASE_URL + "search/keyword?query=autograph";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        KeywordResultsPage keywordResultsPage = getApiToTest().searchKeyword("autograph", null);
        assertNotNull(keywordResultsPage);
        validateAbstractJsonMappingFields(keywordResultsPage);
    }

    /**
     * Tests {@link TmdbSearch#searchMovie(String, Boolean, String, String, Integer, String, String)} with an expected result.
     */
    @Test
    public void testSearchMovie() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/search/movie.json");
        String url = TMDB_API_BASE_URL + "search/movie?query=batman&language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieResultsPage movieResultsPage = getApiToTest().searchMovie("batman", null, "en-US", null, null, null, null);
        assertNotNull(movieResultsPage);
        validateAbstractJsonMappingFields(movieResultsPage);
    }

    /**
     * Tests {@link TmdbSearch#searchMulti(String, Boolean, String, Integer)} with an expected result.
     */
    @Test
    public void testSearchMulti() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/search/multi.json");
        String url = TMDB_API_BASE_URL + "search/multi?query=batman&language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MultiResultsPage multiResultsPage = getApiToTest().searchMulti("batman", null, "en-US", null);
        assertNotNull(multiResultsPage);
        validateAbstractJsonMappingFields(multiResultsPage);

        List<Multi> results = multiResultsPage.getResults();
        Multi multiMovie = results.get(0);
        assertNotNull(multiMovie);
        assertEquals(Multi.MediaType.MOVIE, multiMovie.getMediaType());
        validateAbstractJsonMappingFields((MultiMovie) multiMovie);

        Multi multiTv = results.get(1);
        assertNotNull(multiTv);
        assertEquals(Multi.MediaType.TV_SERIES, multiTv.getMediaType());
        validateAbstractJsonMappingFields((MultiTvSeries) multiTv);

        Multi multiPerson = results.get(2);
        assertNotNull(multiPerson);
        assertEquals(Multi.MediaType.PERSON, multiPerson.getMediaType());
        validateAbstractJsonMappingFields((MultiPerson) multiPerson);
    }

    /**
     * Tests {@link TmdbSearch#searchPerson(String, Boolean, String, Integer)} with an expected result.
     */
    @Test
    public void testSearchPerson() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/search/person.json");
        String url = TMDB_API_BASE_URL + "search/person?query=vin&language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        PopularPersonResultsPage personResultsPage = getApiToTest().searchPerson("vin", null, "en-US", null);
        assertNotNull(personResultsPage);
        validateAbstractJsonMappingFields(personResultsPage);
    }

    /**
     * Tests {@link TmdbSearch#searchTv(String, Integer, Boolean, String, Integer, Integer)} with an expected result.
     */
    @Test
    public void testSearchTv() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/search/tv.json");
        String url = TMDB_API_BASE_URL + "search/tv?query=batman&language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        TvSeriesResultsPage tvSeriesResultsPage = getApiToTest().searchTv("batman", null, null, "en-US", null, null);
        assertNotNull(tvSeriesResultsPage);
        validateAbstractJsonMappingFields(tvSeriesResultsPage);
    }
}
