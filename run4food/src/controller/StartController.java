package controller;

import run4food.RegisteredUser;
import run4food.User;
import run4food.UserManagement;

import java.util.ArrayList;

/**
 * @author Christoph
 * Dies hier ist der Controller, der für den Vorgang bis zur DailyRoutine verantwortlich ist, also bis ein Nutzer sich registriert,
 * eingeloggt oder ein Gast sich angemeldet hat.
 */

public class StartController{

    private ArrayList<RegisteredUser> registeredUsers;
    private ArrayList<String> nickList;
    private MasterController masterController;
    private UserManagement userManagement;

    public StartController(MasterController masterController){
        this.masterController = masterController;
        this.userManagement = new UserManagement();
    }

    /**
     * Ein registeredUser wird erstellt und an das userManagement weitergegeben, wo er dann gespeichert wird. Außerdem wird
     * der User beim masterController als aktiver Nutzer gespeichert.
     */
    public void callSaveUser(String nick, String forename, String surname, String streetName, int streetNumber,
                             int postcode, String city, int phone, int age, String gender, int height, int weight,
                             String preferedFood, ArrayList<String> incompatibilities){
        try {
            RegisteredUser registeredUser = new RegisteredUser(nick, surname, forename, streetName, streetNumber,
                    postcode, city, phone, age, gender, height, weight, preferedFood, incompatibilities);
            this.userManagement.saveUser(registeredUser);
            masterController.setUser(registeredUser);
            this.masterController.getDailyRoutineController().createDailyRoutine();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void saveGuest(String forename, String surname, String street, int streetNumber, int postCode, String city,
                          int phone, int age, String gender, int height, int weight, String preferedFood, ArrayList<String>incompatibilities){
        User user = new User(forename, surname, street, streetNumber, postCode, city, phone, age, gender, height, weight, preferedFood, incompatibilities);
        masterController.setUser(user);
        this.masterController.getDailyRoutineController().createDailyRoutine();
    }

    public ArrayList<String> loadNicknames(){
        try {
            registeredUsers = this.userManagement.loadListe();
        }catch(Exception e){
            e.getMessage();
        }
        nickList = new ArrayList<>();
        for(RegisteredUser user : registeredUsers){
            nickList.add(user.getUserId());
        }
        return nickList;
    }

    private ArrayList<RegisteredUser> loadRegisteredUsers(){
        try {
            return this.userManagement.loadListe();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void callLoadOneUser(String nickName){
        registeredUsers = this.loadRegisteredUsers();
        for(RegisteredUser user : registeredUsers){
            if(user.userId.equals(nickName)){
                this.masterController.setUser(user);
                this.masterController.getDailyRoutineController().createDailyRoutine();
            }
        }
    }

    public void callDeleteUser(){
        try {
            this.userManagement.deleteUser(((RegisteredUser) (this.masterController.getUser())).getUserId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
