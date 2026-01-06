package app.moviso.tmdb4j;

import java.io.IOException;

import app.moviso.tmdb4j.model.certifications.CertificationResults;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbCertifications.TMDB_METHOD_CERTIFICATIONS;
import static app.moviso.tmdb4j.TmdbCertifications.TMDB_METHOD_MOVIE_CERTIFICATIONS;
import static app.moviso.tmdb4j.TmdbCertifications.TMDB_METHOD_TV_CERTIFICATIONS;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbCertifications}.
 */
public class TmdbCertificationsTest extends AbstractTmdbApiTest<TmdbCertifications> {
    @Override
    public TmdbCertifications createApiToTest() {
        return getTmdbApi().getCertifications();
    }

    /**
     * Test {@link TmdbCertifications#getMovieCertifications()} with an expected result.
     */
    @Test
    public void testGetMovieCertifications() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/certifications/movie.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_CERTIFICATIONS + "/" + TMDB_METHOD_MOVIE_CERTIFICATIONS;
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        CertificationResults movieCertifications = getApiToTest().getMovieCertifications();
        assertNotNull(movieCertifications);
        validateAbstractJsonMappingFields(movieCertifications);
    }

    /**
     * Test {@link TmdbCertifications#getTvCertifications()} with an expected result.
     */
    @Test
    public void testGetTvCertifications() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/certifications/tv.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_CERTIFICATIONS + "/" + TMDB_METHOD_TV_CERTIFICATIONS;
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        CertificationResults tvCertifications = getApiToTest().getTvCertifications();
        assertNotNull(tvCertifications);
        validateAbstractJsonMappingFields(tvCertifications);
    }
}
