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
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";

        String result = Differ.generate(wasFilePath, nowFilePath, "stylish");
        assertEquals(expected, result);
    }

    @Test
    public void testEmptyJSON() throws Exception {
        String path = "src/test/resources/fixtures";

        File file = new File(path);
        String fixturesPath = file.getAbsolutePath();

        String wasFilePath = fixturesPath + "/empty.json";
        String nowFilePath = fixturesPath + "/empty.json";

        String expected = "{}";

        String result = Differ.generate(wasFilePath, nowFilePath, "stylish");
        assertEquals(expected, result);
    }

    @Test
    public void testYAMLWithProps() throws Exception {
        String path = "src/test/resources/fixtures";

        File file = new File(path);
        String fixturesPath = file.getAbsolutePath();

        String wasFilePath = fixturesPath + "/file1.yml";
        String nowFilePath = fixturesPath + "/file2.yml";

        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";

        String result = Differ.generate(wasFilePath, nowFilePath, "stylish");
        assertEquals(expected, result);
    }

    @Test
    public void testEmptyYAML() throws Exception {
        String path = "src/test/resources/fixtures";

        File file = new File(path);
        String fixturesPath = file.getAbsolutePath();

        String wasFilePath = fixturesPath + "/empty.yml";
        String nowFilePath = fixturesPath + "/empty.yml";

        String expected = "{}";

        String result = Differ.generate(wasFilePath, nowFilePath, "stylish");
        assertEquals(expected, result);
    }
}
