package com.example.computingproject.UniqueUserHelperClass;

public class Resorthelper {

    String Arrival,Connum,Days,Departure,Name,NIC,Resort;



    public Resorthelper(String arrival, String connum, String days, String departure, String name, String NIC, String resort) {
        Arrival = arrival;
        Connum = connum;
        Days = days;
        Departure = departure;
        Name = name;
        this.NIC = NIC;
        Resort = resort;
    }
    public Resorthelper(){

    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
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

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
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

    public String getResort() {
        return Resort;
    }

    public void setResort(String resort) {
        Resort = resort;
    }
}
