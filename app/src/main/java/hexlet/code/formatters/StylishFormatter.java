package hexlet.code.formatters;

import hexlet.code.Difference;

public class StylishFormatter {
    public static String format(Difference difference) {
        if (difference.isEmpty()) {
            return "{}";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (var entry : difference.entrySet()) {
            switch (entry.getValue().getState()) {
                case CHANGED -> {
                    appendLine(builder, entry.getKey(), entry.getValue().getWas(), "-");
                    appendLine(builder, entry.getKey(), entry.getValue().getNow(), "+");
                }
                case REMOVED -> appendLine(builder, entry.getKey(), entry.getValue().getWas(), "-");
                case ADDED -> appendLine(builder, entry.getKey(), entry.getValue().getNow(), "+");
                case UNCHANGED -> appendLine(builder, entry.getKey(), entry.getValue().getWas());
                default -> throw new IllegalStateException("Unexpected state: " + entry.getValue().getState());
            }
        }

        builder.append("\n}");

        return builder.toString();
    }

    private static void appendLine(StringBuilder builder, String key, Object value, String prefix) {
        builder.append("\n  " + prefix + " ");
        builder.append(key);
        builder.append(": ");
        builder.append(value);
    }

    private static void appendLine(StringBuilder builder, String key, Object value) {
        appendLine(builder, key, value, " ");
    }
}
