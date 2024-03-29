package com.example.rest_client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listTracksOnClick(View v){
        startActivity(new Intent(MainActivity.this, ListOfTracks.class));
    }
    public void newTrackOnClick(View v){
        startActivity(new Intent(MainActivity.this, NewTrackActivity.class));
    }
}