package controller;

import run4food.DailyRoutine;
import run4food.RegisteredUser;
import java.util.ArrayList;

public class StartController {

    private ArrayList<RegisteredUser> registeredUsers;
    private ArrayList<String> nickList;
    private MasterController masterController;
    private DailyRoutine dailyRoutine;

    public StartController(MasterController masterController){
        this.masterController = masterController;
    }

    public void callSaveUser(String nick, String forename, String surname, String streetName, int streetNumber,
                             int postcode, String city, int phone, int age, String gender, int height, int weight,
                             String preferedFood, ArrayList<String> incompatibilities){
        String street = streetName+streetNumber;
        try {
            dailyRoutine = new DailyRoutine(masterController.user);
            int basal = (int)dailyRoutine.basalMetabolism(age, weight, (double)height, gender);
            RegisteredUser registeredUser = new RegisteredUser(surname, forename, street, age, weight, height, gender, nick, basal);
            masterController.userManagement.saveUser(registeredUser);
            masterController.setUser(registeredUser);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> loadNicknames(){
        try {
            registeredUsers = masterController.userManagement.loadListe();
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
            return masterController.userManagement.loadListe();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void callLoadOneUser(String nickName){
        registeredUsers = this.loadRegisteredUsers();
        for(RegisteredUser user : registeredUsers){
            if(user.userId.equals(nickName)){
                masterController.setUser(user);
            }
        }
        masterController.nickname = nickName;
    }

}
