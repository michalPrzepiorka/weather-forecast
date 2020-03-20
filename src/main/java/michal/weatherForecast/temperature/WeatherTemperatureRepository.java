package michal.weatherForecast.temperature;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 20.03.2020
 **/

public interface WeatherTemperatureRepository extends CrudRepository<WeatherTemperatureHelper, String> {
    WeatherTemperatureHelper findFirstByCity(String city);

    WeatherTemperatureHelper findFirstByCityAndTemp(String city, String temperature);
}
