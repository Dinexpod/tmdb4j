package app.moviso.tmdb4j.model.movies;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.NamedIdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MovieList extends NamedIdElement {
    @JsonProperty("description")
    private String description;

    @JsonProperty("favorite_count")
    private Integer favoriteCount;

    @JsonProperty("item_count")
    private Integer itemCount;

    @JsonProperty("iso_639_1")
    private String iso6391;

    @JsonProperty("list_type")
    private String listType;

    @JsonProperty("poster_path")
    private String posterPath;
}
