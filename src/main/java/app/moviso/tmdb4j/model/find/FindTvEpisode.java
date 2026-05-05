package app.moviso.tmdb4j.model.find;

import app.moviso.tmdb4j.model.tv.core.TvEpisode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FindTvEpisode extends TvEpisode {
    @JsonProperty("episode_type")
    private String episodeType;
}
