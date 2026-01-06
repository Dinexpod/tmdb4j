package app.moviso.tmdb4j;

import java.io.IOException;

import app.moviso.tmdb4j.model.reviews.Review;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbReviews.TMDB_METHOD_MOVIE_REVIEW;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests {@link TmdbReviews}.
 */
public class TmdbReviewsTest extends AbstractTmdbApiTest<TmdbReviews> {
    @Override
    public TmdbReviews createApiToTest() {
        return getTmdbApi().getReviews();
    }

    /**
     * Test {@link TmdbReviews#getDetails(int)} with an expected result.
     */
    @Test
    public void testGetDetails() throws IOException, TmdbException {
        int reviewId = 1;

        String body = TestUtils.readTestFile("api_responses/reviews/details.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_MOVIE_REVIEW + "/" + reviewId;
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        Review review = getApiToTest().getDetails(reviewId);
        assertNotNull(review);
        validateAbstractJsonMappingFields(review);
    }
}
