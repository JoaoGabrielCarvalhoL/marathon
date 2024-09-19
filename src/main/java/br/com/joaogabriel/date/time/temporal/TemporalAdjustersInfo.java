package br.com.joaogabriel.date.time.temporal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersInfo {

    private boolean isBusinessDay(LocalDate day) {
        if (day.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The argument must be in present or future.");
        }

        if (DayOfWeek.of(day.get(ChronoField.DAY_OF_WEEK)) == DayOfWeek.SATURDAY ||
                DayOfWeek.of(day.get(ChronoField.DAY_OF_WEEK)) == DayOfWeek.SUNDAY) {
            return false;
        } else {
            return true;
        }
    }

    public LocalDate nextBusinessDay(LocalDate day) {
        if (!isBusinessDay(day)) {
            return day.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        } else {
            return day;
        }
    }

    public LocalDate get(LocalDate businessDay) {
        int dayOfMonth = businessDay.getDayOfMonth() + 1;
        Month month = businessDay.getMonth();
        int year = businessDay.getYear();
        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        if (isBusinessDay(localDate)) {
            return localDate;
        } else {
            return nextBusinessDay(localDate);
        }
    }


    public static void main(String[] args) {
        LocalDate day = LocalDate.now();
        day = day.with(ChronoField.DAY_OF_MONTH, 30);
        System.out.println(day);
        System.out.println(day.getDayOfWeek());
        System.out.println(day.getDayOfMonth());


        LocalDate now = LocalDate.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalDate next = now.with(TemporalAdjusters.next(dayOfWeek));
        LocalDate last = now.with(TemporalAdjusters.previous(dayOfWeek));
        System.out.println("Next " + dayOfWeek.name() + ": " + next);
        System.out.println("Last " + dayOfWeek.name() + ": " + last);
        System.out.println("First day of " + now.getMonth() + ": " + now.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("Last day of " + now.getMonth() + ": " + now.with(TemporalAdjusters.lastDayOfMonth()));

        TemporalAdjustersInfo temporal = new TemporalAdjustersInfo();
        LocalDate localDate = temporal.nextBusinessDay(LocalDate.now());
        LocalDate localDate1 = temporal.nextBusinessDay(LocalDate.of(2024, Month.SEPTEMBER, 14));
        LocalDate localDate2 = temporal.nextBusinessDay(LocalDate.of(2024, Month.SEPTEMBER, 17));
        System.out.println(localDate);
        System.out.println(localDate1);
        System.out.println(localDate2);
        //aumentando sua consciência sobre sua ignorância;
    }
}
