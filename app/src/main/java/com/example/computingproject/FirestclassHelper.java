package com.example.computingproject;

public class FirestclassHelper {

    String Train,Price,Date,Month,Time,Amount,Name,Contact,Email;

    public FirestclassHelper() {

    }

    public FirestclassHelper(String train, String price, String date, String month, String time, String amount, String name, String contact, String email) {
        Train = train;
        Price = price;
        Date = date;
        Month = month;
        Time = time;
        Amount = amount;
        Name = name;
        Contact = contact;
        Email = email;
    }

    public String getTrain() {
        return Train;
    }

    public void setTrain(String train) {
        Train = train;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}