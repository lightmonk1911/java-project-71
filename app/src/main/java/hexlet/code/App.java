package hexlet.code;

import java.io.File;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "0.1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<String> {

    @Option(names = { "-f", "--format" }, paramLabel = "format", description = "output format [default: ${DEFAULT-VALUE}]", defaultValue = "stylish")
    String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    File filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    File filepath2;

    @Override
    public String call() {
        System.out.println("Hello, world! filepath1 = " + filepath1 + " filepath2 = " + filepath2);
        System.out.println("format = " + format);
        return "";
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
