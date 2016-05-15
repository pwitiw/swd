package pwr.swd.algorithm.graph;

/**
 * Created by mi on 2016-05-15.
 */
public class GraphNode {
    private String name;
    private Long timeLimit;

    public GraphNode(String name, Long timeLimit) {
        this.name = name;
        this.timeLimit = timeLimit;
    }
    public Long getTimeLimitAsLong() {
        return timeLimit;
    }

    @Override
    public String toString() {
        return name;
    }
}
