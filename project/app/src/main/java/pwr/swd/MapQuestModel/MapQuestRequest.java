package pwr.swd.mapQuestModel;

/**
 * Created by Patryk on 04.05.2016.
 */
public class MapQuestRequest {

    private String[] locations;
    private MapQuestOptions options;

    public MapQuestRequest(String[] locations) {
        this.locations = locations;
        options = new MapQuestOptions();
    }

    public MapQuestRequest() {
    }

    public String[] getLocations() {
        return locations;
    }

    public void setLocations(String[] locations) {
        this.locations = locations;
    }

    public MapQuestOptions getOptions() {
        return options;
    }

    public void setOptions(MapQuestOptions options) {
        this.options = options;
    }
}
