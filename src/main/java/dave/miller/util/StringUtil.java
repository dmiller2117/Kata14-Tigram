package dave.miller.util;

public class StringUtil {

    private StringUtil() {
        // private method for utility class
    }

    public static String removePunctuation(String string) {
        return string.replaceAll("\\p{P}", "");
    }

}
