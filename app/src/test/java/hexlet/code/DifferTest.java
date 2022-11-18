package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public final class DifferTest {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;
    private static String sourceJson1;
    private static String sourceJson2;
    private static String sourceYaml1;
    private static String sourceYaml2;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String getFixturePathString(String fileName) {
        return getFixturePath(fileName).toString();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("result_json.json");
        resultPlain = readFixture("result_plain.txt");
        resultStylish = readFixture("result_stylish.txt");
        sourceJson1 = getFixturePathString("source_json_1.json");
        sourceJson2 = getFixturePathString("source_json_2.json");
        sourceYaml1 = getFixturePathString("source_yaml_1.yml");
        sourceYaml2 = getFixturePathString("source_yaml_2.yml");
    }

    @Test
    void testJSONWithStylishFormatter() throws Exception {
        String result = Differ.generate(sourceJson1, sourceJson2, "stylish");
        assertEquals(resultStylish, result);
    }

    @Test
    void testJsonWithJsonFormatter() throws Exception {
        String result = Differ.generate(sourceJson1, sourceJson2, "json");
        assertEquals(resultJson, result);
    }

    @Test
    void testJsonWithPlainFormatter() throws Exception {
        String result = Differ.generate(sourceJson1, sourceJson2, "plain");
        assertEquals(resultPlain, result);
    }

    @Test
    void testJsonWithDefaultFormatter() throws Exception {
        String result = Differ.generate(sourceJson1, sourceJson2);
        assertEquals(resultStylish, result);
    }

    @Test
    void testYamlWithStylishFormatter() throws Exception {
        String result = Differ.generate(sourceYaml1, sourceYaml2, "stylish");
        assertEquals(resultStylish, result);
    }

    @Test
    void testYamlWithJsonFormatter() throws Exception {
        String result = Differ.generate(sourceYaml1, sourceYaml2, "json");
        assertEquals(resultJson, result);
    }

    @Test
    void testYamlWithPlainFormatter() throws Exception {
        String result = Differ.generate(sourceYaml1, sourceYaml2, "plain");
        assertEquals(resultPlain, result);
    }

    @Test
    void testYamlWithDefaultFormatter() throws Exception {
        String result = Differ.generate(sourceYaml1, sourceYaml2);
        assertEquals(resultStylish, result);
    }
}
