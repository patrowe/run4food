package gui;

import controller.StartController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RegistrationScene extends StandardScene{

    private Scene registrationScene;
    private BorderPane registrationBorderPane;
    private ScrollPane registrationScrollPane;
    private VBox registrationVBox;
    private HBox registrationHBox, name, street, place, gender, preferedFood, incompatibility, registrationButtons;
    private Label registrationTitle, questionNickname, questionName, questionLiving, questionGender, questionPhone, questionAge, questionweight, questionHeight, questionPreferedFood, questionIncompatibility;
    private TextField nickname, forenameTextField, surnameTextField, streetNameTextField, cityTextField;
    private NumberTextField streetNumberTextField, postcodeTextField, phoneTextField, ageTextField, weightTextField, heightTextField;
    private CheckBox gluten, wheat, lactose;
    private RadioButton veggie, vegan, eatAll, male, female, diverse;
    private ToggleGroup optionsPreferedFood, optionsGender;
    private Button registrationCancel, registrationSave;
    private MainMenuScene mainMenuScene;
    private StartController startController;
    private DailyRoutineScene dailyRoutineScene;

    RegistrationScene(){
        mainMenuScene = new MainMenuScene();
    }

    public void setScene(){

        registrationTitle = new Label("Registrierung");
        registrationTitle.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        registrationTitle.setMinHeight(100);
        registrationTitle.setPadding(new Insets(10));

        questionNickname = new Label("Wie soll ich dich nennen?");
        questionNickname.setFont(Font.font("Calibri", 25));
        questionNickname.setMinHeight(50);

        nickname = new TextField("Nickname");
        nickname.setFont(Font.font("Calibri", 20));

        questionName = new Label("Wie heißt du?");
        questionName.setFont(Font.font("Calibri", FontWeight.NORMAL, 25));
        questionName.setMinHeight(50);

        forenameTextField = new TextField("Vorname");
        forenameTextField.setFont(Font.font("Calibri", 20));

        surnameTextField = new TextField("Nachname");
        surnameTextField.setFont(Font.font("Calibri", 20));

        name = new HBox();
        name.setSpacing(20);
        name.getChildren().addAll(forenameTextField, surnameTextField);

        questionLiving = new Label("Wo lebst du?");
        questionLiving.setFont(Font.font("Calibri", FontWeight.NORMAL, 25));
        questionLiving.setMinHeight(50);

        streetNameTextField = new NumberTextField("Straße");
        streetNameTextField.setFont(Font.font("Calibri", 20));

        streetNumberTextField = new NumberTextField(("Nr."));
        streetNumberTextField.setFont(Font.font("Calibri", 20));

        street = new HBox();
        street.setSpacing(20);
        street.getChildren().addAll(streetNameTextField, streetNumberTextField);

        postcodeTextField = new NumberTextField("PLZ");
        postcodeTextField.setFont(Font.font("Calibri", 20));

        cityTextField = new TextField("Stadt");
        cityTextField.setFont(Font.font("Calibri", 20));

        place = new HBox();
        place.setSpacing(20);
        place.getChildren().addAll(postcodeTextField, cityTextField);

        questionPhone = new Label("Unter welcher Telefonnummer bist du erreichbar?");
        questionPhone.setFont(Font.font("Calibri", 25));
        questionPhone.setMinHeight(50);

        phoneTextField = new NumberTextField("Telefonnummer");
        phoneTextField.setFont(Font.font("Calibri", 20));

        questionAge = new Label("Wie jung bist du?");
        questionAge.setFont(Font.font("Calibri", 25));
        questionAge.setMinHeight(50);

        ageTextField = new NumberTextField("Alter");
        ageTextField.setFont(Font.font("Calibri", 20));

        questionGender = new Label("Welchem Geschlecht fühlst du dich zugehörig?");
        questionGender.setFont(Font.font("Calibri", 25));
        questionGender.setMinHeight(50);

        male = new RadioButton("Männlich");
        male.setFont(Font.font("Calibri", 20));
        male.setMinHeight(50);
        male.setMinWidth(100);

        female = new RadioButton("Weiblich");
        female.setFont(Font.font("Calibri", 20));
        female.setMinHeight(50);
        female.setMinWidth(100);

        diverse = new RadioButton("Divers");
        diverse.setFont(Font.font("Calibri", 20));
        diverse.setMinHeight(50);
        diverse.setMinWidth(100);

        optionsGender = new ToggleGroup();
        optionsGender.getToggles().addAll(male, female, diverse);

        gender = new HBox();
        gender.setAlignment(Pos.CENTER);
        gender.setSpacing(20);
        gender.getChildren().addAll(male, female, diverse);

        questionHeight = new Label("Wie groß bist du?");
        questionHeight.setFont(Font.font("Calibri", 25));
        questionHeight.setMinHeight(50);

        heightTextField = new NumberTextField("Körpergröße");
        heightTextField.setFont(Font.font("Calibri", 20));

        questionweight = new Label("Was für ein Gewicht zeigt deine Waage an?");
        questionweight.setFont(Font.font("Calibri", 25));
        questionweight.setMinHeight(50);

        weightTextField = new NumberTextField("Körpergewicht");
        weightTextField.setFont(Font.font("Calibri", 20));

        questionPreferedFood = new Label("Auf was achtest du beim Essen?");
        questionPreferedFood.setFont(Font.font("Calibri", 25));
        questionPreferedFood.setMinHeight(50);

        veggie = new RadioButton("Vegetarisch");
        veggie.setFont(Font.font("Calibri", 20));
        veggie.setMinHeight(50);
        veggie.setMinWidth(100);

        vegan = new RadioButton("Vegan");
        vegan.setFont(Font.font("Calibri", 20));
        vegan.setMinHeight(50);
        vegan.setMinWidth(100);

        eatAll = new RadioButton("Ich esse alles!");
        eatAll.setFont(Font.font("Calibri", 20));
        eatAll.setMinHeight(50);
        eatAll.setMinWidth(100);

        optionsPreferedFood = new ToggleGroup();
        optionsPreferedFood.getToggles().addAll(veggie, vegan, eatAll);

        preferedFood = new HBox();
        preferedFood.getChildren().addAll(veggie, vegan, eatAll);
        preferedFood.setAlignment(Pos.CENTER);
        preferedFood.setSpacing(20);

        questionIncompatibility = new Label("Was verträgst du nicht?");
        questionIncompatibility.setFont(Font.font("Calibri", 25));
        questionIncompatibility.setMinHeight(50);

        lactose = new CheckBox("Lactose");
        lactose.setFont(Font.font("Calibri", 20));
        lactose.setMinHeight(50);
        lactose.setMinWidth(100);

        gluten = new CheckBox("Gluten");
        gluten.setFont(Font.font("Calibri", 20));
        gluten.setMinHeight(50);
        gluten.setMinWidth(100);

        wheat = new CheckBox("Weizen");
        wheat.setFont(Font.font("Calibri", 20));
        wheat.setMinHeight(50);
        wheat.setMinWidth(100);

        incompatibility = new HBox();
        incompatibility.getChildren().addAll(lactose, gluten, wheat);
        incompatibility.setAlignment(Pos.CENTER);
        incompatibility.setSpacing(20);

        registrationCancel = new Button("Abbrechen und zum Hauptmenü zurückkehren");
        registrationCancel.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        registrationSave = new Button("Profil speichern");
        registrationSave.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        registrationButtons = new HBox();
        registrationButtons.setAlignment(Pos.CENTER);
        registrationButtons.setSpacing(10);
        registrationButtons.setMinHeight(75);
        registrationButtons.getChildren().addAll(registrationCancel, registrationSave);

        // Adding of all components to the panes and finally to the scene

        registrationVBox = new VBox();
        registrationVBox.setAlignment(Pos.CENTER);
        registrationVBox.setSpacing(10);
        registrationVBox.getChildren().addAll(registrationTitle, questionNickname, nickname, questionName, name, questionLiving, street, place, questionPhone, phoneTextField, questionAge, ageTextField,
                questionGender, gender, questionHeight, heightTextField, questionweight, weightTextField, questionPreferedFood, preferedFood, questionIncompatibility, incompatibility);

        registrationHBox = new HBox();
        registrationHBox.setAlignment(Pos.CENTER);
        registrationHBox.getChildren().add(registrationVBox);

        registrationScrollPane = new ScrollPane();
        registrationScrollPane.setFitToWidth(true);
        registrationScrollPane.setPannable(true);
        registrationScrollPane.setContent(registrationHBox);
        registrationScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        registrationBorderPane = new BorderPane();
        registrationBorderPane.setTop(registrationTitle);
        registrationBorderPane.setCenter(registrationScrollPane);
        registrationBorderPane.setBottom(registrationButtons);

        registrationScene = new Scene(registrationBorderPane);
        mainStage.setScene(registrationScene);
        mainStage.setMaximized(false);
        mainStage.setMaximized(true);

        // ActionListeners for the buttons

        registrationSave.setOnAction(actionEvent -> {
            startController = new StartController();
            String nick = nickname.getText();
            String forename = forenameTextField.getText();
            String surname = surnameTextField.getText();
            String street = streetNameTextField.getText();
            int streetNumber = Integer.parseInt(streetNumberTextField.getText());
            int postCode = Integer.parseInt(postcodeTextField.getText());
            String city = cityTextField.getText();
            int phone = Integer.parseInt(phoneTextField.getText());
            int age = Integer.parseInt(ageTextField.getText());
            String gender = optionsGender.getSelectedToggle().toString();
            int height = Integer.parseInt(heightTextField.getText());
            int weight = Integer.parseInt(weightTextField.getText());
            String preferedFood = optionsPreferedFood.getSelectedToggle().toString();
            ArrayList<String> incompatibilities = new ArrayList<>();
            if(lactose.isSelected()){
                incompatibilities.add(lactose.getText());
            }
            if(gluten.isSelected()){
                incompatibilities.add(gluten.getText());
            }
            if(wheat.isSelected()){
                incompatibilities.add(wheat.getText());
            }
            startController.callSaveUser(nick, forename, surname, street, streetNumber, postCode, city, phone, age, gender, height, weight, preferedFood, incompatibilities);
            dailyRoutineScene = new DailyRoutineScene();
            dailyRoutineScene.setScene(nick);
        });

        registrationCancel.setOnAction(actionEvent -> {
            mainMenuScene.setScene();
        });

    }
}