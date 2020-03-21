package michal.weatherForecast.temperature;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 20.03.2020
 **/

public interface WeatherTemperatureRepository extends CrudRepository<WeatherTemperatureHelper, String> {
    WeatherTemperatureHelper findFirstByCityName(String city);
    WeatherTemperatureHelper findFirstByCityNameAndAndTemperature(String city, String temperature);
}
