package app.moviso.tmdb4j;

import java.io.IOException;

import app.moviso.tmdb4j.model.core.popularperson.PopularPersonResultsPage;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbPeopleLists.TMDB_METHOD_PEOPLE_LISTS;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbPeopleLists}.
 */
public class TmdbPeopleListsTest extends AbstractTmdbApiTest<TmdbPeopleLists> {
    @Override
    public TmdbPeopleLists createApiToTest() {
        return getTmdbApi().getPeopleLists();
    }

    /**
     * Test {@link TmdbPeopleLists#getPopular(String, Integer)} with an expected result.
     */
    @Test
    public void testGetPopular() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/people_lists/popular.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PEOPLE_LISTS + "?language=en-US&page=1";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        PopularPersonResultsPage popularPersonResultsPage = getApiToTest().getPopular("en-US", 1);
        assertNotNull(popularPersonResultsPage);
        validateAbstractJsonMappingFields(popularPersonResultsPage);
    }
}
