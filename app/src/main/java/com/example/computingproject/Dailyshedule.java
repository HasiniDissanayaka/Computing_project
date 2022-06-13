package com.example.computingproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Dailyshedule extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailyshedule2);

        searchView =  findViewById(R.id.searchView);
        listView =  findViewById(R.id.lv1);

        list = new ArrayList<>();
        boolean add = list.add("Kurunagala - Galle            Arrival : 12.00PM   Leave:12.15PM");
        list.add("Ganewatte - Plgahawela           Arrival:04.16AM   Leave:4.30AM");
        list.add("Maho - Colombo Fort           Arrival:05.36AM    Leave: 05.50AM");
        list.add("Night Mail(Colombo Fort)         Arrival: 01.09AM  Leave: 01.11AM");
        list.add("Night Mail(Colombo Fort)         Arrival: 01.43AM   Leave: 01.45AM");
        list.add("Udaya Devi(Batticaloa)         Arrival:07.56AM  Leave:07.57AM");
        list.add("Rajarata Rajina(Beliaththa)          Arrival: 07.49   Leave:7.58AM");
        list.add("AC-Intercity(Kankasanthuraii)        Arrival: 01.25AM   Leave: 1.40AM");
        list.add("Yal Devi(Batticaloa)          Arrival: 01.30AM   Leave:01.45AM");
        list.add("Sri Devi(Colombo Fort)    Arrival: 09.52AM   Leave: 10.05AM");
        list.add("Uttara Devi(Kankasanthuraii)            Arrival  01.29PM     Leave:   1.38PM");
        list.add("Rajarata Rajina(Vavuniya)             Arrival: 03.32PM    Leave: 03.45PM");
        list.add("Intercity(Colombo Fort)      Arrival:06.23PM    Leave:6.45");
        list.add("Colombo fort- Kurunagala         Arrival:07.22PM   Leave: 7.35PM");
        list.add("Office(Anurdahapura)          Arrival: 07.55PM    Leave: 08.10PM");
        list.add("Aluthgama- Colombo Fort     Arrival: 05.10AM    Leave: 05.20AM");
        list.add("Maradana -  Panadura     Arrival:  05.10AM  Leave:05.20AM");
        list.add("Colombo Fort - Podi manike(Badulla)     Arrival:05.30AM  Leave:05.55AM");

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

               adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}