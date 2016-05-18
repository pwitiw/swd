package pwr.swd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import pwr.swd.mapQuestModel.MapQuestRequest;
import pwr.swd.services.RestService;

public class MainActivity extends AppCompatActivity {

    private MyRecyclerAdapter adapter;
    private ArrayList<Record> dataSet = new ArrayList<>();


    private RouteService routeService;

    private RestService restService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpButtons();
        setUpRecyclerView();


        routeService = new RouteService();
        restService = new RestService();

    }

    private void setUpButtons() {
        Button bt = (Button) findViewById(R.id.add_new);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addNewItem(new Record());
            }
        });

        Button bt2 = (Button) findViewById(R.id.find_fastest);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapQuestRequest request = MapQuestRequest.parseMapQuestRequest(dataSet);
                restService.getDataForLocalizations(request);
            }
        });

    }

    private void setUpRecyclerView() {

        adapter = new MyRecyclerAdapter(this);
        adapter.setDataSet(this.dataSet);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
