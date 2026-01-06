package app.moviso.tmdb4j.model.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RequestToken extends AbstractJsonMapping {
    @JsonProperty("expires_at")
    private String expires;

    @JsonProperty("request_token")
    private String requestToken;

    @JsonProperty("success")
    private Boolean success;
}
