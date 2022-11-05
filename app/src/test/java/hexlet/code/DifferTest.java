package hexlet.code;

import java.io.File;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DifferTest {

    @Test
    public void testGenerateDiff() throws Exception {
        String path = "src/test/resources/fixtures";

        File file = new File(path);
        String fixturesPath = file.getAbsolutePath();

        String wasFilePath = fixturesPath + "/file1.json";
        String nowFilePath = fixturesPath + "/file2.json";

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        String result = Differ.generate(wasFilePath, nowFilePath);
        assertEquals(result, expected);
    }
}
