package com.example.computingproject;


public interface FirebaseDriverListener {

    void onDriverAdded(Driver driver);

    void onDriverRemoved(Driver driver);

    void onDriverUpdated(Driver driver);

}
