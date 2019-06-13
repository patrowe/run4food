package controller;

import run4food.Dishes;
import run4food.MenuCard;
import run4food.Shoppingcart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class OrderController {

    private MenuCard menuCard;
    private Shoppingcart shoppingcart;
    private ArrayList<Dishes> dishes;
    private HashMap<Dishes, Integer> actualShoppingCart;
    private MasterController masterController;
    private int freeCalories;
    private int availableCalories;

    OrderController(MasterController masterController) {
        this.masterController = masterController;
        this.shoppingcart = new Shoppingcart();
        this.menuCard = new MenuCard();
        this.dishes = new ArrayList<>();
        this.actualShoppingCart = new HashMap<>();
        try {
            this.dishes = menuCard.loadCard();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // 1: Lactose
    // 2: Vegetarisch
    // 3: Gluten
    // 4: Vegan
    // 5: Weizen

    public void setFreeCalories(int calories){
        this.freeCalories = calories;
    }

    public int getFreeCalories() {
        return freeCalories;
    }

    public void setAvailableCalories(int calories) {
        this.availableCalories = calories;
    }

    public int getAvailableCalories() {
        return availableCalories;
    }

    public void deleteShoppingCart(){
        this.shoppingcart = null;
        shoppingcart = new Shoppingcart();
        this.actualShoppingCart = null;
    }

    /**
     * Holt die Unverträglichkeiten aus dem aktuellen User und übergibt sie der Klasse MenuCard. Im Gegenzug bekommt
     * die Methode eine gefilterte Liste aller Dishes.
     */
    public void loadDishes(){
        ArrayList<Integer> numbers = new ArrayList<>();
            for(String s : this.masterController.getUser().getIncompatibilities()){
                if(s.equals("Laktose")){
                    numbers.add(1);
                }
                if(s.equals("Gluten")){
                    numbers.add(3);
                }
                if(s.equals("Weizen")){
                    numbers.add(5);
                }
            }
            String preferedFood = this.masterController.getUser().getPreferedFood();
            if(preferedFood.equals("Vegetarisch")){
                numbers.add(2);
            }else if(preferedFood.equals("Vegan")){
                numbers.add(4);
            }
            try {
                System.out.println("Hier");
                this.dishes = menuCard.filterCard(numbers);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    /**
     * @return: Eine Liste der Namen aller Dishes in der Speisekarte.
     */
    public ArrayList<String> loadDishNames(){
        ArrayList<String> dishNames = new ArrayList<>();
        for(Dishes dish : this.dishes){
            dishNames.add(dish.getName());
        }
        return dishNames;
    }
/**
    public ArrayList<String> loadDishCategories(){
        ArrayList<String> dishCategories = new ArrayList<>();
        for(Dishes dish : dishes){
            dishCategories.add(dish.getCategorie());
        }
        return dishCategories;
    }
*/

    /**
     * @return: Eine Liste der Kalorien aller Dishes in der Speisekarte.
     */
    public ArrayList<String> loadDishCalories(){
        ArrayList<String> dishCalories = new ArrayList<>();
        for(Dishes dish : this.dishes){
            dishCalories.add(Integer.toString(dish.getCal()));
        }
        return dishCalories;
    }

    /**
     * @return: Eine Liste der Preise aller Dishes in der Speisekarte.
     */
    public ArrayList<String> loadDishPrices(){
        ArrayList<String> dishPrices = new ArrayList<>();
        for(Dishes dish : this.dishes){
            dishPrices.add(Double.toString(dish.getPrice()));
        }
        return dishPrices;
    }

    public ArrayList<Boolean> loadDishAvailability(){
        ArrayList<Boolean> dishAvailability = new ArrayList<>();
        for(Dishes dish : this.dishes){
            if(dish.getCal() < availableCalories){
                dishAvailability.add(true);
            }else{
                dishAvailability.add(false);
            }

        }
        return dishAvailability;
    }

    /**
     * Diese Methode übergibt die aktuelle Speisekarte an ein Objekt der Klasse MenuCard und lässt diese nach Namen sortieren.
     */
    public void SortByName(){
        try {
            this.dishes = menuCard.sortCard(this.dishes, 3);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Diese Methode übergibt die aktuelle Speisekarte an ein Objekt der Klasse MenuCard und lässt diese nach Kalorien sortieren.
     */
    public void SortByCalories(){
        try {
            this.dishes = menuCard.sortCard(this.dishes, 2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Diese Methode übergibt die aktuelle Speisekarte an ein Objekt der Klasse MenuCard und lässt diese nach Preisen sortieren.
     */
    public void SortByPrice(){
        try {
            this.dishes = menuCard.sortCard(this.dishes, 1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param name: Das ist der Name des Dish, das dem Warenkorb hinzugefügt werden soll
     * @param quantity: Das ist die Anzahl des Dish, das dem Warenkorb hinzugefügt werden soll
     */
    public void callChangeCart(String name, int quantity){
        Dishes dish;
        for(int i = 0; i < this.dishes.size(); i++){
            if(this.dishes.get(i).getName().equals(name)){
                dish = this.dishes.get(i);
                this.shoppingcart.changeCart(dish, quantity);
                this.actualShoppingCart = this.shoppingcart.getOrder();
                if(this.masterController.getUser() != null) {
                    this.setAvailableCalories((this.getFreeCalories() - this.shoppingcart.getCalCount()));
                }
                break;
            }
        }

    }

    /**
     * @return: Eine Liste der Namen aller Dishes im Warenkorb.
     */
    public ArrayList<String> getNameList() {
        Iterator iterator = this.actualShoppingCart.keySet().iterator();
        ArrayList<String> nameList = new ArrayList<>();
        while(iterator.hasNext()){
            nameList.add(((Dishes)iterator.next()).getName());
        }
        return nameList;
    }

    /**
     * @return: Eine Liste der Preise aller Dishes im Warenkorb.
     */
    public ArrayList<String> getPriceList() {
        Iterator iterator = this.actualShoppingCart.keySet().iterator();
        ArrayList<String> priceList = new ArrayList<>();
        while(iterator.hasNext()){
            priceList.add(String.valueOf(((Dishes)iterator.next()).getPrice()));
        }
        return priceList;
    }

    /**
     * @return: Eine Liste der Anzahlen aller Dishes im Warenkorb.
     */
    public ArrayList<Integer> getQuantityList() {
        Iterator iterator = this.actualShoppingCart.values().iterator();
        ArrayList<Integer> quantityList = new ArrayList<>();
        while(iterator.hasNext()){
            quantityList.add((Integer)iterator.next());
        }
        return quantityList;
    }
}
