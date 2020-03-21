package michal.weatherForecast.temperature;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 16.03.2020
 **/

@Data
@Document(collection = "city-and-temperature")
public class WeatherTemperatureHelper {
    @Id
    private String id;
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
