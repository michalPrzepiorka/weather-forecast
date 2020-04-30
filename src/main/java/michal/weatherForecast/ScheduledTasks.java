package michal.weatherForecast;

import michal.weatherForecast.temperature.WeatherTemperatureHelper;
import michal.weatherForecast.temperature.WeatherTemperatureProvider;
import michal.weatherForecast.temperature.WeatherTemperatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 21.03.2020
 **/

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private WeatherTemperatureRepository repository;

    @Scheduled(fixedRate = 3600000)
    public void reportCurrentTime() {
        repository.deleteAll();
        WeatherTemperatureProvider.getCityTemperature()
                .stream()
                .map(data -> new WeatherTemperatureHelper(data.getCityName(), data.getTemperature()))
                .forEach(weatherForecast -> {
                    boolean add = false;
                    if (repository.findFirstByCityNameAndAndTemperature(weatherForecast.getCityName(), weatherForecast.getTemperature()) == null) {
                        repository.save(weatherForecast);
                        add = true;
                    }
                    log.info("Did we update the database: " + add);
                });
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
