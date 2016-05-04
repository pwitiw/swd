package pwr.swd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

import pwr.swd.model.MapQuestResponse;
import pwr.swd.utils.Consts;
import pwr.swd.utils.HttpHelper;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private HttpHelper http;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            performAction();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void performAction() throws JSONException {
        http = HttpHelper.getInstance();
        http.mapQuestAPI.post(Consts.DANE, new Callback<MapQuestResponse>() {
            @Override
            public void success(MapQuestResponse mapQuestResponse, Response response) {
                System.out.println(mapQuestResponse.toString());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}