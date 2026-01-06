package app.moviso.tmdb4j.model.movies;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Credits extends IdElement {
    @JsonProperty("cast")
    private List<Cast> cast;

    @JsonProperty("crew")
    private List<Crew> crew;
}
