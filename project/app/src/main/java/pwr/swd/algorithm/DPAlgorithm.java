package pwr.swd.algorithm;

import pwr.swd.algorithm.graph.Vertex;

import java.util.*;

/**
 * Created by mi on 2016-05-15.
 */
public class DPAlgorithm {
    private Vertex startingPoint;
    private List<Vertex> locationsToVisit;

    public void initialize(Vertex startingPoint, List<Vertex> locationsToVisit) {
        this.locationsToVisit = locationsToVisit;
        this.startingPoint = startingPoint;
    }

    public SystemState getOptimalPath() {
        SystemState initialState = new SystemState(startingPoint, locationsToVisit);
        return findOptimalPath(initialState);
    }

    public SystemState findOptimalPath(SystemState initialState) {
        List<SystemState> initialStateAsList = new ArrayList<SystemState>();
        initialStateAsList.add(initialState);
        return getShortestPathWithinTimeLimit(findBestPaths(initialStateAsList));
    }

    public List<SystemState> findBestPaths(List<SystemState> calculatedStates) {
        if (calculatedStates.get(0).getLocationsLeft().isEmpty()) {
            return calculatedStates;
        } else {
            List<SystemState> bestOptions = new ArrayList<SystemState>();

            for (SystemState state : calculatedStates) {
                List<Vertex> possiblePaths = new ArrayList<Vertex>(state.getLocationsLeft());

                for (Vertex vertex : possiblePaths) {
                    SystemState candidateState = state.generateNewState(vertex);
                    filterBestOptions(bestOptions, candidateState);
                }
            }
            return findBestPaths(bestOptions);
        }
    }

    public SystemState getShortestPathWithinTimeLimit(List<SystemState> finalPaths) {
        SystemState shortestAllowed = null;
        for (int i=0; i<finalPaths.size(); i++) {
            SystemState path = finalPaths.get(i).generateNewState(startingPoint);

            if (path.getTimeMargin() >= 0 && (shortestAllowed == null || path.getTotalDistance() < shortestAllowed.getTotalDistance())) {
                shortestAllowed = path;
            }
        }
        return shortestAllowed;
    }

    public void filterBestOptions(List<SystemState> reasonableOptions, SystemState state) {
        for (SystemState savedState : reasonableOptions) {
            if (savedState.getCurrentVertex().equals(state.getCurrentVertex())) {
                if (state.betterThan(savedState)) {
                    reasonableOptions.remove(savedState);
                    reasonableOptions.add(state);
                    return;
                }
                if (savedState.betterThan(state)) {
                    return;
                } else {
                    reasonableOptions.add(state);
                    return;
                }
            }
        }
        //case where destination was unreachable before
        reasonableOptions.add(state);
    }
}
