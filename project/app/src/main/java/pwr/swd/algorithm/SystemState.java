package pwr.swd.algorithm;

import pwr.swd.algorithm.graph.Vertex;

import java.util.*;

/**
 * Created by Michal Gzyl
 */
public class SystemState {
    private Long totalDistance = 0L;
    private Long timeMargin = Long.MAX_VALUE;
    private Vertex currentVertex;
    private LinkedList<Vertex> visitedLocations;
    private List<Vertex> locationsLeft;

    public SystemState(Vertex currentVertex, List<Vertex> locationsLeft) {
        this.currentVertex = currentVertex;
        this.locationsLeft = locationsLeft;
        visitedLocations = new LinkedList<>();
        visitedLocations.addFirst(currentVertex);
    }

    public SystemState(SystemState state) {
        this.visitedLocations = new LinkedList<>(state.visitedLocations);
        this.locationsLeft = new ArrayList<>(state.locationsLeft);
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

    public Long getTimeMargin() {
        return timeMargin;
    }

    public List<Vertex> getVisitedLocations() {
        return visitedLocations;
    }

    public SystemState generateNewState(Vertex addedVertex) {
        SystemState state = new SystemState(this);
        Long travelDistance = addedVertex.getDistanceTo(currentVertex);

        state.totalDistance = this.totalDistance + travelDistance;
        state.timeMargin = Math.min(timeMargin -travelDistance, addedVertex.getTimeConstrain());
        state.currentVertex = addedVertex;
        state.visitedLocations.addFirst(addedVertex);
        state.locationsLeft.remove(addedVertex);
        return state;
    }

    public boolean betterThan(SystemState other) {
        return this.getTotalDistance() < other.getTotalDistance() && this.getTimeMargin() > other.getTimeMargin();
    }
}
