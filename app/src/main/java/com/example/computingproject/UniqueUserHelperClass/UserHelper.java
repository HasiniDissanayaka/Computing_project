package com.example.computingproject.UniqueUserHelperClass;

public class UserHelper {
    String Name,NIC,Connum,Days,Resort,Arrival,Departure;

    public UserHelper(){

    }

    public UserHelper(String name, String NIC, String connum, String days, String resort, String arrival, String departure) {
        Name = name;
        this.NIC = NIC;
        Connum = connum;
        Days = days;
        Resort = resort;
        Arrival = arrival;
        Departure = departure;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getConnum() {
        return Connum;
    }

    public void setConnum(String connum) {
        Connum = connum;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }

    public String getResort() {
        return Resort;
    }

    public void setResort(String resort) {
        Resort = resort;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }
}
