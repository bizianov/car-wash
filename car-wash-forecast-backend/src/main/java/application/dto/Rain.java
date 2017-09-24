package application.dto;

import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("3h")
    private double last3hoursAmount;

    public Rain() {
    }

    public double getLast3hoursAmount() {
        return last3hoursAmount;
    }

    public void setLast3hoursAmount(double last3hoursAmount) {
        this.last3hoursAmount = last3hoursAmount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Rain{");
        sb.append("last3hoursAmount='").append(last3hoursAmount).append('\'');
        sb.append('}');
        return sb.toString();
    }
}