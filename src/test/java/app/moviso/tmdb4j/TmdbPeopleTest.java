package app.moviso.tmdb4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.moviso.tmdb4j.model.movies.changes.ChangeResults;
import app.moviso.tmdb4j.model.people.ExternalIds;
import app.moviso.tmdb4j.model.people.PersonDb;
import app.moviso.tmdb4j.model.people.PersonImages;
import app.moviso.tmdb4j.model.people.Translations;
import app.moviso.tmdb4j.model.people.credits.Cast;
import app.moviso.tmdb4j.model.people.credits.CombinedPersonCredits;
import app.moviso.tmdb4j.model.people.credits.Crew;
import app.moviso.tmdb4j.model.people.credits.MediaType;
import app.moviso.tmdb4j.model.people.credits.MovieCast;
import app.moviso.tmdb4j.model.people.credits.MovieCredits;
import app.moviso.tmdb4j.model.people.credits.MovieCrew;
import app.moviso.tmdb4j.model.people.credits.TvCast;
import app.moviso.tmdb4j.model.people.credits.TvCredits;
import app.moviso.tmdb4j.model.people.credits.TvCrew;
import app.moviso.tmdb4j.testutil.AbstractJsonMappingValidator;
import app.moviso.tmdb4j.testutil.TestUtils;
import app.moviso.tmdb4j.tools.RequestType;
import app.moviso.tmdb4j.tools.TmdbException;
import app.moviso.tmdb4j.tools.appendtoresponse.PersonAppendToResponse;
import org.junit.jupiter.api.Test;

import static app.moviso.tmdb4j.TmdbPeople.TMDB_METHOD_PERSON;
import static app.moviso.tmdb4j.testutil.TestUtils.validateAbstractJsonMappingFields;
import static app.moviso.tmdb4j.tools.ApiUrl.TMDB_API_BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link TmdbPeople}.
 */
public class TmdbPeopleTest extends AbstractTmdbApiTest<TmdbPeople> {
    @Override
    public TmdbPeople createApiToTest() {
        return getTmdbApi().getPeople();
    }

    /**
     * Tests {@link TmdbPeople#getDetails(int, String, PersonAppendToResponse...)} with an expected result.
     */
    @Test
    public void testGetDetails() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/people/details.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PERSON + "/123?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        PersonDb details = getApiToTest().getDetails(123, "en-US");
        assertNotNull(details);

