package app.moviso.tmdb4j.model.configuration;

import java.util.List;

import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Configuration extends AbstractJsonMapping {
    @JsonProperty("images")
    private ImageConfig imageConfig;

    @JsonProperty("change_keys")
    private List<String> changeKeys;
}
