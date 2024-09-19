package br.com.joaogabriel.date.time;

import java.time.LocalDate;
import java.time.Month;
/**
 * Since 1.8
 * This class is immutable and thread-safe.
 * */
public class LocalDateInfo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate birthOfDate = LocalDate.of(1996, Month.JANUARY, 15);
        System.out.println(now);
        System.out.println(birthOfDate.getDayOfWeek());
        System.out.println(birthOfDate.getDayOfMonth());
        System.out.println(birthOfDate.isLeapYear());

    }
}
