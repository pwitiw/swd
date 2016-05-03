package pwr.swd;


/**
 * Created by Patryk on 28.04.2016.
 */
public class LocModel {

    private String country;
    private String city;
    private String voivodeship;
    private Float[] times;
    private Float[] distances;

    public LocModel(Float[] times, Float[] distances) {
        this.times = times;
        this.distances = distances;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public Float[] getTimes() {
        return times;
    }

    public void setTimes(Float[] times) {
        this.times = times;
    }

    public Float[] getDistances() {
        return distances;
    }

    public void setDistances(Float[] distances) {
        this.distances = distances;
    }
}

