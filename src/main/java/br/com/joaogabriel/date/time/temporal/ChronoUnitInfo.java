package br.com.joaogabriel.date.time.temporal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * A standard set of date periods units.
 * This set of units provides unit-based access to manipulate a date, time or date-time.
 * */
public class ChronoUnitInfo {
    public static void main(String[] args) {
        LocalDateTime birthDay = LocalDateTime.of(1996, Month.JANUARY, 15, 0, 0);
        LocalDate asm = LocalDate.of(1996, Month.JANUARY, 15);
        System.out.println("Days: " + ChronoUnit.DAYS.between(birthDay, LocalDateTime.now()));
        System.out.println("Weeks: " + ChronoUnit.WEEKS.between(birthDay, LocalDateTime.now()));
        System.out.println("Months: " + ChronoUnit.MONTHS.between(birthDay, LocalDateTime.now()));
        System.out.println("Years: " + ChronoUnit.YEARS.between(birthDay, LocalDateTime.now()));




    }
}

