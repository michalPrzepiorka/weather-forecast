package michal.weatherForecast.currentDate;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 5/24/2020
 **/

public interface DateRepository extends CrudRepository<CurrentDate, String> {
    CurrentDate findFirstByCurrentDate(String date);
}
