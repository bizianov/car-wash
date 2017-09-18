package application.request;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("forecast-weather")
@ConfigurationProperties(prefix = "app.openweathermap")
public class ForecastWeatherRequestBuilder implements RequestBuilder {

    private String forecastRequestPrefix;
    private String requestSuffix;
    private String delimiter;

    @Override
    public String buildRequest(String city, String countryCode) {
        return new StringBuilder()
                .append(forecastRequestPrefix)
                .append(city)
                .append(delimiter)
                .append(countryCode)
                .append(requestSuffix)
                .toString();
    }

    public void setForecastRequestPrefix(String forecastRequestPrefix) {
        this.forecastRequestPrefix = forecastRequestPrefix;
    }

    public void setRequestSuffix(String requestSuffix) {
        this.requestSuffix = requestSuffix;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}