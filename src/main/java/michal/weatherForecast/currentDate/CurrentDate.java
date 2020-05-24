package michal.weatherForecast.currentDate;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 5/24/2020
 **/
@Data
@Document(collection = "current-date")
public class CurrentDate {
    @Id
    private String id;
    private LocalDateTime localDateTime;
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    public CurrentDate(int day, int month, int year, int hour, int minute) {
        localDateTime = LocalDateTime.now();
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    public CurrentDate() {
        localDateTime = LocalDateTime.now();
    }

    public int getDay() {
        return localDateTime.getDayOfMonth();
    }

    public int getMonth() {
        return localDateTime.getMonthValue();
    }

    public int getYear() {
        return localDateTime.getYear();
    }

    public int getHour() {
        return localDateTime.getHour();
    }

    public int getMinute() {
        return localDateTime.getMinute();
    }

    public String getCurrentDate() {
        CurrentDate date = new CurrentDate();
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        int hour = date.getHour();
        int minute = date.getMinute();

        return String.valueOf(new CurrentDate(day, month, year, hour, minute));
    }
}
