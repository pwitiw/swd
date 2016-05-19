package pwr.swd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import pwr.swd.services.ActionService;
import pwr.swd.utils.IncorrectInputException;
import pwr.swd.utils.Record;

public class MainActivity extends AppCompatActivity {

    private MyRecyclerAdapter adapter;
    private ArrayList<Record> dataSet = new ArrayList<>();
    private ActionService actionService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpButtons();
        setUpRecyclerView();
        setUpServices();
    }

    private void setUpButtons() {
        Button bt = (Button) findViewById(R.id.add_new);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addNewItem(new Record());
            }
        });

        Button bt2 = (Button) findViewById(R.id.find_shortestshortest);
        bt2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        performFindFastest();
                    }
                }
        );
    }

    private void setUpRecyclerView() {

        adapter = new MyRecyclerAdapter(this);
        adapter.setDataSet(this.dataSet);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void setUpServices() {
        actionService = new ActionService();
    }

    private void performFindFastest() {
        String result;
        try {
            result = actionService.computeShortestRoute(dataSet);
        } catch (IncorrectInputException e) {
            e.printStackTrace(); //todo tutaj jakas informacja sie niech wyswietla
        }
    }
}
