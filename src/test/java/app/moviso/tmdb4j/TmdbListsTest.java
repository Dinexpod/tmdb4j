package app.moviso.tmdb4j;

import java.io.IOException;
import java.util.HashMap;

import app.moviso.tmdb4j.model.core.responses.ResponseStatus;
import app.moviso.tmdb4j.model.lists.ListDetails;
import app.moviso.tmdb4j.model.lists.ListItemStatus;
import app.moviso.tmdb4j.model.lists.MovieListCreationStatus;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import app.moviso.tmdb4j.tools.TmdbResponseCode;
import app.moviso.tmdb4j.util.JsonUtil;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbLists.TMDB_METHOD_LIST;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbLists}.
 */
public class TmdbListsTest extends AbstractTmdbApiTest<TmdbLists> {
    @Override
    public TmdbLists createApiToTest() {
        return getTmdbApi().getLists();
    }

    /**
     * Tests {@link TmdbLists#addMovie(Integer, String, Integer)} with an expected result.
     */
    @Test
    public void testAddMovie() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/lists/add_movie.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_LIST + "/123/add_item?session_id=testSessionId";

        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("media_id", 456);
        String jsonBody = JsonUtil.toJson(requestBody);

        when(getTmdbUrlReader().readUrl(url, jsonBody, RequestType.POST)).thenReturn(body);

        ResponseStatus responseStatus = getApiToTest().addMovie(123, "testSessionId", 456);
        assertNotNull(responseStatus);
        validateAbstractJsonMappingFields(responseStatus);
        assertEquals(TmdbResponseCode.ITEM_UPDATED, responseStatus.getStatusCode());
    }

    /**
     * Tests {@link TmdbLists#checkItemStatus(Integer, String, Integer)} with an expected result.
     */
    @Test
    public void testCheckItemStatus() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/lists/check_item_status.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_LIST + "/123/item_status?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ListItemStatus listItemStatus = getApiToTest().checkItemStatus(123, "en-US", null);
        assertNotNull(listItemStatus);
        validateAbstractJsonMappingFields(listItemStatus);
    }

    /**
     * Tests {@link TmdbLists#clear(Integer, String, Boolean)} with an expected result.
     */
    @Test
    public void testClear() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/lists/clear.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_LIST + "/123/clear?session_id=testSessionId&confirm=true";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.POST)).thenReturn(body);

        ResponseStatus responseStatus = getApiToTest().clear(123, "testSessionId", true);
        assertNotNull(responseStatus);
        validateAbstractJsonMappingFields(responseStatus);
        assertEquals(TmdbResponseCode.ITEM_UPDATED, responseStatus.getStatusCode());
    }

    /**
     * Tests {@link TmdbLists#create(String, String, String, String)} with an expected result.
     */
    @Test
    public void testCreate() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/lists/create.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_LIST + "?session_id=testSessionId";

        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "testName");
        requestBody.put("description", "testDescription");
        requestBody.put("language", "en-US");
        String jsonBody = JsonUtil.toJson(requestBody);

        when(getTmdbUrlReader().readUrl(url, jsonBody, RequestType.POST)).thenReturn(body);

        MovieListCreationStatus responseStatus = getApiToTest().create("testSessionId", "testName", "testDescription", "en-US");
        assertNotNull(responseStatus);
        validateAbstractJsonMappingFields(responseStatus);
    }

    /**
     * Tests {@link TmdbLists#delete(Integer, String)} with an expected result.
     */
    @Test
    public void testDelete() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/lists/delete.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_LIST + "/123?session_id=testSessionId";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.DELETE)).thenReturn(body);

        ResponseStatus responseStatus = getApiToTest().delete(123, "testSessionId");
        assertNotNull(responseStatus);
        validateAbstractJsonMappingFields(responseStatus);
        assertEquals(TmdbResponseCode.ITEM_UPDATED, responseStatus.getStatusCode());
    }

    /**
     * Tests {@link TmdbLists#getDetails(Integer, String, Integer)} with an expected result.
     */
    @Test
    public void testGetDetails() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/lists/details.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_LIST + "/123?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ListDetails listDetails = getApiToTest().getDetails(123, "en-US", null);
        assertNotNull(listDetails);
        validateAbstractJsonMappingFields(listDetails);
    }

    /**
     * Tests {@link TmdbLists#removeMovie(Integer, String, Integer)} with an expected result.
     */
    @Test
    public void testRemoveMovie() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/lists/remove_movie.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_LIST + "/123/remove_item?session_id=testSessionId";

        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("media_id", 456);
        String jsonBody = JsonUtil.toJson(requestBody);

        when(getTmdbUrlReader().readUrl(url, jsonBody, RequestType.POST)).thenReturn(body);

        ResponseStatus responseStatus = getApiToTest().removeMovie(123, "testSessionId", 456);
        assertNotNull(responseStatus);
        validateAbstractJsonMappingFields(responseStatus);
        assertEquals(TmdbResponseCode.ITEM_DELETED, responseStatus.getStatusCode());
    }
}
