package pwr.swd.utils;

public class Record {
    public String address;
    public String time; //TODO: change to date smt

    @Override
    public String toString() {
        return "Address: " + address + " time: " + time;
    }
}
