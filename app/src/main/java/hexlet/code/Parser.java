package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Parser {
    private static final ObjectMapper JSON_OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_OBJECT_MAPPER = new YAMLMapper();

    public static Map parse(String dataString, String format) throws JsonProcessingException {
        return switch (format) {
            case "json" -> JSON_OBJECT_MAPPER.readValue(dataString, Map.class);
            case "yaml", "yml" -> YAML_OBJECT_MAPPER.readValue(dataString, Map.class);
            default -> throw new IllegalStateException("Unexpected data format: " + format);
        };
    }
}
