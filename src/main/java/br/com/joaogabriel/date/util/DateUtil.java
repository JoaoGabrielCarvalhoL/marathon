package br.com.joaogabriel.date.util;

import java.util.Date;

public class DateUtil {
    public static void main(String[] args) {
        /**
         * Since version 1.
         * Over time, it became an obsolete class.
         *  Work with milliseconds;
         *
         *  Deprecated. Problems with internationalization
         * */
        Date date = new Date(1_000_000_000_000L); // long as represented milliseconds since 01/01/1970
        System.out.println(date);

        Date today = new Date();
        long todayInMilliseconds = today.getTime();
        System.out.println(todayInMilliseconds);

        //Add 01h00
        today.setTime(today.getTime() + 3_600_000L);
        System.out.println(today);


    }
}
