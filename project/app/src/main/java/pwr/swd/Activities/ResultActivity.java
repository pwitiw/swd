package pwr.swd.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import pwr.swd.ActivityTransactionModel;
import pwr.swd.MapQuestModel.MapQuestResponse;
import pwr.swd.R;
import pwr.swd.services.ActionService;
import pwr.swd.services.RouteService;
import pwr.swd.utils.Consts;
import pwr.swd.utils.IncorrectInputException;
import pwr.swd.utils.Record;
import pwr.swd.utils.TimeParser;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ResultActivity extends AppCompatActivity {

    private final String TAG = "ResultActivity";

    private ArrayList<Record> dataSet;

    private TextView resultText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_result);
        resultText = (TextView) findViewById(R.id.result_text);

        Bundle bundle = getIntent().getExtras().getBundle(Consts.BUNDLE_TAG);

        String dataSetJson = bundle.getString(Consts.DTO_TAG);
        ActivityTransactionModel dto = (new Gson()).fromJson(dataSetJson, ActivityTransactionModel.class);

        this.dataSet = dto.dataSet;

        downloadData();
    }

    private void downloadData() {
        resultText.setText(R.string.licze);
        try {
            ActionService actionService = new ActionService();
            actionService.computeShortestRoute(this.dataSet, new Callback<MapQuestResponse>() {
                @Override
                public void success(MapQuestResponse mapQuestResponse, Response r) {

                    RouteService routeService = new RouteService();
                    Long[] times = TimeParser.parseTimes(dataSet);

                    String result = routeService.performAlgorithmForOptimalPath(mapQuestResponse, times);
                    resultText.setText(result);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d(TAG, "failure: " + error.getMessage());
                    resultText.setText(R.string.ewidentny_blad);
                }
            });
        } catch (IncorrectInputException e) {
            e.printStackTrace(); //todo tutaj jakas informacja sie niech wyswietla
            resultText.setText(R.string.zle_dane);
        }
    }
}
