package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class Formatter {
    public static String format(Difference difference, String formatName) {
        if ("stylish".equals(formatName)) {
            return StylishFormatter.format(difference);
        }

        if ("plain".equals(formatName)) {
            return PlainFormatter.format(difference);
        }

        throw new IllegalStateException("Unknown formatter: " + formatName);
    }
}
