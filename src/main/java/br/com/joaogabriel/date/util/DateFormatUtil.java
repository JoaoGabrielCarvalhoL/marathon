package br.com.joaogabriel.date.util;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormatUtil {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat[] dateFormats = new DateFormat[7];
        dateFormats[0] = DateFormat.getInstance();
        dateFormats[1] = DateFormat.getDateInstance();
        dateFormats[2] = DateFormat.getDateTimeInstance();
        dateFormats[3] = DateFormat.getDateInstance(DateFormat.SHORT);
        dateFormats[4] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dateFormats[5] = DateFormat.getDateInstance(DateFormat.LONG);
        dateFormats[6] = DateFormat.getDateInstance(DateFormat.FULL);

        for (DateFormat dateFormat : dateFormats) {
            System.out.println(dateFormat.format(calendar.getTime()));
        }

    }
}
