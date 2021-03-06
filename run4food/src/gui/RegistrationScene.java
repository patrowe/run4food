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
import java.util.regex.Pattern;

/**
 * @author Christoph
 * Diese Klasse erstellt alle GUI-Elemente, die sowohl bei der Registrierung des Users, als auch beim Login als Gast benötigt
 * werden.
 * Labels mit dem Zusatz "Error" sind Labels, durch die eine Fehlermeldung ausgegeben werden soll, wenn der Nutzer z.B.
 * Zahlen statt Buchstaben eingibt.
 * Labels mit dem Zusatz "Hint" sind Labels, die deutlich machen sollen, wofür das darüberliegende Textfeld bestimmt ist.
 */
public class RegistrationScene extends StandardScene{

    BorderPane registrationBorderPane;
    ScrollPane registrationScrollPane;
    VBox registrationVBox;
    HBox registrationHBox, nameHBox, nameHints, streetHBox, streetHints, cityHBox, cityHints, phoneHBox, ageHBox, gender, heightHBox, weightHBox, preferedFood, incompatibility, registrationButtons;
    Label registrationTitle, questionNickname, questionName, questionLiving, questionGender, questionPhone,
            questionAge, questionweight, questionHeight, questionPreferedFood, questionIncompatibility;
    private ErrorLabel nameError, streetError, cityError, phoneError, ageError, heightError, weightError;
    TextField forenameTextField, surnameTextField, streetNameTextField, cityTextField, streetNumberTextField, postcodeTextField, phoneTextField, ageTextField, weightTextField, heightTextField;
    LabelRegistrationHints forenameHint, surnameHint, streetNameHint, streetNumberHint, postcodeHint, cityHint, ageHint, phoneHint, heightHint, weightHint;
    CheckBox gluten, wheat, lactose;
    RadioButton veggie, vegan, eatAll, male, female;
    ToggleGroup optionsPreferedFood, optionsGender;
    Button registrationCancel;
    MainMenuScene mainMenuScene;

    RegistrationScene(){
        super();
    }

