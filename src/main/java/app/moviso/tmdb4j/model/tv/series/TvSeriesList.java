package app.moviso.tmdb4j.model.tv.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.NamedIdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TvSeriesList extends NamedIdElement {
    @JsonProperty("description")
    private String description;

    @JsonProperty("favorite_count")
    private Integer favoriteCount;

    @JsonProperty("item_count")
    private Integer itemCount;

    @JsonProperty("iso_639_1")
    private String iso6391;

    @JsonProperty("iso_3166_1")
    private String iso31661;

    @JsonProperty("poster_path")
    private String posterPath;
}
