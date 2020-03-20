package michal.weatherForecast.temperature;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 20.03.2020
 **/

@RestController
@RequestMapping("/temp")
public class WeatherTemperatureController {
    private WeatherTemperatureRepository weatherTemperatureRepository;

    public WeatherTemperatureController(WeatherTemperatureRepository weatherTemperatureRepository) {
        this.weatherTemperatureRepository = weatherTemperatureRepository;
    }
}
