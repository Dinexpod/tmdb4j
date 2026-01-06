package app.moviso.tmdb4j.model.tv.episodegroups;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.NamedStringIdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TvEpisodeGroup extends NamedStringIdElement {
    @JsonProperty("order")
    private Integer order;

    @JsonProperty("episodes")
    private List<OrderedTvEpisode> episodes;

    @JsonProperty("locked")
    private Boolean locked;
}
