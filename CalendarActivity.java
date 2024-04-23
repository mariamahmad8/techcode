package com.example.findme_technovation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.graphics.Color;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class CalendarActivity extends MainActivity {
    private ArrayList<Event> events;

    FirebaseFirestore db;
    private LinearLayout eventsLayout;
    private Button addButton;
    private Button backButton;
    private static final int ADD_REQUEST = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        final String[][] info = {{""}};
        events = new ArrayList<>();
        final String[] title = {""};
        final String[] message = {""};
        final String[] time = {""};
        final String[] hours = {""};
        final String[] minutes = {""};
        eventsLayout = (LinearLayout) findViewById(R.id.calendarLinear);
        addButton = (Button) findViewById(R.id.addButton);
        backButton = (Button) findViewById(R.id.homeButtonE);
        db = FirebaseFirestore.getInstance();
        db.collection("todos")
                .get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override

            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(CalendarActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    ArrayList<String> titles = new ArrayList<>();
                    ArrayList<String> messages = new ArrayList<>();
                    ArrayList<String> hoursList = new ArrayList<>();
                    ArrayList<String> minutesList = new ArrayList<>();
                    ArrayList<String> times = new ArrayList<>();

                    for(QueryDocumentSnapshot document : task.getResult()) {
                        String docData = document.getData().toString();
                        String title = docData.substring(docData.indexOf("Title") + 6, docData.indexOf("Time") - 2);
                        String message = docData.substring(docData.indexOf("Message") + 8, docData.indexOf("Hours") - 2);
                        String hours = docData.substring(docData.indexOf("Hours") + 6, docData.indexOf("Title") - 2);
                        String minutes = docData.substring(docData.indexOf("Minutes") + 8, docData.indexOf("}"));
                        String time = docData.substring(docData.indexOf("Time") + 5, docData.indexOf("Minutes") - 2);

                        // Add extracted data to ArrayLists
                        titles.add(title);
                        messages.add(message);
                        hoursList.add(hours);
                        minutesList.add(minutes);
                        times.add(time);
                    }
                    addIt(titles, messages, hoursList, minutesList, times);
                    // Now you have ArrayLists containing the data from each document
                    // You can use these ArrayLists as needed, such as displaying in UI or performing further operations
                    // For demonstration, let's just print them
                    for (int i = 0; i < titles.size(); i++) {
                        System.out.println("Title: " + titles.get(i));
                        System.out.println("Message: " + messages.get(i));
                        System.out.println("Time: " + times.get(i));
                        System.out.println("Hours: " + hoursList.get(i));
                        System.out.println("Minutes: " + minutesList.get(i));
                    }
                }
            }

        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarActivity.this, MainActivity.class));
            }
        });

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(CalendarActivity.this, Add.class));
            }
        });
    }

    public void addIt(ArrayList<String> titles,ArrayList<String> messages,ArrayList<String> hoursList,ArrayList<String> minutesList,ArrayList<String> times) {
        for(int k = 0; k < titles.size(); k++) {
            LinearLayout eventLayout = new LinearLayout(this);
            eventLayout.setOrientation(LinearLayout.VERTICAL);
            eventLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            TextView titleTimeView = new TextView(this);
            titleTimeView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            titleTimeView.setText(String.format("%s at %s", titles.get(k), hoursList.get(k) + ":" + minutesList.get(k) ));
            titleTimeView.setPadding(10, 10, 10, 10);
            titleTimeView.setTextSize(25);
            TextView descriptionView = new TextView(this);
            descriptionView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            descriptionView.setText(messages.get(k));
            descriptionView.setTextColor(Color.RED);
            descriptionView.setPadding(10, 8, 10, 10);
            descriptionView.setTextSize(16);
            eventLayout.addView(titleTimeView);
            eventLayout.addView(descriptionView);
            eventsLayout.addView(eventLayout);
        }
    }
}