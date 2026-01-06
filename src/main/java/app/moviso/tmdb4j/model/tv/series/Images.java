package app.moviso.tmdb4j.model.tv.series;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import app.moviso.tmdb4j.model.core.image.Artwork;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Images extends IdElement {
    @JsonProperty("backdrops")
    private List<Artwork> backdrops;

    @JsonProperty("logos")
    private List<Artwork> logos;

    @JsonProperty("posters")
    private List<Artwork> posters;
}
