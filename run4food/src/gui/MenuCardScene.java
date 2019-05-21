package gui;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuCardScene {

    private Stage mainStage;
    private ScrollPane scrollPane;
    private HBox filterHBox, menuCardHBox;
    private VBox sceneContent, dishesVBox, categorieVBox, caloriesVBox, priceVBox;
    private Button filterName, filterPrice, filterCalories;

    public void setScene(Stage stage){
        mainStage = stage;

        filterName = new Button("Nach Name sortieren");
        filterPrice = new Button("Nach Preis sortieren");
        filterCalories = new Button("Nach Kalorien sortieren");
        filterHBox = new HBox();
        filterHBox.getChildren().addAll(filterName, filterCalories, filterPrice);

        menuCardHBox = new HBox();
        sceneContent = new VBox();
        sceneContent.getChildren().addAll(filterHBox, menuCardHBox);
        scrollPane = new ScrollPane();
        scrollPane.setContent(sceneContent);
    }
}
