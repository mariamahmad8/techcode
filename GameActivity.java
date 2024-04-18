package com.example.findme_technovation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends MainActivity {
    Button home;
    Button tic;
    Button memory;
    Button colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        home = findViewById(R.id.homeButtonG);
        colors = findViewById(R.id.colorsButton);
        memory = findViewById(R.id.memoryButton);
        tic = findViewById(R.id.ticButton); // Initialize tic button

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, MainActivity.class));
            }
        });
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, colors.class));
            }
        });
        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, memory.class));
            }
        });
        tic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, tictactoe.class));
            }
        });
    }
}
