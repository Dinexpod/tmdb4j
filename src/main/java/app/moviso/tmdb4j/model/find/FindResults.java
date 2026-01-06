package app.moviso.tmdb4j.model.find;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FindResults extends AbstractJsonMapping {
    @JsonProperty("movie_results")
    private List<FindMovie> movieResults;

    @JsonProperty("person_results")
    private List<FindPerson> personResults;

    @JsonProperty("tv_results")
    private List<FindTvSeries> tvSeriesResults;

    @JsonProperty("tv_season_results")
    private List<FindTvSeason> tvSeasonResults;

    @JsonProperty("tv_episode_results")
    private List<FindTvEpisode> tvEpisodeResults;
}
