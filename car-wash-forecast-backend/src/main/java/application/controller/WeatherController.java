package application.controller;

import application.service.WeatherProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class WeatherController {

    private WeatherProvider weatherProvider;

    @Autowired
    public WeatherController(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    @CrossOrigin
    @RequestMapping("/weather/{city}/{countryCode}")
    public String weatherRequest(@PathVariable String city, @PathVariable String countryCode) {
        return weatherProvider.getCurrentWeather(city, countryCode);
    }

    @CrossOrigin
    @RequestMapping("/forecast/{city}/{countryCode}")
    public String forecastRequest(@PathVariable String city, @PathVariable String countryCode) {
        return weatherProvider.getForecastWeather(city, countryCode);
    }
}