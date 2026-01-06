package app.moviso.tmdb4j.model.tv.series;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Translations extends IdElement {
    @JsonProperty("translations")
    private List<Translation> translations;
}
