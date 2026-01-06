package app.moviso.tmdb4j.model.core.responses;

import app.moviso.tmdb4j.tools.TmdbException;
import app.moviso.tmdb4j.tools.TmdbResponseCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TmdbResponseException extends TmdbException {
    private final TmdbResponseCode responseCode;

    public TmdbResponseException(TmdbResponseCode responseCode) {
        super(responseCode.toString());
        this.responseCode = responseCode;
    }

    public TmdbResponseException(String message) {
        super(message);
        this.responseCode = null;
    }

    public TmdbResponseException(Exception exception) {
        super(exception);
        this.responseCode = null;
    }
}
