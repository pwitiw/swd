package pwr.swd.MapQuestModel;

import java.util.ArrayList;
import java.util.List;

import pwr.swd.utils.Record;

/**
 * Created by Patryk on 04.05.2016.
 */
public class MapQuestRequest {

    private List<String> locations;
    private MapQuestOptions options;

    public MapQuestRequest(List<String> locations) {
        this.locations = locations;
        options = new MapQuestOptions();
    }

    public MapQuestRequest() {
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public MapQuestOptions getOptions() {
        return options;
    }

    public void setOptions(MapQuestOptions options) {
        this.options = options;
    }


    public static MapQuestRequest parseMapQuestRequest(List<Record> records) {
        List<String> locations = new ArrayList<>();
        for (Record record : records) {
            locations.add(record.address);
        }

        return new MapQuestRequest(locations);
    }
}
