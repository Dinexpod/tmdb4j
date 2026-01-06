package app.moviso.tmdb4j;

import java.io.IOException;

import app.moviso.tmdb4j.model.companies.AlternativeNamesResultsPage;
import app.moviso.tmdb4j.model.companies.Company;
import app.moviso.tmdb4j.model.core.image.ImageResults;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbCompanies.TMDB_METHOD_COMPANY;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbCompanies}.
 */
public class TmdbCompaniesTest extends AbstractTmdbApiTest<TmdbCompanies> {
    @Override
    public TmdbCompanies createApiToTest() {
        return getTmdbApi().getCompanies();
    }

    /**
     * Tests {@link TmdbCompanies#getDetails(Integer)}.
     */
    @Test
    public void testGetDetails() throws IOException, TmdbException {
        int companyId = 1;

        String body = TestUtils.readTestFile("api_responses/companies/details.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_COMPANY + "/" + companyId;
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        Company company = getApiToTest().getDetails(companyId);
        assertNotNull(company);
        validateAbstractJsonMappingFields(company);
    }

    /**
     * Tests {@link TmdbCompanies#getAlternativeNames(Integer)}.
     */
    @Test
    public void testGetAlternativeNames() throws IOException, TmdbException {
        int companyId = 1;

        String body = TestUtils.readTestFile("api_responses/companies/alternative_names.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_COMPANY + "/" + companyId + "/alternative_names";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        AlternativeNamesResultsPage alternativeNamesResultsPage = getApiToTest().getAlternativeNames(1);
        assertNotNull(alternativeNamesResultsPage);
        validateAbstractJsonMappingFields(alternativeNamesResultsPage);
    }

    /**
     * Tests {@link TmdbCompanies#getImages(Integer)}.
     */
    @Test
    public void testGetImages() throws IOException, TmdbException {
        int companyId = 1;

        String body = TestUtils.readTestFile("api_responses/companies/images.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_COMPANY + "/" + companyId + "/images";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ImageResults logoImageResults = getApiToTest().getImages(1);
        assertNotNull(logoImageResults);
        validateAbstractJsonMappingFields(logoImageResults);
    }
}
