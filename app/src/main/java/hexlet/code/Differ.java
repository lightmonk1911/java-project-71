package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        String was = Files.readString(path1);

        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        String now = Files.readString(path2);

        String wasExtension = getDataFormat(filePath1);
        String nowExtension = getDataFormat(filePath2);

        Map wasProperties = Parser.parse(was, wasExtension);
        Map nowProperties = Parser.parse(now, nowExtension);

        Difference diff = new Difference(wasProperties, nowProperties);

        return Formatter.format(diff, formatName);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    private static String getDataFormat(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0
                ? filePath.substring(index + 1)
                : "";
    }
}
