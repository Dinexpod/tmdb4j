package app.moviso.tmdb4j.model.credits;

import app.moviso.tmdb4j.model.core.StringIdElement;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditDetails extends StringIdElement {
    @JsonProperty("credit_type")
    private String creditType;

    @JsonProperty("department")
    private String department;

    @JsonProperty("job")
    private String job;

    @JsonProperty("media")
    private CreditMedia media;

    @JsonProperty("media_type")
    private String mediaType;

    @JsonProperty("person")
    private CreditPerson person;
}
