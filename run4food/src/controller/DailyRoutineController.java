package controller;


import run4food.DailyRoutine;

public class DailyRoutineController {

    private double basalMetabolism;
    private DailyRoutine dailyRoutine;

    public DailyRoutineController(){
        //dailyRoutine = new DailyRoutine();
    }

    public double callBasalMetabolism(int age, double weight, double height, String gender){
        basalMetabolism = dailyRoutine.basalMetabolism(age, weight, height, gender);
        return basalMetabolism;
    }

    public void callCalculateSteps(int steps){
        dailyRoutine.calculateSteps(steps);
    }

    public void callCalculateActivity(String activity, int durationHours, int durationMintues){
        //dailyRoutine.calculateActivity(activity, durationHours, durationMintues);
    }

    public void testOneNumber(int a) throws NoSenseException {
        if(a==0){
            throw new NoSenseException("Du musst eine Zahl über Null eingeben, damit die Kalorien berechnet werden");
        }

    }

    public void activityTest(int a, int b) throws NoSenseException{
        System.out.println(a+""+ b);
        if((a == 0) & (b == 0)){
            throw new NoSenseException("Das ergibt keinen Sinn.");
        }
    }


}

