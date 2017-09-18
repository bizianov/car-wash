package application.request;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component("current-weather")
@ConfigurationProperties(prefix = "app.openweathermap")
public class CurrentWeatherRequestBuilder implements RequestBuilder {

    private String weatherRequestPrefix;
    private String requestSuffix;
    private String delimiter;

    @Override
    public String buildRequest(String city, String countryCode) {
        return new StringBuilder()
                .append(weatherRequestPrefix)
                .append(city)
                .append(delimiter)
                .append(countryCode)
                .append(requestSuffix)
                .toString();
    }

    public void setWeatherRequestPrefix(String weatherRequestPrefix) {
        this.weatherRequestPrefix = weatherRequestPrefix;
    }

    public void setRequestSuffix(String requestSuffix) {
        this.requestSuffix = requestSuffix;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}