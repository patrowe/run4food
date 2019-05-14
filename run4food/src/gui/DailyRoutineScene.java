package gui;

import Controller.DailyRoutineController;
import Controller.NegativeNumberException;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class DailyRoutineScene {

    private Stage mainStage;
    private Scene dailyRoutineScene;
    private Label heading, actualdate, nameLabel, basalmetabolismText, stepsText, stepsLabel, activityText,
            activityLabel, activityDuration, eatenCaloriesText, ownCaloriesText, ownCaloriesLabel, ownCaloriesError, calculateCaloriesText,
            calories, stepsError, activityError, eatenCaloriesError;
    private CheckBox apple, pear, crispbread, toast, wholeWheatBread;
    private String dateAsString;
    private TextField steps, activityMinutes, ownCalories;
    private TextField numberApple, numberPear, numberCrispbread, numberToast, numberWholeWheatBread;
    private ChoiceBox activities;
    private Button calculateCalories, order, backToMenu, editProfile, orderHistory, weekOverview;
    private VBox vBox;
    private HBox stepsHBox, activityHbox, ownCaloriesHBox, HBox;
    private ScrollPane scrollPane;
    private TitledPane titledPane;
    private GridPane gridPane;
    private BorderPane borderpane;
    private MainMenuScene mainMenuScene;
    private DailyRoutineController dailyRoutineController;

    private int basalmetabolism;
    private String name;

    DailyRoutineScene(){
        mainMenuScene = new MainMenuScene();
    }

    public void setScene(Stage stage){

        mainStage = stage;

        heading = new Label("Dash Board");
        heading.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        heading.setMinHeight(100);
        heading.setPadding(new Insets(10));

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        dateAsString = DateFormat.getDateInstance().format(date);
        actualdate = new Label(dateAsString);
        actualdate.setPadding(new Insets(10));
        actualdate.setFont(Font.font("Calibri", 25));
        actualdate.setMinHeight(50);

        name = "...";
        nameLabel = new Label("Hallo " + name + ", schön, dass du da bist!");
        nameLabel.setFont(Font.font("Calibri", 25));
        nameLabel.setMinHeight(50);

        //basalmetabolism = DailyRoutineController.getBasalMetabolism();
        basalmetabolism = 1500;
        basalmetabolismText = new Label("Dein Grundumsatz beträgt: " + basalmetabolism + ".");
        basalmetabolismText.setFont(Font.font("Calibri", 25));
        basalmetabolismText.setMinHeight(50);

        stepsText = new Label("Hier kannst du eingeben, wie viele Schritte du gegangen bist. Wenn du die Zahl bestätigst, wird dein Gesamtumsatz aktualisiert.");
        stepsText.setFont(Font.font("Calibri", 25));
        stepsText.setMinHeight(50);

        stepsLabel = new Label("Schrittanzahl:");
        stepsLabel.setFont(Font.font("Calibri", 15));
        stepsLabel.setMinHeight(50);

        steps = new TextField();
        steps.setMinHeight(25);
        steps.setMaxWidth(60);
        steps.setFont(Font.font("Calibri", 12));

        stepsError = new Label();
        stepsError.setFont(Font.font("Calibri", 12));
        stepsError.setMinHeight(50);
        stepsError.setMinWidth(220);

        stepsHBox = new HBox();
        stepsHBox.getChildren().addAll(stepsLabel, steps, stepsError);
        stepsHBox.setAlignment(Pos.CENTER);
        stepsHBox.setSpacing(20);

        activityText = new Label("Hier kannst du deine Aktivitäten und die Zeitdauer (in Minuten) festlegen, damit ein " +
                "Kalorienrechner dir automatisch die Kalorien zu deinem Grundumsatz dazurechnet.");
        activityText.setFont(Font.font("Calibri", 25));
        activityText.setMinHeight(50);

        activityLabel = new Label("Aktivität:");
        activityLabel.setFont(Font.font("Calibri", 15));
        activityLabel.setMinHeight(50);

        activities = new ChoiceBox();
        activities.getItems().add("Schwimmen");
        activities.getItems().add("Radfahren");
        activities.getItems().add("Laufen");
        activities.getItems().add("Tischtennis");
        activities.getItems().add("Fußball");

        activityDuration = new Label("Dauer:");
        activityDuration.setFont(Font.font("Calibri", 15));
        activityDuration.setMinHeight(50);

        activityMinutes = new TextField();
        activityMinutes.setMaxWidth(35);
        activityMinutes.setMinHeight(25);
        activityMinutes.setFont(Font.font("Calibri", 12));

        activityError = new Label();
        activityError.setFont(Font.font("Calibri", 12));
        activityError.setMinHeight(50);
        activityError.setMinWidth(220);

        activityHbox = new HBox();
        activityHbox.getChildren().addAll(activityLabel, activities, activityDuration, activityMinutes, activityError);
        activityHbox.setAlignment(Pos.CENTER);
        activityHbox.setSpacing(20);

        eatenCaloriesText = new Label("Wenn du schon etwas gegessen hast, kannst du hier die Lebensmittel aussuchen, die du schon verzehrt hast.");
        eatenCaloriesText.setFont(Font.font("Calibri", 25));
        eatenCaloriesText.setMinHeight(50);

        apple = new CheckBox("Apfel");
        apple.setPadding(new Insets(2));
        pear = new CheckBox("Birne");
        pear.setPadding(new Insets(2));
        crispbread = new CheckBox("Knäckebrot");
        crispbread.setPadding(new Insets(2));
        toast = new CheckBox("Toastbrot");
        toast.setPadding(new Insets(2));
        wholeWheatBread = new CheckBox("Vollkornbrot");
        wholeWheatBread.setPadding(new Insets(2));

        numberApple = new TextField();
        numberApple.setMaxWidth(30);
        numberPear = new TextField();
        numberPear.setMaxWidth(30);
        numberCrispbread = new TextField();
        numberCrispbread.setMaxWidth(30);
        numberToast = new TextField();
        numberToast.setMaxWidth(30);
        numberWholeWheatBread = new TextField();
        numberWholeWheatBread.setMaxWidth(30);

        gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(2);
        gridPane.addColumn(0, apple, pear, crispbread, toast, wholeWheatBread);
        gridPane.addColumn(1, numberApple, numberPear, numberCrispbread, numberToast, numberWholeWheatBread);
        titledPane = new TitledPane();
        titledPane.setMaxWidth(150);
        titledPane.setExpanded(false);
        titledPane.setContent(gridPane);

        eatenCaloriesError = new Label();
        eatenCaloriesError.setFont(Font.font("Calibri", 12));
        eatenCaloriesError.setMinHeight(50);
        eatenCaloriesError.setMinWidth(220);

        ownCaloriesText = new Label("Rechnest du dir deine verbrauchten Kalorien lieber selber aus? Dann darfst du sie hier eingeben.");
        ownCaloriesText.setFont(Font.font("Calibri", 25));
        ownCaloriesText.setMinHeight(50);

        ownCaloriesLabel = new Label("Kalorien:");
        ownCaloriesLabel.setFont(Font.font("Calibri", 15));
        ownCaloriesLabel.setMinHeight(50);

        ownCalories = new TextField();
        ownCalories.setMinHeight(25);
        ownCalories.setMaxWidth(40);
        ownCalories.setFont(Font.font("Calibri", 12));

        ownCaloriesError = new Label();
        ownCaloriesError.setFont(Font.font("Calibri", 12));
        ownCaloriesError.setMinHeight(50);
        ownCaloriesError.setMinWidth(220);

        ownCaloriesHBox = new HBox();
        ownCaloriesHBox.getChildren().addAll(ownCaloriesLabel, ownCalories, ownCaloriesError);
        ownCaloriesHBox.setAlignment(Pos.CENTER);
        ownCaloriesHBox.setSpacing(20);

        calculateCaloriesText = new Label("Hast du alles eingegeben? Dann kannst du jetzt ausrechnen lassen, wie viele Kalorien du für deine Bestellung einsetzen darfst.");
        calculateCaloriesText.setFont(Font.font("Calibri", 25));
        calculateCaloriesText.setMinHeight(50);

        calculateCalories = new Button("Berechnen");
        calculateCalories.setMinHeight(25);
        calculateCalories.setFont(Font.font("Calibri", FontWeight.BOLD, 15));

        calories = new Label("Du darfst noch Essen mit ... Kalorien bestellen.");
        calories.setFont(Font.font("Calibri", 25));
        calories.setMinHeight(50);

        // Buttons at the bottom of the window

        order = new Button("Essen bestellen");
        order.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        backToMenu = new Button("Hauptmenü");
        backToMenu.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        editProfile = new Button("Profil ändern");
        editProfile.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        orderHistory = new Button("Bestellübersicht");
        orderHistory.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        weekOverview = new Button("Wochenübersicht");
        weekOverview.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.getChildren().addAll(nameLabel, basalmetabolismText, stepsText, stepsHBox, activityText, activityHbox,
                eatenCaloriesText, titledPane, eatenCaloriesError, ownCaloriesText, ownCaloriesHBox, calculateCaloriesText, calculateCalories, calories);
        scrollPane = new ScrollPane();
        scrollPane.setContent(vBox);
        scrollPane.setPannable(true);
        HBox = new HBox();
        HBox.setAlignment(Pos.CENTER);
        HBox.setSpacing(10);
        HBox.setMinHeight(75);
        HBox.getChildren().addAll(order, backToMenu, editProfile, orderHistory, weekOverview);

        borderpane = new BorderPane();
        borderpane.setTop(heading);
        borderpane.setCenter(scrollPane);
        borderpane.setBottom(HBox);
        borderpane.setRight(actualdate);

        Label test2 = new Label();
        test2.setMinWidth(100);
        borderpane.setLeft(test2);

        dailyRoutineScene = new Scene(borderpane);
        mainStage.setScene(dailyRoutineScene);
        mainStage.setMaximized(false);
        mainStage.setMaximized(true);

        dailyRoutineController = new DailyRoutineController();

        // ActionListeners for the Buttons

        calculateCalories.setOnAction(actionEvent -> {
            boolean correct = true;
                int a, b, c;
                String s;
                try {
                    a = Integer.parseInt(steps.getCharacters().toString());
                    dailyRoutineController.test(a);
                    stepsError.setText("");
                } catch (NumberFormatException e) {
                    stepsError.setText("Hier dürfen nur Zahlen eingegeben werden!");
                    correct = false;
                }catch (NegativeNumberException e){
                    stepsError.setText(e.getMessage());
                    correct = false;
                }

                try {
                    s = activities.getSelectionModel().toString();
                    b = Integer.parseInt(activityMinutes.getCharacters().toString());
                    dailyRoutineController.test(b);
                    activityError.setText("");
                } catch (NumberFormatException e) {
                    activityError.setText("Hier dürfen nur Zahlen eingegeben werden!");
                    correct = false;
                }catch(NegativeNumberException e){
                    activityError.setText(e.getMessage());
                    correct = false;
                }

                try {
                    c = Integer.parseInt(ownCalories.getCharacters().toString());
                    dailyRoutineController.test(c);
                    ownCaloriesError.setText("");
                } catch (NumberFormatException e) {
                    ownCaloriesError.setText("Hier dürfen nur Zahlen eingegeben werden!");
                    correct = false;
                }catch(NegativeNumberException e){
                    ownCaloriesError.setText(e.getMessage());
                    correct = false;
                }
                try {
                    ObservableList<Node> children = gridPane.getChildren();
                    ArrayList<Integer> values = new ArrayList<>();
                    for(Node node : children){
                        if(gridPane.getColumnIndex(node)==1){
                            values.add(Integer.valueOf(node.toString()));
                        }
                    }
                    for(int i : values){
                        test2.setText(test2.getText()+Integer.toString(i));
                    }

                    eatenCaloriesError.setText("");
                } catch (NumberFormatException e) {
                    eatenCaloriesError.setText("Hier dürfen nur Zahlen eingegeben werden!");
                    correct = false;
                //} catch (NegativeNumberException e){
                    //eatenCaloriesError.setText(e.getMessage());
                }
                if(correct == true){
                    Label test = new Label("erfolgreich");
                    borderpane.setLeft(test);
                }

                //dailyRoutineController.callCalculateSteps(a);
                //dailyRoutineController.callCalculateActivity(s, b);

        });

        order.setOnAction(actionEvent -> {

        });

        backToMenu.setOnAction(actionEvent -> {
            mainMenuScene.setScene(mainStage);
        });

        editProfile.setOnAction(actionEvent -> {

        });

        orderHistory.setOnAction(actionEvent -> {

        });

        weekOverview.setOnAction(actionEvent -> {

        });

    }
}
