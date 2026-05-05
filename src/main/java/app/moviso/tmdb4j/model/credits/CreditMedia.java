package app.moviso.tmdb4j.model.credits;

import java.util.List;

import app.moviso.tmdb4j.model.core.IdElement;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditMedia extends IdElement {
    @JsonProperty("adult")
    private Boolean adult;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("character")
    private String character;

    @JsonProperty("episode_count")
    private Integer episodeCount;

    @JsonProperty("episodes")
    private List<CreditTvEpisode> episodes;

    @JsonProperty("first_air_date")
    private String firstAirDate;

    @JsonProperty("genre_ids")
    private List<Integer> genreIds;

    @JsonProperty("media_type")
    private String mediaType;

    @JsonProperty("name")
    private String name;

    @JsonProperty("origin_country")
    private List<String> originCountry;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("original_name")
    private String originalName;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("popularity")
    private Double popularity;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("seasons")
    private List<CreditTvSeason> seasons;

    @JsonProperty("title")
    private String title;

    @JsonProperty("video")
    private Boolean video;

    @JsonProperty("vote_average")
    private Double voteAverage;

    @JsonProperty("vote_count")
    private Integer voteCount;
}
