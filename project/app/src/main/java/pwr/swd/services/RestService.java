package pwr.swd.services;

import pwr.swd.MapQuestModel.MapQuestRequest;
import pwr.swd.MapQuestModel.MapQuestResponse;
import pwr.swd.utils.HttpHelper;
import retrofit.Callback;

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

    public String getDataForLocalizations(final MapQuestRequest mapQuestRequest,
                                          final Long[] times, Callback<MapQuestResponse> callback) {

        http = HttpHelper.getInstance();
        routeService = new RouteService();
        final MapQuestRequest request = mapQuestRequest;
        http.mapQuestAPI.post(request, callback);

        return result;
    }




}
