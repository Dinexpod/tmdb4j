package app.moviso.tmdb4j.model.core.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import app.moviso.tmdb4j.tools.TmdbResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseStatus extends AbstractJsonMapping {
    @JsonProperty("status_code")
    private TmdbResponseCode statusCode;

    @JsonProperty("status_message")
    private String statusMessage;
}
