package app.moviso.tmdb4j.model.collections;

import java.util.List;

import app.moviso.tmdb4j.model.core.NamedIdElement;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CollectionInfo extends NamedIdElement {
    @JsonProperty("overview")
    private String overview;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("parts")
    private List<Part> parts;
}
