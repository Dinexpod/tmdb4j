package app.moviso.tmdb4j.model.tv.episodegroups;

import java.util.List;

import app.moviso.tmdb4j.model.core.NamedStringIdElement;
import app.moviso.tmdb4j.model.tv.core.Network;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TvEpisodeGroups extends NamedStringIdElement {
    @JsonProperty("description")
    private String description;

    @JsonProperty("episode_count")
    private Integer episodeCount;

    @JsonProperty("group_count")
    private Integer groupCount;

    @JsonProperty("groups")
    private List<TvEpisodeGroup> groups;

    @JsonProperty("network")
    private Network network;

    @JsonProperty("type")
    private EpisodeGroupType type;
}
