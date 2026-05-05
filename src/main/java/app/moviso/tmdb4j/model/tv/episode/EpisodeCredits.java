package app.moviso.tmdb4j.model.tv.episode;

import java.util.List;

import app.moviso.tmdb4j.model.tv.core.credits.Credits;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EpisodeCredits extends Credits {
    @JsonProperty("guest_stars")
    private List<GuestStar> guestStars;
}
