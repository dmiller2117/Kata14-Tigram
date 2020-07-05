package miller.dave.util;

import miller.dave.logging.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomUtilTest {

    @Test
    void generateRandomInt() {
        for (int i = 0; i < 100; i++) {
            int randomInt = RandomUtil.generateRandomInt(10);
            Logger.log("Random int, max 10: " + randomInt);
            assertTrue(randomInt >= 0);
            assertTrue(randomInt <= 10);
        }
    }

    @Test
    void generateRandomIntIntRange() {
        for (int i = 0; i < 100; i++) {
            int randomInt = RandomUtil.generateRandomInt(0, 10);
            assertTrue(randomInt >= 0);
            assertTrue(randomInt <= 10);

            randomInt = RandomUtil.generateRandomInt(100, 150);
            Logger.log("Random int, max 10: " + randomInt);
            assertTrue(randomInt >= 100);
            assertTrue(randomInt <= 150);
        }
    }
}