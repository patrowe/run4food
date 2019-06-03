package controller;

import run4food.Dishes;
import run4food.MenuCard;
import java.util.ArrayList;

public class OrderController {

    private MasterController masterController;
    private MenuCard menuCard;
    ArrayList<Dishes> dishes;

    public OrderController(MasterController masterController){
        this.masterController = masterController;
        menuCard = new MenuCard();
        dishes = this.loadDishes();
    }


    public String getUserId(){
        //mainMenu.getUserId;
        return "";
    }

    private ArrayList<Dishes> loadDishes(){
        try {
            return menuCard.loadCard();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
/**
    public ArrayList<String> loadDishNames(){
        ArrayList<String> dishNames = new ArrayList<>();
        for(Dishes dish : dishes){
            dishNames.add(dish.getName);
        }
        return dishNames;
    }

    public ArrayList<String> loadDishCategories(){
        ArrayList<String> dishCategories = new ArrayList<>();
        for(Dishes dish : dishes){
            dishCategories.add(dish.getCategorie);
        }
        return dishCategories;
    }

    public ArrayList<String> loadDishCalories(){
        ArrayList<String> dishCalories = new ArrayList<>();
        for(Dishes dish : dishes){
            dishCalories.add(dish.getCal);
        }
        return dishCalories;
    }
    public ArrayList<String> loadDishPrices(){
        ArrayList<String> dishPrices = new ArrayList<>();
        for(Dishes dish : dishes){
            dishPrices.add(dish.getPrice);
        }
        return dishPrices;
    }
 */
}
