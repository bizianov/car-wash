package application.controller;

import application.service.WeatherProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class WeatherController {

    private WeatherProvider weatherProvider;

    @Autowired
    public WeatherController(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    @CrossOrigin
    @RequestMapping(value = "/weather/{city}/{countryCode}", method = RequestMethod.GET)
    public String weatherRequest(@PathVariable String city, @PathVariable String countryCode) {
        return weatherProvider.getCurrentWeather(city, countryCode);
    }

    @CrossOrigin
    @RequestMapping(value = "/forecast/{city}/{countryCode}", method = RequestMethod.GET)
    public String forecastRequest(@PathVariable String city, @PathVariable String countryCode) {
        return weatherProvider.getForecastWeather(city, countryCode);
    }
}