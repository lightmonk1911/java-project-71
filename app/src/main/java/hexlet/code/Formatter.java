package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JSONFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class Formatter {
    public static String format(Difference difference, String formatName) throws JsonProcessingException {
        return switch (formatName) {
            case ("stylish") -> StylishFormatter.format(difference);
            case ("plain") -> PlainFormatter.format(difference);
            case ("json") -> JSONFormatter.format(difference);
            default -> throw new IllegalStateException("Unknown formatter: " + formatName);
        };
    }
}
