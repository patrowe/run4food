package run4food;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

public class DailyRoutine {
    // aktualisiert 3.6.2019
    //getter für earnedCalorie, consumedCalorie, freeCalorie

    private User activeUser;
    private RegisteredUser regUser;
    private Hashtable<String, Integer[]> activeDiary;

    private Calculator calc = new Calculator();

    private int earnedCalorie, consumedCalorie, freeCalorie;
    private String today;
    public Integer[] diaryEntry;


    public DailyRoutine(User activeUser){
        // hier muss noch unterschieden werden, ob es ein RegisteredUser ist oder ein User/Gast

        this.activeUser = activeUser;

        if (activeUser instanceof RegisteredUser) {

            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            today = DateFormat.getDateInstance().format(date);

            activeDiary = ((RegisteredUser) activeUser).getDiary();

            if (activeDiary.containsKey(today)) diaryEntry=activeDiary.get(today);
            else diaryEntry = new Integer[5];
        }
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    //hier müssen die Nutzereingaben übergeben werden.
    public void calculateSteps(int steps) {
        earnedCalorie+=calc.steps2calory(steps);
    }

    //hier müssen die Nutzereingaben übergeben werden.
    public void calculateActivity(String activity, double duration) {
        earnedCalorie+=calc.activity2calory(activity, duration, this.activeUser.getWeight());
    }

    public int getEarnedCalorie() {

        return earnedCalorie;
    }

    //hier müssen die Nutzereingaben übergeben werden.
    public void calculateConsumption(String food, double quantaty) {
        consumedCalorie+=calc.food2calory(food, quantaty);
    }

    //hier müssen die Nutzereingaben übergeben werden.
    public void calculateOwnCalorie(int cal) {
        consumedCalorie+=cal;
    }

    public int getConsumedCalorie() {
        return consumedCalorie;
    }

    //hier werden die noch freien Kalorien für die Bestellung berechnet
    public void calculateFreeCalorie() {
        freeCalorie = this.activeUser.getBasalMetabolism() + earnedCalorie - consumedCalorie;
    }

    public int getFreeCalorie() {
        return freeCalorie;
    }



    public int basalMetabolism(int age, int weight, int height, String gender) {

        return calc.basalMetabolism(age, weight, height, gender);

    }

    public void updateDiary() {

        if (activeUser instanceof RegisteredUser) {
            //Tagebucheintrag in der Reihenfolge earnedCalry/consumedCalory/freeCalory/Weight/BasalMetabolsim
            diaryEntry[0]=(int)earnedCalorie;
            diaryEntry[1]=(int)consumedCalorie;
            diaryEntry[2]=(int)freeCalorie;
            diaryEntry[3]=(int)activeUser.getWeight();
            diaryEntry[4]=(int)activeUser.getBasalMetabolism();
            System.out.println("Hallo");
            System.out.println(diaryEntry[4]);
            ((RegisteredUser) activeUser).setDiary(today, diaryEntry);
        }
    }

}