package dave.miller.io;

import dave.miller.logging.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class FileWriter {

    private FileWriter() {
        // private constructor for utility class
    }

    public static String generateFileName() {
        String now = LocalDateTime.now().toString();
        String fileName = "TigramGenerated_" + now + ".txt";
        Logger.log("Generating file name: " + fileName);
        return fileName;
    }

    public static void writeFile(final String fileText, final String fileName) throws IOException {

        Files.write(Paths.get(fileName), fileText.getBytes(StandardCharsets.UTF_8));

    }
}
