package run4food;

import controller.StartController;
import gui.MainMenuScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainMenu {

	
    private StartController startController;
    private UserManagement userManagement;
    private User activeUser;
/*
    public static void main(String[]args){
        MainMenu mainMenu = new MainMenu();
        mainMenu.start();
    }

    public void start(){  
        startController = new StartController();
        startController.createWindow();
    }
*/
    public void setNewRegisteredUser(String nick, String forename, String surname, String street,
            int postcode, String city, int phone, int age, String gender, int height, int weight,
            String preferedFood, ArrayList<String> incompatibilities){
        userManagement = new UserManagement();
        try {
            userManagement.saveUser(new RegisteredUser(nick, surname, forename, street, postcode, city,phone, age, gender,height, weight, preferedFood, incompatibilities));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<RegisteredUser> loadRegisteredUsers(){
        ArrayList<RegisteredUser> registeredUsers = new ArrayList<>();
        userManagement = new UserManagement();
        try {
            registeredUsers = userManagement.loadListe();
        }catch(Exception e){
            e.printStackTrace();
        }
        return registeredUsers;
    }

    public void loadOneUser(String nickname){
        ArrayList<RegisteredUser> registeredUsers = new ArrayList<>();
        try {
            registeredUsers = userManagement.loadListe();
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
        for(RegisteredUser user : registeredUsers){
            if(user.getUserId().equals(nickname)){
                activeUser = user;
            }
        }
        dailyRoutine(activeUser);
    }

    public void dailyRoutine(User activeUser){
    	
    }

    public void order(){

    }

    public void help(){

    }

	//
}
