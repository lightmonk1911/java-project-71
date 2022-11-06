package hexlet.code;

import java.io.File;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testJSONWithProps() throws Exception {
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

    @Test
    public void testEmpty() throws Exception {
        String path = "src/test/resources/fixtures";

        File file = new File(path);
        String fixturesPath = file.getAbsolutePath();

        String wasFilePath = fixturesPath + "/empty.json";
        String nowFilePath = fixturesPath + "/empty.json";

        String expected = "{}";

        String result = Differ.generate(wasFilePath, nowFilePath);
        assertEquals(result, expected);
    }

    @Test
    public void testYAMLWithProps() throws Exception {
        String path = "src/test/resources/fixtures";

        File file = new File(path);
        String fixturesPath = file.getAbsolutePath();

        String wasFilePath = fixturesPath + "/file1.yml";
        String nowFilePath = fixturesPath + "/file2.yml";

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
