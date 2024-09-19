package br.com.joaogabriel.internationalization;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleUtil {

    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        Locale pt = Locale.of("pt", "BR");
        Locale it = Locale.of("it", "IT");
        Calendar calendar = Calendar.getInstance();
        DateFormat dateInstancePt = DateFormat.getDateInstance(DateFormat.FULL, pt);
        DateFormat dateInstanceIt = DateFormat.getDateInstance(DateFormat.FULL, it);
        System.out.println(pt.getDisplayCountry() + ": " + dateInstancePt.format(calendar.getTime()));
        System.out.println(it.getDisplayCountry() + ": " + dateInstanceIt.format(calendar.getTime()));

    }
}
