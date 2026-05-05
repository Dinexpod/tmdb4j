package app.moviso.tmdb4j.model.people;

import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

@lombok.Data
@EqualsAndHashCode(callSuper = false)
public class Data extends AbstractJsonMapping {
    @JsonProperty("biography")
    private String biography;
}
