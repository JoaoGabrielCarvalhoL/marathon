package br.com.joaogabriel.date.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * The Duration class was created to be used to work with amounts of time.
 * It is used to account for time intervals, dates and is based on seconds and nanoseconds.
 * */

public class DurationInfo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime afterTwoYears = LocalDateTime.now().plusYears(2);

        LocalTime hourlyNow = LocalTime.now();
        LocalTime hourlyAfterSevenHours = LocalTime.now().plusHours(7);

        Duration betweenDate = Duration.between(now, afterTwoYears);
        Duration betweenTime = Duration.between(hourlyNow, hourlyAfterSevenHours);
        System.out.println(betweenDate);
        System.out.println(betweenTime);

        /**
         * LocalDate does not support seconds.
         * When passing LocalDate type arguments as a parameter, an exception is thrown at runtime.
         * */

        Duration hoursInDays = Duration.ofDays(31);
        Duration hoursInHours = Duration.ofMinutes(120);
        System.out.println(hoursInDays);
        System.out.println(hoursInHours);


    }
}
