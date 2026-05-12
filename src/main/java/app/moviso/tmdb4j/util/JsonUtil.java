package app.moviso.tmdb4j.util;

import java.util.Map;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectWriter;
import tools.jackson.databind.json.JsonMapper;

/**
 * JSON Utility.
 */
public final class JsonUtil {
    public static final ObjectMapper OBJECT_MAPPER = JsonMapper.builder()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .build();

    private static final ObjectWriter MAP_WRITER = OBJECT_MAPPER.writerFor(Map.class);

    private JsonUtil() {
    }

    /**
     * Converts a Map to a JSON String.
     *
     * @param map the map to convert.
     * @return the json.
     */
    public static String toJson(Map<String, ?> map) {
        try {
            return MAP_WRITER.writeValueAsString(map);
        }
        catch (JacksonException exception) {
            throw new RuntimeException("json conversion failed", exception);
        }
    }
}
