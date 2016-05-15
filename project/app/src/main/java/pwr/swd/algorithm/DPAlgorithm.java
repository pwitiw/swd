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
        List<SystemState> list = new ArrayList<SystemState>();
        list.add(new SystemState(startingPoint, locationsToVisit));

        List<SystemState> bestPaths = findBest(list);
        List<Vertex> bestSolution = null;

        return bestSolution;
    }

    public List<SystemState> findBest(List<SystemState> previousStates) {
        List<SystemState> bestOptions = new ArrayList<SystemState>();

        for (SystemState state : previousStates) {
            List<Vertex> possiblePaths = state.getLocationsLeft();

            for (Vertex vertex : possiblePaths) {
                SystemState candidateState = state.generateNewState(vertex);
                selectOptimalRoutes(bestOptions, candidateState);
            }
        }

        return bestOptions;
    }

    public List<SystemState> selectOptimalRoutes(List<SystemState> reasonableOptions, SystemState state) {
        for (SystemState savedState : reasonableOptions) {
            if (savedState.getCurrentVertex().equals(state.getCurrentVertex())) {
                if(state.getTotalDistance() < savedState.getTotalDistance() && state.getTimeMagrin() > savedState.getTimeMagrin()) {
                    reasonableOptions.remove(savedState);
                    reasonableOptions.add(state);
                    return reasonableOptions;
                } else if (state.getTotalDistance() > savedState.getTotalDistance() && state.getTimeMagrin() < savedState.getTimeMagrin()){
                    return reasonableOptions;
                } else {
                    reasonableOptions.add(state);
                    return reasonableOptions;
                }
            }
        }
        reasonableOptions.add(state);
        return reasonableOptions;
    }
}
