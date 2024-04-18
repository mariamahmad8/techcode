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

public class AddEvent extends CalendarActivity {
    // fields:
    String nameOfEvent;
    String time;
    boolean isMedicine;

    public AddEvent(){
        nameOfEvent = "unittled event";
        time = "all day";
        isMedicine = false;
    }
    public AddEvent(String nameOfEvent, String time, boolean isMedicine ){
        this.nameOfEvent = nameOfEvent;
        this.time = time;
        this.isMedicine = isMedicine;
        if(isMedicine){
            changeAlarmVal();
        }
    }

    public String getNameOfEvent(){
        return "";
    }
    public String getTime(){
        return "";
    }
    public boolean getIsMedicine(){
        return false;
    }

    public void changeAlarmVal(){

    }
    // create getter + setters

}
