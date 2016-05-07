package pwr.swd.services;

import java.util.List;

import pwr.swd.Node;
import pwr.swd.mapQuestModel.MapQuestRequest;
import pwr.swd.mapQuestModel.MapQuestResponse;
import pwr.swd.utils.HttpHelper;
import pwr.swd.utils.NodeParser;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Patryk on 04.05.2016.
 */
public class RestService {

    private HttpHelper http;

    public RestService() {
        http = HttpHelper.getInstance();
    }

    public void getDataForLocalizations(String[] localizations) {

        http = HttpHelper.getInstance();
        MapQuestRequest request = new MapQuestRequest(localizations);
        http.mapQuestAPI.post(request, new Callback<MapQuestResponse>() {
            @Override
            public void success(MapQuestResponse mapQuestResponse, Response response) {
                List<Node> nodes = NodeParser.getNodesForResponse(mapQuestResponse);

            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

}
