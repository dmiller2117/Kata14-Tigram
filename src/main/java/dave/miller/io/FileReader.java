package dave.miller.io;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private FileReader(){
        // private constructor for utility class
    }

    public static String getFileAsString(String filename) throws IOException, URISyntaxException {

        Path path = Paths.get(FileReader.class.getClassLoader()
                .getResource(filename).toURI());

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();

        return data.trim();
    }


}
