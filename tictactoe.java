package com.example.findme_technovation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * THE USER WILL ALWAYS BE "X," AND THE COMPUTER WILL ALWAYS BE "O"
 * Computer iwll randomly come up with moves based on math.Random
 */
public class tictactoe extends GameActivity{


    Button back; // back button
    Button b1; // all the possible buttons
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;

    boolean userTurn; // boolean checking if its currentlty the users turns
    boolean computerTurn; // literally the opposite
    int enabledCount; // count ot check if the board is full
    TextView turn; // turn

    List<Button> buttons; // List to hold buttons

    public tictactoe(){ // initalize all of the values
        userTurn = true;
        computerTurn = false;
        enabledCount = 0;
    }

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);

        back = findViewById(R.id.backButtonM);
        b1 = findViewById(R.id.b1);// initalize all of hte ubtons
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        buttons = new ArrayList<>(); // add em to the arrayList
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);

        back = findViewById(R.id.backButtonT);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(tictactoe.this, GameActivity.class));
            }
        });

        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (userTurn) {
                        // hand the user move and set the text of button to x or o
                            // gotta come up with lgoic
                        button.setText("X");
                        button.setEnabled(false); // disalbe the button
                        enabledCount ++;
                        // check if user wins or if board is full and if its not
                        // then its the pcs turns
                        if (!checkForWin() && !isBoardFull()) {
                            computerTurn = true;
                            userTurn = false;
                            makeComputerMove();
                        }
                    }
                }
            });
        }
    }

    public void makeComputerMove() {
        Random random = new Random();
        // choose a rndom butotn
        Button randomButton;
        do {
            int index = random.nextInt(buttons.size()); // 0 to list size
            randomButton = buttons.get(index); // gest butotn form that spot
        } while (!randomButton.getText().toString().isEmpty()); // keep going until emty found
        // set text to x or o based off oslogic
        randomButton.setText("O");
        randomButton.setEnabled(false); // disalb eit
        enabledCount ++;
        if(isBoardFull()){
            System.out.println("poo");
        }
        // check if computer wins or if board is full and if its sint then its the user turns
        if (!checkForWin() && !isBoardFull()) {
            computerTurn = false;
            userTurn = true;
        }
    }

    public boolean checkForWin() {

        int[][] winCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // teh rwos
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // the cols
                {0, 4, 8}, {2, 4, 6}  // the diaonls
        };

        // go through each combo in the win combinations
        for (int[] combination : winCombinations) {
            Button b1 = buttons.get(combination[0]); // get the ghree buttons from teh combos
            Button b2 = buttons.get(combination[1]);
            Button b3 = buttons.get(combination[2]);
            if (!b1.getText().toString().isEmpty() && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText())) {
                if(b1.getText().equals("X")){
                    System.out.println("you win");
                }
                else{
                    System.out.println("pc wins");
                }
                makeRed(b1, b2, b3);
                return true; // return true
            }
        }
        return false; // Return false if no winning combination is found
    }

    // Optional method to highlight the winning combination
    public void makeRed(Button b1, Button b2, Button b3) {
        b1.setTextColor(Color.RED);
        b2.setTextColor(Color.RED);
        b3.setTextColor(Color.RED);
    }


    public boolean isBoardFull() {
        // do this too idk
        if(enabledCount >= 9){
            return true;
        }
        return false;
    }
}
