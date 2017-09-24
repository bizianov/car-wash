package application.dto.forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastWeather {

    private City city;
    @SerializedName("list")
    private List<ForecastItem> forecastItems;

    public ForecastWeather() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<ForecastItem> getForecastItems() {
        return forecastItems;
    }

    public void setForecastItems(List<ForecastItem> forecastItems) {
        this.forecastItems = forecastItems;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ForecastWeather{");
        sb.append("city=").append(city);
        sb.append(", forecastItems=").append(forecastItems);
        sb.append('}');
        return sb.toString();
    }
}