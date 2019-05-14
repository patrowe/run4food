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

    public void caloriesTest(String s) throws FieldIsEmptyException, NegativeNumberException {
        int i;
        if(s.isEmpty()){
            throw new FieldIsEmptyException("Ausgewählte Felder dürfen nicht leer sein!");
        }
        try {
            i = Integer.parseInt(s);
        }catch(NumberFormatException e) {
            e.getMessage();
            throw new NumberFormatException("Hier dürfen nur Zahlen eingegeben werden!");
        }
        if(i < 1){
            throw new NegativeNumberException("Ungültige Zahl! Es sind nur positive Zahlen über Null erlaubt!");
        }
    }

    public void activityTest(int a, int b) throws NoSenseException{
        System.out.println(a+""+ b);
        if((a == 0) & (b == 0)){
            throw new NoSenseException("Das ergibt keinen Sinn.");
        }
    }


}

