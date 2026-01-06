package app.moviso.tmdb4j.model.core.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseStatusDelete extends AbstractJsonMapping {
    @JsonProperty("success")
    private Boolean success;
}
