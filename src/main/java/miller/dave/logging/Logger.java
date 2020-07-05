package miller.dave.logging;

import java.time.LocalDateTime;

public class Logger {

    public static void log(String string) {
        System.out.println(LocalDateTime.now() + " :: " + string);
    }

}
