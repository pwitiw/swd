package pwr.swd;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.Adapter;
import static android.support.v7.widget.RecyclerView.ViewHolder;

public class MyRecyclerAdapter extends Adapter {

    private final FragmentActivity fragmentActivity;
    public ArrayList<Record> dataSet;

    //TODO: new constructor
    public MyRecyclerAdapter(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).mapValues(dataSet.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addNewItem(Record item) {
        dataSet.add(item);
        notifyDataSetChanged();
    }

    public void setDataSet(ArrayList<Record> dataSet) {
        this.dataSet = dataSet;
    }

    class MyViewHolder extends ViewHolder {

        public EditText address;

        public EditText time;
        public int position;

        private boolean dontChangeThis;

        public MyViewHolder(View itemView) {
            super(itemView);

            dontChangeThis = true;
            address = (EditText) itemView.findViewById(R.id.address);
            time = (EditText) itemView.findViewById(R.id.textClock);

            address.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (dontChangeThis)
                        return;
                    if (position <= dataSet.size()) {
                        dataSet.get(position).address = s.toString();
                    }
                }
            });

            time.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() != MotionEvent.ACTION_DOWN)
                        return false;
                    MyTimePickerFragment dialog = new MyTimePickerFragment();
                    dialog.setCallback(new MyTimePickerFragment.Callback() {
                                           @Override
                                           public void onTimeSet(int hour, int minute) {
                                               String timeString;
                                               if (hour < 10 && minute<10 )
                                                   timeString = "0" + hour + ":0" + minute;
                                               else if (hour < 10)
                                                   timeString = "0" + hour + ":" + minute;
                                               else if (minute <10)
                                                   timeString = hour + ":0" + minute;
                                               else
                                                   timeString = hour + ":" + minute;

                                               dataSet.get(position).time = timeString;
                                               time.setText(timeString);
                                           }
                                       }
                    );
                    dialog.show(fragmentActivity.getFragmentManager(), "timePicker");
                    return true;
                }
            });

        }

        public void mapValues(Record record, int position) {
            dontChangeThis = true;

            address.setText(record.address);
            time.setText(record.time);
            this.position = position;

            dontChangeThis = false;
        }
    }
}