package app.moviso.tmdb4j.model.movies;

import app.moviso.tmdb4j.model.core.NamedIdElement;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BelongsToCollection extends NamedIdElement {
    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("backdrop_path")
    private String backdropPath;
}
