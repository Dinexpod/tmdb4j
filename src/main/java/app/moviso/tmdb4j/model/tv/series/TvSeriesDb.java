package app.moviso.tmdb4j.model.tv.series;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import app.moviso.tmdb4j.model.core.AccountStates;
import app.moviso.tmdb4j.model.core.Genre;
import app.moviso.tmdb4j.model.core.Language;
import app.moviso.tmdb4j.model.core.NamedIdElement;
import app.moviso.tmdb4j.model.core.ProductionCompany;
import app.moviso.tmdb4j.model.core.ProductionCountry;
import app.moviso.tmdb4j.model.core.ReviewResultsPage;
import app.moviso.tmdb4j.model.core.TvKeywords;
import app.moviso.tmdb4j.model.core.TvSeriesResultsPage;
import app.moviso.tmdb4j.model.core.video.VideoResults;
import app.moviso.tmdb4j.model.core.watchproviders.ProviderResults;
import app.moviso.tmdb4j.model.tv.core.ChangeResults;
import app.moviso.tmdb4j.model.tv.core.Network;
import app.moviso.tmdb4j.model.tv.core.TvEpisode;
import app.moviso.tmdb4j.model.tv.core.TvSeason;
import app.moviso.tmdb4j.model.tv.core.credits.AggregateCredits;
import app.moviso.tmdb4j.model.tv.core.credits.Credits;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Holger Brandl, c-eg
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
public class TvSeriesDb extends NamedIdElement {
    @JsonProperty("adult")
    private Boolean adult;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("created_by")
    private List<CreatedBy> createdBy;

    @JsonProperty("episode_run_time")
    private List<Integer> episodeRunTime;

    @JsonProperty("first_air_date")
    private String firstAirDate;

    @JsonProperty("genres")
    private List<Genre> genres;

    @JsonProperty("homepage")
    private String homepage;

    @JsonProperty("in_production")
    private Boolean inProduction;

    @JsonProperty("languages")
    private List<String> languages;

    @JsonProperty("last_air_date")
    private String lastAirDate;

    @JsonProperty("last_episode_to_air")
    private TvEpisode lastEpisodeToAir;

    @JsonProperty("next_episode_to_air")
    private TvEpisode nextEpisodeToAir;

    @JsonProperty("networks")
    private List<Network> networks;

    @JsonProperty("number_of_episodes")
    private Integer numberOfEpisodes;

    @JsonProperty("number_of_seasons")
    private Integer numberOfSeasons;

    @JsonProperty("origin_country")
    private List<String> originCountry;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("original_name")
    private String originalName;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("popularity")
    private Double popularity;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("production_companies")
    private List<ProductionCompany> productionCompanies;

    @JsonProperty("production_countries")
    private List<ProductionCountry> productionCountries;

    @JsonProperty("seasons")
    private List<TvSeason> seasons;

    @JsonProperty("spoken_languages")
    private List<Language> spokenLanguages;

    @JsonProperty("status")
    private String status;

    @JsonProperty("tagline")
    private String tagline;

    @JsonProperty("type")
    private String type;

    @JsonProperty("vote_average")
    private Double voteAverage;

    @JsonProperty("vote_count")
    private Integer voteCount;

    /* append to responses */

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("account_states")
    private AccountStates accountStates;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("aggregate_credits")
    private AggregateCredits aggregateCredits;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("alternative_titles")
    private AlternativeTitleResults alternativeTitles;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("changes")
    private ChangeResults changes;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("content_ratings")
    private ContentRatingResults contentRatings;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("credits")
    private Credits credits;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("episode_groups")
    private EpisodeGroupResults episodeGroups;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("external_ids")
    private ExternalIds externalIds;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("images")
    private Images images;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("keywords")
    private TvKeywords keywords;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("lists")
    private TvSeriesListResultsPage lists;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("recommendations")
    private TvSeriesResultsPage recommendations;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("reviews")
    private ReviewResultsPage reviews;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("screened_theatrically")
    private ScreenedTheatricallyResults screenedTheatrically;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("similar")
    private TvSeriesResultsPage similar;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("translations")
    private Translations translations;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("videos")
    private VideoResults videos;

    /** Can be null if not appended to the request (append to response). */
    @JsonProperty("watch/providers")
    private ProviderResults watchProviders;
}
