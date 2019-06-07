package controller;

import run4food.Dishes;
import run4food.MenuCard;
import run4food.Shoppingcart;
import run4food.User;

import java.util.ArrayList;

public class OrderController {

    private MenuCard menuCard;
    private Shoppingcart shoppingcart;
    ArrayList<Dishes> dishes;
    MasterController masterController;


    // 1: Lactose
    // 2: Vegetarisch
    // 3: Gluten
    // 4: Vegan
    // 5: Weizen

    public OrderController(MasterController masterController) {
        this.masterController = masterController;
        this.shoppingcart = new Shoppingcart();
        menuCard = new MenuCard();
        dishes = new ArrayList<>();
        try {
            this.dishes = menuCard.loadCard();
        }catch(Exception e){
            e.printStackTrace();
        }
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

    public void callSetOrder(int index, int quantity){
        this.shoppingcart.setOrder(this.dishes.get(index), quantity);
    }
}
