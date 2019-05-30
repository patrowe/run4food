package controller;

import run4food.DailyRoutine;

public class DailyRoutineController {

    private double basalMetabolism;

    public String getNickname(MasterController masterController){
        return masterController.getNickname();
    }

    public double callBasalMetabolism(int age, double weight, double height, String gender){
        //basalMetabolism = dailyRoutine.basalMetabolism(age, weight, height, gender);
        return basalMetabolism;
    }

    public void callCalculateSteps(int steps, MasterController masterController){
        DailyRoutine dailyRoutine = new DailyRoutine(masterController.user);
        dailyRoutine.calculateSteps(steps);
    }

    public void callCalculateActivity(String activity, int durationHours, int durationMintues){
        //dailyRoutine.calculateActivity(activity, durationHours, durationMintues);
    }

    public String getFreeCalories(MasterController mastercontroller){
        DailyRoutine dailyRoutine = new DailyRoutine(mastercontroller.user);
        //String freeCalories;
        //freeCalories = dailyRoutine.getFreeCalories();
        //return freeCalories;
        return "";
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


}

