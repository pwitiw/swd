package pwr.swd.algorithm;

import pwr.swd.algorithm.graph.Vertex;

import java.util.*;

/**
 * Created by Michal Gzyl
 */
public class SystemState {
    private Long totalDistance = 0L;
    private Long timeMagrin = Long.MAX_VALUE;
    private Vertex currentVertex;
    private LinkedList<Vertex> visitedLocations = new LinkedList<Vertex>();
    private List<Vertex> locationsLeft;

    public SystemState(Vertex currentVertex, List<Vertex> locationsLeft) {
        this.currentVertex = currentVertex;
        this.locationsLeft = locationsLeft;
        visitedLocations.addFirst(currentVertex);
    }

    public SystemState(SystemState state) {
        this.visitedLocations = state.visitedLocations;
        this.locationsLeft = state.locationsLeft;
    }

    public SystemState(Long totalDistance, Long timeMagrin, Vertex currentVertex, LinkedList<Vertex> visitedLocations, List<Vertex> locationsLeft) {
        this.totalDistance = totalDistance;
        this.timeMagrin = timeMagrin;
        this.currentVertex = currentVertex;
        this.visitedLocations = visitedLocations;
        this.locationsLeft = locationsLeft;
    }

    public List<Vertex> getLocationsLeft() {
        return locationsLeft;
    }

    public Vertex getCurrentVertex() {
        return currentVertex;
    }

    public Long getTotalDistance() {
        return totalDistance;
    }

    public Long getTimeMagrin() {
        return timeMagrin;
    }

    public List<Vertex> getVisitedLocations() {
        return visitedLocations;
    }

    public boolean isFinished() {
        return locationsLeft.isEmpty();
    }

    public SystemState generateNewState(Vertex addedVertex) {
        SystemState state = new SystemState(this);
        Long travelDistance = currentVertex.getDistanceTo(addedVertex);

        state.totalDistance = this.totalDistance + travelDistance;
        state.timeMagrin = Math.min(timeMagrin-travelDistance, addedVertex.getTimeConstrain());
        state.currentVertex = addedVertex;
        state.visitedLocations.addFirst(addedVertex);
        state.locationsLeft.remove(addedVertex);
        return state;
    }

    public boolean betterThan(SystemState other) {
        return this.getTotalDistance() < other.getTotalDistance() && this.getTimeMagrin() > other.getTimeMagrin();
    }
}
