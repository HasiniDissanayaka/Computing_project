package com.example.computingproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class kandycolo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kandycolo);
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Person objects
        /*
        Person john = new Person("John","12-20-1998","Male",
                getResources().getIdentifier("@drawable/cartman_cop", null,this.getPackageName()));
                */

        person t1 = new person("Kandy","normal","05.00 A.M","Express");
        person t2 = new person("Kandy","normal","06.15 A.M","Intercity");
        person t3 = new person("Kandy","normal","10.40 A.M","Express");
        person t4 = new person("Kandy","Udarata Manike","12.50 P.M","Express");
        person t5 = new person("Kandy","Podi manike","18.05 P.M","Express");
        person t6 = new person("Colombo","Podi Manike","05.55 A.M","Express");
        person t7 = new person("Colombo","Normal","07.00 A.M","Intercity");
        person t8 = new person("Colombo","Udarata Manike","08.30 A.M","Express");
        person t9 = new person("Colombo","Normal","12.30 P.M","Express");
        person t10 = new person("Colombo","A/C -Intercity","17.20 P.M","Intercity");



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
        peopleList.add(t9);
        peopleList.add(t10);



        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peopleList);
        mListView.setAdapter(adapter);
    }
}
