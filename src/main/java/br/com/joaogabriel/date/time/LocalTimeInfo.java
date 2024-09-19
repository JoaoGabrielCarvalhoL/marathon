package br.com.joaogabriel.date.time;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeInfo {
    public static void main(String[] args) {
        LocalTime localTimeNow = LocalTime.now();
        LocalTime localTimeOf = LocalTime.of(12, 10);
        LocalTime localTimeOfWithSeconds = LocalTime.of(12, 10, 30);
        System.out.println(localTimeNow);
        System.out.println(localTimeOf);
        System.out.println(localTimeOfWithSeconds);
        System.out.println(localTimeNow.get(ChronoField.CLOCK_HOUR_OF_AMPM));
        System.out.println(localTimeNow.get(ChronoField.CLOCK_HOUR_OF_DAY));
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);
    }
}
