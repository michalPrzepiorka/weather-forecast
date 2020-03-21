package michal.weatherForecast.temperature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public Iterable<WeatherTemperatureHelper> findAllWeatherForecast() {
        return weatherTemperatureRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<WeatherTemperatureHelper> findByCityId(@PathVariable String id) {
        return weatherTemperatureRepository.findById(id);
    }

    @GetMapping("/search")
    public WeatherTemperatureHelper getWeatherForecastByCity(@RequestParam(required = false) String city) {
        if (city == null) {
            return weatherTemperatureRepository.findAll().iterator().next();
        } else {
            return weatherTemperatureRepository.findFirstByCityName(city);
        }
    }
}
