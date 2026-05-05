package app.moviso.tmdb4j.model.credits;

import app.moviso.tmdb4j.model.core.NamedIdElement;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditTvSeason extends NamedIdElement {
    @JsonProperty("air_date")
    private String airDate;

    @JsonProperty("episode_count")
    private Integer episodeCount;

    @JsonProperty("media_type")
    private String mediaType;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("season_number")
    private Integer seasonNumber;

    @JsonProperty("vote_average")
    private Double voteAverage;
}
