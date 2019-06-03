package gui;

import controller.DailyRoutineController;
import controller.MasterController;
import controller.NoSenseException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import run4food.Lexicon;

import java.text.DateFormat;
import java.util.*;


public class DailyRoutineScene extends StandardScene{

    private Label heading, actualdate, nameLabel, basalmetabolismLabel, stepsExplanation, stepsLabel, activityExplanation,
            activityLabel, activityLabel2, activityLabel3, eatenCaloriesText, ownCaloriesText, ownCaloriesLabel,
            calories, activityError;
    private ErrorLabel stepsError, ownCaloriesError, eatenCaloriesError;
    private String dateAsString;
    private NumberTextField steps, ownCalories;
    private Button calculateSteps, calculateActivities, calculateEatenCalories, calculateOwnCalories, order, backToMenu, editProfile, orderHistory, weekOverview;
    private VBox vBox, eatenCaloriesFoodList, eatenCaloriesTextFieldList, activityList, activityDurationHoursList, activityDurationMinutesList, activityTitledPaneContent;
    private HBox dateHBox, stepsHBox, activityHBox, activityLabelHBox, activityUIElementHbox, eatenCaloriesHBox, eatenCaloriesUIElementHBox, ownCaloriesHBox, navigationHBox;
    private ScrollPane scrollPane;
    private TitledPane activityTitledPane, eatenCaloriesTitledPane;
    private BorderPane borderpane;
    private MainMenuScene mainMenuScene;
    private DailyRoutineController dailyRoutineController;
    private int basalmetabolism;
    private MasterController masterController;

    public DailyRoutineScene(){
        mainMenuScene = new MainMenuScene();
        dailyRoutineController = new DailyRoutineController();
    }

