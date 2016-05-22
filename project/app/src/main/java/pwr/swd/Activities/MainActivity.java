package pwr.swd.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;

import pwr.swd.ActivityTransactionModel;
import pwr.swd.Adapters.MyRecyclerAdapter;
import pwr.swd.R;
import pwr.swd.services.ActionService;
import pwr.swd.utils.Consts;
import pwr.swd.utils.Record;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyRecyclerAdapter adapter;
    private ArrayList<Record> dataSet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_activity_main);
        setUpButtons();
        setUpRecyclerView();
    }

    private void setUpButtons() {
        findViewById(R.id.add_new).setOnClickListener(this);
        findViewById(R.id.find_shortestshortest).setOnClickListener(this);
    }

    private void setUpRecyclerView() {

        adapter = new MyRecyclerAdapter(this);
        adapter.setDataSet(this.dataSet);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.add_new:
                adapter.addNewItem(new Record());
                break;

            case R.id.find_shortestshortest:
                Intent intent = new Intent(this, ResultActivity.class);
                Bundle bundle = new Bundle();

                ActivityTransactionModel dto = new ActivityTransactionModel();
                dto.dataSet = this.dataSet;

                String json = (new Gson()).toJson(dto);
                bundle.putString(Consts.DTO_TAG, json);

                intent.putExtra(Consts.BUNDLE_TAG, bundle);
                startActivity(intent);
                break;
        }
    }
}
