package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class NewPostTabController {
    private static Parent root;

    static {

        try {
            root = FXMLLoader.load(Objects.requireNonNull(UserAccountController.class.getResource("NewPostTab.fxml")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Scene scene = new Scene(root);

    @FXML
    AnchorPane myPane;
    @FXML
    Button homeTabButton;
    @FXML
    Button searchTabButton;
    @FXML
    Button newPostButton;
    @FXML
    Button chatTabButton;
    @FXML
    Button myPageTabButton;
    @FXML
    Button logoutButton;
    @FXML
    Label userinfoLabel;

    @FXML
    Rectangle postImageRect;
    @FXML
    Button selectImageButton;
    @FXML
    TextField captionTextField;
    @FXML
    Button doneButton;


    public static User loginUser;
    ImageView img = new ImageView();

    public void reset(){
        postImageRect.setFill(Paint.valueOf("#d3d9df"));
        captionTextField.clear();
    }

    public void selectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.svg"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            img.setImage(new Image(file.toURI().toString()));
            postImageRect.setFill(new ImagePattern(img.getImage()));
        } else {
            System.out.println("It's null");
        }
    }

    public void sendPost() {
        Rectangle rect = new Rectangle();
        rect.setWidth(540);
        rect.setHeight(327);
        rect.setFill(new ImagePattern(img.getImage()));
        loginUser.new_post(rect,captionTextField.getText());
        reset();
    }

    public void homeTab() {
        reset();
        Main.changeSceneToHomeTab();

    }

    public void searchTab() {
        reset();
        Main.changeSceneToUserAccount();
    }

    public void newPostTab() {
        userinfoLabel.setText(loginUser.username);
        if (Main.theme.equals("Default")) {
            homeTabButton.setStyle("");
            homeTabButton.setTextFill(Color.BLACK);
            searchTabButton.setStyle("");
            searchTabButton.setTextFill(Color.BLACK);
            newPostButton.setStyle("");
            newPostButton.setTextFill(Color.BLACK);
            chatTabButton.setStyle("");
            chatTabButton.setTextFill(Color.BLACK);
            myPageTabButton.setStyle("");
            myPageTabButton.setTextFill(Color.BLACK);
            logoutButton.setStyle("");
            logoutButton.setTextFill(Color.BLACK);
            myPane.setStyle("");
        }

        else if (Main.theme.equals("Dark")) {
            homeTabButton.setStyle("-fx-border-color: #ffffff");
            homeTabButton.setStyle("-fx-background-color: #000000");
            homeTabButton.setTextFill(Color.WHITE);
            searchTabButton.setStyle("-fx-border-color: #ffffff");
            searchTabButton.setStyle("-fx-background-color: #000000");
            searchTabButton.setTextFill(Color.WHITE);
            newPostButton.setStyle("-fx-border-color: #ffffff");
            newPostButton.setStyle("-fx-background-color: #000000");
            newPostButton.setTextFill(Color.WHITE);
            chatTabButton.setStyle("-fx-border-color: #ffffff");
            chatTabButton.setStyle("-fx-background-color: #000000");
            chatTabButton.setTextFill(Color.WHITE);
            myPageTabButton.setStyle("-fx-border-color: #ffffff");
            myPageTabButton.setStyle("-fx-background-color: #000000");
            myPageTabButton.setTextFill(Color.WHITE);
            logoutButton.setStyle("-fx-border-color: #ffffff");
            logoutButton.setStyle("-fx-background-color: #000000");
            logoutButton.setTextFill(Color.WHITE);
            myPane.setStyle("-fx-background-color: #000000");
        }
        else if (Main.theme.equals("Dark Blue")) {
            homeTabButton.setStyle("-fx-border-color: #ffffff");
            homeTabButton.setStyle("-fx-background-color: #0d0084");
            homeTabButton.setTextFill(Color.WHITE);
            searchTabButton.setStyle("-fx-border-color: #ffffff");
            searchTabButton.setStyle("-fx-background-color: #0d0084");
            searchTabButton.setTextFill(Color.WHITE);
            newPostButton.setStyle("-fx-border-color: #ffffff");
            newPostButton.setStyle("-fx-background-color: #0d0084");
            newPostButton.setTextFill(Color.WHITE);
            chatTabButton.setStyle("-fx-border-color: #ffffff");
            chatTabButton.setStyle("-fx-background-color: #0d0084");
            chatTabButton.setTextFill(Color.WHITE);
            myPageTabButton.setStyle("-fx-border-color: #ffffff");
            myPageTabButton.setStyle("-fx-background-color: #0d0084");
            myPageTabButton.setTextFill(Color.WHITE);
            logoutButton.setStyle("-fx-border-color: #ffffff");
            logoutButton.setStyle("-fx-background-color: #0d0084");
            logoutButton.setTextFill(Color.WHITE);
            myPane.setStyle("-fx-background-color: #0d0084");
        }

        else if (Main.theme.equals("Light Blue")) {
            homeTabButton.setStyle("-fx-border-color: #ffffff");
            homeTabButton.setStyle("-fx-background-color: #00ffc2");
            homeTabButton.setTextFill(Color.BLACK);
            searchTabButton.setStyle("-fx-border-color: #ffffff");
            searchTabButton.setStyle("-fx-background-color: #00ffc2");
            searchTabButton.setTextFill(Color.BLACK);
            newPostButton.setStyle("-fx-border-color: #ffffff");
            newPostButton.setStyle("-fx-background-color: #00ffc2");
            newPostButton.setTextFill(Color.BLACK);
            chatTabButton.setStyle("-fx-border-color: #ffffff");
            chatTabButton.setStyle("-fx-background-color: #00ffc2");
            chatTabButton.setTextFill(Color.BLACK);
            myPageTabButton.setStyle("-fx-border-color: #ffffff");
            myPageTabButton.setStyle("-fx-background-color: #00ffc2");
            myPageTabButton.setTextFill(Color.BLACK);
            logoutButton.setStyle("-fx-border-color: #ffffff");
            logoutButton.setStyle("-fx-background-color: #00ffc2");
            logoutButton.setTextFill(Color.BLACK);
            myPane.setStyle("-fx-background-color: #00ffc2");
        }
    }

    public void chatTab(){
        reset();
        Main.changeSceneToChatTab();
    }

    public void myPageTab() {
        reset();
        Main.changeSceneToMyPageTab();
    }

    public void logout() {
        reset();
        Main.changeSceneToHelloController();
    }
    public void mouseHand(MouseEvent mouseEvent) {
        scene.setCursor(Cursor.HAND);
    }

    public void mouseDefault(MouseEvent mouseEvent) {
        scene.setCursor(Cursor.DEFAULT);
    }
}
