package app.moviso.tmdb4j.model.find;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.tv.core.TvEpisode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FindTvEpisode extends TvEpisode {
    @JsonProperty("episode_type")
    private String episodeType;
}
