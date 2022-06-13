package com.example.computingproject;

public class Time {
   String time,start,end;

    public Time() {
    }

    public Time(String time, String start, String end) {
        this.time = time;
        this.start = start;
        this.end = end;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
