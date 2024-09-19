package br.com.joaogabriel.date.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
    /**
     * Since 1.1
     * Created to resolve problems with internationalization of class Date.
     * */
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        System.out.println("Type of Calendar: " + calendar.getCalendarType());
        System.out.println("Timezone" + calendar.getTimeZone());
        System.out.println("Weeks In Week Year: " + calendar.getWeeksInWeekYear());
        System.out.println("First Day of Week: " + calendar.getFirstDayOfWeek());
        System.out.println("Day of Week: " + Calendar.DAY_OF_WEEK);
        System.out.println("Day of Month: " + Calendar.DAY_OF_MONTH);
        System.out.println("Day of Year: " + Calendar.DAY_OF_YEAR);

        calendar.add(Calendar.DAY_OF_MONTH, 5);
        calendar.add(Calendar.HOUR, 5);
        Date time = calendar.getTime();
        System.out.println(time);

    }
}
