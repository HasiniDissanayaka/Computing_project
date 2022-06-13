package com.example.computingproject;

public class UserHelper {
    String Name,NIC,Connum,Days,Resort,Arrival,Deprture,roomstatus;

    public UserHelper(String resort, String NIC) {

    }

    public UserHelper(String name, String NIC, String connum, String days, String resort, String arrival, String deprture, String roomstatus) {
        Name = name;
        this.NIC = NIC;
        Connum = connum;
        Days = days;
        Resort = resort;
        Arrival = arrival;
        Deprture = deprture;
        this.roomstatus = roomstatus;
    }

    public String getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(String roomstatus) {
        this.roomstatus = roomstatus;
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

    public void setConnum(String days) {

        Connum = days;
    }
    public String getDays() {

        return Connum;
    }

    public void setDAYS(String days) {

        Connum = days;
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

    public String getDeprture() {

        return Deprture;
    }

    public void setDeprture(String deprture) {

        Deprture = deprture;
    }
}

