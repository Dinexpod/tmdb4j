package app.moviso.tmdb4j.model.account;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Avatar extends AbstractJsonMapping {
    @JsonProperty("gravatar")
    private Map<String, String> gravatar;

    @JsonProperty("tmdb")
    private Map<String, String> tmdb;

    public String getGravatarHash() {
        return gravatar.get("hash");
    }

    public String getTmdbAvatarPath() {
        return tmdb.get("avatar_path");
    }
}
