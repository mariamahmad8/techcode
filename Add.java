package com.example.findme_technovation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Add extends Activity {
    private EditText titleEdit, timeEdit, messageEdit, hourAdd, minuteAdd;
    private CheckBox amCheckBox, pmCheckBox, medCheckBox;
    private Button doneButton;

    FirebaseFirestore db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding);
        db = FirebaseFirestore.getInstance();
        titleEdit = (EditText) findViewById(R.id.titleAdd);
        messageEdit = (EditText) findViewById(R.id.dirAdd);
        hourAdd = (EditText) findViewById(R.id.hourAdd);
        minuteAdd = (EditText) findViewById(R.id.minuteAdd);
        amCheckBox = (CheckBox) findViewById(R.id.AMbox);
        pmCheckBox = (CheckBox) findViewById(R.id.PMbox);
        medCheckBox = (CheckBox) findViewById(R.id.medBox);
        doneButton = (Button) findViewById(R.id.doneButton);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEdit.getText().toString();
                String hours = hourAdd.getText().toString();
                String minutes = minuteAdd.getText().toString();
                String message = messageEdit.getText().toString();
                boolean  isAM = amCheckBox.isChecked();
                boolean isMedicine = medCheckBox.isChecked();

                Map<String,Object> todos = new HashMap<>();
                todos.put("Title", title);
                todos.put("Message", message);
                todos.put("Hours", hours);
                todos.put("Minutes", minutes);
                if(isAM)
                    todos.put("Time", "AM");
                else
                    todos.put("Time", "PM");
                db.collection("todos")
                        .add(todos)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(Add.this, "Success", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Add.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                startActivity(new Intent(Add.this, CalendarActivity.class));
/*
                Event newEvent = new Event(time, isAM, isMedicine);
                newEvent.setTitle(title);
                newEvent.setMessage(message);
                Intent resultIntent = new Intent(); // so we gotta create intent to pass it into other compeontnts
                resultIntent.putExtra("event", newEvent); // lowkey dont know what this does got this code from stack
                setResult(RESULT_OK, resultIntent); // somethign to do wth the fact that it was successful
                //"here is the result of the activity and it contains this data (Event object)"
                finish(); // finish the activity */
            }
        });
    }
}