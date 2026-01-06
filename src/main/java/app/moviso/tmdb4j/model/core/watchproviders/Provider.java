package app.moviso.tmdb4j.model.core.watchproviders;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Provider extends AbstractJsonMapping {
    @JsonProperty("display_priority")
    private Integer displayPriority;

    @JsonProperty("logo_path")
    private String logoPath;

    @JsonProperty("provider_id")
    private Integer providerId;

    @JsonProperty("provider_name")
    private String providerName;
}
