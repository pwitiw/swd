package pwr.swd;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
<<<<<<< HEAD
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
=======
import android.view.View;
import android.widget.Button;
>>>>>>> c9b13b891813395f29ced4a5def9228624f35247

import java.util.ArrayList;
import java.util.List;

import pwr.swd.mapQuestModel.MapQuestRequest;
import pwr.swd.services.RestService;
import pwr.swd.services.RouteService;

public class MainActivity extends AppCompatActivity {

    private MyRecyclerAdapter adapter;
<<<<<<< HEAD
=======
    private List<Record> dataSet = new ArrayList<>();

>>>>>>> c9b13b891813395f29ced4a5def9228624f35247

    private ArrayList<Record> dataSet = new ArrayList<>();
    private RouteService routeService;


    private RestService restService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
<<<<<<< HEAD
=======
        setUpButtons();
        setUpRecyclerView();

>>>>>>> c9b13b891813395f29ced4a5def9228624f35247

        routeService = new RouteService();
        setUpButtons();
        restService = new RestService();
        setUpRecyclerView();

    }

    private void setUpButtons() {
<<<<<<< HEAD
        Button bt = (Button)findViewById(R.id.add_new);
=======
        Button bt = (Button) findViewById(R.id.add_new);
>>>>>>> c9b13b891813395f29ced4a5def9228624f35247
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addNewItem(new Record());
            }
        });

<<<<<<< HEAD
        Button bt2 = (Button)findViewById(R.id.find_fastest);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Record item:
                        dataSet) {
                    Log.v("Records", item.toString());
                }
=======
        Button bt2 = (Button) findViewById(R.id.find_fastest);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapQuestRequest request = MapQuestRequest.parseMapQuestRequest(dataSet);
                restService.getDataForLocalizations(request);
>>>>>>> c9b13b891813395f29ced4a5def9228624f35247
            }
        });

    }

    private void setUpRecyclerView() {

        adapter = new MyRecyclerAdapter();
        adapter.setDataSet(this.dataSet);

<<<<<<< HEAD
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list);
=======
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
>>>>>>> c9b13b891813395f29ced4a5def9228624f35247
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
