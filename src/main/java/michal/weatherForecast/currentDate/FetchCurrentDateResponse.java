package michal.weatherForecast.currentDate;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 5/25/2020
 **/

public class FetchCurrentDateResponse {
    private String date;

    public FetchCurrentDateResponse(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
