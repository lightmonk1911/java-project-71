package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String formatter) throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        String was = Files.readString(path1);

        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        String now = Files.readString(path2);

        String wasExtension = getExtension(filePath1);
        String nowExtension = getExtension(filePath2);

        Map wasProperties = Parser.parse(was, wasExtension);
        Map nowProperties = Parser.parse(now, nowExtension);

        Difference diff = new Difference(wasProperties, nowProperties);

        if ("stylish".equals(formatter)) {
            return StylishFormatter.format(diff);
        }

        throw new IllegalStateException("Unknown formatter: " + formatter);
    }

    private static String getExtension(String path) {
        if (path.endsWith("json")) {
            return "json";
        }

        if (path.endsWith("yml") || path.endsWith("yaml")) {
            return "yaml";
        }

        throw new IllegalStateException("We don't support such extension: " + path);
    }
}
