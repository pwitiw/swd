package pwr.swd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pwr.swd.services.RestService;
import pwr.swd.services.RouteService;
import pwr.swd.utils.Consts;

public class MainActivity extends AppCompatActivity {


    private RouteService routeService;

    private RestService restService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        routeService = new RouteService();
        restService = new RestService();

        restService.getDataForLocalizations(Consts.LOCALES);
    }

}