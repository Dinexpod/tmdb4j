package app.moviso.tmdb4j.model.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.EqualsAndHashCode;

@lombok.Data
@EqualsAndHashCode(callSuper = false)
public class Data extends AbstractJsonMapping {
    @JsonProperty("biography")
    private String biography;
}
