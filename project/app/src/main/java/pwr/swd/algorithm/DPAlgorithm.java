package pwr.swd.algorithm;

import pwr.swd.algorithm.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

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

    public List<Vertex> getOptimalPath() {
        SystemState systemState = new SystemState(startingPoint, locationsToVisit);


        return systemState.getVisitedLocations();
    }

    private List<SystemState> findBest(List<SystemState> previousStates) {
        List<SystemState> bestOptions = new ArrayList<SystemState>();

        for(SystemState state : previousStates) {
            List<Vertex> possiblePaths = state.getLocationsLeft();

            for(Vertex vertex : possiblePaths) {
                SystemState candidateState = state.generateNewState(vertex);

                if(badOption(bestOptions, candidateState)) {
                    bestOptions.add(candidateState);
                }
            }
        }

        return bestOptions;
    }

    private boolean badOption(List<SystemState> reasonableOptions, SystemState state) {
        if(reasonableOptions.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
