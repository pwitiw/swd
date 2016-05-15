package pwr.swd.algorithm.graph;




import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michal Gzyl
 */
public class Vertex {
    private GraphNode graphNode;
    private Map<Vertex, Long> distanceMap = new HashMap<Vertex, Long>();

    public Vertex(GraphNode graphNode) {
        this.graphNode = graphNode;
    }

    public void addDestination(Vertex key, Long distance) {
        distanceMap.put(key, distance);
    }

    public Long getDistanceTo(Vertex v) {
        return distanceMap.get(v);
    }

    public Long getTimeConstrain() {
        return graphNode.getTimeLimitAsLong();
    }

    @Override
    public String toString() {
        return graphNode.toString();
    }
}
