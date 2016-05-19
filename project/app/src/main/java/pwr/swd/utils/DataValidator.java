package pwr.swd.utils;

import java.util.ArrayList;

/**
 * Created by Patryk on 19.05.2016.
 */
public class DataValidator {

    public static void validate(ArrayList<Record> dataSet) throws IncorrectInputException {
        if (dataSet.size()<2)
            throw new IncorrectInputException();
        for (Record record : dataSet) {
            if (record.time == null || record.address == null)
                throw new IncorrectInputException();
            if (record.address.trim().equals("") || record.time.trim().equals(""))
                throw new IncorrectInputException();
        }
    }

}
