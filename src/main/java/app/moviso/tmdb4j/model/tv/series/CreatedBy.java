package app.moviso.tmdb4j.model.tv.series;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.NamedIdElement;
import app.moviso.tmdb4j.model.people.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreatedBy extends NamedIdElement {
    @JsonProperty("credit_id")
    private String creditId;

    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("profile_path")
    private String profilePath;
}
