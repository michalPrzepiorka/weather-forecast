package michal.weatherForecast.currentDate;

import org.springframework.web.bind.annotation.*;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 5/24/2020
 **/

@RestController
@RequestMapping("/date")
@CrossOrigin(origins = "http://localhost:8080")
public class DateController {
    private DateRepository dateRepository;

    public DateController(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    @GetMapping("/current-date")
    public CurrentDate getCurrentDate(@RequestParam(required = false) String date) {
        if (date == null) {
            return dateRepository.findAll().iterator().next();
        } else {
            return dateRepository.findFirstByCurrentDate(date);
        }
    }
}
