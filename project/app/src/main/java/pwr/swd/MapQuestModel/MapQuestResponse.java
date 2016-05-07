package pwr.swd.mapQuestModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Patryk on 04.05.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapQuestResponse {

    private Float[][] distance;
    private Float[][] time;
    private MapQuestLocation[] locations;

    public Float[][] getDistance() {
        return distance;
    }

    public void setDistance(Float[][] distance) {
        this.distance = distance;
    }

    public Float[][] getTime() {
        return time;
    }

    public void setTime(Float[][] time) {
        this.time = time;
    }

    public MapQuestLocation[] getLocations() {
        return locations;
    }

    public void setLocations(MapQuestLocation[] locations) {
        this.locations = locations;
    }
}