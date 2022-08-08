package com.example.oop_project;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Post {
    String username;
    String text;
    String caption;
    Rectangle rect;
    int number_of_likes=0;
    int number_of_comments=0;
    ArrayList<Comment> comments = new ArrayList<Comment>();
    ArrayList<String> likers = new ArrayList<String>();
    String date;

    Post(Rectangle rect, String caption){
        this.rect=rect;
        this.caption=caption;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        this.date=dtf.format(now);
       // text = this.username+":"+caption+"        "+date;
    }

    public void show_comments(){
        for (int i=0;i<comments.size();i++)
            System.out.println(i+".["+comments.get(i).username+"]:"+comments.get(i).text+"       "+comments.get(i).date);

    }

    public void show_likers(){
        for (int i=0; i<likers.size(); i++)
            System.out.println(likers.get(i));
    }




}
