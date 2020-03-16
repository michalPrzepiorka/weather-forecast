package michal.weatherForecast.temperature;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 16.03.2020
 **/

public class WeatherTemperatureHelper {

    private String cityName;
    private String temperature;

    public WeatherTemperatureHelper(String cityName, String temperature) {
        this.cityName = cityName;
        this.temperature = temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
