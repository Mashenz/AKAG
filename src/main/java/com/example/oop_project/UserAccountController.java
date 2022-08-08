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
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class UserAccountController {
    private static Parent root;

    static {

        try {
            root = FXMLLoader.load(Objects.requireNonNull(UserAccountController.class.getResource("UserAccount.fxml")));

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

    //searchTab
    @FXML
    Button searchUserButton;
    @FXML
    TextField searchUserTextField;
    @FXML
    ListView<String> userFoundListView;
    @FXML
    Rectangle showUserRect;
    @FXML
    Circle userProfileCircle;
    @FXML
    Label nPostsLabel;
    @FXML
    Label nFollowersLabel;
    @FXML
    Label nFollowingsLabel;
    @FXML
    Label postsLabel;
    @FXML
    Label followersLabel;
    @FXML
    Label followingsLabel;
    @FXML
    Button backFromUserProfileButton;
    @FXML
    Button followUserButton;
    @FXML
    Button followingUserButton;
    @FXML
    ListView<String> showFollowersOrFollowingsOrLikersListView;
    @FXML
    Button exitFromFollowersOrFollowingsOrLikersList;
    @FXML
    ListView<Rectangle> showPostsListView;
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
    ListView<String> showCommentsListView;
    @FXML
    TextField commentTextField;
    @FXML
    Button sendCommentButton;
    @FXML
    Button exitFromShowCommentsButton;
    @FXML
    Button blockUserButton;
    @FXML
    Button blockedUserButton;




    public static User loginUser;
    public User selectedUser;


    public void reset(){
        showUserRect.setVisible(false);
        userProfileCircle.setVisible(false);
        nPostsLabel.setVisible(false);
        nFollowersLabel.setVisible(false);
        nFollowingsLabel.setVisible(false);
        postsLabel.setVisible(false);
        followersLabel.setVisible(false);
        followingsLabel.setVisible(false);
        backFromUserProfileButton.setVisible(false);
        followUserButton.setVisible(false);
        followingUserButton.setVisible(false);
        showFollowersOrFollowingsOrLikersListView.setVisible(false);
        exitFromFollowersOrFollowingsOrLikersList.setVisible(false);
        showPostsListView.setVisible(false);
        showUserPostRect.setVisible(false);
        postCaptionLabel.setVisible(false);
        showUserCaptionRect.setVisible(false);
        exitFromShowPostButton.setVisible(false);
        likePostButton.setVisible(false);
        showLikersButton.setVisible(false);
        likedPostButton.setVisible(false);
        commentButton.setVisible(false);
        showCommentsListView.setVisible(false);
        commentTextField.setVisible(false);
        exitFromShowCommentsButton.setVisible(false);
        sendCommentButton.setVisible(false);
        blockUserButton.setVisible(false);
        blockedUserButton.setVisible(false);
        searchUserTextField.clear();
        commentTextField.clear();
        userFoundListView.getItems().clear();
        showPostsListView.getItems().clear();
        showCommentsListView.getItems().clear();
        showFollowersOrFollowingsOrLikersListView.getItems().clear();
    }

    public void searchUser() {

        String search = searchUserTextField.getText();
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i < User.users.size(); i++) {
            if ((User.users.get(i).username.contains(search)) && (!User.users.get(i).username.equals(loginUser.username)))
                users.add(User.users.get(i).username);
        }
        userFoundListView.setItems(FXCollections.observableList(users));
    }

    public void showUserPage() {
        //int x = 0;
        String username = userFoundListView.getSelectionModel().getSelectedItem();
        for (int i = 0; i < User.users.size(); i++) {
            if (User.users.get(i).username.equals(username))
                selectedUser = User.users.get(i);
        }
        nPostsLabel.setText(String.valueOf(selectedUser.posts.size()));
        nFollowersLabel.setText(String.valueOf(selectedUser.followers.size()));
        nFollowingsLabel.setText(String.valueOf(selectedUser.followings.size()));
        showUserRect.setVisible(true);
        userProfileCircle.setVisible(true);
        nPostsLabel.setVisible(true);
        nFollowersLabel.setVisible(true);
        nFollowingsLabel.setVisible(true);
        postsLabel.setVisible(true);
        followersLabel.setVisible(true);
        followingsLabel.setVisible(true);
        backFromUserProfileButton.setVisible(true);
        boolean exist = false;
        for (int i = 0; i < (loginUser.followings.size()) && (!exist); i++) {
            if (loginUser.followings.get(i).username.equals(userFoundListView.getSelectionModel().getSelectedItem())) {
                followingUserButton.setVisible(true);
                exist = true;
            }
        }
        if (!exist)
            followUserButton.setVisible(true);

        showPostsListView.setVisible(true);
        ArrayList<Rectangle> aa = new ArrayList<>();
        for (int i = 0; i < selectedUser.posts.size(); i++) {
            aa.add(selectedUser.posts.get(i).rect);
        }
        showPostsListView.setItems(FXCollections.observableList(aa));

        if (selectedUser.blocks.contains(loginUser.username))
            blockedUserButton.setVisible(true);

        else
            blockUserButton.setVisible(true);

    }


    public void backFromUserProfile() {
        searchTab();

    }

    public void userFollow() {
        followUserButton.setVisible(false);
        followingUserButton.setVisible(true);
        String username = userFoundListView.getSelectionModel().getSelectedItem();
        loginUser.follow(username);
        showUserPage();
    }

    public void userunFollow() {
        followUserButton.setVisible(true);
        followingUserButton.setVisible(false);
        String username = userFoundListView.getSelectionModel().getSelectedItem();
        loginUser.unfollow(username);
        showUserPage();
    }

    public void exitFromFollowersOrFollowingsList() {
        showFollowersOrFollowingsOrLikersListView.getItems().clear();
        showFollowersOrFollowingsOrLikersListView.setVisible(false);
        exitFromFollowersOrFollowingsOrLikersList.setVisible(false);
    }

    public void showFollowersList() {
        showFollowersOrFollowingsOrLikersListView.setVisible(true);
        exitFromFollowersOrFollowingsOrLikersList.setVisible(true);
        int x = 0;
        String username = userFoundListView.getSelectionModel().getSelectedItem();
        ArrayList<String> listitems = new ArrayList<>();
        for (int i = 0; i < User.users.size(); i++) {
            if (User.users.get(i).username.equals(username))
                x = i;
        }
        for (int i = 0; i < User.users.get(x).followers.size(); i++)
            listitems.add(User.users.get(x).followers.get(i).username);

        showFollowersOrFollowingsOrLikersListView.setItems(FXCollections.observableList(listitems));
    }

    public void showFollowingsList() {
        showFollowersOrFollowingsOrLikersListView.setVisible(true);
        exitFromFollowersOrFollowingsOrLikersList.setVisible(true);
        int x = 0;
        String username = userFoundListView.getSelectionModel().getSelectedItem();
        ArrayList<String> listitems = new ArrayList<>();
        for (int i = 0; i < User.users.size(); i++) {
            if (User.users.get(i).username.equals(username))
                x = i;
        }
        for (int i = 0; i < User.users.get(x).followings.size(); i++)
            listitems.add(User.users.get(x).followings.get(i).username);

        showFollowersOrFollowingsOrLikersListView.setItems(FXCollections.observableList(listitems));
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
        int n = showPostsListView.getSelectionModel().getSelectedIndex();
        if (!selectedUser.posts.get(n).likers.contains(loginUser.username)){
            selectedUser.posts.get(n).likers.add(loginUser.username);
            likePostButton.setVisible(false);
            likedPostButton.setVisible(true);
        }
        else {
            selectedUser.posts.get(n).likers.remove(loginUser.username);
            likePostButton.setVisible(true);
            likedPostButton.setVisible(false);
        }
        System.out.println(selectedUser.posts.get(n).likers.size());
    }

    public void showUserPost() {
        int n = showPostsListView.getSelectionModel().getSelectedIndex();
        showUserPostRect.setVisible(true);
        showUserCaptionRect.setVisible(true);
        postCaptionLabel.setVisible(true);
        exitFromShowPostButton.setVisible(true);
        showLikersButton.setVisible(true);
        commentButton.setVisible(true);
        if (!selectedUser.posts.get(n).likers.contains(loginUser.username))
            likePostButton.setVisible(true);
        else
            likedPostButton.setVisible(true);
        showUserPostRect.setFill(showPostsListView.getSelectionModel().getSelectedItem().getFill());

        postCaptionLabel.setText(selectedUser.posts.get(n).username+":"+selectedUser.posts.get(n).caption+"        "+selectedUser.posts.get(n).date);

    }

    public void showLikers() {
        showFollowersOrFollowingsOrLikersListView.setVisible(true);
        exitFromFollowersOrFollowingsOrLikersList.setVisible(true);
        int n = showPostsListView.getSelectionModel().getSelectedIndex();
        ArrayList<String> listitems = new ArrayList<>();
        for (int i = 0; i < selectedUser.posts.get(n).likers.size(); i++)
            listitems.add(selectedUser.posts.get(n).likers.get(i));

        showFollowersOrFollowingsOrLikersListView.setItems(FXCollections.observableList(listitems));
    }

    public void showComments() {
        showCommentsListView.setVisible(true);
        commentTextField.setVisible(true);
        sendCommentButton.setVisible(true);
        exitFromShowCommentsButton.setVisible(true);
        int n = showPostsListView.getSelectionModel().getSelectedIndex();
        ArrayList<String> listitems = new ArrayList<>();
        for (int i = 0; i < selectedUser.posts.get(n).comments.size(); i++)
            listitems.add(selectedUser.posts.get(n).comments.get(i).username+":"+
                    selectedUser.posts.get(n).comments.get(i).text+"           "+selectedUser.posts.get(n).comments.get(i).date);
        showCommentsListView.setItems(FXCollections.observableList(listitems));
    }

    public void sendComment() {
        String text = commentTextField.getText();
        Comment new_comment = new Comment(loginUser.username,text);
        int n = showPostsListView.getSelectionModel().getSelectedIndex();
        selectedUser.posts.get(n).comments.add(new_comment);
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

    public void homeTab() {
        reset();
        Main.changeSceneToHomeTab();
        HomeTabController.loginUser=loginUser;
    }

    public void newPostTab() {
        reset();
        Main.changeSceneToNewPostTab();
        NewPostTabController.loginUser=loginUser;
    }

    public void searchTab() {
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
            searchUserButton.setStyle("");
            searchUserButton.setTextFill(Color.BLACK);
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
            searchUserButton.setStyle("-fx-background-color: #000000");
            searchUserButton.setTextFill(Color.WHITE);
            myPane.setStyle("-fx-background-color: #ffffff");
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
            searchUserButton.setStyle("-fx-background-color: #0d0084");
            searchUserButton.setTextFill(Color.WHITE);
            myPane.setStyle("-fx-background-color: #ffffff");
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
            searchUserButton.setStyle("-fx-background-color: #00ffc2");
            searchUserButton.setTextFill(Color.BLACK);
            myPane.setStyle("-fx-background-color: #ffffff");
        }

        reset();
    }

    public void chatTab(){
        reset();
        Main.changeSceneToChatTab();
    }

    public void myPageTab() {
        reset();
        MyPageTabController.loginUser=loginUser;
        Main.changeSceneToMyPageTab();
    }

    public void logout(ActionEvent event) {
        reset();
        Main.changeSceneToHelloController();
    }

    public void mouseHand(MouseEvent mouseEvent) {
        scene.setCursor(Cursor.HAND);
    }

    public void mouseDefault(MouseEvent mouseEvent) {
        scene.setCursor(Cursor.DEFAULT);
    }

    public void block() {
        if (selectedUser.blocks.contains(loginUser.username)) {
            blockedUserButton.setVisible(false);
            blockUserButton.setVisible(true);
            selectedUser.blocks.remove(loginUser.username);
        }

        else {
            blockedUserButton.setVisible(true);
            blockUserButton.setVisible(false);
            selectedUser.blocks.add(loginUser.username);
        }
    }


}

