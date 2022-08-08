package com.example.oop_project;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class HomeTabController {
    private static Parent root;

    static {

        try {
            root = FXMLLoader.load(Objects.requireNonNull(UserAccountController.class.getResource("HomeTab.fxml")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Scene scene = new Scene(root);

    @FXML
    AnchorPane myPane;
    @FXML
    Label userinfoLabel;
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
    ListView<Rectangle> latestPostsListView;
    @FXML
    Rectangle showUserPostRect;
    @FXML
    Rectangle showUserCaptionRect;
    @FXML
    Button exitFromShowPostButton;
    @FXML
    Label postCaptionLabel;
    @FXML
    Button likePostButton;
    @FXML
    Button showLikersButton;
    @FXML
    Button likedPostButton;
    @FXML
    Button commentButton;
    @FXML
    ListView<String> showLikersListView;
    @FXML
    Button exitFromLikersList;
    @FXML
    ListView<String> showCommentsListView;
    @FXML
    TextField commentTextField;
    @FXML
    Button sendCommentButton;
    @FXML
    Button exitFromShowCommentsButton;




    public ArrayList<Post> userOfLatestPosts = new ArrayList<>();
    public static User loginUser;

    public void reset(){
        showUserPostRect.setVisible(false);
        showUserCaptionRect.setVisible(false);
        exitFromShowPostButton.setVisible(false);
        postCaptionLabel.setVisible(false);
        likePostButton.setVisible(false);
        showLikersButton.setVisible(false);
        likedPostButton.setVisible(false);
        commentButton.setVisible(false);
        showLikersListView.setVisible(false);
        exitFromLikersList.setVisible(false);
        showCommentsListView.setVisible(false);
        commentTextField.setVisible(false);
        sendCommentButton.setVisible(false);
        exitFromShowCommentsButton.setVisible(false);
        showCommentsListView.getItems().clear();
        showLikersListView.getItems().clear();
    }

    public void homeTab() {
        userinfoLabel.setText(loginUser.username);
        latestPostsListView.setVisible(true);
        userOfLatestPosts.clear();
        ArrayList<Rectangle> aa = new ArrayList<>();
        for (int i = 0; i < loginUser.latest_posts.size(); i++) {
            aa.add(loginUser.latest_posts.get(i).rect);
            userOfLatestPosts.add(loginUser.latest_posts.get(i));
        }
        latestPostsListView.setItems(FXCollections.observableList(aa));


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

    public void showUserPostinHomeTab() {
        int n = latestPostsListView.getSelectionModel().getSelectedIndex();
        showUserPostRect.setVisible(true);
        showUserCaptionRect.setVisible(true);
        postCaptionLabel.setVisible(true);
        exitFromShowPostButton.setVisible(true);
        showLikersButton.setVisible(true);
        commentButton.setVisible(true);
        if (!userOfLatestPosts.get(n).likers.contains(loginUser.username))
            likePostButton.setVisible(true);
        else
            likedPostButton.setVisible(true);
        System.out.println(userOfLatestPosts.get(n).username);
        showUserPostRect.setFill(latestPostsListView.getSelectionModel().getSelectedItem().getFill());
        postCaptionLabel.setText(userOfLatestPosts.get(n).username+":"+userOfLatestPosts.get(n).caption+"        "+userOfLatestPosts.get(n).date);
    }

    public void exitFromShowPost() {
        showUserPostRect.setVisible(false);
        showUserCaptionRect.setVisible(false);
        postCaptionLabel.setVisible(false);
        exitFromShowPostButton.setVisible(false);
        likePostButton.setVisible(false);
        likedPostButton.setVisible(false);
        showLikersButton.setVisible(false);
        commentButton.setVisible(false);
    }

    public void likePost() {
        int n = latestPostsListView.getSelectionModel().getSelectedIndex();
        if (!userOfLatestPosts.get(n).likers.contains(loginUser.username)){
            userOfLatestPosts.get(n).likers.add(loginUser.username);
            likePostButton.setVisible(false);
            likedPostButton.setVisible(true);
        }
        else {
            userOfLatestPosts.get(n).likers.remove(loginUser.username);
            likePostButton.setVisible(true);
            likedPostButton.setVisible(false);
        }
    }


    public void showLikers() {
        showLikersListView.setVisible(true);
        exitFromLikersList.setVisible(true);
        int n = latestPostsListView.getSelectionModel().getSelectedIndex();
        ArrayList<String> listitems = new ArrayList<>();
        for (int i = 0; i < userOfLatestPosts.get(n).likers.size(); i++)
            listitems.add(userOfLatestPosts.get(n).likers.get(i));

        showLikersListView.setItems(FXCollections.observableList(listitems));
    }

    public void showComments() {
        showCommentsListView.setVisible(true);
        commentTextField.setVisible(true);
        sendCommentButton.setVisible(true);
        exitFromShowCommentsButton.setVisible(true);
        int n = latestPostsListView.getSelectionModel().getSelectedIndex();
        ArrayList<String> listitems = new ArrayList<>();
        for (int i = 0; i < userOfLatestPosts.get(n).comments.size(); i++)
            listitems.add(userOfLatestPosts.get(n).comments.get(i).username+":"+
                    userOfLatestPosts.get(n).comments.get(i).text+"           "+userOfLatestPosts.get(n).comments.get(i).date);
        showCommentsListView.setItems(FXCollections.observableList(listitems));
    }

    public void sendComment() {
        String text = commentTextField.getText();
        Comment new_comment = new Comment(loginUser.username,text);
        int n = latestPostsListView.getSelectionModel().getSelectedIndex();
        userOfLatestPosts.get(n).comments.add(new_comment);
        commentTextField.clear();
        showComments();

    }

    public void exitFromShowComments() {
        showCommentsListView.setVisible(false);
        commentTextField.setVisible(false);
        exitFromShowCommentsButton.setVisible(false);
        sendCommentButton.setVisible(false);
        commentTextField.clear();
        showCommentsListView.getItems().clear();
    }

    public void exitLikersList() {
        showLikersListView.setVisible(false);
        exitFromLikersList.setVisible(false);
    }

    public void searchTab() {
        reset();
        Main.changeSceneToUserAccount();
    }

    public void newPostTab() {
        reset();
        Main.changeSceneToNewPostTab();
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
