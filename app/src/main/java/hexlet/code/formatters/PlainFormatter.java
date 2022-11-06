package hexlet.code.formatters;

import java.util.Collection;
import java.util.Map;

import hexlet.code.Difference;

public class PlainFormatter {
    public static String format(Difference difference) {
        StringBuilder builder = new StringBuilder();
        for (var entry : difference.entrySet()) {
            switch (entry.getValue().getState()) {
                case CHANGED -> {
                    String nowValue = normalizeValue(entry.getValue().getNow());
                    String wasValue = normalizeValue(entry.getValue().getWas());
                    builder.append("Property '"
                            + entry.getKey()
                            + "' was updated. From "
                            + wasValue
                            + " to " + nowValue + "\n");
                }
                case REMOVED -> builder.append("Property '" + entry.getKey() + "' was removed\n");
                case ADDED -> builder.append("Property '"
                        + entry.getKey()
                        + "' was added with value: "
                        + normalizeValue(entry.getValue().getNow())
                        + "\n");
                case NOT_CHANGED -> {
                }
                default -> throw new IllegalStateException("Unexpected state: " + entry.getValue().getState());
            }
        }

        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    private static String normalizeValue(Object value) {
        if (value instanceof Collection || value instanceof Map) {
            return "[complex value]";
        }

        if (value instanceof String) {
            return "'" + value + "'";
        }

        return String.valueOf(value);
    }
}
