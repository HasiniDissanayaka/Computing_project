package com.example.computingproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Trincocol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trincocol);
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Person objects
        /*
        Person john = new Person("John","12-20-1998","Male",
                getResources().getIdentifier("@drawable/cartman_cop", null,this.getPackageName()));
                */

        person t1 = new person("Trincomalee","Night mail","21.30 P.M","Night mail");
        person t2 = new person("colombo","Night mail","19.00 P.M","Night mail");





        //Add the Person objects to an ArrayList
        ArrayList<person> peopleList = new ArrayList<>();
        peopleList.add(t1);
        peopleList.add(t2);




        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peopleList);
        mListView.setAdapter(adapter);
    }
}
