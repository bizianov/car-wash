package request;

import application.request.ForecastWeatherRequestBuilder;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ForecastWeatherRequestBuilderTest {

    private static final String FORECAST_REQUEST_PREFIX = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String FORECAST_REQUEST_SUFFIX = "&appid=470093b9e92109886214fd5a9bba9584";
    private static final String DELIMITER = ",";
    private static final String CITY = "Odessa";
    private static final String COUNTRY_CODE = "UA";

    @Test
    public void forecastWeatherRequest() {
        ForecastWeatherRequestBuilder forecastWeatherRequestBuilder = new ForecastWeatherRequestBuilder();
        forecastWeatherRequestBuilder.setForecastRequestPrefix(FORECAST_REQUEST_PREFIX);
        forecastWeatherRequestBuilder.setRequestSuffix(FORECAST_REQUEST_SUFFIX);
        forecastWeatherRequestBuilder.setDelimiter(DELIMITER);
        String forecastWeatherRequest = forecastWeatherRequestBuilder.buildRequest(CITY, COUNTRY_CODE);
        String expectedResult =
                "http://api.openweathermap.org/data/2.5/forecast?q=Odessa,UA&appid=470093b9e92109886214fd5a9bba9584";
        assertThat(forecastWeatherRequest, is(expectedResult));
    }
}