package application.dto.forecast;

import application.dto.Location;
import com.google.gson.annotations.SerializedName;

public class City {

    private String name;
    @SerializedName("coord")
    private Location location;

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("City{");
        sb.append("name='").append(name).append('\'');
        sb.append(", location=").append(location);
        sb.append('}');
        return sb.toString();
    }
}