package pwr.swd.services;

import java.util.ArrayList;
import java.util.List;

import pwr.swd.algorithm.DPAlgorithm;
import pwr.swd.algorithm.graph.GraphNode;
import pwr.swd.algorithm.graph.Vertex;
import pwr.swd.MapQuestModel.MapQuestLocation;
import pwr.swd.MapQuestModel.MapQuestResponse;

/**
 * Created by Patryk on 19.05.2016.
 */
public class RouteService {

    DPAlgorithm algorithm;

    public String performAlgorithmForOptimalPath(MapQuestResponse response, Long[] times) {
        setUpVertexes(response, times);
        return algorithm.printOptimalPath();
    }

    private void setUpVertexes(MapQuestResponse response, Long[] times) {
        List<Vertex> nodes = createVertexes(response, times);
        createDistanceMatrix(response, nodes);
        algorithm = new DPAlgorithm(nodes);
    }

    private List<Vertex> createVertexes(MapQuestResponse response, Long[] times) {
        List<Vertex> list = new ArrayList<Vertex>();
        MapQuestLocation[] locations = response.getLocations();

        for (int i = 0; i < locations.length; i++) {

            list.add(new Vertex(new GraphNode(locations[i].toString(), times[i])));
        }
        return list;
    }

    public void createDistanceMatrix(MapQuestResponse response, List<Vertex> list) {
        for (int i = 0; i < list.size(); i++) {
            Long[] currTimes = response.getTime()[i];

            for (int j = 0; j < currTimes.length; j++) {
                list.get(i).addDestination(list.get(j), currTimes[j]);
            }
        }
    }


}
