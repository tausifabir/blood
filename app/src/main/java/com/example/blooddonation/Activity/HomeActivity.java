package com.example.blooddonation.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.blooddonation.Fragment.HomeFragment;
import com.example.blooddonation.Fragment.MapsFragment;
import com.example.blooddonation.Fragment.NotificationsFragment;
import com.example.blooddonation.Fragment.ProfileFragment;
import com.example.blooddonation.Fragment.RequestFragment;
import com.example.blooddonation.Fragment.SplashFragment_1;
import com.example.blooddonation.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomeActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    ChipNavigationBar chipNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.home,true);


        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.add(R.id.dashboardContainer, homeFragment);
        fragmentTransaction.commit();


        bottomMenu();

    }



    private void bottomMenu() {


        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.notifications:
                        fragment = new NotificationsFragment();
                        break;

                    case R.id.search:
                        fragment = new MapsFragment();
                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.dashboardContainer,fragment).commit();
            }
        });


    }
}