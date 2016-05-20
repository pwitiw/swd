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
    private RouteService routeService;
    private String result;

    public RestService() {
        http = HttpHelper.getInstance();
    }

    public String getDataForLocalizations(final MapQuestRequest mapQuestRequest, final Long[] times) {

        http = HttpHelper.getInstance();
        routeService = new RouteService();
        final MapQuestRequest request = mapQuestRequest;
        http.mapQuestAPI.post(request, new Callback<MapQuestResponse>() {
            @Override
            public void success(MapQuestResponse mapQuestResponse, Response r) {

               result = routeService.performAlgorithmForOptimalPath(mapQuestResponse, times);
                //todo tutaj nowe activity odpalane z resultem
            }

            @Override
            public void failure(RetrofitError error) {
                result = "";
            }
        });

        return result;
    }




}
