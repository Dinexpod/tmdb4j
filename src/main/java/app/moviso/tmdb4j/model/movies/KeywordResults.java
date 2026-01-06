package app.moviso.tmdb4j.model.movies;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.core.IdElement;
import app.moviso.tmdb4j.model.keywords.Keyword;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class KeywordResults extends IdElement {
    @JsonProperty("keywords")
    private List<Keyword> keywords;
}
