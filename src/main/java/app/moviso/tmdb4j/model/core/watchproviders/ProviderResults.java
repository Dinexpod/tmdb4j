package app.moviso.tmdb4j.model.core.watchproviders;

import java.util.Map;

import app.moviso.tmdb4j.model.core.IdElement;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProviderResults extends IdElement {
    @JsonProperty("results")
    private Map<String, WatchProviders> results;
}
