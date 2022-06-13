package com.example.computingproject;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class Dahmain extends AppCompatActivity {
    DrawerLayout drawerLayout;


    //initialize variable
     MeowBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dahmain);
        drawerLayout = findViewById(R.id.drawer_layout);
        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_train));

        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_travel));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_menu_24));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //initialized fegment
                Fragment fragment = null;
                switch (item.getId()){
                    case 1:

                        fragment = new TrainFragment();
                        break;

                    case 2:
                        fragment = new TravelFragment();
                        break;
                    //when id is 3
                    //initialize resort fregment

                    case 3:
                        fragment = new HomeFragment();
                        break;




                }
                //load fregment


                LoadFragment(fragment);

            }
        });

        bottomNavigation.show(1 ,true);

        //set


         bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
             @Override
             public void onClickItem(MeowBottomNavigation.Model item) {
                 Toast.makeText(getApplicationContext(), "Your Clicked"+item.getId(), Toast.LENGTH_SHORT).show();
             }
         });
         bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
             @Override
             public void onClickItem(MeowBottomNavigation.Model item) {
                 Toast.makeText(getApplicationContext(), "You Reselected" +item.getId(), Toast.LENGTH_SHORT).show();
             }
         });

    }

    private void LoadFragment(Fragment fragment) {

        //Repalace fregment

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fram_layout,fragment)
                .commit();
    }

    }



