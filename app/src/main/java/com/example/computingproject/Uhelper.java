package com.example.computingproject;

public class Uhelper {

    String Name,NIC,Connum,Address,Start,End,Days;

    public Uhelper() {

    }

    public Uhelper(String name, String NIC, String connum, String address, String start, String end, String days) {
        this.Name = name;
        this.NIC = NIC;
        this.Connum = connum;
        this.Address = address;
        this.Start = start;
        this.End = end;
        this.Days = days;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String days) {
        Days = days;
    }
}
