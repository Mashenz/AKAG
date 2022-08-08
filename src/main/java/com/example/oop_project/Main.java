package com.example.oop_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage myStage;
    public static String theme = "Default";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        User a=new User("Abolfazl","aaa",false);
        User b=new User("Ab","aaa",false);
        User c=new User("Abo","aaa",false);
        User d=new User("Abol","aaa",false);
        User.users.add(a);
        User.users.add(b);
        User.users.add(c);
        User.users.add(d);
        a.follow("Abo");
        a.follow("Abo");
        c.follow("Ab");
        b.follow("Abolfazl");
        d.follow("Ab");
        Rectangle rect1 = new Rectangle();
        rect1.setWidth(540);
        rect1.setHeight(327);
        rect1.setFill(Color.BLACK);
        Rectangle rect2 = new Rectangle();
        rect2.setWidth(540);
        rect2.setHeight(327);
        rect2.setFill(Color.BLUE);
        Rectangle rect3 = new Rectangle();
        rect3.setWidth(540);
        rect3.setHeight(327);
        rect3.setFill(Color.RED);
        Rectangle rect4 = new Rectangle();
        rect4.setWidth(540);
        rect4.setHeight(327);
        rect4.setFill(Color.YELLOW);
        b.new_post(rect1,"aaaaa");
        b.new_post(rect2,"ssss");
        b.new_post(rect3,"qqqq");
        b.new_post(rect4,"dddd");
        c.new_post(rect1,"j");

        myStage = new Stage();
        myStage.setTitle("Hello");
        myStage.setResizable(false);
        myStage.setScene(HelloController.scene);
        myStage.show();
    }

    public static void changeSceneToHomeTab () {
        myStage.setScene(HomeTabController.scene);
        myStage.setTitle("Hello");
    }

    public static void changeSceneToUserAccount () {
        myStage.setScene(UserAccountController.scene);
        myStage.setTitle("User");
    }

    public static void changeSceneToNewPostTab () {
        myStage.setScene(NewPostTabController.scene);
        myStage.setTitle("Hello");
    }

    public static void changeSceneToChatTab () {
        myStage.setScene(ChatTabController.scene);
        myStage.setTitle("Hello");
    }

    public static void changeSceneToMyPageTab () {
        myStage.setScene(MyPageTabController.scene);
        myStage.setTitle("Hello");
    }

    public static void changeSceneToHelloController () {
        myStage.setScene(HelloController.scene);
        myStage.setTitle("Hello");
    }

}
