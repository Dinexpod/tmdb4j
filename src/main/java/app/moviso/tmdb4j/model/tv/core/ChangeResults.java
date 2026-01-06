package app.moviso.tmdb4j.model.tv.core;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ChangeResults extends AbstractJsonMapping {
    @JsonProperty("changes")
    private List<Change> changedItems;
}
