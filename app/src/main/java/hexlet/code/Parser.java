package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Parser {
    private static final ObjectMapper JSON_OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_OBJECT_MAPPER = new YAMLMapper();

    public static Map parse(String fileContent, String type) throws JsonProcessingException {
        switch (type) {
            case  ("json"):
                return JSON_OBJECT_MAPPER.readValue(fileContent, Map.class);
            case ("yaml"):
                return YAML_OBJECT_MAPPER.readValue(fileContent, Map.class);
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
