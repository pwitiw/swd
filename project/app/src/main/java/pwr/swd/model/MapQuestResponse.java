package pwr.swd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

import pwr.swd.model.Location;

/**
 * Created by Patryk on 04.05.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapQuestResponse{

    private Boolean allToAll;
    private List<List<Float>> distance;
    private List<List<Float>> time;
    private Location[] locations;
    private Boolean manyToOne;

    public Boolean getAllToAll() {
        return allToAll;
    }

    public void setAllToAll(Boolean allToAll) {
        this.allToAll = allToAll;
    }

    public List<List<Float>> getDistance() {
        return distance;
    }

    public void setDistance(List<List<Float>> distance) {
        this.distance = distance;
    }

    public List<List<Float>> getTime() {
        return time;
    }

    public void setTime(List<List<Float>> time) {
        this.time = time;
    }

    public Boolean getManyToOne() {
        return manyToOne;
    }

    public void setManyToOne(Boolean manyToOne) {
        this.manyToOne = manyToOne;
    }

    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }
}
