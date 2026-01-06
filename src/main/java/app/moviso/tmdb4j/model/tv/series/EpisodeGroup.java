package app.moviso.tmdb4j.model.tv.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.NamedStringIdElement;
import app.moviso.tmdb4j.model.tv.core.Network;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EpisodeGroup extends NamedStringIdElement {
    @JsonProperty("description")
    private String description;

    @JsonProperty("episode_count")
    private Integer episodeCount;

    @JsonProperty("group_count")
    private Integer groupCount;

    @JsonProperty("network")
    private Network network;

    @JsonProperty("type")
    private String type;
}
