package pwr.swd.services;

import java.util.ArrayList;
import java.util.List;

import pwr.swd.algorithm.graph.GraphNode;
import pwr.swd.algorithm.graph.Vertex;
import pwr.swd.mapQuestModel.MapQuestLocation;
import pwr.swd.mapQuestModel.MapQuestRequest;
import pwr.swd.mapQuestModel.MapQuestResponse;
import pwr.swd.utils.HttpHelper;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Patryk on 04.05.2016.
 */
public class RestService {

    private HttpHelper http;
    private List<Vertex> nodes;

    public RestService() {
        http = HttpHelper.getInstance();
    }

    public void getDataForLocalizations(final MapQuestRequest mapQuestRequest) {

        http = HttpHelper.getInstance();
        MapQuestRequest request = mapQuestRequest;
        http.mapQuestAPI.post(request, new Callback<MapQuestResponse>() {
            @Override
            public void success(MapQuestResponse mapQuestResponse, Response response) {
                nodes = createVertexes(mapQuestResponse);
                createDistanceMatrix(mapQuestResponse, nodes);
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    public List<Vertex> getLocationsGraph() {
        return nodes;
    }

    private List<Vertex> createVertexes(MapQuestResponse response) {
        List<Vertex> list = new ArrayList<Vertex>();
        MapQuestLocation[] locations = response.getLocations();

        for (MapQuestLocation loc : locations) {
            //todo przekazac ograniczenie czasowe jako Long (liczba sekund od teraz do limitu czaspwego) zamiast tego "0"
            list.add(new Vertex(new GraphNode(loc.toString(), 0L)));
        }
        return list;
    }

    private void createDistanceMatrix(MapQuestResponse response, List<Vertex> list) {
        for (int i = 0; i < list.size(); i++) {
            Long[] currTimes = response.getTime()[i];

            for (int j = 0; j < currTimes.length; j++) {
                list.get(i).addDestination(list.get(j), currTimes[j]);
            }
        }
    }

}
