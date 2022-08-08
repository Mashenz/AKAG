package com.example.oop_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    private static Parent root;

    static {

        try {
            root = FXMLLoader.load(Objects.requireNonNull(UserAccountController.class.getResource("hello-view.fxml")));

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Scene scene = new Scene(root);


    @FXML
    AnchorPane pane;

    @FXML
    Button login;
    @FXML
    Button create_account;

    @FXML
    Rectangle loginRect;
    @FXML
    Label usernameLabel_L;
    @FXML
    Label passwordLabel_L;
    @FXML
    Label loginError;
    @FXML
    TextField usernameTextField_L;
    @FXML
    TextField passwordTextField_L;
    @FXML
    Button loginButton_L;
    @FXML
    Button backButton_L;

    @FXML
    Label usernameLabel_C;
    @FXML
    Label passwordLabel_C;
    @FXML
    Label createAccountError;
    @FXML
    TextField usernameTextField_C;
    @FXML
    TextField passwordTextField_C;
    @FXML
    CheckBox bussinessAccountCheckBox_C;
    @FXML
    Button doneButton_C;
    @FXML
    Button backButton_C;


    public void login(){
        login.setVisible(false);
        create_account.setVisible(false);
        loginRect.setVisible(true);
        usernameLabel_L.setVisible(true);
        passwordLabel_L.setVisible(true);
        usernameTextField_L.setVisible(true);
        passwordTextField_L.setVisible(true);
        loginButton_L.setVisible(true);
        backButton_L.setVisible(true);
    }

    public void create_account(){
        login.setVisible(false);
        create_account.setVisible(false);
        loginRect.setVisible(true);
        usernameLabel_C.setVisible(true);
        passwordLabel_C.setVisible(true);
        usernameTextField_C.setVisible(true);
        passwordTextField_C.setVisible(true);
        doneButton_C.setVisible(true);
        backButton_C.setVisible(true);
        bussinessAccountCheckBox_C.setVisible(true);
    }

    public void login2(ActionEvent event) {
        String username = usernameTextField_L.getText();
        String password = passwordTextField_L.getText();
        boolean exist = false;
        for (int i=0;i<User.users.size();i++) {
            if (User.users.get(i).username.equals(username)) {
                if (User.users.get(i).password.equals(password)) {
                    HomeTabController.loginUser = User.users.get(i);
                    UserAccountController.loginUser = User.users.get(i);
                    NewPostTabController.loginUser = User.users.get(i);
                    ChatTabController.loginUser = User.users.get(i);
                    MyPageTabController.loginUser = User.users.get(i);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
                    LocalDateTime now = LocalDateTime.now();
                    loginError.setVisible(false);
                    Main.changeSceneToHomeTab();
                    exist = true;
                }
            }
        }

        if (!exist)
            loginError.setVisible(true);

        usernameTextField_L.clear();
        passwordTextField_L.clear();
    }

    public void back_L(ActionEvent event) {
        login.setVisible(true);
        create_account.setVisible(true);
        loginRect.setVisible(false);
        usernameLabel_L.setVisible(false);
        passwordLabel_L.setVisible(false);
        usernameTextField_L.setVisible(false);
        passwordTextField_L.setVisible(false);
        loginButton_L.setVisible(false);
        backButton_L.setVisible(false);
    }

    public void mouseHand(MouseEvent mouseEvent) {
        scene.setCursor(Cursor.HAND);
    }

    public void mouseDefault(MouseEvent mouseEvent) {
        scene.setCursor(Cursor.DEFAULT);
    }

    public void done(ActionEvent event) {

        boolean exist = false;
        for (int j = 0; (j < User.users.size()) && (!exist); j++) {
            if (User.users.get(j).username.equals(usernameTextField_C.getText())) {
                createAccountError.setVisible(true);
                exist = true;
            }
        }

        if (exist)
            createAccountError.setVisible(true);

        else {
            User new_user = new User(usernameTextField_C.getText(),passwordTextField_C.getText(),bussinessAccountCheckBox_C.isSelected());
            User.users.add(new_user);
            back_C();
            login.setVisible(false);
            create_account.setVisible(false);
            loginRect.setVisible(true);
            usernameLabel_L.setVisible(true);
            passwordLabel_L.setVisible(true);
            usernameTextField_L.setVisible(true);
            passwordTextField_L.setVisible(true);
            loginButton_L.setVisible(true);
            backButton_L.setVisible(true);
            createAccountError.setVisible(false);
            usernameTextField_C.clear();
            passwordTextField_C.clear();
        }
    }

    public void back_C() {
        login.setVisible(true);
        create_account.setVisible(true);
        loginRect.setVisible(false);
        usernameLabel_C.setVisible(false);
        passwordLabel_C.setVisible(false);
        usernameTextField_C.setVisible(false);
        passwordTextField_C.setVisible(false);
        doneButton_C.setVisible(false);
        backButton_C.setVisible(false);
        createAccountError.setVisible(false);
        bussinessAccountCheckBox_C.setVisible(false);
    }
}