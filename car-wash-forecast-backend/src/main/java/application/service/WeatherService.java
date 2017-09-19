package application.service;

import application.dto.CurrentWeather;
import application.request.RequestBuilder;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService implements WeatherProvider {

    private RequestBuilder currentWeatherRequestBuilders;
    private RequestBuilder forecastWeatherRequestBuilders;
    private RestTemplate restTemplate;
    private Gson gson;

    @Autowired
    public WeatherService(@Qualifier("current-weather") RequestBuilder currentWeatherRequestBuilders,
                          @Qualifier("forecast-weather")RequestBuilder forecastWeatherRequestBuilders,
                          RestTemplate restTemplate,
                          Gson gson) {
        this.currentWeatherRequestBuilders = currentWeatherRequestBuilders;
        this.forecastWeatherRequestBuilders = forecastWeatherRequestBuilders;
        this.restTemplate = restTemplate;
        this.gson = gson;
    }

    @Override
    public String getCurrentWeather(String city, String countryCode) {
        String request = currentWeatherRequestBuilders.buildRequest(city, countryCode);
        ResponseEntity<String> response = restTemplate.getForEntity(request, String.class);
        CurrentWeather currentWeather = gson.fromJson(response.getBody(), CurrentWeather.class);
        return gson.toJson(currentWeather);
    }

    @Override
    public String getForecastWeather(String city, String countryCode) {
        String request = forecastWeatherRequestBuilders.buildRequest(city, countryCode);
        ResponseEntity<String> response = restTemplate.getForEntity(request, String.class);
        return response.getBody();
    }
}