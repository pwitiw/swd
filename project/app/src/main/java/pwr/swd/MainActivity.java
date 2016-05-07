package pwr.swd;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyRecyclerAdapter adapter;
    private ArrayList<Record> dataSet = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        setUpButtons();
        setUpRecyclerView();
    }

    private void setUpButtons() {
        Button bt = (Button)findViewById(R.id.add_new);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addNewItem(new Record());
            }
        });

        Button bt2 = (Button)findViewById(R.id.find_fastest);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Record item:
                        dataSet) {
                    Log.v("Records", item.toString());
                }
            }
        });

    }

    private void setUpRecyclerView() {

        adapter = new MyRecyclerAdapter();
        adapter.setDataSet(this.dataSet);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
