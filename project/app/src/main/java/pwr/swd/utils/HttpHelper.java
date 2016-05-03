package pwr.swd.utils;

import retrofit.RestAdapter;

/**
 * Created by Patryk on 25.04.2016.
 */
public class HttpHelper {

    private static HttpHelper instance = null;
    private RestAdapter restAdapter;
    public MapQuestAPI mapQuestAPI;

    private HttpHelper() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(Consts.BASE_URL)
                .build();

        mapQuestAPI = restAdapter.create(MapQuestAPI.class);
    }

    public static HttpHelper getInstance() {
        if (instance == null) {
            instance = new HttpHelper();
        }

        return instance;
    }
}
