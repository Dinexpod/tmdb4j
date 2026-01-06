package app.moviso.tmdb4j.model.changes;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Change extends IdElement {
    @JsonProperty("adult")
    private Boolean adult;
}
