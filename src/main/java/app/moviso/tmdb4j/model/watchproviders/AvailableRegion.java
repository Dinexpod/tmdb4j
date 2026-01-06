package app.moviso.tmdb4j.model.watchproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AvailableRegion extends AbstractJsonMapping {
    @JsonProperty("iso_3166_1")
    private String iso31661;

    @JsonProperty("english_name")
    private String englishName;

    @JsonProperty("native_name")
    private String nativeName;
}
