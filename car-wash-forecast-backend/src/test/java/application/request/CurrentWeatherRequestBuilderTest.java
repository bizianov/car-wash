package application.request;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CurrentWeatherRequestBuilderTest {

    private static final String WEATHER_REQUEST_PREFIX = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String WEATHER_REQUEST_SUFFIX = "&appid=470093b9e92109886214fd5a9bba9584";
    private static final String DELIMITER = ",";
    private static final String CITY = "Odessa";
    private static final String COUNTRY_CODE = "UA";

    @Test
    public void currentWeatherRequest() {
        CurrentWeatherRequestBuilder currentWeatherRequestBuilder = new CurrentWeatherRequestBuilder();
        currentWeatherRequestBuilder.setWeatherRequestPrefix(WEATHER_REQUEST_PREFIX);
        currentWeatherRequestBuilder.setRequestSuffix(WEATHER_REQUEST_SUFFIX);
        currentWeatherRequestBuilder.setDelimiter(DELIMITER);
        String currentWeatherRequest = currentWeatherRequestBuilder.buildRequest(CITY, COUNTRY_CODE);
        String expectedResult =
                "http://api.openweathermap.org/data/2.5/weather?q=Odessa,UA&appid=470093b9e92109886214fd5a9bba9584";
        assertThat(currentWeatherRequest, is(expectedResult));
    }
}