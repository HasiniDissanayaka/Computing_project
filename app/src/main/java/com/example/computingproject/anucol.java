package com.example.computingproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class anucol extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anucol);
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Person objects
        /*
        Person john = new Person("John","12-20-1998","Male",
                getResources().getIdentifier("@drawable/cartman_cop", null,this.getPackageName()));
                */

        person t1 = new person("Colombo","A/C-Intercity","05:45A.M","A/C");
        person t2 = new person("Colombo","Yal devi","06.35 A.M","Long distance");
        person t3 = new person("Colombo","Uttara devi","11.50 A.M","A/C");
        person t4 = new person("Colombo","Rajarata rejini","13.45 P.M","Express");
        person t5 = new person("Colombo","A/C IKntercity","15.55.P.M","Express");
        person t6 = new person("Colombo","Nightmail Train","20.30 P.M","Night mail");
        person t7 = new person("Anuradhapura","Rajarata Regini","05.00 A.M","Express");
        person t8 = new person("Anuradhapura","Uttara Devi","09.15 P.M","Express");
        person t9 = new person("Anuradhapura","Yal devi","13.50 P.M","Long distance");
        person t10= new person("Anuradhapura","Nightmail","23.10 P.M","Nightmail");



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

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(anucol.this, TrainSchedule.class);
        startActivity(intent);
    }
}
