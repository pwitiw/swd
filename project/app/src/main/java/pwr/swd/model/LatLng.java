package pwr.swd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Patryk on 04.05.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LatLng {

    protected Double lat;
    protected Double lng;

    public LatLng() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

}
