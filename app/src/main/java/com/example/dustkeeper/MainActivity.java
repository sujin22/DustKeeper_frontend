package com.example.dustkeeper;

import com.example.dustkeeper.FragmentHome;
import com.example.dustkeeper.FragmentChallengeList;
import com.example.dustkeeper.FragmentChallengeGallery;
import com.example.dustkeeper.FragmentMileageShop;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;

import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    //Fragment List
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentHome fragmentHome = new FragmentHome();
    private FragmentChallengeList fragmentChallengeList = new FragmentChallengeList();
    private FragmentChallengeGallery fragmentChallengeGallery = new FragmentChallengeGallery();
    private FragmentMileageShop fragmentMileageShop = new FragmentMileageShop();

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();
                    return true;
                case R.id.navigation_challenge_list:
                    transaction.replace(R.id.frameLayout, fragmentChallengeList).commitAllowingStateLoss();
                    return true;
                case R.id.navigation_challenge_gallery:
                    transaction.replace(R.id.frameLayout, fragmentChallengeGallery).commitAllowingStateLoss();
                    return true;
                case R.id.navigation_mileage_shop:
                    transaction.replace(R.id.frameLayout, fragmentMileageShop).commitAllowingStateLoss();
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fragment 전환
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
