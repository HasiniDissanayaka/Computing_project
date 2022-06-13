package com.example.computingproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class coltogalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coltogalle);
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Person objects
        /*
        Person john = new Person("John","12-20-1998","Male",
                getResources().getIdentifier("@drawable/cartman_cop", null,this.getPackageName()));
                */

        person t1 = new person("Colombo","Normal","06.55 A.M","Express");
        person t2 = new person("Colombo","Raja rata rejini","10.30 A.M","Express");
        person t3 = new person("Colombo","Galu Kumari","14.25 P.M","Long distance ");
        person t4 = new person("Colombo","Samudra devi","17.30 P.M","Express");
        person t5 = new person("Colombo","Night mail","19.30 P.M","Night mail");
        person t6 = new person("Galle","Samudra devi","05.00 A.M","Express");
        person t7 = new person("Galle","Sagarika","06.00 A.M","Express");
        person t8 = new person("Galle","Ruhunu Kumari","10.55 A.M","Express");
        person t9 = new person("Galle","Normal","14.25 P.M","COLOMBO COMMUTER");
        person t10 = new person("Galle","Night mail","03.40 A.M","Night mail");


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


