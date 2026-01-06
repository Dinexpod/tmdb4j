package app.moviso.tmdb4j.model.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GuestSession extends AbstractJsonMapping {
    @JsonProperty("expires_at")
    private String expiresAt;

    @JsonProperty("guest_session_id")
    private String guestSessionId;

    @JsonProperty("success")
    private Boolean success;
}
