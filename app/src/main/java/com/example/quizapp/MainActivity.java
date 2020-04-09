package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    TextView titleTextView, TextView1, TextView2, TextView3, TextView4, TextView5;
    TextView saveTextView;
    ScrollView scrollView;
    ImageView profilePhoto0ImageView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Menu menu;
    ImageView Photo1ImageView;
    ImageView Photo2ImageView, Photo3ImageView, Photo5ImageView, Photo6ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        titleTextView = findViewById(R.id.textView);
        saveTextView = findViewById(R.id.textView2);
        scrollView = findViewById(R.id.scrollView);
        profilePhoto0ImageView = findViewById(R.id.imageView);
        Photo1ImageView = findViewById(R.id.GK);
        Photo2ImageView = findViewById(R.id.islamic);
        Photo3ImageView = findViewById(R.id.football);
        Photo5ImageView = findViewById(R.id.cricket);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        Photo6ImageView = findViewById(R.id.science);


        TextView1 = findViewById(R.id.textView3);
        TextView2 = findViewById(R.id.textView4);
        TextView3 = findViewById(R.id.textView5);
        TextView4 = findViewById(R.id.textView6);
        TextView5 = findViewById(R.id.textView7);
        setSupportActionBar(toolbar);

        Photo1ImageView.setOnClickListener(this);
        Photo2ImageView.setOnClickListener(this);
        Photo3ImageView.setOnClickListener(this);

        Photo5ImageView.setOnClickListener(this);
        Photo6ImageView.setOnClickListener(this);


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }



    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.GK) {
            Intent intent = new Intent(MainActivity.this,GKActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.islamic) {
            Intent intent = new Intent(MainActivity.this, IslamicActivity.class);
            startActivity(intent);


        } else if (v.getId() == R.id.football) {
            Intent intent = new Intent(MainActivity.this, FootballActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cricket) {
            Intent intent = new Intent(MainActivity.this, CricketActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.science) {
            Intent intent = new Intent(MainActivity.this, ScienceActivity.class);
            startActivity(intent);
        }
    }

    public void showQuestions() {
    }
}