package dave.miller.util;

import dave.miller.logging.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TigramUtil {

    private TigramUtil() {
        //  private constructor for utility class
    }

    public static Map<String, List<String>> generateTigramMap(final String[] textArray) {

        Map<String, List<String>> tigramMap = generateFirstTigram(textArray);

        for (int i = 1; i < textArray.length - 2; i++) {
            String key = generateKey(textArray, i);
            String value = generateValue(textArray, i);
            if (tigramMap.containsKey(key)) {
                tigramMap.get(key).add(value);
            } else {
                addTigramKeyValue(tigramMap, key, value);
            }

        }

        return tigramMap;
    }

    private static Map<String, List<String>> generateFirstTigram(final String[] textArray) {

        Map<String, List<String>> tigramMap = new HashMap<>();

        String key = generateKey(textArray, 0);
        String value = generateValue(textArray, 0);

        addTigramKeyValue(tigramMap, key, value);

        return tigramMap;
    }

    private static String generateKey(final String[] textArray, final int index) {
        return textArray[index] + " " + textArray[index + 1];
    }

    private static String generateValue(final String[] textArray, final int index) {
        return textArray[index + 2];
    }

    private static void addTigramKeyValue(final Map<String, List<String>> tigramMap, final String key, final String value) {
        List<String> values = new ArrayList<>();
        values.add(value);
        tigramMap.put(key, values);
    }

    public static String generateTigramText(final Map<String, List<String>> tigramMap) {

        if(tigramMap == null || tigramMap.isEmpty()) throw new IllegalArgumentException("tigramMap must not be null or empty");

        List<String> trigramKeys = new ArrayList<>(tigramMap.keySet());
        String nextWordKey = trigramKeys.get(RandomUtil.generateRandomInt(trigramKeys.size() - 1));
        Logger.log("Starting words:" + nextWordKey);
        StringBuilder textBuffer = new StringBuilder(nextWordKey);
        List<String> nextWordsList = tigramMap.get(nextWordKey);
        while (nextWordsList != null) {

            String randomNextWord;
            if (nextWordsList.size() == 1) {
                randomNextWord = nextWordsList.get(0);
            } else {
                randomNextWord = nextWordsList.get(RandomUtil.generateRandomInt(nextWordsList.size() - 1));
            }
            Logger.log("randomNextWord :" + randomNextWord);

            String nextWordLookupValue = nextWordKey + " " + randomNextWord;
            textBuffer.append(" ").append(randomNextWord);
            nextWordKey = nextWordLookupValue.substring(nextWordLookupValue.indexOf(" ") + 1);
            Logger.log("nextWordKey :" + nextWordKey);
            nextWordsList = tigramMap.get(nextWordKey);
        }
        return textBuffer.toString();
    }

}
