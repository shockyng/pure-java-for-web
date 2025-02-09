package me.shockyng;

import java.time.LocalDateTime;

public class APILogger {

    private static Class aClass;

    private APILogger(Class t) {
        aClass = t;
    }

    public static APILogger getLogger(Class t) {
        return new APILogger(t);
    }

    public void info(String message) {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.printf(
                "%1$tm/%1$td/%1$tY - %2$s - %3$s \n",
                dateTime,
                aClass.getName(),
                message
        );
    }
}
