package app.moviso.tmdb4j.model.core.image;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ImageResults extends IdElement {
    @JsonProperty("logos")
    private List<Image> logos;
}
