package app.moviso.tmdb4j;

import java.io.IOException;
import java.util.List;

import app.moviso.tmdb4j.model.credits.CreditDetails;
import app.moviso.tmdb4j.testutil.AbstractJsonMappingValidator;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbCredits.TMDB_METHOD_CREDIT;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbCredits}.
 */
public class TmdbCreditsTest extends AbstractTmdbApiTest<TmdbCredits> {
    @Override
    public TmdbCredits createApiToTest() {
        return getTmdbApi().getCredits();
    }

    /**
     * Tests {@link TmdbCredits#getDetails(String, String)} with an expected result.
     */
    @Test
    public void testGetDetails() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/credits/details.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_CREDIT + "/61aecf46a242320089aafb19?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        CreditDetails creditDetails = getApiToTest().getDetails("61aecf46a242320089aafb19", "en-US");
        assertNotNull(creditDetails);
        assertEquals("61aecf46a242320089aafb19", creditDetails.getId());

        AbstractJsonMappingValidator abstractJsonMappingValidator = new AbstractJsonMappingValidator(creditDetails);
        List<String> filteredModel = List.of(
            "app.moviso.tmdb4j.model.credits.CreditDetails.media.episodeCount",
            "app.moviso.tmdb4j.model.credits.CreditDetails.media.episodes",
            "app.moviso.tmdb4j.model.credits.CreditDetails.media.firstAirDate",
            "app.moviso.tmdb4j.model.credits.CreditDetails.media.name",
            "app.moviso.tmdb4j.model.credits.CreditDetails.media.originCountry",
            "app.moviso.tmdb4j.model.credits.CreditDetails.media.originalName",
            "app.moviso.tmdb4j.model.credits.CreditDetails.media.seasons"
        );
        abstractJsonMappingValidator.validateNullFields(filteredModel);
        abstractJsonMappingValidator.validateEmptyCollections();
        abstractJsonMappingValidator.validateNullContainingCollection();
        abstractJsonMappingValidator.validateEmptyMaps();
        abstractJsonMappingValidator.validateNullContainingMaps();
        abstractJsonMappingValidator.validateNewItems();
    }
}
