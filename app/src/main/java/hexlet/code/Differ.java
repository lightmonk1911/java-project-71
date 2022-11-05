package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String generate(String filePath1, String filePath2) throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        String was = Files.readString(path1);

        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        String now = Files.readString(path2);

        Map wasProperties = MAPPER.readValue(was, Map.class);
        Map nowProperties = MAPPER.readValue(now, Map.class);

        Set<String> keysOfBoth = new TreeSet<>();
        keysOfBoth.addAll(wasProperties.keySet());
        keysOfBoth.addAll(nowProperties.keySet());

        return createDiffString(keysOfBoth, wasProperties, nowProperties);
    }

    public static String createDiffString(Set<String> keys, Map was, Map now) {
        if (keys.isEmpty()) {
            return "{}";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (String key : keys) {
            if (was.containsKey(key) && now.containsKey(key)) {
                if (was.get(key).equals(now.get(key))) {
                    appendLine(builder, key, now.get(key));
                } else {
                    appendLine(builder, key, was.get(key), "-");
                    appendLine(builder, key, now.get(key), "+");
                }
            }

            if (was.containsKey(key) && !now.containsKey(key)) {
                appendLine(builder, key, was.get(key), "-");
            }

            if (!was.containsKey(key) && now.containsKey(key)) {
                appendLine(builder, key, now.get(key), "+");
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
