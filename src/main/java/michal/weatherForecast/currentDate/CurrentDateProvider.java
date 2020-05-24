package michal.weatherForecast.currentDate;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 5/24/2020
 **/

public class CurrentDateProvider {
    public static List<CurrentDate> getCurrentDate() {
        List<CurrentDate> currentDate = new LinkedList<>();

        CurrentDate date = new CurrentDate();
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        int hour = date.getHour();
        int minute = date.getMinute();

        currentDate.add(new CurrentDate(
                day,
                month,
                year,
                hour,
                minute
        ));
        return currentDate;
    }
}
