package michal.weatherForecast.temperature;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Y510p
 * @project weatherForecast
 * @date 16.03.2020
 **/

public class WeatherTemperatureProvider {
    public static List<WeatherTemperatureHelper> getCityTemperature() {
        final Document document;
        List<WeatherTemperatureHelper> weather = new LinkedList<>();

        try {
            document = Jsoup.connect("https://pogoda.interia.pl/").get();
            Elements element = document.getElementsByClass("weather-places-group cities-weather is-legend");
            weather.clear();

            for (Element row : element.select("ul").select("li")) {
                Element index = row.getElementsByClass("weather-index-item").first();

                String cityName = index.getElementsByClass("weather-index-item-name saveCityInCookie").first().text();
                String temp = index.selectFirst("span").text();
                weather.add(new WeatherTemperatureHelper(cityName, temp));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return weather;
    }
}
