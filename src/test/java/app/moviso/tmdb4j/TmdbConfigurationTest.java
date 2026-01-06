package app.moviso.tmdb4j;

import java.io.IOException;
import java.util.List;

import app.moviso.tmdb4j.model.configuration.Configuration;
import app.moviso.tmdb4j.model.configuration.Country;
import app.moviso.tmdb4j.model.configuration.Job;
import app.moviso.tmdb4j.model.configuration.Timezone;
import app.moviso.tmdb4j.model.core.Language;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbConfiguration.TMDB_METHOD_CONFIGURATION;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbConfiguration}.
 */
public class TmdbConfigurationTest extends AbstractTmdbApiTest<TmdbConfiguration> {
    @Override
    public TmdbConfiguration createApiToTest() {
        return getTmdbApi().getConfiguration();
    }

    /**
     * Test for {@link TmdbConfiguration#getDetails()} with an expected result.
     */
    @Test
    public void testGetDetails() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/configuration/details.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_CONFIGURATION;
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        Configuration configuration = getApiToTest().getDetails();
        assertNotNull(configuration);
        validateAbstractJsonMappingFields(configuration);
    }

    /**
     * Test for {@link TmdbConfiguration#getCountries(String)} with an expected result.
     */
    @Test
    public void testGetCountries() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/configuration/countries.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_CONFIGURATION + "/countries";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        List<Country> countries = getApiToTest().getCountries(null);
        assertNotNull(countries);
        assertFalse(countries.isEmpty());

        Country country = countries.get(0);
        assertNotNull(country);
        validateAbstractJsonMappingFields(country);
    }

    /**
     * Test for {@link TmdbConfiguration#getJobs()} with an expected result.
     */
    @Test
    public void testGetJobs() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/configuration/jobs.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_CONFIGURATION + "/jobs";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        List<Job> jobs = getApiToTest().getJobs();
        assertNotNull(jobs);
        assertFalse(jobs.isEmpty());

        Job job = jobs.get(0);
        assertNotNull(job);
        validateAbstractJsonMappingFields(job);
    }

    /**
     * Test for {@link TmdbConfiguration#getLanguages()} with an expected result.
     */
    @Test
    public void testGetLanguages() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/configuration/languages.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_CONFIGURATION + "/languages";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        List<Language> languages = getApiToTest().getLanguages();
        assertNotNull(languages);
        assertFalse(languages.isEmpty());

        Language language = languages.get(0);
        assertNotNull(language);
        validateAbstractJsonMappingFields(language);
    }

    /**
     * Test for {@link TmdbConfiguration#getPrimaryTranslations()} with an expected result.
     */
    @Test
    public void testGetPrimaryTranslations() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/configuration/primary_translations.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_CONFIGURATION + "/primary_translations";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        List<String> primaryTranslations = getApiToTest().getPrimaryTranslations();
        assertNotNull(primaryTranslations);
        assertFalse(primaryTranslations.isEmpty());

        String primaryTranslation = primaryTranslations.get(0);
        assertNotNull(primaryTranslation);
    }

    /**
     * Test for {@link TmdbConfiguration#getTimezones()} with an expected result.
     */
    @Test
    public void testGetTimezones() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/configuration/timezones.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_CONFIGURATION + "/timezones";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        List<Timezone> timezones = getApiToTest().getTimezones();
        assertNotNull(timezones);
        assertFalse(timezones.isEmpty());

        Timezone timezone = timezones.get(0);
        assertNotNull(timezone);
        validateAbstractJsonMappingFields(timezone);
    }
}
