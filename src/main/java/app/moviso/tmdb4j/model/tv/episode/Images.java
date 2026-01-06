package app.moviso.tmdb4j.model.tv.episode;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import app.moviso.tmdb4j.model.core.image.Artwork;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Images extends IdElement {
    @JsonProperty("stills")
    private List<Artwork> stills;
}
