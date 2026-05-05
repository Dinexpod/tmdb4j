package app.moviso.tmdb4j.model.credits;

import app.moviso.tmdb4j.model.core.NamedIdElement;
import app.moviso.tmdb4j.model.people.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditPerson extends NamedIdElement {
    @JsonProperty("adult")
    private Boolean adult;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("known_for_department")
    private String knownForDepartment;

    @JsonProperty("media_type")
    private String mediaType;

    @JsonProperty("original_name")
    private String originalName;

    @JsonProperty("popularity")
    private Double popularity;

    @JsonProperty("profile_path")
    private String profilePath;
}
