package com.example.findme_technovation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.graphics.Color;
import java.util.ArrayList;

public class memory extends GameActivity{
    Button back;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;

    String[] colors;
    String[] buttonNum;
    int[] randNums;
    String[] pairs;

    int index1;
    int index2;
    int index3;
    int index4;
    int index5;
    int index6;

    int count; //count of button presses

    int lastPressed; // track the last index
    boolean[] buttonPressed;
    int pairsMatched = 0;
    public memory(){
        count = 0;
        colors = new String[]{"Blue", "Green", "Pink", "Purple", "Yellow", "Orange", "Maroon"};
        buttonNum = new String[]{"1","2", "3", "4", "5", "6"};
        randNums = new int[3];
        pairs = new String[3];
        lastPressed = -1;
        buttonPressed = new boolean[6];

    }
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory);
        back = (Button) findViewById(R.id.backButtonM);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(memory.this, GameActivity.class));
            }
        });

        choose();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                boolean[] currentPair = new boolean[2];
                if(index1 == 0) {
                    if(buttonPressed[0])
                        buttonPressed[1] = true;
                    else
                        buttonPressed[0] = true;
                    currentPair[0] = buttonPressed[0];
                    currentPair[1] = buttonPressed[1];
                }
                else if(index1 == 1) {
                    if(buttonPressed[2])
                        buttonPressed[3] = true;
                    else
                        buttonPressed[2] = true;
                    currentPair[0] = buttonPressed[2];
                    currentPair[1] = buttonPressed[3];
                }
                else if(index1 == 2) {
                    if(buttonPressed[4])
                        buttonPressed[5] = true;
                    else
                        buttonPressed[4] = true;
                    currentPair[0] = buttonPressed[4];
                    currentPair[1] = buttonPressed[5];
                }

                if(currentPair[0] && currentPair[1]) {
                    int color = getColorForIndex(randNums[index1]); // Use randNums[0] for button b1
                    b1.setBackgroundColor(color);
                }
                else {
                    int color = getColorForIndex(randNums[index1]); // Use randNums[0] for button b1
                    b1.setBackgroundColor(color);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int defaultColor = Color.rgb(255, 255, 255);
                            b1.setBackgroundColor(defaultColor);
                        }
                    }, 200);
                }
                if(count % 2 == 0)
                    buttonPressed = new boolean[6];
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                boolean[] currentPair = new boolean[2];
                if(index2 == 0) {
                    if(buttonPressed[0])
                        buttonPressed[1] = true;
                    else
                        buttonPressed[0] = true;
                    currentPair[0] = buttonPressed[0];
                    currentPair[1] = buttonPressed[1];
                }
                else if(index2 == 1) {
                    if(buttonPressed[2])
                        buttonPressed[3] = true;
                    else
                        buttonPressed[2] = true;
                    currentPair[0] = buttonPressed[2];
                    currentPair[1] = buttonPressed[3];
                }
                else if(index2 == 2) {
                    if(buttonPressed[4])
                        buttonPressed[5] = true;
                    else
                        buttonPressed[4] = true;
                    currentPair[0] = buttonPressed[4];
                    currentPair[1] = buttonPressed[5];
                }

                if(currentPair[0] && currentPair[1]) {
                    int color = getColorForIndex(randNums[index2]); // Use randNums[0] for button b1
                    b2.setBackgroundColor(color);
                }
                else {
                    int color = getColorForIndex(randNums[index2]);
                    b2.setBackgroundColor(color);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int defaultColor = Color.rgb(255, 255, 255);
                            b2.setBackgroundColor(defaultColor);
                        }
                    }, 200);
                }
                if(count % 2 == 0)
                    buttonPressed = new boolean[6];
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                boolean[] currentPair = new boolean[2];
                if(index3 == 0) {
                    if(buttonPressed[0])
                        buttonPressed[1] = true;
                    else
                        buttonPressed[0] = true;
                    currentPair[0] = buttonPressed[0];
                    currentPair[1] = buttonPressed[1];
                }
                else if(index3 == 1) {
                    if(buttonPressed[2])
                        buttonPressed[3] = true;
                    else
                        buttonPressed[2] = true;
                    currentPair[0] = buttonPressed[2];
                    currentPair[1] = buttonPressed[3];
                }
                else if(index3 == 2) {
                    if(buttonPressed[4])
                        buttonPressed[5] = true;
                    else
                        buttonPressed[4] = true;
                    currentPair[0] = buttonPressed[4];
                    currentPair[1] = buttonPressed[5];
                }

                if(currentPair[0] && currentPair[1]) {
                    int color = getColorForIndex(randNums[index3]); // Use randNums[0] for button b1
                    b3.setBackgroundColor(color);
                }
                else {
                    int color = getColorForIndex(randNums[index3]);
                    b3.setBackgroundColor(color);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int defaultColor = Color.rgb(255, 255, 255);
                            b3.setBackgroundColor(defaultColor);
                        }
                    }, 200);
                }
                if(count % 2 == 0)
                    buttonPressed = new boolean[6];
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                boolean[] currentPair = new boolean[2];
                if(index4 == 0) {
                    if(buttonPressed[0])
                        buttonPressed[1] = true;
                    else
                        buttonPressed[0] = true;
                    currentPair[0] = buttonPressed[0];
                    currentPair[1] = buttonPressed[1];
                }
                else if(index4 == 1) {
                    if(buttonPressed[2])
                        buttonPressed[3] = true;
                    else
                        buttonPressed[2] = true;
                    currentPair[0] = buttonPressed[2];
                    currentPair[1] = buttonPressed[3];
                }
                else if(index4 == 2) {
                    if(buttonPressed[4])
                        buttonPressed[5] = true;
                    else
                        buttonPressed[4] = true;
                    currentPair[0] = buttonPressed[4];
                    currentPair[1] = buttonPressed[5];
                }

                if(currentPair[0] && currentPair[1]) {
                    int color = getColorForIndex(randNums[index4]); // Use randNums[0] for button b1
                    b4.setBackgroundColor(color);
                }
                else {
                    int color = getColorForIndex(randNums[index4]);
                    b4.setBackgroundColor(color);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int defaultColor = Color.rgb(255, 255, 255);
                            b4.setBackgroundColor(defaultColor);
                        }
                    }, 200);
                }
                if(count % 2 == 0)
                    buttonPressed = new boolean[6];
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                boolean[] currentPair = new boolean[2];
                if(index5 == 0) {
                    if(buttonPressed[0])
                        buttonPressed[1] = true;
                    else
                        buttonPressed[0] = true;
                    currentPair[0] = buttonPressed[0];
                    currentPair[1] = buttonPressed[1];
                }
                else if(index5 == 1) {
                    if(buttonPressed[2])
                        buttonPressed[3] = true;
                    else
                        buttonPressed[2] = true;
                    currentPair[0] = buttonPressed[2];
                    currentPair[1] = buttonPressed[3];
                }
                else if(index5 == 2) {
                    if(buttonPressed[4])
                        buttonPressed[5] = true;
                    else
                        buttonPressed[4] = true;
                    currentPair[0] = buttonPressed[4];
                    currentPair[1] = buttonPressed[5];
                }

                if(currentPair[0] && currentPair[1]) {
                    int color = getColorForIndex(randNums[index5]); // Use randNums[0] for button b1
                    b5.setBackgroundColor(color);
                }
                else {
                    int color = getColorForIndex(randNums[index5]);
                    b5.setBackgroundColor(color);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int defaultColor = Color.rgb(255, 255, 255);
                            b5.setBackgroundColor(defaultColor);
                        }
                    }, 200);
                }
                if(count % 2 == 0)
                    buttonPressed = new boolean[6];
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                boolean[] currentPair = new boolean[2];
                if(index6 == 0) {
                    if(buttonPressed[0])
                        buttonPressed[1] = true;
                    else
                        buttonPressed[0] = true;
                    currentPair[0] = buttonPressed[0];
                    currentPair[1] = buttonPressed[1];
                }
                else if(index6 == 1) {
                    if(buttonPressed[2])
                        buttonPressed[3] = true;
                    else
                        buttonPressed[2] = true;
                    currentPair[0] = buttonPressed[2];
                    currentPair[1] = buttonPressed[3];
                }
                else if(index6 == 2) {
                    if(buttonPressed[4])
                        buttonPressed[5] = true;
                    else
                        buttonPressed[4] = true;
                    currentPair[0] = buttonPressed[4];
                    currentPair[1] = buttonPressed[5];
                }

                if(currentPair[0] && currentPair[1]) {
                    int color = getColorForIndex(randNums[index6]); // Use randNums[0] for button b1
                    b6.setBackgroundColor(color);
                }
                else {
                    int color = getColorForIndex(randNums[index6]);
                    b6.setBackgroundColor(color);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int defaultColor = Color.rgb(255, 255, 255);
                            b6.setBackgroundColor(defaultColor);
                        }
                    }, 200);
                }
                if(count % 2 == 0)
                    buttonPressed = new boolean[6];
            }
        });
    }

    public int getColorForIndex(int index) {
        if (index == 0) {
            return Color.rgb(84, 179, 247) ;// blue
        }
        else if (index == 1) {
            return Color.rgb(126, 207, 139); // green
        }
        else if (index == 2) {
            return Color.rgb(255, 173, 245); // Pink
        }
        else if (index == 3) {
            return Color.rgb(157, 150, 255); // purple
        }
        else if (index == 4) {
            return Color.rgb(247, 233, 129); // yellow
        }
        else if (index == 5) {
            return Color.rgb(255, 163, 112); // orange
        }
        else if(index == 6){
            return Color.rgb(150, 75, 92); // maroon
        }
        else {
            return Color.rgb(255,255,255); // white
        }
    }
    public void choose(){
        ArrayList<Integer> usedValues = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int rand;
            do {
                rand = (int) (Math.random() * 7);
            } while (usedValues.contains(rand));
            usedValues.add(rand);
            randNums[i] = rand;
        }
        // create random pairs no value repeating to esnure values dont repeat
        // use an array list and then check the generated number and see if its in the
        //array list and ifi f it is generate a new nubmer (1-6)
        //  pairs is a string array and so is buttonNums
        ArrayList<Integer> usedIndices = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int i1 = (int) (Math.random() * buttonNum.length);
            while (usedIndices.contains(i1)) {
                i1 = (int) (Math.random() * buttonNum.length);
            }
            usedIndices.add(i1);
            int i2 = (int) (Math.random() * buttonNum.length);
            while (i2 == i1 || usedIndices.contains(i2)) {
                i2 = (int) (Math.random() * buttonNum.length);
            }
            usedIndices.add(i2);
            String pair = buttonNum[i1] + buttonNum[i2];
            pairs[i] = pair;
        }
        for(int j = 0; j < pairs.length; j++){ // PLEASER RHAKUEHRJKEAHRJKHAER
            System.out.println(pairs[j]);
        }
        for(int i = 0; i < pairs.length;i++){
            String word = pairs[i];
            for(int j = 0; j < word.length(); j++){ //seperate the pairs
                char c = word.charAt(j);
                if(c == '1') { // set the indexs to the button
                    index1 = i;
                }
                else if( c == '2'){
                    index2 = i;
                }
                else if( c == '3'){
                    index3 = i;
                }
                else if( c == '4'){
                    index4 = i;
                }
                else if( c == '5'){
                    index5 = i;
                }
                else if( c == '6'){
                    index6 = i;
                }
            }
        }
        System.out.println("hellllllllll");
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3); // vals works
        System.out.println(index4);
        System.out.println(index5);
        System.out.println(index6);
    }

    public boolean checkPair(int i1, int i2){
        String pair1 = pairs[i1];
        String pair2 = pairs[i2];
        System.out.println(pair1);
        System.out.println(pair2);
        return pair1.equals(pair2);
    }

}


