package pwr.swd.utils;

import pwr.swd.mapQuestModel.MapQuestRequest;
import pwr.swd.mapQuestModel.MapQuestResponse;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Patryk on 26.04.2016.
 */
public interface MapQuestAPI {

    @POST("/routematrix?key=" + Consts.MAP_QUEST_KEY)
    public void post(@Body MapQuestRequest requestBody, Callback<MapQuestResponse> response);


}
