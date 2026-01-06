package app.moviso.tmdb4j.model.tv.season;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.StringIdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeItem extends StringIdElement {
    @JsonProperty("action")
    private String action;

    @JsonProperty("time")
    private String time;

    @JsonProperty("value")
    private Object value;
}
