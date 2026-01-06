package app.moviso.tmdb4j.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import app.moviso.tmdb4j.model.reviews.AuthorDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Review extends StringIdElement {
    @JsonProperty("author")
    private String author;

    @JsonProperty("author_details")
    private AuthorDetails authorDetails;

    @JsonProperty("content")
    private String content;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("url")
    private String url;
}
