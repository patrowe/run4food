package controller;

import run4food.DailyRoutine;
import run4food.RegisteredUser;

import java.util.Hashtable;

public class DailyRoutineController {

    private DailyRoutine dailyRoutine;
    private MasterController masterController;

    public DailyRoutineController(MasterController masterController){
        this.masterController = masterController;
    }

    public void createDailyRoutine(){
        this.dailyRoutine = new DailyRoutine(this.masterController.getUser());
    }

    public void callCalculateSteps(int steps){
        this.dailyRoutine.calculateSteps(steps);
    }

    public void callCalculateActivity(String activity, int durationHours, int durationMintues){
        double a = (durationHours + (durationMintues/60));
        this.dailyRoutine.calculateActivity(activity, a);
    }

    public void callCalculateEatenCalories(String food, int quantity){
        this.dailyRoutine.calculateConsumption(food, quantity);
        this.dailyRoutine.calculateFreeCalorie();
    }

    public void callCalculateOwnCalories(int ownCalories){
        this.dailyRoutine.calculateOwnCalorie(ownCalories);
    }

    public int getFreeCalories(){
        this.dailyRoutine.calculateFreeCalorie();
        return this.dailyRoutine.getFreeCalorie();
    }

    public void testOneNumber(int a) throws NoSenseException {
        if(a==0){
            throw new NoSenseException("Du musst eine Zahl über Null eingeben, damit die Kalorien berechnet werden");
        }
    }

    public void activityTest(int a, int b) throws NoSenseException{
        System.out.println(""+a+b);
        if((a == 0) & (b == 0)){
            throw new NoSenseException("Das ergibt keinen Sinn.");
        }
    }

    public void callUpdateDiary(){
        dailyRoutine.updateDiary();
        RegisteredUser regUser = (RegisteredUser)this.masterController.getUser();
        Hashtable a = regUser.getDiary();
    }


}

