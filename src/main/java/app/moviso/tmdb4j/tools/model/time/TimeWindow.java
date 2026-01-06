package app.moviso.tmdb4j.tools.model.time;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Time window for trending media.
 */
@AllArgsConstructor
@Getter
public enum TimeWindow {
    DAY("day"),
    WEEK("week");

    private final String value;
}
