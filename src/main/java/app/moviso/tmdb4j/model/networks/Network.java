package app.moviso.tmdb4j.model.networks;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.NamedIdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Network extends NamedIdElement {
    @JsonProperty("headquarters")
    private String headquarters;

    @JsonProperty("homepage")
    private String homepage;

    @JsonProperty("logo_path")
    private String logoPath;

    @JsonProperty("origin_country")
    private String originCountry;
}
