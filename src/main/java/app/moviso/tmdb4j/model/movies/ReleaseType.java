package app.moviso.tmdb4j.model.movies;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReleaseType {
    PREMIERE,
    THEATRICAL_LIMITED,
    THEATRICAL,
    DIGITAL,
    PHYSICAL,
    TV;

    @JsonValue
    public int toValue() {
        return ordinal() + 1;  // ids start at 1
    }
}
