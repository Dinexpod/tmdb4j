package app.moviso.tmdb4j.model.certifications;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Certification extends AbstractJsonMapping {
    @JsonProperty("certification")
    private String certification;

    @JsonProperty("meaning")
    private String meaning;

    @JsonProperty("order")
    private Integer order;
}
