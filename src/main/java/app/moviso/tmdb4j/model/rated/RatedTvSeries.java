package app.moviso.tmdb4j.model.rated;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.TvSeries;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RatedTvSeries extends TvSeries {
    @JsonProperty("rating")
    private Double rating;
}
