package app.moviso.tmdb4j.model.movielists;

import app.moviso.tmdb4j.model.core.Movie;
import app.moviso.tmdb4j.model.core.ResultsPage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MovieResultsPageWithDates extends ResultsPage<Movie> {
    @JsonProperty("dates")
    private Dates dates;
}
