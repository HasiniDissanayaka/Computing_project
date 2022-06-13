package com.example.computingproject;

public class MyLocation {

    private double latitude;
    private double longitude;

    public MyLocation(double latitude, double logitude) {
        this.latitude = latitude;
        this.longitude = logitude;
    }

    public MyLocation(){}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
