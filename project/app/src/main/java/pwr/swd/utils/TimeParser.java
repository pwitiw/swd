package pwr.swd.utils;

import org.joda.time.Hours;
import org.joda.time.LocalTime;

import java.util.ArrayList;
import java.util.Calendar;
import pwr.swd.Record;

/**
 * Created by Patryk on 18.05.2016.
 */
public class TimeParser {

    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;

    public static Long[] parseTimes(ArrayList<Record> dataSet) {

        Long[] times = new Long[dataSet.size()];

        for (int i = 0; i < dataSet.size(); i++) {
            times[i] = getTimeForHour(dataSet.get(i).time);
        }

        return times;
    }

    private static long getTimeForHour(String hours) {

        String[] numbers = hours.split(":");
        Long seconds = Long.parseLong(numbers[0]) * SECONDS_IN_HOUR + Long.parseLong(numbers[1]) * SECONDS_IN_MINUTE;
        final Calendar c = Calendar.getInstance();
        int actualHour = c.get(Calendar.HOUR_OF_DAY);
        int actualMinute = c.get(Calendar.MINUTE);
        int actualSeconds = actualHour * SECONDS_IN_HOUR + actualMinute * SECONDS_IN_MINUTE;
        long difference = seconds - actualSeconds;

        return difference > 0 ? difference : 24 * SECONDS_IN_HOUR + difference;
    }


}
