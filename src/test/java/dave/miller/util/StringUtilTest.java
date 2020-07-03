package dave.miller.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test the StringUtil")
class StringUtilTest {

    @Test
    @DisplayName("Test the punctuation is removed")
    public void removePunctuation() {
        assertEquals("Gracious goodness What was that Mrs Baggert", StringUtil.removePunctuation("\"Gracious goodness!\" What was that, Mrs. Baggert?"));
    }

    @Test
    @DisplayName("Test the string is split by a space correctly")
    public void splitStringBySpace(){
        assertArrayEquals(new String[]{"test", "test"}, StringUtil.splitStringBySpace("test test"));
        assertArrayEquals(new String[]{"Gracious", "goodness", "What", "was", "that", "Mrs", "Baggert"}, StringUtil.splitStringBySpace("Gracious goodness What was that Mrs Baggert"));
        assertArrayEquals(new String[]{"There", "was", "a", "rushing,", "whizzing,", "throbbing", "noise", "in", "the", "air.", "", "A", "great", "body,", "like", "that", "of", "some", "immense", "bird,", "sailed", "along,", "casting", "a", "grotesque"}, StringUtil.splitStringBySpace("There was a rushing, whizzing, throbbing noise in the air.  A great body, like that of some immense bird, sailed along, casting a grotesque"));
    }

    @Test
    @DisplayName("Test we remove new lines, for all varients")
    public void removeNewLine(){
        assertEquals("this has no new lines in it", StringUtil.removeNewLine("this has no new lines\nin it"));
        assertEquals("this has no new lines in it", StringUtil.removeNewLine("this has no new lines\rin it"));
        assertEquals("this has no new lines  in it", StringUtil.removeNewLine("this has no new lines\n\rin it"));
    }

}