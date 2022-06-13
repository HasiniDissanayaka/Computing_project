package com.example.computingproject;

public class person {
    private String from;
    private String name;
    private String time;
    private String type;


    public person(String From, String Name, String Time,String Type) {
        this.from = From;
        this.name = Name;
        this.time = Time;
        this.type = Type;

    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getType() {
        return type;
    }

    public void setType(String time) {
        this.type = type;
    }

}