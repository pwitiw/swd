package pwr.swd.algorithm;

import pwr.swd.algorithm.graph.Vertex;

import java.util.Set;

/**
 * Created by Michal Gzyl
 */
public class SystemState {
    private Long totalDistance;
    private Long timeMagrin;
    private Set<Vertex> visitedLocations;

    public Long getTotalDistance() {
        return totalDistance;
    }

    public Long getTimeMagrin() {
        return timeMagrin;
    }

    public Set<Vertex> getVisitedLocations() {
        return visitedLocations;
    }

    public SystemState updateState(Vertex addedVertex) {
        visitedLocations.add(addedVertex);

        return this;
    }
}
