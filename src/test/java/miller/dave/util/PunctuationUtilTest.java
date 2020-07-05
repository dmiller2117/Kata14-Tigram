package miller.dave.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PunctuationUtilTest {

    @Test
    @DisplayName("Capitalise the word if it matches a reserved set")
    public void capitaliseWord() {
        assertEquals("I", PunctuationUtil.capitaliseWord("prevWord", "i", 2));
        assertEquals("Mr", PunctuationUtil.capitaliseWord("prevWord", "mr", 2));
        assertEquals("Mrs", PunctuationUtil.capitaliseWord("prevWord", "mrs", 2));
        assertEquals("Tom", PunctuationUtil.capitaliseWord("prevWord", "tom", 2));
        assertEquals("I", PunctuationUtil.capitaliseWord("prevWord", "i", 2));
    }

    @Test
    @DisplayName("Capitalise the word if it's the first word in a sentence'")
    public void capitaliseWordForTheFirstWord() {
        assertEquals("I", PunctuationUtil.capitaliseWord("prevWord", "i", 1));
        assertEquals("Now", PunctuationUtil.capitaliseWord("prevWord", "now", 1));
        assertEquals("Not", PunctuationUtil.capitaliseWord("prevWord", "not", 1));
        assertEquals("A", PunctuationUtil.capitaliseWord("prevWord", "a", 1));
        assertEquals("Gibberish", PunctuationUtil.capitaliseWord("prevWord", "gibberish", 1));
    }

    @Test
    @DisplayName("Capitalise the word if the previous word matches a reserved set'")
    public void capitaliseWordForThePreviousWord() {
        assertEquals("Smith", PunctuationUtil.capitaliseWord("mr", "smith", 2));
        assertEquals("Tiggiewinkle", PunctuationUtil.capitaliseWord("mrs", "tiggiewinkle", 2));
        assertEquals("Dot", PunctuationUtil.capitaliseWord(".", "dot", 2));
    }

    @Test
    @DisplayName("Only a new sentence if there is only one word")
    public void isNewSentence() {
        assertTrue(PunctuationUtil.isNewSentence(1));
        assertFalse(PunctuationUtil.isNewSentence(0));
        assertFalse(PunctuationUtil.isNewSentence(2));
        assertFalse(PunctuationUtil.isNewSentence(100));
    }

    @Test
    @DisplayName("Only a new sentence we are between 15 and 20 words and not a reserved set.")
    public void isNewSentenceWithNextWord() {
        assertTrue(PunctuationUtil.isNewSentence(20, "another"));
        assertTrue(PunctuationUtil.isNewSentence(20, "word"));
        assertTrue(PunctuationUtil.isNewSentence(20, "altogether"));

        assertFalse(PunctuationUtil.isNewSentence(20, "i"));
        assertFalse(PunctuationUtil.isNewSentence(20, "a"));
        assertFalse(PunctuationUtil.isNewSentence(20, "mr"));
        assertFalse(PunctuationUtil.isNewSentence(20, "mrs"));
        assertFalse(PunctuationUtil.isNewSentence(20, "and"));

        assertFalse(PunctuationUtil.isNewSentence(14, "another"));
        assertFalse(PunctuationUtil.isNewSentence(10, "word"));
        assertFalse(PunctuationUtil.isNewSentence(14, "altogether"));
    }

    @Test
    @DisplayName("Creating a new paragraph every 3 to 6 sentences")
    public void isNewParagraph() {
        assertTrue(PunctuationUtil.isNewParagraph(6));
        assertTrue(PunctuationUtil.isNewParagraph(7));
        assertTrue(PunctuationUtil.isNewParagraph(RandomUtil.generateRandomInt(6, 1000)));

        assertFalse(PunctuationUtil.isNewParagraph(2));
        assertFalse(PunctuationUtil.isNewParagraph(1));
    }

}