package app.moviso.tmdb4j.model.configuration;

import java.util.List;

import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Timezone extends AbstractJsonMapping {
    @JsonProperty("iso_3166_1")
    private String iso31661;

    @JsonProperty("zones")
    private List<String> zones;
}
