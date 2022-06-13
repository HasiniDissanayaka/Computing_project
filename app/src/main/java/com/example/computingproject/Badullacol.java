package com.example.computingproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Badullacol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badullacol);
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Person objects
        /*
        Person john = new Person("John","12-20-1998","Male",
                getResources().getIdentifier("@drawable/cartman_cop", null,this.getPackageName()));
                */

        person t1 = new person("Colombo","Podi Manike","05.55 A.M","Express");
        person t2 = new person("Colombo","Udarata Manike","08.30 A.M","Express");
        person t3 = new person("Colombo","1007","09.45A.M","Express");
        person t4 = new person("Colombo","Night mail","20.00 P.M","Night mail");
        person t5 = new person("Badulla","Udarata","05.45 A.M","Express");
        person t6 = new person("Badulla","Podi Manike","08.30 A.M","Express");
        person t7 = new person("Badulla","Express train","11.00 A.M","Express");
        person t8 = new person("Badulla","Nightmail","17.50 P.M","Express");


        //Add the Person objects to an ArrayList
        ArrayList<person> peopleList = new ArrayList<>();
        peopleList.add(t1);
        peopleList.add(t2);
        peopleList.add(t3);
        peopleList.add(t4);
        peopleList.add(t5);
        peopleList.add(t6);
        peopleList.add(t7);
        peopleList.add(t8);




        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peopleList);
        mListView.setAdapter(adapter);
    }
}
