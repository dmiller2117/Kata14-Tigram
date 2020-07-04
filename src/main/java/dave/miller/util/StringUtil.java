package dave.miller.util;

public class StringUtil {

    private StringUtil() {
        // private method for utility class
    }

    public static String removePunctuation(final String string) {
        return string.replaceAll("\\p{P}", "");
    }

    public static String removeNewLine(final String string) {
        return string.replaceAll("\n", " ").replaceAll("\r", " ");
    }

    public static String removeWhiteSpace(final String string) {
        return string.trim().replaceAll(" +", " ");
    }

    public static String[] splitStringBySpace(final String string) {
        return string.split(" ");
    }

    public static String capitalise(final String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }


}
