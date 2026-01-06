package app.moviso.tmdb4j.model.people;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    NOT_SPECIFIED,
    FEMALE,
    MALE,
    NON_BINARY;

    @JsonValue
    public int toValue() {
        return ordinal();
    }
}
