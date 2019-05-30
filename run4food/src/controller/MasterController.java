package controller;

import run4food.User;
import run4food.UserManagement;

public class MasterController {

    String nickname;
    UserManagement userManagement;
    User user;

    public void setNickname(String string){
        this.nickname = string;
    }

    public String getNickname(){
        return this.nickname;
    }

    public void setUser(User user){
        this.user = user;
    }

    public MasterController(){
        userManagement = new UserManagement();
    }
}
