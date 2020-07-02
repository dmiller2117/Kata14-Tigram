package dave.miller.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilTest {

    @Test
    public void removePunctuation() {
        assertEquals("Gracious goodness What was that Mrs Baggert", StringUtil.removePunctuation("\"Gracious goodness!\" What was that, Mrs. Baggert?"));
    }

}