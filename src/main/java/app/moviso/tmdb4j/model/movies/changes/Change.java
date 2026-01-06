package app.moviso.tmdb4j.model.movies.changes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Change extends AbstractJsonMapping {
    @JsonProperty("key")
    private String key;

    @JsonProperty("items")
    private List<ChangeItem> changeItems;
}
