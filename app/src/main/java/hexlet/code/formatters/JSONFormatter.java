package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Difference;

public class JSONFormatter {
    private static final ObjectMapper JSON_OBJECT_MAPPER = new ObjectMapper();
    public static String format(Difference difference) throws JsonProcessingException {
        return JSON_OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(difference);
    }
}
