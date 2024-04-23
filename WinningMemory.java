package com.example.findme_technovation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.graphics.Color;
import java.util.ArrayList;

public class WinningMemory extends memory {

    Button winButton;
    public WinningMemory(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winningpage);

        winButton = findViewById(R.id.finishButton);
        winButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WinningMemory.this, GameActivity.class));
            }
        });
    }
}
