package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JSONFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class Formatter {
    public static String format(Difference difference, String formatName) throws JsonProcessingException {
        if ("stylish".equals(formatName)) {
            return StylishFormatter.format(difference);
        }

        if ("plain".equals(formatName)) {
            return PlainFormatter.format(difference);
        }

        if ("json".equals(formatName)) {
            return JSONFormatter.format(difference);
        }

        throw new IllegalStateException("Unknown formatter: " + formatName);
    }
}
