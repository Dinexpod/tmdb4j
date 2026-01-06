package app.moviso.tmdb4j.model.people.credits;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TvCredits extends IdElement {
    @JsonProperty("cast")
    private List<TvCast> cast;

    @JsonProperty("crew")
    private List<TvCrew> crew;
}
