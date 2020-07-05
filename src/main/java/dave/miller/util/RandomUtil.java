package dave.miller.util;

import java.util.Random;

public class RandomUtil {

    private RandomUtil() {
        // private constructor for utility class
    }

    protected static int generateRandomInt(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange + 1);
    }

    protected static int generateRandomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
