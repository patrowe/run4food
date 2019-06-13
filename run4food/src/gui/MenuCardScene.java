package gui;

import controller.MasterController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Christoph Klassen
 */
public class MenuCardScene extends StandardScene{

    //Attribute für die Menüliste

    private BorderPane borderPane;
    private ScrollPane scrollPane;
    private HBox informationHBox, nameAndFilterHBox, menuCardHBox, navigationHBox;
    private VBox sceneContent, nameVBox, caloriesVBox, priceVBox, quantityVBox;
    private Button sortName, sortPrice, sortCalories, addToCart, backToMenu, goBackToDaily, goToShoppingCart;
    private Label heading, freeCalories, shoppingCartLabel;
    private ArrayList<String> dishNames, dishCalories, dishPrices;
    private MasterController masterController;
    private StandardScene standardScene;
    private boolean somebodyIsLoggedIn;

    //Attribute für die Warenkorb-Vorschau

    private HBox labelHBox, contentHBox;
    private VBox shoppingCartVBox, nameListVBox, quantityListVBox, priceListVBox;
    private Button changeCartButton;

    public void setScene(StandardScene standardScene, MasterController masterController){

        this.masterController = masterController;
        this.standardScene = standardScene;
        if(this.masterController.getUser() == null){
            this.somebodyIsLoggedIn = false;
        }else{
            this.somebodyIsLoggedIn = true;
        }

        heading = new Label("Dash Board");
        heading.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        heading.setMinHeight(100);
        heading.setPadding(new Insets(10));

        if(somebodyIsLoggedIn) {
            freeCalories = new Label("Verfügbare Kalorien: " + this.masterController.getOrderController().getAvailableCalories());

            informationHBox = new HBox();
            informationHBox.getChildren().add(freeCalories);
        }

        /*
        nameLabel = new Label("Name des Gerichts");
        nameLabel.setAlignment(Pos.CENTER_RIGHT);
        nameLabel.setFont(Font.font("Calibri", FontWeight.BOLD,16));
        nameLabel.setMinHeight(30);
        nameLabel.setMinWidth(120);

        caloriesLabel = new Label("Kalorien");
        caloriesLabel.setAlignment(Pos.CENTER_RIGHT);
        caloriesLabel.setFont(Font.font("Calibri", FontWeight.BOLD,16));
        caloriesLabel.setMinHeight(30);
        caloriesLabel.setMinWidth(120);

        priceLabel = new Label("Preis");
        priceLabel.setAlignment(Pos.CENTER_RIGHT);
        priceLabel.setFont(Font.font("Calibri", FontWeight.BOLD,16));
        priceLabel.setMinHeight(30);
        priceLabel.setMinWidth(120);
         */

        sortName = new Button("Gericht");
        sortName.setMinHeight(30);
        sortName.setMinWidth(250);
        sortPrice = new Button("Preis");
        sortPrice.setMinHeight(30);
        sortPrice.setMinWidth(250);
        sortCalories = new Button("Kalorien");
        sortCalories.setMinHeight(30);
        sortCalories.setMinWidth(250);

        nameAndFilterHBox = new HBox();
        nameAndFilterHBox.setAlignment(Pos.CENTER_LEFT);
        nameAndFilterHBox.setSpacing(10);
        nameAndFilterHBox.getChildren().addAll(sortName, sortCalories, sortPrice);

        nameVBox = new VBox();
        nameVBox.setSpacing(5);
        caloriesVBox = new VBox();
        caloriesVBox.setSpacing(5);
        priceVBox = new VBox();
        priceVBox.setSpacing(5);
        quantityVBox = new VBox();
        quantityVBox.setSpacing(5);

        menuCardHBox = new HBox();
        menuCardHBox.setAlignment(Pos.CENTER_LEFT);
        menuCardHBox.setFillHeight(true);
        menuCardHBox.setSpacing(10);
        menuCardHBox.getChildren().addAll(nameVBox, caloriesVBox, priceVBox, quantityVBox);

        if(somebodyIsLoggedIn) {
            this.updateMenuCardForLoggedIn();
        }else{
            this.updateMenuCardForNotLoggedIn();
        }

        scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPannable(true);
        scrollPane.setContent(menuCardHBox);

        addToCart = new Button("Zum Warenkorb hinzufügen");

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setFillWidth(true);
        vBox.getChildren().addAll(nameAndFilterHBox, scrollPane, addToCart);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setFillHeight(true);
        hBox.getChildren().add(vBox);

        sceneContent = new VBox();
        sceneContent.setSpacing(10);
        sceneContent.setFillWidth(true);

        if(somebodyIsLoggedIn) {
            sceneContent.getChildren().addAll(informationHBox, hBox);
        }else{
            sceneContent.getChildren().addAll(hBox);
        }

        //Hier kommt der Teil für die Warenkorb-Vorschau

        labelHBox = new HBox();

        nameListVBox = new VBox();
        nameListVBox.setSpacing(5);
        quantityListVBox = new VBox();
        quantityListVBox.setSpacing(5);
        priceListVBox = new VBox();
        priceListVBox.setSpacing(5);

        contentHBox = new HBox();
        contentHBox.getChildren().addAll(nameListVBox, quantityListVBox, priceListVBox);

        shoppingCartLabel = new Label("Vorschau:");
        shoppingCartLabel.setAlignment(Pos.CENTER);
        shoppingCartLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 18));

        changeCartButton = new Button("Ändern");
        changeCartButton.setVisible(false);

        shoppingCartVBox = new VBox();
        shoppingCartVBox.setMinWidth(250);
        shoppingCartVBox.getChildren().addAll(shoppingCartLabel, labelHBox, contentHBox, changeCartButton);

        //Hier werden die Buttons für die Navigation erstellt

        goToShoppingCart = new NavigationButton("Weiter zum Warenkorb");
        goBackToDaily = new NavigationButton("Zurück zum Dash Board");
        backToMenu = new NavigationButton("Zurück zum Hauptmenü");

        navigationHBox = new HBox();
        navigationHBox.setAlignment(Pos.CENTER);
        navigationHBox.setSpacing(10);
        navigationHBox.setMinHeight(75);

        if(somebodyIsLoggedIn){
            navigationHBox.getChildren().addAll(goBackToDaily, goToShoppingCart);
        }else{
            navigationHBox.getChildren().addAll(backToMenu, goToShoppingCart);
        }


        borderPane = new BorderPane();
        borderPane.setTop(heading);
        borderPane.setCenter(sceneContent);
        borderPane.setRight(shoppingCartVBox);
        borderPane.setBottom(navigationHBox);

        standardScene.setSceneContent(borderPane);

        //
        //Action Listener für die Buttons
        //

        sortName.setOnAction(actionEvent -> {
            this.masterController.getOrderController().SortByName();
            this.updateMenuCardForLoggedIn();
        });

        sortCalories.setOnAction(actionEvent -> {
            this.masterController.getOrderController().SortByCalories();
            this.updateMenuCardForLoggedIn();
        });

        sortPrice.setOnAction(actionEvent -> {
            this.masterController.getOrderController().SortByPrice();
            this.updateMenuCardForLoggedIn();
        });

        goBackToDaily.setOnAction(actionEvent -> {
            this.masterController.getOrderController().deleteShoppingCart();
            DailyRoutineScene dailyRoutineScene = new DailyRoutineScene();
            dailyRoutineScene.setScene(this.standardScene, this.masterController);
        });

        backToMenu.setOnAction(actionEvent -> {
            MainMenuScene mainMenuScene = new MainMenuScene();
            mainMenuScene.setScene(this.standardScene, this.masterController);
        });

        goToShoppingCart.setOnAction(actionEvent -> {

        });

        addToCart.setOnAction(actionEvent -> {
            Iterator it1 = quantityVBox.getChildren().iterator();
            Iterator it2 = nameVBox.getChildren().iterator();

            ArrayList<String> quantityList = new ArrayList<>();
            ArrayList<String> nameList = new ArrayList<>();

            while(it1.hasNext()){
                quantityList.add(((OrderTextfield)it1.next()).getText());
                nameList.add(((DishLabel)it2.next()).getText());
            }
            for(int i = 0; i < quantityList.size(); i++) {
                if (!(quantityList.get(i).equals(""))){
                    try {
                        int quantity = Integer.parseInt(quantityList.get(i));
                        this.masterController.getOrderController().callChangeCart(nameList.get(i), quantity);
                        freeCalories.setText("Verfügbare Kalorien: " + this.masterController.getOrderController().getAvailableCalories());
                    }catch(NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }
            this.updateLocalShoppingCart();
            if(somebodyIsLoggedIn){
                this.updateMenuCardForLoggedIn();
            }else{
                this.updateMenuCardForNotLoggedIn();
            }
        });

        changeCartButton.setOnAction(actionEvent -> {
            Iterator it1 = quantityListVBox.getChildren().iterator();
            Iterator it2 = nameListVBox.getChildren().iterator();

            ArrayList<String> quantityList = new ArrayList<>();
            ArrayList<String> nameList = new ArrayList<>();
            while(it1.hasNext()){
                quantityList.add(((OrderTextfield)it1.next()).getText());
                nameList.add(((PreviewLabel)it2.next()).getText());
            }
            for(int i = 0; i < quantityList.size(); i++) {
                if (!(quantityList.get(i).equals(""))){
                    try {
                        int quantity = Integer.parseInt(quantityList.get(i));
                        this.masterController.getOrderController().callChangeCart(nameList.get(i), quantity);
                        freeCalories.setText("Verfügbare Kalorien: " + this.masterController.getOrderController().getAvailableCalories());
                    }catch(NumberFormatException e){
                        e.printStackTrace();
                    }
                }
            }
            this.updateLocalShoppingCart();
            if(somebodyIsLoggedIn){
                this.updateMenuCardForLoggedIn();
            }else{
                this.updateMenuCardForNotLoggedIn();
            }
        });
    }

    /**
     * Die Methode erneuert die Menükarte mit der jeweils aktuellen Liste an Dishes
     */
    private void updateMenuCardForNotLoggedIn(){
        dishNames = this.masterController.getOrderController().loadDishNames();
        nameVBox.getChildren().clear();
        quantityVBox.getChildren().clear();
        caloriesVBox.getChildren().clear();
        priceVBox.getChildren().clear();

        for(String name : dishNames){
            nameVBox.getChildren().add(new DishLabel(name));
            quantityVBox.getChildren().add(new OrderTextfield(""));
                    }

        dishCalories = masterController.getOrderController().loadDishCalories();
        for(String calories : dishCalories){
            caloriesVBox.getChildren().add(new DishLabel(calories));
        }

        dishPrices = masterController.getOrderController().loadDishPrices();
        for(String price : dishPrices){
            priceVBox.getChildren().add(new DishLabel(price));
        }
    }

    private void updateMenuCardForLoggedIn(){
        ArrayList<Boolean> dishAvailability = this.masterController.getOrderController().loadDishAvailability();
        dishNames = this.masterController.getOrderController().loadDishNames();
        dishCalories = masterController.getOrderController().loadDishCalories();
        dishPrices = masterController.getOrderController().loadDishPrices();

        nameVBox.getChildren().clear();
        quantityVBox.getChildren().clear();
        caloriesVBox.getChildren().clear();
        priceVBox.getChildren().clear();

        for(int i = 0; i < dishAvailability.size(); i++){
            if(dishAvailability.get(i)){
                nameVBox.getChildren().add(new DishLabel(dishNames.get(i)));
                quantityVBox.getChildren().add(new OrderTextfield(""));
                caloriesVBox.getChildren().add(new DishLabel(dishCalories.get(i)));
                priceVBox.getChildren().add(new DishLabel(dishPrices.get(i)));
            }else{
                nameVBox.getChildren().add(new DishLabel(dishNames.get(i), false));
                quantityVBox.getChildren().add(new OrderTextfield("", false));
                caloriesVBox.getChildren().add(new DishLabel(dishCalories.get(i), false));
                priceVBox.getChildren().add(new DishLabel(dishPrices.get(i), false));
            }
        }
    }

    private void updateLocalShoppingCart(){
        nameListVBox.getChildren().clear();
        quantityListVBox.getChildren().clear();
        priceListVBox.getChildren().clear();

        ArrayList<String> nameList = this.masterController.getOrderController().getNameList();
        ArrayList<String> priceList = this.masterController.getOrderController().getPriceList();
        ArrayList<Integer> quantityList = this.masterController.getOrderController().getQuantityList();

        if(nameList.size()>0){
            changeCartButton.setVisible(true);
        }else{
            changeCartButton.setVisible(false);
        }

        for(int i = 0; i < nameList.size(); i++){
            nameListVBox.getChildren().add(new PreviewLabel(nameList.get(i)));
            priceListVBox.getChildren().add(new PreviewLabel(priceList.get((i))));
            quantityListVBox.getChildren().add(new OrderTextfield(String.valueOf(quantityList.get(i))));
        }
    }
}
