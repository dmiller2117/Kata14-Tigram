package dave.miller.logging;

import java.time.LocalDateTime;

public class Logger {

    public static void log(String string) {
        LocalDateTime.now();
        System.out.println(LocalDateTime.now() + " :: " + string);
    }

}
