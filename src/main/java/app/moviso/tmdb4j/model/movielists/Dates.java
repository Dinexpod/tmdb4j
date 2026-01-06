package app.moviso.tmdb4j.model.movielists;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Dates extends AbstractJsonMapping {
    @JsonProperty("maximum")
    private String maximum;

    @JsonProperty("minimum")
    private String minimum;
}
