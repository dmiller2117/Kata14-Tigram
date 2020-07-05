package dave.miller;

import dave.miller.io.FileReader;
import dave.miller.io.FileWriter;
import dave.miller.logging.Logger;
import dave.miller.util.StringUtil;
import dave.miller.util.TigramUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class TigramGenerator {

    public static void main(String[] args) throws IOException, URISyntaxException {

        // Read in a file
        // Format it to remove what we don't need so we can create a clean data structure, an array would be best as we
        // need to look ahead and we will know the size from the beginning.
        // Create a tigram map, based on reading three adjacent words.  First two are the key, third is the value
        // then move to the next word and do the same.  Have made all words lowercase for ease of lookup.
        // Future enhancement would be to use a word metadata class so we would know what capitalisation and punctuation
        // a word originally had in the initial document.
        // Then loop round the map, use a random pair key, and use this to generate the next random word.
        // Use the new word pair at the end of the text to do another lookup.
        // Add some punctuation routines to take care of basic capitalisation, sentences and paragraphs.
        // Write the file out in the root directory

        Logger.log("About to start processing");
        String fileText = FileReader.getFileAsString("Tom_Swift_and_His_Submarine_Boat_Chapt1.txt");

        String textWithoutPunct = StringUtil.removePunctuation(fileText);

        String textWithNoNewLines = StringUtil.removeNewLine(textWithoutPunct);

        String textWithNoDoubleSpaces = StringUtil.removeWhiteSpace(textWithNoNewLines);

        String textLowercase = textWithNoDoubleSpaces.toLowerCase();

        String[] textArray = StringUtil.splitStringBySpace(textLowercase);

        Logger.log(textWithNoNewLines);

        Map<String, List<String>> tigramMap = TigramUtil.generateTigramMap(textArray);
        Logger.log(tigramMap.toString());

        String tigramText = TigramUtil.generateTigramText(tigramMap);

        Logger.log(tigramText);

        String fileName = FileWriter.generateFileName();
        FileWriter.writeFile(tigramText, fileName);

        Logger.log("End of processing");

    }

}
