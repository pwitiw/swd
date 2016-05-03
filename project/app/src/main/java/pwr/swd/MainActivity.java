package pwr.swd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

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

    void performAction() throws JSONException{
        http = HttpHelper.getInstance();
        http.mapQuestAPI.post(new JSONObject(Consts.DANE),new Callback<Response>() {

            @Override
            public void success(Response response, Response response2) {
                System.out.println("SUCCESS");
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("FAIL");
            }
        });
    }
}