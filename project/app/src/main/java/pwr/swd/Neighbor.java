package pwr.swd;

/**
 * Created by Patryk on 05.05.2016.
 */
public class Neighbor {

    private String location;
    private Long time;
    private float distance;

    public Neighbor(String location, long time, float distance) {
        this.location = location;
        this.time = time;
        this.distance = distance;
    }

}
