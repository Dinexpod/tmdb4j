package app.moviso.tmdb4j.model.tv.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends AbstractJsonMapping {
    @JsonProperty("credit_id")
    private String creditId;

    @JsonProperty("character")
    private String character;

    @JsonProperty("episode_count")
    private Integer episodeCount;
}
