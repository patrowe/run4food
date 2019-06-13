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
import java.util.regex.Pattern;

/**
 * @author Christoph Klassen
 */
public class MenuCardScene extends StandardScene{

    //Attribute für die Menüliste

    private BorderPane borderPane;
    private ScrollPane scrollPane;
    private HBox informationHBox, nameAndFilterHBox, menuCardHBox, navigationHBox;
    private VBox sceneContent, nameVBox, caloriesVBox, priceVBox, quantityVBox, addButtonsVBox;
    private Button sortName, sortPrice, sortCalories, addToCart, goBackToDaily, goToShoppingCart;
    private Label heading, nameLabel, caloriesLabel, priceLabel, shoppingCartLabel;
    private ArrayList<String> dishNames, dishCalories, dishPrices;
    private MasterController masterController;

    //Attribute für die Warenkorb-Vorschau

    private HBox labelHBox, contentHBox;
    private VBox shoppingCartVBox, nameListVBox, quantityListVBox, priceListVBox;
    private Button changeCartButton;

    public void setScene(StandardScene standardScene, MasterController masterController){

        this.masterController = masterController;

        heading = new Label("Dash Board");
        heading.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        heading.setMinHeight(100);
        heading.setPadding(new Insets(10));

        Label freeCalories = new Label("Verfügbare Kalorien: " + this.masterController.getOrderController().getAvailableCalories());

        informationHBox = new HBox();
        informationHBox.getChildren().add(freeCalories);

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

        this.updateMenuCard();

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
        sceneContent.getChildren().addAll(informationHBox, hBox);

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

        shoppingCartVBox = new VBox();
        shoppingCartVBox.setMinWidth(250);
        shoppingCartVBox.getChildren().addAll(shoppingCartLabel, labelHBox, contentHBox, changeCartButton);

        //Hier werden die Buttons für die Navigation erstellt

        goBackToDaily = new NavigationButton("Zurück zum Dash Board");
        goToShoppingCart = new NavigationButton("Weiter zum Warenkorb");

        navigationHBox = new HBox();
        navigationHBox.setAlignment(Pos.CENTER);
        navigationHBox.setSpacing(10);
        navigationHBox.setMinHeight(75);
        navigationHBox.getChildren().addAll(goBackToDaily, goToShoppingCart);

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
            this.updateMenuCard();
        });

        sortCalories.setOnAction(actionEvent -> {
            this.masterController.getOrderController().SortByCalories();
            this.updateMenuCard();
        });

        sortPrice.setOnAction(actionEvent -> {
            this.masterController.getOrderController().SortByPrice();
            this.updateMenuCard();
        });

        goBackToDaily.setOnAction(actionEvent -> {
            DailyRoutineScene dailyRoutineScene = new DailyRoutineScene();
            dailyRoutineScene.setScene(standardScene, masterController);
        });

        goToShoppingCart.setOnAction(actionEvent -> {

        });

        addToCart.setOnAction(actionEvent -> {
            Iterator iterator = quantityVBox.getChildren().iterator();
            int index = 0;
            while(iterator.hasNext()){
                OrderTextfield orderTextfield = (OrderTextfield) iterator.next();
                System.out.println("Inhalt des Textfelds: " + orderTextfield.getText());
                if(!(orderTextfield.getText().equals(""))){
                    try {
                        int quantity = Integer.parseInt(((OrderTextfield) quantityVBox.getChildren().get(index)).getText());
                        this.masterController.getOrderController().callChangeCart(index, quantity);
                        this.updateLocalShoppingCart();
                        System.out.println("Index und Anzahl: " + index + "" + quantity);
                    }catch(NumberFormatException e){
                        e.printStackTrace();
                    }

                }
                index++;
            }
        });

        changeCartButton.setOnAction(actionEvent -> {

        });
    }

    /**
     * Die Methode erneuert die Menükarte mit der jeweils aktuellen Liste an Dishes
     */
    private void updateMenuCard(){
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

    private void updateLocalShoppingCart(){
        nameListVBox.getChildren().clear();
        quantityListVBox.getChildren().clear();
        priceListVBox.getChildren().clear();

        ArrayList<String> nameList = this.masterController.getOrderController().getNameList();
        ArrayList<String> priceList = this.masterController.getOrderController().getPriceList();
        ArrayList<Integer> quantityList = this.masterController.getOrderController().getQuantityList();

        for(int i = 0; i < nameList.size(); i++){
            nameListVBox.getChildren().add(new Label(nameList.get(i)));
            priceListVBox.getChildren().add(new Label(priceList.get((i))));
            quantityListVBox.getChildren().add(new OrderTextfield(String.valueOf(quantityList.get(i))));
        }
    }


}

/*
    void handleCheckBoxEvent(CheckBox checkBox) {
        Iterator iterator = nameVBox.getChildren().iterator();
        if (checkBox.isSelected()) {
            while (iterator.hasNext()) {
                if (!(iterator.next().equals(checkBox))) {
                    CheckBox box = (CheckBox) iterator.next();
                    box.setDisable(true);
                }
            }
        } else {
            while (iterator.hasNext()) {
                if (!(iterator.next().equals(checkBox))) {
                    CheckBox box = (CheckBox) iterator.next();
                    box.setDisable(false);
                }


            }
        }
    }
 */