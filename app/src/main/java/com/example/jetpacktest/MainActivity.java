package com.example.jetpacktest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.jetpacktest.ui.main.BlankFragment;
import com.example.jetpacktest.ui.main.MainFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNav);
        final NavHostFragment host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        final NavController controller = host.getNavController();


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_songs:
                                controller.navigate(R.id.mainFragment,null);
                                return true;
                            case R.id.navigation_albums:
                                controller.navigate(R.id.blankFragment,null);
                                return true;
                            case R.id.navigation_artists:
                                controller.navigate(R.id.itemFragment,null);
                                return true;
                        }
                        return false;
                    }
                });


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }



    }








}
