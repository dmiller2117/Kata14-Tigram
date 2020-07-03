package dave.miller.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TigramUtil {

    private TigramUtil() {
        //  private constructor for utility class
    }

    public static Map<String, List<String>> generateTigramMap(String[] textArray) {

        Map<String, List<String>> tigramMap = generateFirstTigram(textArray);

        for (int i = 1; i < textArray.length - 2; i++) {
            String key = generateKey(textArray, i);
            String value = generateValue(textArray, i);
            if(tigramMap.containsKey(key)){
                tigramMap.get(key).add(value);
            } else {
                addTigramKeyValue(tigramMap, key, value);
            }

        }

        return tigramMap;
    }

    private static Map<String, List<String>> generateFirstTigram(String[] textArray) {

        Map<String, List<String>> tigramMap = new HashMap<>();

        String key = generateKey(textArray, 0);
        String value = generateValue(textArray, 0);

        addTigramKeyValue(tigramMap, key, value);

        return tigramMap;
    }

    private static String generateKey(String[] textArray, int index) {
        return textArray[index] + " " + textArray[index + 1];
    }

    private static String generateValue(String[] textArray, int index) {
        return textArray[index + 2];
    }

    private static void addTigramKeyValue(Map<String, List<String>> tigramMap, String key, String value) {
        List<String> values = new ArrayList<>();
        values.add(value);
        tigramMap.put(key, values);
    }

}
