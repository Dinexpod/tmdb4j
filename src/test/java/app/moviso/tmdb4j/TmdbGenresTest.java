package app.moviso.tmdb4j;

import java.io.IOException;
import java.util.List;

import app.moviso.tmdb4j.model.core.Genre;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbGenre.TMDB_METHOD_GENRE;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbGenre}.
 */
public class TmdbGenresTest extends AbstractTmdbApiTest<TmdbGenre> {
    @Override
    public TmdbGenre createApiToTest() {
        return getTmdbApi().getGenre();
    }

    /**
     * Tests {@link TmdbGenre#getMovieList(String)} with an expected result.
     */
    @Test
    public void testGetMovieList() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/genres/movie_list.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_GENRE + "/movie/list?language=en";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        List<Genre> genres = getApiToTest().getMovieList("en");
        assertNotNull(genres);
        assertFalse(genres.isEmpty());

        Genre genre = genres.get(0);
        assertNotNull(genre);
        validateAbstractJsonMappingFields(genre);
    }

    /**
     * Tests {@link TmdbGenre#getTvList(String)} with an expected result.
     */
    @Test
    public void testGetTvList() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/genres/tv_list.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_GENRE + "/tv/list?language=en";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        List<Genre> genres = getApiToTest().getTvList("en");
        assertNotNull(genres);
        assertFalse(genres.isEmpty());

        Genre genre = genres.get(0);
        assertNotNull(genre);
        validateAbstractJsonMappingFields(genre);
    }
}
