package app.moviso.tmdb4j.model.rated;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.Movie;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RatedMovie extends Movie {
    @JsonProperty("rating")
    private Double rating;
}
