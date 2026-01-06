package app.moviso.tmdb4j.model.configuration;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Job extends AbstractJsonMapping {
    @JsonProperty("department")
    private String department;

    @JsonProperty("jobs")
    private List<String> jobs;
}
