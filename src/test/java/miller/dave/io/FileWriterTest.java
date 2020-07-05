package miller.dave.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileWriterTest {

    private String fileName;

    @Test
    @DisplayName("test a file is written")
    public void writeFile() throws IOException {

        fileName = FileWriter.generateFileName();
        assertTrue(fileName.endsWith(".txt"));
        assertTrue(fileName.startsWith("TigramGenerated_"));

        FileWriter.writeFile("text to write", fileName);

        String content = new String(Files.readAllBytes(Paths.get(fileName)));

        assertNotNull(content);
        assertEquals("text to write", content);

    }

    @AfterEach
    public void cleanUp() throws IOException {
        Files.delete(Paths.get(fileName));
    }

}