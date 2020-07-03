package dave.miller.util;

import dave.miller.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test the TigramUtil")
class TigramUtilTest {

    @Test
    @DisplayName("create a TigramMap and verify it's contents")
    void generateTigramMap() {
        String[] textArray = new String[] {"I", "wish", "I", "may", "I", "wish", "I", "might"};
        Map<String, List<String>> tigramMap  = TigramUtil.generateTigramMap(textArray);
        Logger.log(tigramMap.toString());
        assertTrue(tigramMap.containsKey("I wish"));
        List<String> valueList = tigramMap.get("I wish");
        assertEquals(2, valueList.size());
        assertEquals("I", valueList.get(0));
        assertEquals("I", valueList.get(1));

        assertTrue(tigramMap.containsKey("may I"));
        valueList = tigramMap.get("may I");
        assertEquals(1, valueList.size());
        assertEquals("wish", valueList.get(0));

        assertTrue(tigramMap.containsKey("I may"));
        valueList = tigramMap.get("I may");
        assertEquals(1, valueList.size());
        assertEquals("I", valueList.get(0));

        assertTrue(tigramMap.containsKey("wish I"));
        valueList = tigramMap.get("wish I");
        assertEquals(2, valueList.size());
        assertEquals("may", valueList.get(0));
        assertEquals("might", valueList.get(1));
    }
}