package pwr.swd.mapQuestModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Patryk on 04.05.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapQuestResponse {

    private Float[][] distance;
    private Long[][] time;
    private MapQuestLocation[] locations;

    public Float[][] getDistance() {
        return distance;
    }

    public void setDistance(Float[][] distance) {
        this.distance = distance;
    }

    public Long[][] getTime() {
        return time;
    }

    public void setTime(Long[][] time) {
        this.time = time;
    }

    public MapQuestLocation[] getLocations() {
        return locations;
    }

    public void setLocations(MapQuestLocation[] locations) {
        this.locations = locations;
    }

    public boolean isEmpty(){
        return distance ==null? true:(locations == null ? true: (time == null ? true : false));
    }

}
