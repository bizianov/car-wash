package application.dto.current;

import application.dto.*;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentWeather {

    @SerializedName("coord")
    private Location location;
    private List<Weather> weather;
    @SerializedName("main")
    private MainInfo mainInfo;
    private Rain rain;
    private Clouds clouds;

    public CurrentWeather() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CurrentWeather{");
        sb.append("location=").append(location);
        sb.append(", weather=").append(weather);
        sb.append(", mainInfo=").append(mainInfo);
        sb.append(", rain=").append(rain);
        sb.append(", clouds=").append(clouds);
        sb.append('}');
        return sb.toString();
    }
}