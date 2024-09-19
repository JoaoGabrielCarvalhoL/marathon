package br.com.joaogabriel.date.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * <Name of Class> + Formatter: Object to String
 * <Name of Class> + Parse: String to Object
 *
 *  DateTimeFormatter now is a class responsible for formatter.
 * */

public class DateTimeFormatterInfo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE)); //pattern of formatter
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_TIME));
        System.out.println(localDate.format(DateTimeFormatter.ISO_WEEK_DATE));

        LocalDate parseOfIsoDate = LocalDate.parse("2024-09-19");
        System.out.println(parseOfIsoDate);
        LocalDate parseOfBasicIsoDate = LocalDate.parse("20240919", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parseOfBasicIsoDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String now = LocalDate.now().format(formatter);
        System.out.println(now);
        LocalDate parsed = LocalDate.parse("19/09/2024", formatter);
        System.out.println(parsed);

        DateTimeFormatter formatterGerman = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);
        String formatted = LocalDate.now().format(formatterGerman);
        System.out.println(formatted);


    }

    /**
     * System.out.println(localDate.format(DateTimeFormatter.ISO_OFFSET_DATE));
     * System.out.println(localDate.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
     * System.out.println(localDate.format(DateTimeFormatter.ISO_OFFSET_TIME));
     * System.out.println(localDate.format(DateTimeFormatter.ISO_ORDINAL_DATE));
     * System.out.println(localDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
     * System.out.println(localDateTime.format(DateTimeFormatter.RFC_1123_DATE_TIME));
     * System.out.println(localDateTime.format(DateTimeFormatter.ISO_INSTANT));
     *
     *
     * */
}
