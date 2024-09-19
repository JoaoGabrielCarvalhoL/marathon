package br.com.joaogabriel.date.time;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

/**
 * ZoneId
 * ZonedDateTime
 * OffsetDateTime
 * */
public class ZonedInfo {
    public static void main(String[] args) {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        System.out.println(shortIds);
        System.out.println("Zone on Operational System: " + ZoneId.systemDefault());
        ZoneId phoenix = ZoneId.of("America/Phoenix");
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(phoenix);
        System.out.println(zonedDateTime);

        System.out.println(ZoneOffset.MAX);
        System.out.println(ZoneOffset.MIN);

        ZoneOffset zoneOffset = ZoneOffset.of("-04:00"); //Must be this syntax
        OffsetDateTime offsetDateTime = LocalDateTime.now().atOffset(zoneOffset);
        System.out.println(offsetDateTime);

        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
        System.out.println(japaneseDate);

        JapaneseDate from = JapaneseDate.from(LocalDate.of(1900, Month.JANUARY, 1));
        System.out.print(from);


    }
}
