package gui;

import controller.MasterController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;
import java.util.Iterator;


public class MenuCardScene extends StandardScene{

    private BorderPane borderPane;
    private ScrollPane scrollPane;
    private HBox informationHBox, nameAndFilterHBox, menuCardHBox, navigationHBox;
    private VBox sceneContent, nameVBox, caloriesVBox, priceVBox, quantitiyVBox, addButtonsVBox, shoppingCartVBox;
    private Button sortName, sortPrice, sortCalories, goBackToDaily, goToShoppingCart;
    private Label heading, nameLabel, caloriesLabel, priceLabel, shoppingCartLabel;
    private ArrayList<String> dishNames, dishCalories, dishPrices;
    private MasterController masterController;

    public void setScene(StandardScene standardScene, MasterController masterController){

        this.masterController = masterController;

        heading = new Label("Dash Board");
        heading.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        heading.setMinHeight(100);
        heading.setPadding(new Insets(10));

        Label freeCalories = new Label("Verfügbare Kalorien: ");

        informationHBox = new HBox();
        informationHBox.getChildren().add(freeCalories);

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

        sortName = new Button("Sortieren nach Name");
        sortName.setMinHeight(30);
        sortName.setMinWidth(80);
        sortPrice = new Button("Sortieren nach Preis");
        sortPrice.setMinHeight(30);
        sortPrice.setMinWidth(80);
        sortCalories = new Button("Sortieren nach Kalorien");
        sortCalories.setMinHeight(30);
        sortCalories.setMinWidth(80);

        nameAndFilterHBox = new HBox();
        nameAndFilterHBox.setAlignment(Pos.CENTER);
        nameAndFilterHBox.setSpacing(10);
        nameAndFilterHBox.getChildren().addAll(nameLabel, sortName, caloriesLabel, sortCalories, priceLabel, sortPrice);

        menuCardHBox = new HBox();
        menuCardHBox.setAlignment(Pos.CENTER);
        menuCardHBox.setSpacing(10);

        this.updateList();

        scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setPannable(true);
        scrollPane.setContent(menuCardHBox);

        sceneContent = new VBox();
        sceneContent.getChildren().addAll(informationHBox, nameAndFilterHBox, scrollPane);

        shoppingCartLabel = new Label("Im Warenkorb:");
        shoppingCartLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 18));

        shoppingCartVBox = new VBox();
        shoppingCartVBox.setMinWidth(200);
        shoppingCartVBox.getChildren().addAll(shoppingCartLabel);

        goBackToDaily = new NavigationButton("Zurück zum Dash Board");
        goToShoppingCart = new NavigationButton("Weiter zum Warenkorb");

        navigationHBox = new HBox();
        navigationHBox.setAlignment(Pos.CENTER);
        navigationHBox.setSpacing(10);
        navigationHBox.getChildren().addAll(goBackToDaily, goToShoppingCart);

        borderPane = new BorderPane();
        borderPane.setTop(heading);
        borderPane.setCenter(sceneContent);
        borderPane.setRight(shoppingCartVBox);
        borderPane.setBottom(navigationHBox);

        standardScene.setSceneContent(borderPane);

        sortName.setOnAction(actionEvent -> {
            this.masterController.getOrderController().SortByName();
            this.updateList();
        });

        sortCalories.setOnAction(actionEvent -> {
            this.masterController.getOrderController().SortByCalories();
            this.updateList();
        });

        sortPrice.setOnAction(actionEvent -> {
            this.masterController.getOrderController().SortByPrice();
            this.updateList();
        });

        goBackToDaily.setOnAction(actionEvent -> {
            DailyRoutineScene dailyRoutineScene = new DailyRoutineScene();
            dailyRoutineScene.setScene(standardScene, masterController);
        });

        goToShoppingCart.setOnAction(actionEvent -> {

        });
    }

    private void updateList(){
        menuCardHBox.getChildren().removeAll(nameVBox, caloriesVBox, priceVBox, quantitiyVBox, addButtonsVBox);
        nameVBox = new VBox();
        nameVBox.setSpacing(5);
        caloriesVBox = new VBox();
        caloriesVBox.setSpacing(5);
        priceVBox = new VBox();
        priceVBox.setSpacing(5);
        quantitiyVBox = new VBox();
        quantitiyVBox.setSpacing(5);
        addButtonsVBox = new VBox();
        addButtonsVBox.setSpacing(5);

        dishNames = this.masterController.getOrderController().loadDishNames();

        for(String name : dishNames){
            nameVBox.getChildren().add(new DishLabel(name));
            quantitiyVBox.getChildren().add(new ActivityChoiceBox<>( "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
            addButtonsVBox.getChildren().add(new OrderButton("+", this));
        }

        dishCalories = masterController.getOrderController().loadDishCalories();
        for(String calories : dishCalories){
            caloriesVBox.getChildren().add(new DishLabel(calories));
        }

        dishPrices = masterController.getOrderController().loadDishPrices();
        for(String price : dishPrices){
            priceVBox.getChildren().add(new DishLabel(price));
        }
        menuCardHBox.getChildren().addAll(nameVBox, caloriesVBox, priceVBox, quantitiyVBox, addButtonsVBox);
    }

    void handleOrderButtonEvent(Button sourceButton){
        Iterator iterator = addButtonsVBox.getChildren().iterator();
        int index = 0;
        while(iterator.hasNext()){
            Button button = (Button)iterator.next();
            if(button.equals(sourceButton)){
                break;
            }else{
                index++;
            }
        }
        int quantity = Integer.parseInt(((ActivityChoiceBox)quantitiyVBox.getChildren().get(index)).getValue().toString());
        this.masterController.getOrderController().callSetOrder(index, quantity);
        System.out.println(index + "" + quantity);
    }

}

/**
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