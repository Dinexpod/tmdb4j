package app.moviso.tmdb4j.model.companies;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.NamedIdElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Company extends NamedIdElement {
    @JsonProperty("description")
    private String description;

    @JsonProperty("headquarters")
    private String headquarters;

    @JsonProperty("homepage")
    private String homepage;

    @JsonProperty("logo_path")
    private String logoPath;

    @JsonProperty("origin_country")
    private String originCountry;

    @JsonProperty("parent_company")
    private Integer parentCompanyId;
}

