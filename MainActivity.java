package com.example.findme_technovation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button music;
    Button calendar;
    Button game;
    public MainActivity() {

    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = (Button) findViewById(R.id.musicButton);
        calendar = (Button) findViewById(R.id.calendarButton);
        game = (Button) findViewById(R.id.gameButton);
        music.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, MusicActivity.class));
            }

        });
        calendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, CalendarActivity.class));
            }

        });
        game.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }

        });
    }
}