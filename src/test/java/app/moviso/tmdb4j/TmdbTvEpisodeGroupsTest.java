package app.moviso.tmdb4j;

import java.io.IOException;

import app.moviso.tmdb4j.model.tv.episodegroups.EpisodeGroupType;
import app.moviso.tmdb4j.model.tv.episodegroups.TvEpisodeGroups;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbTvEpisodeGroups.TMDB_METHOD_TV_EPISODE_GROUPS;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbTvEpisodeGroups}.
 */
public class TmdbTvEpisodeGroupsTest extends AbstractTmdbApiTest<TmdbTvEpisodeGroups> {
    @Override
    public TmdbTvEpisodeGroups createApiToTest() {
        return getTmdbApi().getTvEpisodeGroups();
    }

    /**
     * Tests {@link TmdbTvEpisodeGroups#getDetails(String)} with an expected result.
     */
    @Test
    public void testGetDetails() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episode_groups/details.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV_EPISODE_GROUPS + "/5acfef37c3a36842e400333f";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        TvEpisodeGroups tvEpisodeGroups = getApiToTest().getDetails("5acfef37c3a36842e400333f");
        assertNotNull(tvEpisodeGroups);
        validateAbstractJsonMappingFields(tvEpisodeGroups);
    }

    /**
     * Tests the json value of type is mapped to the correct value of {@link EpisodeGroupType}.
     */
    @Test
    public void testEpisodeGroupType() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/tv_episode_groups/details.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_TV_EPISODE_GROUPS + "/5acfef37c3a36842e400333f";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        TvEpisodeGroups tvEpisodeGroups = getApiToTest().getDetails("5acfef37c3a36842e400333f");
        assertEquals(EpisodeGroupType.DIGITAL, tvEpisodeGroups.getType());
    }
}
