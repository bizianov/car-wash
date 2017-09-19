package application.dto;

public class Clouds {

    private int all;

    public Clouds() {
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Clouds{");
        sb.append("all=").append(all);
        sb.append('}');
        return sb.toString();
    }
}