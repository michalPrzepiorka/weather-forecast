package michal.weatherForecast.currentDate;

import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 5/24/2020
 **/

@RestController
@RequestMapping("/date")
@CrossOrigin(origins = "*")
public class DateController {
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private DateRepository dateRepository;

    public DateController(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    @GetMapping("/current-date")
    public FetchCurrentDateResponse getCurrentDate() {
//        if (date == null) {
        CurrentDate currentDate = dateRepository.findAll().iterator().next();
        if (currentDate == null) {
            return new FetchCurrentDateResponse("No date in database...");
        }
        String dateAsString = FORMATTER.format(currentDate.getLocalDateTime());
        return new FetchCurrentDateResponse(dateAsString);
//        } else {
//            return dateRepository.findFirstByCurrentDate(date);
//        }
    }
}
