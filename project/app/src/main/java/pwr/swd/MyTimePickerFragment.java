package pwr.swd;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by xyarn on 08.05.2016.
 */

public class MyTimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener{

    private MyTimePickerFragment.Callback callback;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        callback.onTimeSet(hourOfDay, minute);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {
        void onTimeSet(int hour, int minute);
    }
}
