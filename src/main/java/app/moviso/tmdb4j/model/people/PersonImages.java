package app.moviso.tmdb4j.model.people;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import app.moviso.tmdb4j.model.core.image.Artwork;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonImages extends IdElement {
    @JsonProperty("profiles")
    private List<Artwork> profiles;
}
