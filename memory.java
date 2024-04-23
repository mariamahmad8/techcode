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

    int[] buttonColors;
    String[] buttonNum;

    int previousColor;
    int[] randNums;
    String[] pairs;

    int prevButtonNum;

    int turn;

    int count; //count of button presses

    int lastPressed; // track the last index
    boolean[] buttonPressed;

    public memory(){
        count = 0;
        colors = new String[]{"Blue", "Green", "Pink", "Purple", "Yellow", "Orange", "Maroon"};
        buttonNum = new String[]{"1","2", "3", "4", "5", "6"};
        randNums = new int[3];
        pairs = new String[3];
        lastPressed = -1;
        buttonPressed = new boolean[6];
        buttonColors = new int[6];
        previousColor = 0;
        turn = 1;

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
        setColors();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(buttonColors[0]);
                if(turn == 1) {
                    System.out.println("ONEDISABLE");
                    b1.setEnabled(false);
                    previousColor = buttonColors[0];
                    prevButtonNum = 1;
                    turn++;
                }
                else if(turn == 2) {
                    if(buttonColors[0] == previousColor) {
                        System.out.println("ONEDISABLE");
                        b1.setEnabled(false);
                    }
                    else {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int defaultColor = Color.rgb(255, 255, 255);
                                b1.setBackgroundColor(defaultColor);
                            }
                        }, 200);
                        System.out.println("REENABLE");
                        resetPrevButton();
                    }
                    turn--;
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setBackgroundColor(buttonColors[1]);
                if(turn == 1) {
                    System.out.println("TWO DISABLE");
                    b2.setEnabled(false);
                    previousColor = buttonColors[1];
                    prevButtonNum = 2;
                    turn++;
                }
                else if(turn == 2) {
                    if(buttonColors[1] == previousColor) {
                        System.out.println("TWO DISABLE");
                        b2.setEnabled(false);
                    }
                    else {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int defaultColor = Color.rgb(255, 255, 255);
                                b2.setBackgroundColor(defaultColor);
                            }
                        }, 200);
                        System.out.println("REENABLE");
                        resetPrevButton();
                    }
                    turn--;
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ENTERED3");
                System.out.print(buttonColors[2]);
                b3.setBackgroundColor(buttonColors[2]);
                if(turn == 1) {
                    previousColor = buttonColors[2];
                    prevButtonNum = 3;
                    turn++;
                    System.out.println("THREEE DISABLE");
                    b3.setEnabled(false);
                }
                else if(turn == 2) {
                    if(buttonColors[2] == previousColor) {
                        System.out.println("THREE DISABLE");
                        b3.setEnabled(false);
                    }
                    else {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int defaultColor = Color.rgb(255, 255, 255);
                                b3.setBackgroundColor(defaultColor);
                            }
                        }, 200);
                        resetPrevButton();
                    }
                    turn--;
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print(buttonColors[3]);
                b4.setBackgroundColor(buttonColors[3]);
                if(turn == 1) {
                    System.out.println("FOUR DISABLE");
                    b4.setEnabled(false);
                    previousColor = buttonColors[3];
                    prevButtonNum = 4;
                    turn++;
                }
                else if(turn == 2) {
                    if(buttonColors[3] == previousColor) {
                        System.out.println("FOUR DISABLE");
                        b4.setEnabled(false);
                    }
                    else {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int defaultColor = Color.rgb(255, 255, 255);
                                b4.setBackgroundColor(defaultColor);
                            }
                        }, 200);
                        resetPrevButton();
                    }
                    turn--;
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5.setBackgroundColor(buttonColors[4]);
                if(turn == 1) {
                    System.out.println("FIVE DISABLE");
                    b5.setEnabled(false);
                    previousColor = buttonColors[4];
                    prevButtonNum = 5;
                    turn++;
                }
                else if(turn == 2) {
                    if(buttonColors[4] == previousColor) {
                        System.out.println("FIVE DISABLE");
                        b5.setEnabled(false);
                    }
                    else {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int defaultColor = Color.rgb(255, 255, 255);
                                b5.setBackgroundColor(defaultColor);
                            }
                        }, 200);
                        resetPrevButton();
                    }
                    turn--;
                }
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b6.setBackgroundColor(buttonColors[5]);
                if(turn == 1) {
                    System.out.println("TWO DISABLE");
                    b6.setEnabled(false);
                    previousColor = buttonColors[5];
                    prevButtonNum = 6;
                    turn++;
                }
                else if(turn == 2) {
                    if(buttonColors[5] == previousColor) {
                        System.out.println("SIX DISABLE");
                        b6.setEnabled(false);
                    }
                    else {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int defaultColor = Color.rgb(255, 255, 255);
                                b6.setBackgroundColor(defaultColor);
                            }
                        }, 200);
                        resetPrevButton();
                    }
                    turn--;
                }
            }
        });
    }

    public void setColors() {
        //3 random numbers 0 - 6;
        ArrayList<Integer> colorRands = new ArrayList<Integer>();
        int colorRand = 0;
        while(colorRands.size() < 3) {
            colorRand = (int)(Math.random() * 7);
            if(colorRands.indexOf(colorRand) == -1) {
                colorRands.add(colorRand);
            }
        }
        //randomizes position of each color
        ArrayList<Integer> buttonNumbers= new ArrayList<Integer>();
        buttonNumbers.add(0);
        buttonNumbers.add(1);
        buttonNumbers.add(2);
        buttonNumbers.add(3);
        buttonNumbers.add(4);
        buttonNumbers.add(5);
        int colorRandIndex = 0;
        for(int i = 0; i < 6; i++) {
            int buttonIndex = (int)(Math.random() * buttonNumbers.size());
            //sets array of corresponding colors
            buttonColors[buttonNumbers.get(buttonIndex)] = getColorForIndex(colorRandIndex);
            if(i%2 == 1) {
                colorRandIndex++;
            }
            buttonNumbers.remove(buttonIndex);
        }
    }

    public void resetPrevButton() {
        if(prevButtonNum == 1) {
            System.out.println("ONE ENABLE");
            b1.setEnabled(true);
            int defaultColor = Color.rgb(255, 255, 255);
            b1.setBackgroundColor(defaultColor);
        }
        else if(prevButtonNum == 2) {
            System.out.println("TWO ENABLE");
            b2.setEnabled(true);
            int defaultColor = Color.rgb(255, 255, 255);
            b2.setBackgroundColor(defaultColor);
        }
        else if(prevButtonNum == 3) {
            System.out.println("THREE ENABLE");
            b3.setEnabled(true);
            int defaultColor = Color.rgb(255, 255, 255);
            b3.setBackgroundColor(defaultColor);
        }
        else if(prevButtonNum == 4) {
            System.out.println("FOUR ENABLE");
            b4.setEnabled(true);
            int defaultColor = Color.rgb(255, 255, 255);
            b4.setBackgroundColor(defaultColor);
        }
        else if(prevButtonNum == 5) {
            System.out.println("FIVE ENABLE");
            b5.setEnabled(true);
            int defaultColor = Color.rgb(255, 255, 255);
            b5.setBackgroundColor(defaultColor);
        }
        else if(prevButtonNum == 6) {
            System.out.println("SIX ENABLE");
            b6.setEnabled(true);
            int defaultColor = Color.rgb(255, 255, 255);
            b6.setBackgroundColor(defaultColor);
        }
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

}