    public void setScene(StandardScene standardScene, MasterController masterController, String title){

        registrationTitle = new Label(title);
        registrationTitle.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        registrationTitle.setMinHeight(100);
        registrationTitle.setPadding(new Insets(10));

        questionName = new Label("Wie heißt du?");
        questionName.setFont(Font.font("Calibri", FontWeight.NORMAL, 25));
        questionName.setMinHeight(50);

        nameError = new ErrorLabel();

        final Pattern namePattern = Pattern.compile("(^$|^([A-Za-zäÄöÖüÜß]+[ -]?)*)");

        TextFormatter<?> forenameFormatter = new TextFormatter<>(change -> {
            if(namePattern.matcher(change.getControlNewText()).matches()) {
                nameError.setText("");
                return change;
            }else{
                nameError.setText("Failed");
                nameError.setRed();
                return null;
            }
        });

        forenameTextField = new TextField();
        forenameTextField.setMinHeight(35);
        forenameTextField.setMinWidth(200);
        forenameTextField.setTextFormatter(forenameFormatter);

        TextFormatter<?> surnameFormatter = new TextFormatter<>(change -> {
            if(namePattern.matcher(change.getControlNewText()).matches()) {
                nameError.setText("");
                return change;
            }else{
                nameError.setText("Failed");
                nameError.setRed();
                return null;
            }
        });

        surnameTextField = new TextField();
        surnameTextField.setMinHeight(35);
        surnameTextField.setMinWidth(200);
        surnameTextField.setTextFormatter(surnameFormatter);

        forenameHint = new LabelRegistrationHints("(Vorname)", 200);
        surnameHint = new LabelRegistrationHints("(Nachname)", 200);

        nameHBox = new HBox();
        nameHBox.setSpacing(35);
        nameHBox.getChildren().addAll(forenameTextField, surnameTextField, nameError);

        nameHints = new HBox();
        nameHints.setSpacing(35);
        nameHints.getChildren().addAll(forenameHint, surnameHint);

        questionLiving = new Label("Wo lebst du?");
        questionLiving.setFont(Font.font("Calibri", FontWeight.NORMAL, 25));
        questionLiving.setMinHeight(50);

        streetError = new ErrorLabel();

        Pattern streetNamePattern = Pattern.compile("(^$|^([A-Za-zäÄöÖüÜß]+[ -]?)*[.]?)");

        TextFormatter<?> streetNameFormatter = new TextFormatter<>(change -> {
            if(streetNamePattern.matcher(change.getControlNewText()).matches()) {
                streetError.setText("");
                return change;
            }else{
                streetError.setText("Failed");
                streetError.setRed();
                return null;
            }
        });

        streetNameTextField = new TextField();
        streetNameTextField.setMinHeight(35);
        streetNameTextField.setMinWidth(200);
        streetNameTextField.setTextFormatter(streetNameFormatter);

        Pattern streetNumberPattern = Pattern.compile("(|^[1-9]\\d{0,2}$)");

        TextFormatter<?> streetNumberFormatter = new TextFormatter<>(change -> {
            if(streetNumberPattern.matcher(change.getControlNewText()).matches()) {
                streetError.setText("");
                return change;
            }else{
                streetError.setText("Failed");
                streetError.setRed();
                return null;
            }
        });

        streetNumberTextField = new TextField();
        streetNumberTextField.setMinHeight(35);
        streetNumberTextField.setMinWidth(200);
        streetNumberTextField.setTextFormatter(streetNumberFormatter);

        streetHBox = new HBox();
        streetHBox.setSpacing(20);
        streetHBox.getChildren().addAll(streetNameTextField, streetNumberTextField, streetError);

        streetNameHint = new LabelRegistrationHints("(Straße)", 200);
        streetNumberHint = new LabelRegistrationHints("(Hausnummer)", 200);

        streetHints = new HBox();
        streetHints.setSpacing(20);
        streetHints.getChildren().addAll(streetNameHint, streetNumberHint);

        cityError = new ErrorLabel();

        final Pattern zipcodePattern = Pattern.compile("(|[1-9]\\d{0,4})");
        TextFormatter<?> zipCodeFormatter = new TextFormatter<>(change -> {
            if(zipcodePattern.matcher(change.getControlNewText()).matches()) {
                cityError.setText("");
                return change;
            }else{
                cityError.setText("Failed");
                cityError.setRed();
                return null;
                }
        });

        postcodeTextField = new TextField();
        postcodeTextField.setMinHeight(35);
        postcodeTextField.setMinWidth(200);
        postcodeTextField.setTextFormatter(zipCodeFormatter);

        TextFormatter<?> cityFormatter = new TextFormatter<>(change -> {
            if(namePattern.matcher(change.getControlNewText()).matches()) {
                cityError.setText("");
                return change;
            }else{
                cityError.setText("Failed");
                cityError.setRed();
                return null;
            }
        });

        cityTextField = new TextField();
        cityTextField.setMinHeight(35);
        cityTextField.setMinWidth(200);
        cityTextField.setTextFormatter(cityFormatter);

        cityHBox = new HBox();
        cityHBox.setSpacing(20);
        cityHBox.getChildren().addAll(postcodeTextField, cityTextField, cityError);

        postcodeHint = new LabelRegistrationHints("(PLZ)", 200);
        cityHint = new LabelRegistrationHints("(Stadt)", 200);

        cityHints = new HBox();
        cityHints.setSpacing(20);
        cityHints.getChildren().addAll(postcodeHint, cityHint);

        questionPhone = new Label("Unter welcher Telefonnummer bist du erreichbar?");
        questionPhone.setFont(Font.font("Calibri", 25));
        questionPhone.setMinHeight(50);

        Pattern phonePattern = Pattern.compile("^\\+?[0-9]*");

        TextFormatter<?> phoneFormatter = new TextFormatter<>(change -> {
            if(phonePattern.matcher(change.getControlNewText()).matches()) {
                phoneError.setText("");
                return change;
            }else{
                phoneError.setText("Failed");
                phoneError.setRed();
                return null;
            }
        });

        phoneError = new ErrorLabel();

        phoneTextField = new TextField();
        phoneTextField.setMinHeight(35);
        phoneTextField.setMinWidth(200);
        phoneTextField.setTextFormatter(phoneFormatter);

        phoneHint = new LabelRegistrationHints("(Telefonnummer)", 200);

        phoneHBox = new HBox();
        phoneHBox.setSpacing(20);
        phoneHBox.getChildren().addAll(phoneTextField, phoneError);

        questionAge = new Label("Wie jung bist du?");
        questionAge.setFont(Font.font("Calibri", 25));
        questionAge.setMinHeight(50);

        TextFormatter<?> ageFormatter = new TextFormatter<>(change -> {
            if(streetNumberPattern.matcher(change.getControlNewText()).matches()) {
                ageError.setText("");
                return change;
            }else{
                ageError.setText("Failed");
                ageError.setRed();
                return null;
            }
        });

        ageError = new ErrorLabel();

        ageTextField = new TextField();
        ageTextField.setMinHeight(35);
        ageTextField.setMinWidth(200);
        ageTextField.setTextFormatter(ageFormatter);

        ageHBox = new HBox();
        ageHBox.setSpacing(20);
        ageHBox.getChildren().addAll(ageTextField, ageError);

        ageHint = new LabelRegistrationHints("(Alter)", 200);

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

        optionsGender = new ToggleGroup();
        optionsGender.getToggles().addAll(male, female);

        gender = new HBox();
        gender.setAlignment(Pos.CENTER);
        gender.setSpacing(20);
        gender.getChildren().addAll(male, female);

        questionHeight = new Label("Wie groß bist du?");
        questionHeight.setFont(Font.font("Calibri", 25));
        questionHeight.setMinHeight(50);

        heightError = new ErrorLabel();

        TextFormatter<?> heightFormatter = new TextFormatter<>(change -> {
            if(streetNumberPattern.matcher(change.getControlNewText()).matches()) {
                heightError.setText("");
                return change;
            }else{
                heightError.setText("Failed");
                heightError.setRed();
                return null;
            }
        });

        heightTextField = new TextField();
        heightTextField.setMinHeight(35);
        heightTextField.setMinWidth(200);
        heightTextField.setTextFormatter(heightFormatter);

        heightHBox = new HBox();
        heightHBox.setSpacing(20);
        heightHBox.getChildren().addAll(heightTextField, heightError);

        heightHint = new LabelRegistrationHints("(Körpergröße in cm)", 200);

        questionweight = new Label("Was für ein Gewicht zeigt deine Waage an?");
        questionweight.setFont(Font.font("Calibri", 25));
        questionweight.setMinHeight(50);

        weightError = new ErrorLabel();

        TextFormatter<?> weightFormatter = new TextFormatter<>(change -> {
            if(streetNumberPattern.matcher(change.getControlNewText()).matches()) {
                weightError.setText("");
                return change;
            }else{
                weightError.setText("Failed");
                weightError.setRed();
                return null;
            }
        });

        weightTextField = new TextField();
        weightTextField.setMinHeight(35);
        weightTextField.setMinWidth(200);
        weightTextField.setTextFormatter(weightFormatter);

        weightHBox = new HBox();
        weightHBox.setSpacing(20);
        weightHBox.getChildren().addAll(weightTextField, weightError);

        weightHint = new LabelRegistrationHints("(Körpergewicht in kg)", 200);

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

        registrationButtons = new HBox();
        registrationButtons.setAlignment(Pos.CENTER);
        registrationButtons.setSpacing(10);
        registrationButtons.setMinHeight(75);
        registrationButtons.getChildren().add(registrationCancel);

        registrationVBox = new VBox();

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

        /**
         * Hier kommt der ActionListener bzw. handler, der dafür sorgt, dass der Nutzer zum Menü zurückkehren kann.
         */

        registrationCancel.setOnAction(actionEvent -> {
            mainMenuScene = new MainMenuScene();
            mainMenuScene.setScene(standardScene, masterController);
        });

    }
}
