package app.moviso.tmdb4j.model.certifications;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.AbstractJsonMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CertificationResults extends AbstractJsonMapping {
    @JsonProperty("certifications")
    private Map<String, List<Certification>> certifications;
}
