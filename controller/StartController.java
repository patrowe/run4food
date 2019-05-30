package controller;

import gui.MainMenuScene;
import gui.MainMenuWindow;
import gui.StandardButton;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import run4food.MainMenu;
import run4food.RegisteredUser;
import run4food.UserManagement;
import java.util.ArrayList;


public class StartController  implements EventHandler {

    private UserManagement userManagement;
    private MainMenu mainMenu;
    private MainMenuScene mainMenuScene;
    private RegisteredUser registeredUser;
    private ArrayList<RegisteredUser> registeredUsers;
    private ArrayList<String> nickList;

    public StartController(){
        mainMenu = new MainMenu();
    }

    public void createWindow(){
        MainMenuWindow.launch();
    }

    public void openMainMenu(){
        mainMenuScene = new MainMenuScene();
        mainMenuScene.setScene();
    }

    public void callSaveUser(String nick, String forename, String surname, String streetName, int streetNumber,
                             int postcode, String city, int phone, int age, String gender, int height, int weight,
                             String preferedFood, ArrayList<String> incompatibilities){
        String street = streetName+streetNumber;
        mainMenu.setNewRegisteredUser(nick, surname, forename, street, postcode, city,phone, age, gender,height, weight, preferedFood, incompatibilities);
    }


    public ArrayList<String> callLoadRegisteredUsers(){
        registeredUsers = new ArrayList<>();
        registeredUsers = mainMenu.loadRegisteredUsers();
        nickList = new ArrayList<>();
        for(RegisteredUser user : registeredUsers){
            nickList.add(user.getUserId());
        }
        return nickList;
    }

    @Override
    public void handle(Event event) {
        StandardButton button = (StandardButton)event.getSource();
        mainMenu.loadOneUser(button.getText());
        event.getSource();
    }

	
}