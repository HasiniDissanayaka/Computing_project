package com.example.computingproject;

public class UniquHelper {

    String NIC,Resort;

    public UniquHelper ( String userNIC , String userResort ){
        this.NIC = userNIC;
        this.Resort = userResort;

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
