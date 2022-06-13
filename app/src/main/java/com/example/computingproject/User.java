package com.example.computingproject;

public class User {
    String train, price, date, month, time, amount, name, contact, email;

    public User(String train, String price, String date, String month, String time, String amount, String name, String contact, String email) {
        this.train = train;
        this.price = price;
        this.date = date;
        this.month = month;
        this.time = time;
        this.amount = amount;
        this.name = name;
        this.contact = contact;
        this.email = email;
    }

    public User() {
    }


    public String getTrain() {

        return train;
    }

    public void setTrain(String train) {

        this.train = train;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}