        AbstractJsonMappingValidator abstractJsonMappingValidator = new AbstractJsonMappingValidator(details);
        List<String> filteredModel = new ArrayList<>();
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.changes");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.combinedCredits");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.externalIds");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.images");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.latest");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.movieCredits");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.tvCredits");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.translations");

        abstractJsonMappingValidator.validateNullFields(filteredModel);
        abstractJsonMappingValidator.validateEmptyCollections();
        abstractJsonMappingValidator.validateNullContainingCollection();
        abstractJsonMappingValidator.validateEmptyMaps();
        abstractJsonMappingValidator.validateNullContainingMaps();
        abstractJsonMappingValidator.validateNewItems();
    }

    /**
     * Tests {@link TmdbPeople#getDetails(int, String, PersonAppendToResponse...)} with appended responses, with an expected result.
     */
    @Test
    public void testGetDetailsWithAppendToResponse() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/people/details_with_append_to_response.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PERSON + "/123?language=en-US&" +
            "append_to_response=changes%2Ccombined_credits%2Cexternal_ids%2Cimages%2Clatest%2Cmovie_credits%2Ctv_credits%2Ctranslations";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        PersonDb details = getApiToTest().getDetails(123, "en-US", PersonAppendToResponse.values());
        assertNotNull(details);
        validateAbstractJsonMappingFields(details);
    }

    /**
     * Tests {@link TmdbPeople#getChanges(int, String, String, Integer)} with an expected result.
     */
    @Test
    public void testGetChanges() throws IOException, TmdbException {
        String startDate = "2023-01-13";
        String endDate = "2023-01-14";
        int page = 1;

        String body = TestUtils.readTestFile("api_responses/people/changes.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PERSON +
            "/123/changes?start_date=" + startDate + "&end_date=" + endDate + "&page=" + page;
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ChangeResults changes = getApiToTest().getChanges(123, startDate, endDate, page);
        assertNotNull(changes);
        validateAbstractJsonMappingFields(changes);
    }

    /**
     * Tests {@link TmdbPeople#getCombinedCredits(int, String)} with an expected result.
     */
    @Test
    public void testGetCombinedCredits() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/people/combined_credits.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PERSON + "/123/combined_credits?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        CombinedPersonCredits personCredits = getApiToTest().getCombinedCredits(123, "en-US");
        assertNotNull(personCredits);
        validateAbstractJsonMappingFields(personCredits);

        // this is not done in generic util way to make sure that the cast and crew are of the correct type
        List<Cast> cast = personCredits.getCast();
        assertNotNull(cast);
        assertFalse(cast.isEmpty());
        MovieCast movieCast = (MovieCast) cast.get(0);
        assertNotNull(movieCast);
        validateAbstractJsonMappingFields(movieCast);
        TvCast tvCast = (TvCast) cast.get(1);
        assertNotNull(tvCast);
        validateAbstractJsonMappingFields(tvCast);

        List<Crew> crew = personCredits.getCrew();
        assertNotNull(crew);
        assertFalse(crew.isEmpty());
        MovieCrew movieCrew = (MovieCrew) crew.get(0);
        assertNotNull(movieCrew);
        validateAbstractJsonMappingFields(movieCrew);
        TvCrew tvCrew = (TvCrew) crew.get(1);
        assertNotNull(tvCrew);
        validateAbstractJsonMappingFields(tvCrew);
    }

    /**
     * Tests {@link TmdbPeople#getExternalIds(int)} with an expected result.
     */
    @Test
    public void testExternalIds() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/people/external_ids.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PERSON + "/123/external_ids";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        ExternalIds externalIds = getApiToTest().getExternalIds(123);
        assertNotNull(externalIds);
        validateAbstractJsonMappingFields(externalIds);
    }

    /**
     * Tests {@link TmdbPeople#getImages(int)} with an expected result.
     */
    @Test
    public void testGetImages() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/people/images.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PERSON + "/123/images";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        PersonImages images = getApiToTest().getImages(123);
        assertNotNull(images);
        validateAbstractJsonMappingFields(images);
    }

    /**
     * Tests {@link TmdbPeople#getLatest()} with an expected result.
     */
    @Test
    public void testGetLatest() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/people/latest.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PERSON + "/latest";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        PersonDb latest = getApiToTest().getLatest();
        assertNotNull(latest);

        AbstractJsonMappingValidator abstractJsonMappingValidator = new AbstractJsonMappingValidator(latest);
        List<String> filteredModel = new ArrayList<>();
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.changes");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.combinedCredits");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.externalIds");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.images");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.latest");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.movieCredits");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.tvCredits");
        filteredModel.add("app.moviso.tmdb4j.model.people.PersonDb.translations");

        abstractJsonMappingValidator.validateNullFields(filteredModel);
        abstractJsonMappingValidator.validateEmptyCollections();
        abstractJsonMappingValidator.validateNullContainingCollection();
        abstractJsonMappingValidator.validateEmptyMaps();
        abstractJsonMappingValidator.validateNullContainingMaps();
        abstractJsonMappingValidator.validateNewItems();
    }

    /**
     * Tests {@link TmdbPeople#getMovieCredits(int, String)} with an expected result.
     */
    @Test
    public void testGetMovieCredits() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/people/movie_credits.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PERSON + "/123/movie_credits?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        MovieCredits movieCredits = getApiToTest().getMovieCredits(123, "en-US");
        assertNotNull(movieCredits);
        validateAbstractJsonMappingFields(movieCredits);

        // this is not done in generic util way to make sure that the cast and crew are of the correct type
        List<MovieCast> cast = movieCredits.getCast();
        assertNotNull(cast);
        assertFalse(cast.isEmpty());
        cast.forEach(c -> assertEquals(c.getMediaType(), MediaType.MOVIE));

        MovieCast movieCast = cast.get(0);
        assertNotNull(movieCast);
        validateAbstractJsonMappingFields(movieCast);

        List<MovieCrew> crew = movieCredits.getCrew();
        assertNotNull(crew);
        assertFalse(crew.isEmpty());
        crew.forEach(c -> assertEquals(c.getMediaType(), MediaType.MOVIE));

        MovieCrew movieCrew = crew.get(0);
        assertNotNull(movieCrew);
        validateAbstractJsonMappingFields(movieCrew);
    }

    /**
     * Tests {@link TmdbPeople#getTvCredits(int, String)} with an expected result.
     */
    @Test
    public void testGetTvCredits() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/people/tv_credits.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PERSON + "/123/tv_credits?language=en-US";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        TvCredits tvCredits = getApiToTest().getTvCredits(123, "en-US");
        assertNotNull(tvCredits);
        validateAbstractJsonMappingFields(tvCredits);

        // this is not done in generic util way to make sure that the cast and crew are of the correct type
        List<TvCast> cast = tvCredits.getCast();
        assertNotNull(cast);
        assertFalse(cast.isEmpty());
        cast.forEach(c -> assertEquals(c.getMediaType(), MediaType.TV));

        TvCast tvCast = cast.get(0);
        assertNotNull(tvCast);
        validateAbstractJsonMappingFields(tvCast);

        List<TvCrew> crew = tvCredits.getCrew();
        assertNotNull(crew);
        assertFalse(crew.isEmpty());
        crew.forEach(c -> assertEquals(c.getMediaType(), MediaType.TV));

        TvCrew tvCrew = crew.get(0);
        assertNotNull(tvCrew);
        validateAbstractJsonMappingFields(tvCrew);
    }

    /**
     * Tests {@link TmdbPeople#getTranslations(int)} with an expected result.
     */
    @Test
    public void testGetTranslations() throws IOException, TmdbException {
        String body = TestUtils.readTestFile("api_responses/people/translations.json");
        String url = TMDB_API_BASE_URL + TMDB_METHOD_PERSON + "/123/translations";
        when(getTmdbUrlReader().readUrl(url, null, RequestType.GET)).thenReturn(body);

        Translations translations = getApiToTest().getTranslations(123);
        assertNotNull(translations);
        validateAbstractJsonMappingFields(translations);
    }
}
