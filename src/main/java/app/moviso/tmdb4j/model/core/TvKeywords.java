package app.moviso.tmdb4j.model.core;

import app.moviso.tmdb4j.model.keywords.Keyword;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TvKeywords extends Results<Keyword> {
}
