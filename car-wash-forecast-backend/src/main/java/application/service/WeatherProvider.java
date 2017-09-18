package application.service;

public interface WeatherProvider {

    String getCurrentWeather(String city, String countryCode);

    String getForecastWeather(String city, String countryCode);
}