package com.example.computingproject;

public class KShedule {
    private    String Startstation;
    private String Endstation;
    private String Arrival;
    private String Leave;


    public KShedule(String startstation) {
        Startstation = startstation;
    }

    public KShedule(String startstation, String endstation, String arrival, String leave) {
        Startstation = startstation;
        Endstation = endstation;
        Arrival = arrival;
        Leave = leave;
    }

    public String getStartstation() {
        return Startstation;
    }

    public void setStartstation(String startstation) {
        Startstation = startstation;
    }

    public String getEndstation() {
        return Endstation;
    }

    public void setEndstation(String endstation) {
        Endstation = endstation;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    public String getLeave() {
        return Leave;
    }

    public void setLeave(String leave) {
        Leave = leave;
    }
}
