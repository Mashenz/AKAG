package com.example.oop_project;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Comment {
    String username;
    String text;
    ArrayList<String> likers = new ArrayList<String>();
    String date;

    Comment(String username, String text){
        this.username=username;
        this.text=text;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        this.date=dtf.format(now);
    }

    public void like(){

    }



}