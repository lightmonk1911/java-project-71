package hexlet.code;

import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "0.1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<String> {
    @Override
    public String call() {
        System.out.println("Hello, world!");
        return "";
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
