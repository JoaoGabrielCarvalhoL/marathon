package br.com.joaogabriel.date.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Just small demonstrations.
 * */

public class LocalDateTimeInfo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);
        LocalDate date = LocalDate.parse("2024-09-09");
        LocalTime time = LocalTime.parse("18:46:00");
        LocalDateTime anotherDate = date.atTime(time);
        LocalDateTime anotherTime = time.atDate(date);
        System.out.println(anotherDate);
        System.out.println(anotherTime);
    }
}
