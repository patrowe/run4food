package gui;

import controller.OrderController;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuCardScene extends StandardScene{

    private BorderPane borderPane;
    private ScrollPane scrollPane;
    private HBox nameAndFilterHBox, menuCardHBox, navigationHBox;
    private VBox sceneContent, nameVBox, categorieVBox, caloriesVBox, priceVBox, checkBoxVBox;
    private Button filterName, filterCategorie, filterPrice, filterCalories, goBackToDaily, goToShoppingCart;
    private Label heading, nameLabel, categorieLabel, caloriesLabel, priceLabel;

    public void setScene(){

        heading = new Label("Dash Board");
        heading.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        heading.setMinHeight(100);
        heading.setPadding(new Insets(10));

        nameLabel = new Label("Name des Gerichts");
        nameLabel.setAlignment(Pos.CENTER_RIGHT);
        nameLabel.setFont(Font.font("Calibri", FontWeight.BOLD,16));
        nameLabel.setMinHeight(30);
        nameLabel.setMinWidth(120);

        categorieLabel = new Label("Kategorie");
        categorieLabel.setAlignment(Pos.CENTER_RIGHT);
        categorieLabel.setFont(Font.font("Calibri", FontWeight.BOLD,16));
        categorieLabel.setMinHeight(30);
        categorieLabel.setMinWidth(120);

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

        filterName = new Button("Sortieren nach Name");
        filterName.setMinHeight(30);
        filterName.setMinWidth(75);
        filterCategorie = new Button("Sortieren nach Kategorie");
        filterCategorie.setMinHeight(30);
        filterCategorie.setMinWidth(75);
        filterPrice = new Button("Sortieren nach Preis");
        filterPrice.setMinHeight(30);
        filterPrice.setMinWidth(75);
        filterCalories = new Button("Sortieren nach Kalorien");
        filterCalories.setMinHeight(30);
        filterCalories.setMinWidth(75);

        nameAndFilterHBox = new HBox();
        nameAndFilterHBox.setAlignment(Pos.CENTER);
        nameAndFilterHBox.setSpacing(10);
        nameAndFilterHBox.getChildren().addAll(nameLabel, filterName, categorieLabel, filterCategorie, caloriesLabel, filterCalories, priceLabel, filterPrice);

        scrollPane = new ScrollPane();
        scrollPane.setContent(menuCardHBox);

        sceneContent = new VBox();
        sceneContent.getChildren().addAll(nameAndFilterHBox, scrollPane);

        goBackToDaily = new NavigationButton("Zurück zum Dash Board");
        goToShoppingCart = new NavigationButton("Weiter zum Warenkorb");

        navigationHBox = new HBox();
        navigationHBox.setAlignment(Pos.CENTER);
        navigationHBox.setSpacing(10);
        navigationHBox.getChildren().addAll(goBackToDaily, goToShoppingCart);

        borderPane = new BorderPane();
        borderPane.setTop(heading);
        borderPane.setCenter(sceneContent);
        borderPane.setBottom(navigationHBox);

        scene.setRoot(borderPane);

        goBackToDaily.setOnAction(actionEvent -> {
            DailyRoutineScene dailyRoutineScene = new DailyRoutineScene();
            dailyRoutineScene.setScene(new OrderController().getUserId());
        });
    }
}
