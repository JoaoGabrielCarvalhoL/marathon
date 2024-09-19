package br.com.joaogabriel.date.time;

import java.time.LocalDate;
import java.time.Period;

/**
 * The Period class was created to be used to work with amounts of time.
 * It is used to account for time intervals, dates and isn't based on seconds and nanoseconds. Only dates.
 * */
public class PeriodInfo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate future = LocalDate.now().plusYears(10);

        Period resultBetween = Period.between(now, future); //Only LocalDate
        System.out.println(resultBetween);

        Period days = Period.of(1, 15, 30);
        System.out.println(days);

        System.out.println(Period.ofDays(30));
        System.out.println(Period.ofMonths(60));
        System.out.println(Period.ofWeeks(40));
        System.out.println(Period.ofYears(15));
    }
}
