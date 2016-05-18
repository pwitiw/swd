package pwr.swd;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> c9b13b891813395f29ced4a5def9228624f35247

import static android.support.v7.widget.RecyclerView.Adapter;
import static android.support.v7.widget.RecyclerView.ViewHolder;

public class MyRecyclerAdapter extends Adapter {

<<<<<<< HEAD
    public ArrayList<Record> dataSet;
=======
    public List<Record> dataSet;
>>>>>>> c9b13b891813395f29ced4a5def9228624f35247

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder)holder).mapValues(dataSet.get(position), position);
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

<<<<<<< HEAD
    public void setDataSet(ArrayList<Record> dataSet) {
=======
    public void setDataSet(List<Record> dataSet) {
>>>>>>> c9b13b891813395f29ced4a5def9228624f35247
        this.dataSet = dataSet;
    }

    class MyViewHolder extends ViewHolder {

        public EditText address;
        public EditText time;
        public int position;

        private boolean dontChangeThisShit;

        public MyViewHolder(View itemView) {
            super(itemView);

            dontChangeThisShit = true;
            address = (EditText)itemView.findViewById(R.id.address);
            time = (EditText)itemView.findViewById(R.id.textClock);

            address.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(dontChangeThisShit)
                        return;
                    if(position <= dataSet.size()) {
                        dataSet.get(position).address = s.toString();
                    }
                }
            });
            time.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(dontChangeThisShit)
                        return;
                    if(position <= dataSet.size()) {
                        dataSet.get(position).time = s.toString();
                    }
                }
            });
        }

        public void mapValues(Record record, int position){
            dontChangeThisShit = true;

            address.setText(record.address);
            time.setText(record.time);
            this.position = position;

            dontChangeThisShit = false;
        }
    }
}