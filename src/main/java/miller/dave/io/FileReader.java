package miller.dave.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

public class FileReader {

    private FileReader() {
        // private constructor for utility class
    }

    public static String getFileAsString(final String filename) throws IOException, URISyntaxException {

        try (InputStream inputStream = FileReader.class.getResourceAsStream("/" + filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            return contents;
        }

    }


}
