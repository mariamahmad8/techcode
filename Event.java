package com.example.findme_technovation;


import java.io.Serializable;
public class Event implements Serializable {
    private String time;
    private String title;
    private boolean isAM;
    private boolean isMedicine;
    private boolean isDaily;


    private String message;


    public Event(String time, boolean isAM, boolean isMedicine) {
        this.time = time;
        this.isAM = isAM;
        this.isMedicine = isMedicine;
        this.isDaily = isDaily;
        this.title = "Untitled Event";
        this.message = "";
    }


    public String getTime() {
        return time;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getMessage(){
        return message;
    }


    public void setMessage(String message){
        this.message = message;
    }


    public boolean isAM() {
        return isAM;
    }


    public boolean isMedicine() {
        return isMedicine;
    }


    public boolean isDaily() {
        return isDaily;
    }




}