    public void setScene(StandardScene standardScene, MasterController mController){

        this.masterController = mController;

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
        dateHBox = new HBox();
        dateHBox.setAlignment(Pos.TOP_RIGHT);
        dateHBox.getChildren().add(actualdate);

        nameLabel = new Label("Hallo " + dailyRoutineController.getNickname(masterController) + ", schön, dass du da bist!");
        nameLabel.setFont(Font.font("Calibri", 25));
        nameLabel.setMinHeight(50);

        basalmetabolism = 1500;
        basalmetabolismLabel = new Label("Dein Grundumsatz beträgt: " + masterController.getUser().getBasalMetabolism() + ".");
        basalmetabolismLabel.setFont(Font.font("Calibri", 25));
        basalmetabolismLabel.setMinHeight(50);

        stepsExplanation = new Label("Hier kannst du eingeben, wie viele Schritte du gegangen bist. Wenn du die Zahl bestätigst, wird dein Gesamtumsatz aktualisiert.");
        stepsExplanation.setFont(Font.font("Calibri", 25));
        stepsExplanation.setMinHeight(50);

        stepsLabel = new Label("Schrittanzahl:");
        stepsLabel.setFont(Font.font("Calibri", 15));
        stepsLabel.setMinHeight(50);

        steps = new NumberTextField("0", stepsError);
        steps.setMinHeight(25);
        steps.setMaxWidth(60);
        steps.setFont(Font.font("Calibri", 12));

        calculateSteps = new Button("Berechnen");
        calculateSteps.setMinHeight(25);
        calculateSteps.setFont(Font.font("Calibri", FontWeight.BOLD, 15));

        stepsError = new ErrorLabel();
        stepsError.setFont(Font.font("Calibri", 12));
        stepsError.setMinHeight(50);
        stepsError.setMinWidth(220);

        stepsHBox = new HBox();
        stepsHBox.getChildren().addAll(stepsLabel, steps, calculateSteps, stepsError);
        stepsHBox.setAlignment(Pos.CENTER);
        stepsHBox.setSpacing(20);

        activityExplanation = new Label("Hier kannst du deine Aktivitäten und die Zeitdauer festlegen, damit ein " +
                "Kalorienrechner dir automatisch die Kalorien zu deinem Grundumsatz dazurechnet.");
        activityExplanation.setFont(Font.font("Calibri", 25));
        activityExplanation.setMinHeight(50);

        activityLabel = new Label("Aktivität");
        activityLabel.setFont(Font.font("Calibri", 15));
        activityLabel.setMinHeight(20);
        activityLabel.setMinWidth(200);

        activityLabel2 = new Label("Stunden");
        activityLabel2.setFont(Font.font("Calibri", 15));
        activityLabel2.setMinHeight(20);
        activityLabel2.setMinWidth(60);

        activityLabel3 = new Label("Minuten");
        activityLabel3.setFont(Font.font("Calibri", 15));
        activityLabel3.setMinHeight(20);
        activityLabel3.setMinWidth(60);

        Lexicon lexicon = new Lexicon();

        activityList = new VBox();
        activityList.setSpacing(5);
        activityList.setMinWidth(200);

        activityDurationHoursList = new VBox();
        activityDurationHoursList.setSpacing(5);

        activityDurationMinutesList = new VBox();
        activityDurationMinutesList.setSpacing(5);

        Set<String> activityKeys = lexicon.getActivity2calory().keySet();
        Iterator<String> iterator = activityKeys.iterator();
        while(iterator.hasNext()){
            activityList.getChildren().add(new ActivityCheckBox(iterator.next()));
            activityDurationHoursList.getChildren().add(new ActivityChoiceBox<String>("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                    "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"));
            activityDurationMinutesList.getChildren().add(new ActivityChoiceBox<String>("0", "15", "30", "45"));
        }


        activityLabelHBox = new HBox();
        activityLabelHBox.setSpacing(5);
        activityLabelHBox.getChildren().addAll(activityLabel, activityLabel2, activityLabel3);

        activityHBox = new HBox();
        activityHBox.setSpacing(5);
        activityHBox.getChildren().addAll(activityList, activityDurationHoursList, activityDurationMinutesList);

        activityTitledPaneContent = new VBox();
        activityTitledPaneContent.setSpacing(10);
        activityTitledPaneContent.getChildren().addAll(activityLabelHBox, activityHBox);

        activityTitledPane = new TitledPane();
        activityTitledPane.setText("Aktivitäten");
        activityTitledPane.setMaxWidth(400);
        activityTitledPane.setExpanded(false);
        activityTitledPane.setContent(activityTitledPaneContent);

        calculateActivities = new Button("Berechnen");
        calculateActivities.setMinHeight(25);
        calculateActivities.setFont(Font.font("Calibri", FontWeight.BOLD, 15));

        activityError = new Label();
        activityError.setFont(Font.font("Calibri", 12));
        activityError.setMinHeight(50);
        activityError.setMinWidth(220);

        activityUIElementHbox = new HBox();
        activityUIElementHbox.getChildren().addAll(activityTitledPane, calculateActivities, activityError);
        activityUIElementHbox.setAlignment(Pos.CENTER);
        activityUIElementHbox.setSpacing(20);

        eatenCaloriesText = new Label("Wenn du schon etwas gegessen hast, kannst du hier die Lebensmittel aussuchen, die du schon verzehrt hast.");
        eatenCaloriesText.setFont(Font.font("Calibri", 25));
        eatenCaloriesText.setMinHeight(50);

        eatenCaloriesFoodList = new VBox();
        eatenCaloriesFoodList.setSpacing(5);
        eatenCaloriesFoodList.setMinWidth(200);

        eatenCaloriesTextFieldList = new VBox();
        eatenCaloriesTextFieldList.setSpacing(5);

        for(String s : lexicon.getFood2calory().keySet()){
            eatenCaloriesFoodList.getChildren().add(new EatenCaloriesCheckBox(s));
            eatenCaloriesTextFieldList.getChildren().add(new NumberTextField("0", eatenCaloriesError));
        }

        eatenCaloriesHBox = new HBox();
        eatenCaloriesHBox.getChildren().addAll(eatenCaloriesFoodList, eatenCaloriesTextFieldList);

        eatenCaloriesTitledPane = new TitledPane();
        eatenCaloriesTitledPane.setText("Kalorienrechner für Lebensmittel");
        eatenCaloriesTitledPane.setMaxWidth(250);
        eatenCaloriesTitledPane.setExpanded(false);
        eatenCaloriesTitledPane.setContent(eatenCaloriesHBox);

        calculateEatenCalories = new Button("Berechnen");
        calculateEatenCalories.setMinHeight(25);
        calculateEatenCalories.setFont(Font.font("Calibri", FontWeight.BOLD, 15));

        eatenCaloriesError = new ErrorLabel();
        eatenCaloriesError.setFont(Font.font("Calibri", 12));
        eatenCaloriesError.setMinHeight(50);
        eatenCaloriesError.setMinWidth(350);

        eatenCaloriesUIElementHBox = new HBox();
        eatenCaloriesUIElementHBox.getChildren().addAll(eatenCaloriesTitledPane, calculateEatenCalories, eatenCaloriesError);
        eatenCaloriesUIElementHBox.setAlignment(Pos.CENTER);
        eatenCaloriesUIElementHBox.setSpacing(20);

        ownCaloriesText = new Label("Rechnest du dir deine verbrauchten Kalorien lieber selber aus? Dann darfst du sie hier eingeben.");
        ownCaloriesText.setFont(Font.font("Calibri", 25));
        ownCaloriesText.setMinHeight(50);

        ownCaloriesLabel = new Label("Kalorien:");
        ownCaloriesLabel.setFont(Font.font("Calibri", 15));
        ownCaloriesLabel.setMinHeight(50);

        ownCalories = new NumberTextField("0", ownCaloriesError);
        ownCalories.setMinHeight(25);
        ownCalories.setMaxWidth(40);
        ownCalories.setFont(Font.font("Calibri", 12));

        calculateOwnCalories = new Button("Berechnen");
        calculateOwnCalories.setMinHeight(25);
        calculateOwnCalories.setFont(Font.font("Calibri", FontWeight.BOLD, 15));

        ownCaloriesError = new ErrorLabel();
        ownCaloriesError.setFont(Font.font("Calibri", 12));
        ownCaloriesError.setMinHeight(50);
        ownCaloriesError.setMinWidth(220);

        ownCaloriesHBox = new HBox();
        ownCaloriesHBox.getChildren().addAll(ownCaloriesLabel, ownCalories, calculateOwnCalories, ownCaloriesError);
        ownCaloriesHBox.setAlignment(Pos.CENTER);
        ownCaloriesHBox.setSpacing(20);

        calories = new Label("Du darfst noch Essen mit " + dailyRoutineController.getFreeCalories(masterController) + " Kalorien bestellen.");
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
        vBox.setSpacing(10);
        vBox.getChildren().addAll(dateHBox, nameLabel, basalmetabolismLabel, stepsExplanation, stepsHBox, activityExplanation, activityUIElementHbox,
                eatenCaloriesText, eatenCaloriesUIElementHBox, ownCaloriesText, ownCaloriesHBox, calories);
        vBox.setAlignment(Pos.CENTER);
        scrollPane = new ScrollPane();
        scrollPane.setPannable(true);
        scrollPane.setContent(vBox);
        scrollPane.setFitToWidth(true);

        navigationHBox = new HBox();
        navigationHBox.setAlignment(Pos.CENTER);
        navigationHBox.setSpacing(10);
        navigationHBox.setMinHeight(75);
        navigationHBox.getChildren().addAll(order, backToMenu, editProfile, orderHistory, weekOverview);

        borderpane = new BorderPane();
        borderpane.setTop(heading);
        borderpane.setCenter(scrollPane);
        borderpane.setBottom(navigationHBox);

        standardScene.setSceneContent(borderpane);

        //
        // ActionListeners for the Buttons
        //

        calculateSteps.setOnAction(actionEvent -> {
            try {
                int a = Integer.parseInt(steps.getText());
                dailyRoutineController.testOneNumber(a);
                stepsError.setText("Berechnung erfolgreich");
                dailyRoutineController.callCalculateSteps(a, masterController);
                updateFreeCalories();
            }catch(NumberFormatException e){
                stepsError.setText("Du musst eine Zahl eingeben, um die Kalorien berechnen zu lassen");
            }catch(NoSenseException e){
                stepsError.setText(e.getMessage());
            }
        });

        calculateActivities.setOnAction(actionEvent -> {

            // Every generated checkbox and ChoiceBox for activities is added to an ArrayList
            boolean minimumOneChosen = false;
            boolean testSuccessful = true;
            ArrayList<ActivityCheckBox> checkBoxes = new ArrayList<>();
            ArrayList<Integer> choiceBoxesHours = new ArrayList<>();
            ArrayList<Integer> choiceBoxesMinutes = new ArrayList<>();
            Iterator iteratorCheckboxes = activityList.getChildren().iterator();
            Iterator iteratorChoiceBoxesHours = activityDurationHoursList.getChildren().iterator();
            Iterator iteratorChoiceBoxesMinutes = activityDurationMinutesList.getChildren().iterator();
            while(iteratorCheckboxes.hasNext()){
                checkBoxes.add((ActivityCheckBox) iteratorCheckboxes.next());
            }
            while(iteratorChoiceBoxesHours.hasNext()){
                try {
                    String s = ((ActivityChoiceBox<String>) iteratorChoiceBoxesHours.next()).getValue();
                    if(s == null){
                        choiceBoxesHours.add(0);
                    }else{
                        choiceBoxesHours.add(Integer.parseInt(s));
                    }
                }catch(NullPointerException e){
                    testSuccessful = false;
                }
            }
            while(iteratorChoiceBoxesMinutes.hasNext()){
                try {
                    String s = ((ActivityChoiceBox<String>) iteratorChoiceBoxesMinutes.next()).getValue();
                    if(s == null){
                        choiceBoxesMinutes.add(0);
                    }else{
                        choiceBoxesMinutes.add(Integer.parseInt(s));
                    }
                }catch(NullPointerException e){
                    testSuccessful = false;
                }
            }
            for (Integer s : choiceBoxesHours){
                System.out.println(s);
            }
            for (Integer s : choiceBoxesMinutes){
                System.out.println(s);
            }
            for (int i = 0; i < checkBoxes.size(); i++){
                if(checkBoxes.get(i).isSelected()) {
                    minimumOneChosen = true;
                    try {
                        dailyRoutineController.activityTest(choiceBoxesHours.get(i), choiceBoxesMinutes.get(i));
                    }catch(IndexOutOfBoundsException e){
                        e.printStackTrace();
                    }catch (NoSenseException e) {
                        testSuccessful = false;
                        activityError.setText(e.getMessage());
                    }
                }

            }

            if(!minimumOneChosen){
                activityError.setText("Du hast kein Aktivität ausgewählt!");
            }else if(testSuccessful){
                for(int i = 0; i < checkBoxes.size(); i++){
                    if(checkBoxes.get(i).isSelected()){
                        //dailyRoutineController.callCalculateActivity(checkBoxes.get(i).getText(),
                                //Integer.parseInt(choiceBoxesHours.get(i)), Integer.parseInt(choiceBoxesMinutes.get(i)));
                    }
                }
                activityError.setText("Berechnung erfolgreich.");
            }

        });

        calculateEatenCalories.setOnAction(actionEvent -> {

            // Every generated checkbox and textfield for activities is added to an ArrayList
            ArrayList<CheckBox> checkBoxes = new ArrayList<>();
            ArrayList<NumberTextField> textFields = new ArrayList<>();
            Iterator iteratorCheckBoxes = eatenCaloriesFoodList.getChildren().iterator();
            while(iteratorCheckBoxes.hasNext()){
                checkBoxes.add((CheckBox)iteratorCheckBoxes.next());
            }
            Iterator iteratorTextFields = eatenCaloriesTextFieldList.getChildren().iterator();
            while (iteratorTextFields.hasNext()){
                textFields.add((NumberTextField) iteratorTextFields.next());
            }

            // Calling a test method of DailyRoutineController to check, if the user's input is valid
            boolean testSuccessful = true;
            boolean minimumOneChosen = false;
            for(int i = 0; i < checkBoxes.size(); i++){
                if(checkBoxes.get(i).isSelected()){
                    minimumOneChosen = true;
                    try {
                        int a = Integer.parseInt(textFields.get(i).getText());
                        dailyRoutineController.testOneNumber(a);
                        eatenCaloriesError.setText("Berechnung erfolgreich");
                    }catch(NumberFormatException e){
                        testSuccessful = false;
                        eatenCaloriesError.setText("Wenn ein Lebensmittel ausgewählt ist, muss auch die Anzahl eingegeben werden");
                    } catch(NoSenseException e){
                        testSuccessful = false;
                        eatenCaloriesError.setText(e.getMessage());
                    }
                }
            }
            if(!minimumOneChosen){
                eatenCaloriesError.setText("Du hast keine Lebensmittel ausgewählt!");
            }else if(testSuccessful){
                for(int i = 0; i < checkBoxes.size(); i++){
                    if(checkBoxes.get(i).isSelected()){
                        //dailyRoutineController.callCalculateEatenCalories(checkBoxes.get(i).getText(), Integer.parseInt(textFields.get(i).getText()));
                    }
                }
                eatenCaloriesError.setText("Berechnung erfolgreich.");
            }

        });

        calculateOwnCalories.setOnAction(actionEvent -> {
            try {
                int a = Integer.parseInt(ownCalories.getText());
                dailyRoutineController.testOneNumber(a);
                ownCaloriesError.setText("Berechnung erfolgreich");
                dailyRoutineController.callCalculateSteps(a, masterController);
            }catch(NumberFormatException e){
                ownCaloriesError.setText("Du musst eine Zahl eingeben, um die Kalorien berechnen zu lassen");
            }catch(NoSenseException e){
                ownCaloriesError.setText(e.getMessage());
            }
        });

        order.setOnAction(actionEvent -> {
            MenuCardScene menuCardScene = new MenuCardScene();
            menuCardScene.setScene(standardScene, masterController);
        });

        backToMenu.setOnAction(actionEvent -> {
            mainMenuScene.setScene(standardScene, masterController);
        });

        editProfile.setOnAction(actionEvent -> {

        });

        orderHistory.setOnAction(actionEvent -> {

        });

        weekOverview.setOnAction(actionEvent -> {

        });

    }

    private void updateFreeCalories() {
        calories.setText("Du darfst noch Essen mit " + dailyRoutineController.getFreeCalories(masterController) + " Kalorien bestellen.");
    }

}



