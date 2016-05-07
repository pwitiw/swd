package pwr.swd.utils;

import java.util.ArrayList;
import java.util.List;

import pwr.swd.Node;
import pwr.swd.Parameters;
import pwr.swd.mapQuestModel.MapQuestLocation;
import pwr.swd.mapQuestModel.MapQuestResponse;

/**
 * Created by Patryk on 05.05.2016.
 */
public class NodeParser {

    public static List<Node> getNodesForResponse(MapQuestResponse response) {
        List<Node> nodes = new ArrayList();
        int numberOfLocations = response.getLocations().length;
        for (int i = 0; i < numberOfLocations; i++) {

            Float[] currDistances = response.getDistance()[i];
            Float[] currTimes = response.getTime()[i];

            List<Parameters> parameters = parseParameter(response.getLocations(), currDistances, currTimes);
            nodes.add(new Node(response.getLocations()[i].toString(), parameters));
        }
        
        return nodes;
    }

    private static List<Parameters> parseParameter(MapQuestLocation[] locations, Float[] distances, Float[] times) {

        List<Parameters> parameters = new ArrayList();
        for (int i = 0; i < locations.length; i++) {
            if (distances[i] != 0)
                parameters.add(new Parameters(locations[i].toString(), distances[i], times[i]));
        }
        return parameters;
    }
}
