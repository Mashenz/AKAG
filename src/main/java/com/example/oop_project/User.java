package com.example.oop_project;
import javafx.scene.shape.Rectangle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class User {
    public static ArrayList<User> users = new ArrayList<User>();
    String username;
    String password;
    ArrayList<Post> latest_posts = new ArrayList<Post>();
    ArrayList<User> followers = new ArrayList<User>();
    ArrayList<User> followings = new ArrayList<User>();
    ArrayList<String> blocks = new ArrayList<String>();
    ArrayList<Post> posts = new ArrayList<Post>();
    ArrayList<Chat> chats = new ArrayList<Chat>();
    ArrayList<Group> groups = new ArrayList<Group>();
    boolean bussines_account;
    String date;

    User(String usernsme, String password, boolean bussines_account){
        this.username=usernsme;
        this.password=password;
        this.bussines_account=bussines_account;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        this.date=dtf.format(now);
    }

    public void new_post(Rectangle rect,String caption){
        Post post = new Post(rect,caption);
        post.username=this.username;
        posts.add(post);
        for (int i=0; i<followers.size(); i++)
            followers.get(i).latest_posts.add(post);
       /* for (int i=0; i<followers.size(); i++){
            followers.get(i).latest_posts.add("[" +this.username +"]:"+twitt);
        }
        */

    }

    public void show_my_posts(){
        for (int i=0; i<posts.size();i++){
            System.out.println(i+"."+posts.get(i).text);
            System.out.println("likes:"+posts.get(i).number_of_likes+"     "+"comments:"+posts.get(i).number_of_comments+"     "+posts.get(i).date);
        }
    }

    public void show_others_post(String username){
        for(int i=0;i<users.size();i++){
            if(users.get(i).username.equals(username)){
                users.get(i).show_my_posts();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Do you want to like a post?");
                String input = scanner.nextLine();
                while (input.equals("Yes")) {
                    System.out.println("Which post you want to like?");
                    int j = Integer.parseInt(scanner.nextLine());
                    like(i, j);

                    System.out.println("Do you want to like a post?");
                    input = scanner.nextLine();
                }
                System.out.println("Do you want to see who liked a post?");
                input = scanner.nextLine();

                while (input.equals("Yes")) {
                    System.out.println("Which post you want to see?");
                    int j = Integer.parseInt(scanner.nextLine());
                    users.get(i).posts.get(j).show_likers();

                    System.out.println("Do you want to see who liked a post?");
                    input = scanner.nextLine();
                }
                System.out.println("Do you want make a comment?");
                input = scanner.nextLine();
                while (input.equals("Yes")) {
                    System.out.println("Which post you want to comment?");
                    int j = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter your comment...");
                    input = scanner.nextLine();
                    comment(input,i,j);

                    System.out.println("Do you want make a comment?");
                    input = scanner.nextLine();
                }
                System.out.println("Do you want to see comments?");
                input = scanner.nextLine();
                while (input.equals("Yes")) {
                    System.out.println("Which post you want to see?");
                    int j = Integer.parseInt(scanner.nextLine());
                    followings.get(i).posts.get(j).show_comments();

                    System.out.println("Do you want to see comments?");
                    input = scanner.nextLine();
                }
            }
        }
    }

    public void follow(String username) {
        for (int i=0; i<users.size();i++){
            if (users.get(i).username.equals(username)) {
                followings.add(users.get(i));
                users.get(i).followers.add(this);
            }
        }

    }

    public void unfollow(String username) {
        for (int i=0; i<users.size();i++){
            if (users.get(i).username.equals(username)) {
                followings.remove(users.get(i));
                users.get(i).followers.remove(this);
            }
        }

    }

    public void like(int i, int j) {
        followings.get(i).posts.get(j).number_of_likes++;
        followings.get(i).posts.get(j).likers.add(this.username);
    }

    public void like( int j) {
        posts.get(j).number_of_likes++;
        posts.get(j).likers.add(this.username);
    }

    public void comment(String input, int i, int j) {
        Comment comment = new Comment(this.username,input);
        followings.get(i).posts.get(j).comments.add(comment);
        followings.get(i).posts.get(j).number_of_comments++;
    }


    public void block(String username){
        blocks.add(username);
    }

    public void show_latest_posts(){
        for (int i=latest_posts.size()-1; i>=0; i--){
            System.out.println(latest_posts.get(i));
        }
    }


}
