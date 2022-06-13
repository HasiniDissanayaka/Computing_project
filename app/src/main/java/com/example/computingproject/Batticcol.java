package com.example.computingproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Batticcol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batticcol);
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Person objects
        /*
        Person john = new Person("John","12-20-1998","Male",
                getResources().getIdentifier("@drawable/cartman_cop", null,this.getPackageName()));
                */

        person t1 = new person("BATTICALOA","Udaya Devi","08.30 A.M","Express");
        person t2 = new person("BATTICALOA","Nightmail","20.15 P.M","Nighr mail");
        person t3 = new person("Colombo","Udaya Devi","06.05 A.M","Express");
        person t4 = new person("Colombo","Nightmail","19.00 P.M","Night mail");




        //Add the Person objects to an ArrayList
        ArrayList<person> peopleList = new ArrayList<>();
        peopleList.add(t1);
        peopleList.add(t2);
        peopleList.add(t3);
        peopleList.add(t4);



        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peopleList);
        mListView.setAdapter(adapter);
    }
}
