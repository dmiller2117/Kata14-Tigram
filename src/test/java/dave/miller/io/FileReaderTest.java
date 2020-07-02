package dave.miller.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    @Test
    void getFileAsString() throws IOException, URISyntaxException {
        String fileString = FileReader.getFileAsString("testFile.txt");
        assertEquals("This is a test file with some text in it.", fileString);
    }

    @Test
    void getFileMultiLineAsString() throws IOException, URISyntaxException {
        String fileString = FileReader.getFileAsString("testFileMultiLine.txt");
        assertEquals("There was a rushing, whizzing, throbbing noise in the air.  A great\n" +
                "body, like that of some immense bird, sailed along, casting a grotesque\n" +
                "shadow on the ground below.  An elderly man, who was seated on the\n" +
                "porch of a large house, started to his feet in alarm.", fileString);
    }
}