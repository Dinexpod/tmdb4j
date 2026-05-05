package app.moviso.tmdb4j.model.credits;

import app.moviso.tmdb4j.model.core.NamedIdElement;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditTvEpisode extends NamedIdElement {
    @JsonProperty("air_date")
    private String airDate;

    @JsonProperty("episode_number")
    private Integer episodeNumber;

    @JsonProperty("episode_type")
    private String episodeType;

    @JsonProperty("media_type")
    private String mediaType;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("production_code")
    private String productionCode;

    @JsonProperty("runtime")
    private Integer runtime;

    @JsonProperty("season_number")
    private Integer seasonNumber;

    @JsonProperty("show_id")
    private Integer showId;

    @JsonProperty("still_path")
    private String stillPath;

    @JsonProperty("vote_average")
    private Double voteAverage;

    @JsonProperty("vote_count")
    private Integer voteCount;
}
