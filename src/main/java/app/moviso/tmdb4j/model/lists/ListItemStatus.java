package app.moviso.tmdb4j.model.lists;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Holger Brandl
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ListItemStatus extends IdElement {
    @JsonProperty("item_present")
    private Boolean itemPresent;
}
