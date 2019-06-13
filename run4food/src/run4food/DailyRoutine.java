	package run4food;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;


/**
 * @author pamela
 *
 */
public class DailyRoutine {
    // aktualisiert 13.6.2019
    //getter für earnedCalorie, consumedCalorie, freeCalorie
	
	
	

    private User activeUser;
    private RegisteredUser regUser;
    private TreeMap<String, Integer[]> activeDiary;

    private Calculator calc = new Calculator();

    private int earnedCalorie, consumedCalorie, freeCalorie;
    private String today;
    public Integer[] diaryEntry;


    /**
     * @param activeUser 
     * 
     * Konstruktor testet, ob der User ein registeredUser ist, falls ja wird das Diary geladen 
     * und ein Eintrag für den heutigen Tag erstellt
     */
    public DailyRoutine(User activeUser){
       

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

    
    /**
     * @param steps die Schrittzahl die der Nutzer eingibt
     * 
     * Die Schritte werden in kcal umgerechnet und der Wert für earnedCalorie aktualisiert
     */
    public void calculateSteps(int steps) {
        earnedCalorie+=calc.steps2calory(steps);
        
    }

    //hier müssen die Nutzereingaben übergeben werden.
    
    /**
     * @param activity - die Sportart
     * @param duration - die Dauer der Tätigkiet
     * 
     * Der Wert earnedCalorie wird entspechend geändert
     * 
     */
    public void calculateActivity(String activity, double duration) {
        earnedCalorie+=calc.activity2calory(activity, duration, this.activeUser.getWeight());
    }

    public int getEarnedCalorie() {

        return earnedCalorie;
    }

    //hier müssen die Nutzereingaben übergeben werden.
    
    /**
     * @param food
     * @param quantaty
     * 
     * Der Wert für consumedCalorie wird aktualisiert
     */
    public void calculateConsumption(String food, double quantaty) {
        consumedCalorie+=calc.food2calory(food, quantaty);
    }

    
    /**
     * @param cal
     * 
     * hier werden die Kalorien, die der Nutzer direkt eingibt zu consumedCalorie dazu addiert
     */
    public void calculateOwnCalorie(int cal) {
        consumedCalorie+=cal;
    }

    public int getConsumedCalorie() {
        return consumedCalorie;
    }

    
    /**
     * die freien Kalorien werden berechnet und unter freeCalorie gespeichert
     */
    public void calculateFreeCalorie() {
        freeCalorie = this.activeUser.getBasalMetabolism() + earnedCalorie - consumedCalorie;
    }

    public int getFreeCalorie() {
        return freeCalorie;
    }



    /**
     * @param age
     * @param weight
     * @param height
     * @param gender
     * @return der Grundumsatz wird zurück gegeben
     * 
     * Die Berechnung für den Grundumsatz wird im Calculator aufgerufen.
     * 
     */
    public int basalMetabolism(int age, int weight, int height, String gender) {

        return calc.basalMetabolism(age, weight, height, gender);

    }

    /**
     * Der Tagebucheintrag für den heutigen Tag wird erstellt und auch beim activeUser aktualisert
     * 
     */
    public void updateDiary() {

        if (activeUser instanceof RegisteredUser) {
            //Tagebucheintrag in der Reihenfolge earnedCalorie/consumedCalorie/freeCalorie/Weight/BasalMetabolsim
            diaryEntry[0]=(int)earnedCalorie;
            diaryEntry[1]=(int)consumedCalorie;
            diaryEntry[2]=(int)freeCalorie;
            diaryEntry[3]=(int)activeUser.getWeight();
            diaryEntry[4]=(int)activeUser.getBasalMetabolism();
           
            ((RegisteredUser) activeUser).setDiary(today, diaryEntry);
        }
    }

}