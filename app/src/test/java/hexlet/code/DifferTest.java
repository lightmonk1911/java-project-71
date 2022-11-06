package hexlet.code;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DifferTest {

    private String fixturesPath;

    @BeforeAll
    public void init() {
        String path = "src/test/resources/fixtures";

        File file = new File(path);
        fixturesPath = file.getAbsolutePath();
    }

    @Test
    public void testJSONWithProps() throws Exception {
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
        String wasFilePath = fixturesPath + "/empty.json";
        String nowFilePath = fixturesPath + "/empty.json";

        String expected = "{}";

        String result = Differ.generate(wasFilePath, nowFilePath, "stylish");
        assertEquals(expected, result);
    }

    @Test
    public void testYAMLWithProps() throws Exception {
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
        String wasFilePath = fixturesPath + "/empty.yml";
        String nowFilePath = fixturesPath + "/empty.yml";

        String expected = "{}";

        String result = Differ.generate(wasFilePath, nowFilePath, "stylish");
        assertEquals(expected, result);
    }

    @Test
    public void testYAMLWithPropsPlain() throws Exception {
        String wasFilePath = fixturesPath + "/file1.yml";
        String nowFilePath = fixturesPath + "/file2.yml";

        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";

        String result = Differ.generate(wasFilePath, nowFilePath, "plain");
        assertEquals(expected, result);
    }

    @Test
    public void testJSONWithPropsToJSON() throws Exception {
        String wasFilePath = fixturesPath + "/file1.yml";
        String nowFilePath = fixturesPath + "/file2.yml";

        String expected = "{\n"
                + "  \"chars1\" : {\n"
                + "    \"was\" : [ \"a\", \"b\", \"c\" ],\n"
                + "    \"now\" : [ \"a\", \"b\", \"c\" ],\n"
                + "    \"state\" : \"NOT_CHANGED\"\n"
                + "  },\n"
                + "  \"chars2\" : {\n"
                + "    \"was\" : [ \"d\", \"e\", \"f\" ],\n"
                + "    \"now\" : false,\n"
                + "    \"state\" : \"CHANGED\"\n"
                + "  },\n"
                + "  \"checked\" : {\n"
                + "    \"was\" : false,\n"
                + "    \"now\" : true,\n"
                + "    \"state\" : \"CHANGED\"\n"
                + "  },\n"
                + "  \"default\" : {\n"
                + "    \"was\" : null,\n"
                + "    \"now\" : [ \"value1\", \"value2\" ],\n"
                + "    \"state\" : \"CHANGED\"\n"
                + "  },\n"
                + "  \"id\" : {\n"
                + "    \"was\" : 45,\n"
                + "    \"now\" : null,\n"
                + "    \"state\" : \"CHANGED\"\n"
                + "  },\n"
                + "  \"key1\" : {\n"
                + "    \"was\" : \"value1\",\n"
                + "    \"now\" : null,\n"
                + "    \"state\" : \"REMOVED\"\n"
                + "  },\n"
                + "  \"key2\" : {\n"
                + "    \"was\" : null,\n"
                + "    \"now\" : \"value2\",\n"
                + "    \"state\" : \"ADDED\"\n"
                + "  },\n"
                + "  \"numbers1\" : {\n"
                + "    \"was\" : [ 1, 2, 3, 4 ],\n"
                + "    \"now\" : [ 1, 2, 3, 4 ],\n"
                + "    \"state\" : \"NOT_CHANGED\"\n"
                + "  },\n"
                + "  \"numbers2\" : {\n"
                + "    \"was\" : [ 2, 3, 4, 5 ],\n"
                + "    \"now\" : [ 22, 33, 44, 55 ],\n"
                + "    \"state\" : \"CHANGED\"\n"
                + "  },\n"
                + "  \"numbers3\" : {\n"
                + "    \"was\" : [ 3, 4, 5 ],\n"
                + "    \"now\" : null,\n"
                + "    \"state\" : \"REMOVED\"\n"
                + "  },\n"
                + "  \"numbers4\" : {\n"
                + "    \"was\" : null,\n"
                + "    \"now\" : [ 4, 5, 6 ],\n"
                + "    \"state\" : \"ADDED\"\n"
                + "  },\n"
                + "  \"obj1\" : {\n"
                + "    \"was\" : null,\n"
                + "    \"now\" : {\n"
                + "      \"nestedKey\" : \"value\",\n"
                + "      \"isNested\" : true\n"
                + "    },\n"
                + "    \"state\" : \"ADDED\"\n"
                + "  },\n"
                + "  \"setting1\" : {\n"
                + "    \"was\" : \"Some value\",\n"
                + "    \"now\" : \"Another value\",\n"
                + "    \"state\" : \"CHANGED\"\n"
                + "  },\n"
                + "  \"setting2\" : {\n"
                + "    \"was\" : 200,\n"
                + "    \"now\" : 300,\n"
                + "    \"state\" : \"CHANGED\"\n"
                + "  },\n"
                + "  \"setting3\" : {\n"
                + "    \"was\" : true,\n"
                + "    \"now\" : \"none\",\n"
                + "    \"state\" : \"CHANGED\"\n"
                + "  }\n"
                + "}";

        String result = Differ.generate(wasFilePath, nowFilePath, "json");
        assertEquals(expected, result);
    }
}
