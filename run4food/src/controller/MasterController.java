package controller;

import run4food.RegisteredUser;
import run4food.User;
import run4food.UserManagement;

public class MasterController {

    private StartController startController;
    private DailyRoutineController dailyRoutineController;
    private OrderController orderController;
    private User user;

    public MasterController(){
        startController = new StartController(this);
        dailyRoutineController = new DailyRoutineController(this);
        orderController = new OrderController(this);
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public String getNickname(){
        RegisteredUser registeredUser = (RegisteredUser)this.user;
        return registeredUser.getUserId();
    }

    public StartController getStartController() {
        return this.startController;
    }

    public DailyRoutineController getDailyRoutineController() {
        return this.dailyRoutineController;
    }

    public OrderController getOrderController() {
        return this.orderController;
    }
}
