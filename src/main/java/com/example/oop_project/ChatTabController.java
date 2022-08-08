package com.example.oop_project;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class ChatTabController {
    private static Parent root;

    static {

        try {
            root = FXMLLoader.load(Objects.requireNonNull(UserAccountController.class.getResource("ChatTab.fxml")));

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
    TextField userSearchTextField;
    @FXML
    Button searchButton;
    @FXML
    ListView<String> contactsListView;
    @FXML
    ListView<String> chatListView;
    @FXML
    TextField chatTextField;
    @FXML
    Button sendButton;
    @FXML
    ListView<String> erfListView;
    @FXML
    TextField erfTextField;
    @FXML
    Button erfSendButton;
    @FXML
    Button erfExitButton;
    @FXML
    ListView<String> groupListView;
    @FXML
    Button newGroupButton;
    @FXML
    Rectangle groupRect;
    @FXML
    TextField groupNameTextField;
    @FXML
    TextField groupUsernameTextField;
    @FXML
    Button addUserButton;
    @FXML
    Button doneGroupButton;
    @FXML
    Button showGroupUserButton;
    @FXML
    ListView groupUsersListView;
    @FXML
    Button exitFromGroupUsersButton;




    public static User loginUser;
    public User selectedUser;
    int index1;
    int index2;
    boolean flag = false;

    public void reset(){
        userSearchTextField.clear();
        contactsListView.getItems().clear();
        ArrayList<String> a = new ArrayList<>();
        chatListView.setItems(FXCollections.observableList(a));
        chatTextField.clear();
        erfListView.setVisible(false);
        erfTextField.setVisible(false);
        erfSendButton.setVisible(false);
        erfExitButton.setVisible(false);
        erfTextField.clear();
        groupRect.setVisible(false);
        groupNameTextField.setVisible(false);
        groupUsernameTextField.setVisible(false);
        addUserButton.setVisible(false);
        doneGroupButton.setVisible(false);
        groupUsersListView.setVisible(false);
        exitFromGroupUsersButton.setVisible(false);
        groupNameTextField.clear();
        groupListView.getItems().clear();
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
        reset();
        Main.changeSceneToNewPostTab();
    }

    public void chatTab(){
        reset();
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
            sendButton.setStyle("");
            sendButton.setTextFill(Color.BLACK);
            searchButton.setStyle("");
            searchButton.setTextFill(Color.BLACK);
            erfSendButton.setStyle("");
            erfSendButton.setTextFill(Color.BLACK);
            erfExitButton.setStyle("");
            erfExitButton.setTextFill(Color.BLACK);
            newGroupButton.setStyle("");
            newGroupButton.setTextFill(Color.BLACK);
            showGroupUserButton.setStyle("");
            showGroupUserButton.setTextFill(Color.BLACK);
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
            sendButton.setStyle("-fx-border-color: #ffffff");
            sendButton.setStyle("-fx-background-color: #000000");
            sendButton.setTextFill(Color.WHITE);
            searchButton.setStyle("-fx-border-color: #ffffff");
            searchButton.setStyle("-fx-background-color: #000000");
            searchButton.setTextFill(Color.WHITE);
            erfSendButton.setStyle("-fx-border-color: #ffffff");
            erfSendButton.setStyle("-fx-background-color: #000000");
            erfSendButton.setTextFill(Color.WHITE);
            erfExitButton.setStyle("-fx-border-color: #ffffff");
            erfExitButton.setStyle("-fx-background-color: #000000");
            erfExitButton.setTextFill(Color.WHITE);
            newGroupButton.setStyle("-fx-border-color: #ffffff");
            newGroupButton.setStyle("-fx-background-color: #000000");
            newGroupButton.setTextFill(Color.WHITE);
            showGroupUserButton.setStyle("-fx-border-color: #ffffff");
            showGroupUserButton.setStyle("-fx-background-color: #000000");
            showGroupUserButton.setTextFill(Color.WHITE);
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
            sendButton.setStyle("-fx-border-color: #ffffff");
            sendButton.setStyle("-fx-background-color: #0d0084");
            sendButton.setTextFill(Color.WHITE);
            searchButton.setStyle("-fx-border-color: #ffffff");
            searchButton.setStyle("-fx-background-color: #0d0084");
            searchButton.setTextFill(Color.WHITE);
            erfSendButton.setStyle("-fx-border-color: #ffffff");
            erfSendButton.setStyle("-fx-background-color: #0d0084");
            erfSendButton.setTextFill(Color.WHITE);
            erfExitButton.setStyle("-fx-border-color: #ffffff");
            erfExitButton.setStyle("-fx-background-color: #0d0084");
            erfExitButton.setTextFill(Color.WHITE);
            newGroupButton.setStyle("-fx-border-color: #ffffff");
            newGroupButton.setStyle("-fx-background-color: #0d0084");
            newGroupButton.setTextFill(Color.WHITE);
            showGroupUserButton.setStyle("-fx-border-color: #ffffff");
            showGroupUserButton.setStyle("-fx-background-color: #0d0084");
            showGroupUserButton.setTextFill(Color.WHITE);
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
            sendButton.setStyle("-fx-border-color: #ffffff");
            sendButton.setStyle("-fx-background-color: #00ffc2");
            sendButton.setTextFill(Color.BLACK);
            searchButton.setStyle("-fx-border-color: #ffffff");
            searchButton.setStyle("-fx-background-color: #00ffc2");
            searchButton.setTextFill(Color.BLACK);
            erfSendButton.setStyle("-fx-border-color: #ffffff");
            erfSendButton.setStyle("-fx-background-color: #00ffc2");
            erfSendButton.setTextFill(Color.BLACK);
            erfExitButton.setStyle("-fx-border-color: #ffffff");
            erfExitButton.setStyle("-fx-background-color: #00ffc2");
            erfExitButton.setTextFill(Color.BLACK);
            newGroupButton.setStyle("-fx-border-color: #ffffff");
            newGroupButton.setStyle("-fx-background-color: #00ffc2");
            newGroupButton.setTextFill(Color.BLACK);
            showGroupUserButton.setStyle("-fx-border-color: #ffffff");
            showGroupUserButton.setStyle("-fx-background-color: #00ffc2");
            showGroupUserButton.setTextFill(Color.BLACK);
            myPane.setStyle("-fx-background-color: #ffffff");
        }

        for (int i=0; i<loginUser.groups.size(); i++) {
            groupListView.getItems().add(loginUser.groups.get(i).name);
        }

    }

    public void myPageTab() {
        reset();
        Main.changeSceneToMyPageTab();
    }

    public void logout() {
        reset();
        Main.changeSceneToHelloController();

    }

    public void searchContact() {
        String search = userSearchTextField.getText();
        ArrayList<String> users = new ArrayList<>();
        for (int i = 0; i < User.users.size(); i++) {
            if ((User.users.get(i).username.contains(search)) && (!User.users.get(i).username.equals(loginUser.username)))
                users.add(User.users.get(i).username);
        }
        contactsListView.setItems(FXCollections.observableList(users));

        ArrayList<String> erf = new ArrayList<>();
        erf.add("Edit");
        erf.add("Reply");
        erf.add("Forward");
        erfListView.setItems(FXCollections.observableList(erf));
    }

    public void chat() {
        flag = false;
        boolean exist = false;
        String contactUsername = contactsListView.getSelectionModel().getSelectedItem();
        for (int i = 0; i < (loginUser.chats.size()) && (!exist); i++) {
            if (loginUser.chats.get(i).contactUsername.equals(contactUsername)) {
                exist = true;
                index1 = i;
            }
        }
        System.out.println(exist);
        if (!exist) {
            Chat new_chat = new Chat();
            new_chat.contactUsername = contactUsername;
            loginUser.chats.add(new_chat);
            index1 = loginUser.chats.size() - 1;
            for (int i = 0; i < User.users.size(); i++) {
                if (User.users.get(i).username.equals(contactUsername)) {
                    selectedUser = User.users.get(i);
                    Chat new_chat2 = new Chat();
                    new_chat2.contactUsername = loginUser.username;
                    selectedUser.chats.add(new_chat2);
                    index2 = selectedUser.chats.size() - 1;
                }
            }
        } else {
            for (int i = 0; i < User.users.size(); i++) {
                if (User.users.get(i).username.equals(contactUsername)) {
                    selectedUser = User.users.get(i);
                    for (int j = 0; j < selectedUser.chats.size(); j++) {
                        if (selectedUser.chats.get(j).contactUsername.equals(loginUser.username)) {
                            index2 = j;
                            System.out.println("SS");
                        }
                    }
                }
            }
        }
        chatListView.setItems(FXCollections.observableList(loginUser.chats.get(index1).chat));
    }

    public void sendChat() {
        if (flag){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            LocalDateTime now = LocalDateTime.now();
            String date=dtf.format(now);
            for (int i=0 ;i<loginUser.groups.size(); i++) {
                if (loginUser.groups.get(i).name.equals(groupListView.getSelectionModel().getSelectedItem())) {
                    String chat = "["+loginUser.username+"]"+chatTextField.getText()+"        "+date;
                    loginUser.groups.get(i).chat.add(chat);
                    chatListView.getItems().add(chat);
                    chatListView.getItems().remove(chatListView.getItems().size() - 1);
                }
            }
            chatTextField.clear();
        }
        else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);
            String chat = "[" + loginUser.username + "]" + chatTextField.getText() + "        " + date;
            loginUser.chats.get(index1).chat.add(chat);
            selectedUser.chats.get(index2).chat.add(chat);
            chatListView.getItems().add(chat);
            chatListView.getItems().remove(chatListView.getItems().size() - 1);
            chatTextField.clear();
        }
    }


    public void showerf(MouseEvent mouseEvent) {
        ArrayList<String> erf = new ArrayList<>();
        erf.add("Edit");
        erf.add("Reply");
        erf.add("Forward");
        erfListView.setItems(FXCollections.observableList(erf));
        erfListView.setLayoutX(mouseEvent.getSceneX());
        erfListView.setLayoutY(mouseEvent.getSceneY());
        erfListView.setVisible(true);
    }

    public void erf() {
        String x = erfListView.getSelectionModel().getSelectedItem();
        erfTextField.setVisible(true);
        erfSendButton.setVisible(true);
        erfExitButton.setVisible(true);

        if (x.equals("Edit")){
            erfTextField.setPromptText("Enter your edited massage");
        }

        else if (x.equals("Reply")){
            erfTextField.setPromptText("Enter your reply massage");
        }

        else if (x.equals("Forward")){
            erfTextField.setPromptText("Enter your contact username");
        }

        erfListView.setVisible(false);
    }

    public void erfSend(ActionEvent event) {
        String x = erfListView.getSelectionModel().getSelectedItem();

        if (flag){
            if (x.equals("Edit")) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                LocalDateTime now = LocalDateTime.now();
                String date=dtf.format(now);
                for (int i=0 ;i<loginUser.groups.size(); i++) {
                    if (loginUser.groups.get(i).name.equals(groupListView.getSelectionModel().getSelectedItem())) {
                        int n = chatListView.getSelectionModel().getSelectedIndex();
                        String chat = "[" + loginUser.username + "]" + erfTextField.getText() + "      (edited)" + "        " + date;
                        loginUser.groups.get(i).chat.remove(n);
                        loginUser.groups.get(i).chat.add(n, chat);
                        chatListView.getItems().add(chat);
                        chatListView.getItems().remove(chatListView.getItems().size() - 1);
                    }
                }
                erfTextField.clear();
                erfExit();
            } else if (x.equals("Reply")) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                LocalDateTime now = LocalDateTime.now();
                String date=dtf.format(now);
                for (int i=0 ;i<loginUser.groups.size(); i++) {
                    if (loginUser.groups.get(i).name.equals(groupListView.getSelectionModel().getSelectedItem())) {
                        String chat = "[" + loginUser.username + "] reply to:(" + chatListView.getSelectionModel().getSelectedItem() + ")     " +
                                erfTextField.getText() + "        " + date;
                        loginUser.groups.get(i).chat.add(chat);
                        chatListView.getItems().add(chat);
                        chatListView.getItems().remove(chatListView.getItems().size() - 1);
                    }
                }
                erfTextField.clear();
                erfExit();
            } else if (x.equals("Forward")) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);
                String contactUsername = erfTextField.getText();
                boolean exist = false;
                int index11 = -1;
                int index22 = -1;
                for (int i = 0; i < (loginUser.chats.size()) && (!exist); i++) {
                    if (loginUser.chats.get(i).contactUsername.equals(contactUsername)) {
                        exist = true;
                        index11 = i;
                    }
                }
                System.out.println(exist);
                if (!exist) {
                    Chat new_chat = new Chat();
                    new_chat.contactUsername = contactUsername;
                    loginUser.chats.add(new_chat);
                    index11 = loginUser.chats.size() - 1;
                    for (int i = 0; i < User.users.size(); i++) {
                        if (User.users.get(i).username.equals(contactUsername)) {
                            selectedUser = User.users.get(i);
                            Chat new_chat2 = new Chat();
                            new_chat2.contactUsername = loginUser.username;
                            selectedUser.chats.add(new_chat2);
                            index22 = selectedUser.chats.size() - 1;
                        }
                    }
                } else {
                    for (int i = 0; i < User.users.size(); i++) {
                        if (User.users.get(i).username.equals(contactUsername)) {
                            selectedUser = User.users.get(i);
                            for (int j = 0; j < selectedUser.chats.size(); j++) {
                                if (selectedUser.chats.get(j).contactUsername.equals(loginUser.username)) {
                                    index22 = j;
                                    System.out.println("SS");
                                }
                            }
                        }
                    }
                }

                if (index11 != -1) {
                    String chat = "[" + loginUser.username + "]" + "Forwarded from  " + groupListView.getSelectionModel().getSelectedItem() + "        " + date;
                    loginUser.chats.get(index11).chat.add(chat);
                    selectedUser.chats.get(index22).chat.add(chat);
                }

                erfExit();
            }
        }

        else {
            if (x.equals("Edit")) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);
                int n = chatListView.getSelectionModel().getSelectedIndex();
                String chat = "[" + loginUser.username + "]" + erfTextField.getText() + "      (edited)" + "        " + date;
                loginUser.chats.get(index1).chat.remove(n);
                loginUser.chats.get(index1).chat.add(n, chat);
                selectedUser.chats.get(index2).chat.remove(n);
                selectedUser.chats.get(index2).chat.add(n, chat);
                chatListView.setItems(FXCollections.observableList(loginUser.chats.get(index1).chat));
                erfTextField.clear();
                erfExit();
            } else if (x.equals("Reply")) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);
                String chat = "[" + loginUser.username + "] reply to:(" + chatListView.getSelectionModel().getSelectedItem() + ")     " +
                        erfTextField.getText() + "        " + date;
                loginUser.chats.get(index1).chat.add(chat);
                selectedUser.chats.get(index2).chat.add(chat);
                chatListView.getItems().add(chat);
                chatListView.getItems().remove(chatListView.getItems().size() - 1);
                erfTextField.clear();
                erfExit();
            } else if (x.equals("Forward")) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                LocalDateTime now = LocalDateTime.now();
                String date = dtf.format(now);
                String contactUsername = erfTextField.getText();
                boolean exist = false;
                int index11 = -1;
                int index22 = -1;
                for (int i = 0; i < (loginUser.chats.size()) && (!exist); i++) {
                    if (loginUser.chats.get(i).contactUsername.equals(contactUsername)) {
                        exist = true;
                        index11 = i;
                    }
                }
                System.out.println(exist);
                if (!exist) {
                    Chat new_chat = new Chat();
                    new_chat.contactUsername = contactUsername;
                    loginUser.chats.add(new_chat);
                    index11 = loginUser.chats.size() - 1;
                    for (int i = 0; i < User.users.size(); i++) {
                        if (User.users.get(i).username.equals(contactUsername)) {
                            selectedUser = User.users.get(i);
                            Chat new_chat2 = new Chat();
                            new_chat2.contactUsername = loginUser.username;
                            selectedUser.chats.add(new_chat2);
                            index22 = selectedUser.chats.size() - 1;
                        }
                    }
                } else {
                    for (int i = 0; i < User.users.size(); i++) {
                        if (User.users.get(i).username.equals(contactUsername)) {
                            selectedUser = User.users.get(i);
                            for (int j = 0; j < selectedUser.chats.size(); j++) {
                                if (selectedUser.chats.get(j).contactUsername.equals(loginUser.username)) {
                                    index22 = j;
                                    System.out.println("SS");
                                }
                            }
                        }
                    }
                }

                if (index11 != -1) {
                    String chat = "[" + loginUser.username + "]" + "Forwarded from  " + chatListView.getSelectionModel().getSelectedItem() + "        " + date;
                    loginUser.chats.get(index11).chat.add(chat);
                    selectedUser.chats.get(index22).chat.add(chat);
                }

                erfExit();
            }
        }


    }

    public void erfExit() {
        erfExitButton.setVisible(false);
        erfSendButton.setVisible(false);
        erfTextField.setVisible(false);
        erfTextField.clear();
    }
    public void mouseHand(MouseEvent mouseEvent) {
        scene.setCursor(Cursor.HAND);
    }

    public void mouseDefault(MouseEvent mouseEvent) {
        scene.setCursor(Cursor.DEFAULT);
    }

    public void groupChat(MouseEvent mouseEvent) {
        flag=true;
        for (int i=0 ;i<loginUser.groups.size(); i++) {
            if (loginUser.groups.get(i).name.equals(groupListView.getSelectionModel().getSelectedItem())) {
                chatListView.setItems(FXCollections.observableList(loginUser.groups.get(i).chat));
            }
        }
    }

    public void newgroup(ActionEvent event) {
        groupRect.setVisible(true);
        groupNameTextField.setVisible(true);
        groupUsernameTextField.setVisible(true);
        addUserButton.setVisible(true);
        doneGroupButton.setVisible(true);
        Group new_group = new Group();
        loginUser.groups.add(new_group);
    }

    public void makeGroup(ActionEvent event) {
        loginUser.groups.get(loginUser.groups.size()-1).name = groupNameTextField.getText();
        groupRect.setVisible(false);
        groupNameTextField.setVisible(false);
        groupUsernameTextField.setVisible(false);
        addUserButton.setVisible(false);
        doneGroupButton.setVisible(false);
        groupListView.getItems().add(groupNameTextField.getText());
        groupNameTextField.clear();
    }

    public void addUser(ActionEvent event) {
        loginUser.groups.get(loginUser.groups.size()-1).username.add(groupUsernameTextField.getText());
        for (int i=0 ;i<User.users.size(); i++){
            if (User.users.get(i).username.equals(groupUsernameTextField.getText())){
                User.users.get(i).groups.add(loginUser.groups.get(loginUser.groups.size()-1));
            }
        }
        groupUsernameTextField.clear();
    }

    public void showUsers(ActionEvent event) {
        groupUsersListView.setVisible(true);
        exitFromGroupUsersButton.setVisible(true);
        for (int i=0 ;i<loginUser.groups.size(); i++) {
            if (loginUser.groups.get(i).name.equals(groupListView.getSelectionModel().getSelectedItem())) {
                groupUsersListView.setItems(FXCollections.observableList(loginUser.groups.get(i).username));
            }
        }
    }

    public void exitFromGroupUsers(ActionEvent event) {
        groupUsersListView.setVisible(false);
        exitFromGroupUsersButton.setVisible(false);
    }
}
