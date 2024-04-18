package com.example.findme_technovation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class colors extends GameActivity{
    Button back;
    Button press;
    TextView text;

    String[] hex;
    String[] namesOfColor;
    public colors() {

        namesOfColor = new String[]{"Red", "Orange", "Yellow", "Green", "Blue", "Purple"};
        hex = new String[]{"C12E0E", "E98815", "EDED66", "79BE72", "479FCA", "B7A2DE"};
    }

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colors);
        back = (Button) findViewById(R.id.backButtonC);
        press = (Button) findViewById(R.id.pressButton);
        text = (TextView) findViewById(R.id.colorText);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(colors.this, GameActivity.class));
            }
        });
        press.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int rand = (int)(Math.random() * 6);
                String colorName = namesOfColor[rand];
                int r = 0;
                int g = 0;
                int b = 0;
                if(colorName.equals("Red")){
                    r = 239;
                    g = 58;
                    b = 58;
                }
                else if(colorName.equals("Orange")){
                    r = 233;
                    g = 91;
                    b = 50;
                }
                else if(colorName.equals("Yellow")){
                    r = 237;
                    g = 237;
                    b = 102;
                }
                else if(colorName.equals("Green")){
                    r = 121;
                    g = 190;
                    b = 114;
                }
                else if(colorName.equals("Blue")){
                    r = 71;
                    g = 159;
                    b = 202;
                }
                else if(colorName.equals("Purple")){
                    r = 183;
                    g = 162;
                    b = 222;
                }
                int color = Color.rgb(r, g, b);
                press.setBackgroundColor(color);
                text.setTextColor(color);
                text.setText(colorName);

            }
        });
    }
}
