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
    private int availableCalories;

    public OrderController(MasterController masterController) {
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

    public void setAvailableCalories(int calories){
        this.availableCalories = calories;
    }

    public int getAvailableCalories() {
        return availableCalories;
    }

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
    public ArrayList<String> loadDishCalories(){
        ArrayList<String> dishCalories = new ArrayList<>();
        for(Dishes dish : this.dishes){
            dishCalories.add(Integer.toString(dish.getCal()));
        }
        return dishCalories;
    }
    public ArrayList<String> loadDishPrices(){
        ArrayList<String> dishPrices = new ArrayList<>();
        for(Dishes dish : this.dishes){
            dishPrices.add(Double.toString(dish.getPrice()));
        }
        return dishPrices;
    }

    public void SortByName(){
        try {
            this.dishes = menuCard.sortCard(this.dishes, 3);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void SortByCalories(){
        try {
            this.dishes = menuCard.sortCard(this.dishes, 2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void SortByPrice(){
        try {
            this.dishes = menuCard.sortCard(this.dishes, 1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void callChangeCart(int index, int quantity){
        this.shoppingcart.changeCart(this.dishes.get(index), quantity);
        this.actualShoppingCart = this.shoppingcart.getOrder();
        Iterator it = this.actualShoppingCart.keySet().iterator();
    }

    public ArrayList<String> getNameList() {
        Iterator iterator = this.actualShoppingCart.keySet().iterator();
        ArrayList<String> nameList = new ArrayList<>();
        while(iterator.hasNext()){
            nameList.add(((Dishes)iterator.next()).getName());
        }
        return nameList;
    }

    public ArrayList<String> getPriceList() {
        Iterator iterator = this.actualShoppingCart.keySet().iterator();
        ArrayList<String> priceList = new ArrayList<>();
        while(iterator.hasNext()){
            priceList.add(String.valueOf(((Dishes)iterator.next()).getPrice()));
        }
        return priceList;
    }

    public ArrayList<Integer> getQuantityList() {
        Iterator iterator = this.actualShoppingCart.values().iterator();
        ArrayList<Integer> quantityList = new ArrayList<>();
        while(iterator.hasNext()){
            quantityList.add((Integer)iterator.next());
        }
        return quantityList;
    }
}
