package app.moviso.tmdb4j.model.tv.season;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AccountState extends IdElement {
    @JsonProperty("rated")
    private Object rated;

    @JsonProperty("episode_number")
    private Integer episodeNumber;
}
