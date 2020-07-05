package dave.miller.util;

public class PunctuationUtil {

    protected static String capitaliseWord(String previousWord, String word, int sentenceLength) {

        if (isNewSentence(sentenceLength)) return StringUtil.capitalise(word);

        switch (word.toLowerCase()) {
            case "i":
            case "mr":
            case "mrs":
            case "tom":
                return StringUtil.capitalise(word);
            default:
                break;
        }

        switch (previousWord.toLowerCase()) {
            case "mr":
            case "mrs":
            case ".":
                return StringUtil.capitalise(word);
            default:
                return word;
        }

    }

    protected static boolean isNewSentence(final int sentenceLength, final String nextWord) {

        switch (nextWord.toLowerCase()) {
            case "i":
            case "a":
            case "mr":
            case "mrs":
            case "and":
                return false;
            default:
                int goodSentenceLength = RandomUtil.generateRandomInt(15, 20);
                return sentenceLength >= goodSentenceLength;
        }

    }

    protected static boolean isNewSentence(int sentenceLength) {
        return sentenceLength == 1;
    }

    protected static boolean isNewParagraph(int noOfSentences) {
        int goodParagraphLength = RandomUtil.generateRandomInt(3, 6);
        return noOfSentences >= goodParagraphLength;
    }
}
