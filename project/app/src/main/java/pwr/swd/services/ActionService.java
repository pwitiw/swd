package pwr.swd.services;

import java.util.ArrayList;

import pwr.swd.utils.Record;
import pwr.swd.MapQuestModel.MapQuestRequest;
import pwr.swd.MapQuestModel.MapQuestResponse;
import pwr.swd.utils.DataValidator;
import pwr.swd.utils.IncorrectInputException;
import pwr.swd.utils.TimeParser;
import retrofit.Callback;

/**
 * Created by Patryk on 19.05.2016.
 */
public class ActionService {

    private RestService rest;

    public ActionService() {

    }

    public String computeShortestRoute(ArrayList<Record> dataSet, Callback<MapQuestResponse> callback)
            throws IncorrectInputException {

        DataValidator.validate(dataSet);
        rest = new RestService();
        MapQuestRequest request = MapQuestRequest.parseMapQuestRequest(dataSet);
        Long[] times = TimeParser.parseTimes(dataSet);
        MapQuestResponse response = new MapQuestResponse();
        return rest.getDataForLocalizations(request, times, callback);
    }

}
