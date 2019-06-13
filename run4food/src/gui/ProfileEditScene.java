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
import java.util.regex.Pattern;

public class ProfileEditScene{

    private StandardScene standardScene;
    private DailyRoutineScene dailyRoutineScene;
    private MasterController masterController;
    private Label editTitle, nicknameLabel, forenameLabel, surnameLabel, streetNameLabel, streetNumberLabel, postcodeLabel,
            cityLabel, phoneLabel, ageLabel, genderLabel, heightLabel, weightLabel, preferedFoodLabel, incompatibilityLabel;
    TextField nickname, forenameTextField, surnameTextField, streetNameTextField, cityTextField, streetNumberTextField,
            postcodeTextField, phoneTextField, ageTextField, weightTextField, heightTextField;
    private Button editCancel, editSave, deleteProfile;
    private VBox contentVBox;
    private HBox nicknameHBox, nameHBox, streetHBox, cityHBox, phoneHBox, ageHBox, gender, heightHBox, weightHBox, preferedFoodHBox, incompatibilityHBox, hBoxForVBox, editButtons;
    private ErrorLabel nameError, streetError, cityError, phoneError, ageError, heightError, weightError;
    CheckBox gluten, wheat, lactose;
    RadioButton veggie, vegan, eatAll, male, female;
    ToggleGroup optionsPreferedFood, optionsGender;
    ScrollPane scrollPane;
    private BorderPane borderPane;

    public void setScene(StandardScene standardScene, MasterController masterController){
        this.standardScene = standardScene;
        this.masterController = masterController;

        editTitle = new Label("Profiländerung");
        editTitle.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        editTitle.setMinHeight(100);
        editTitle.setPadding(new Insets(10));

        nicknameLabel = new Label("Nickname:");

        nickname = new TextField(this.masterController.getNickname());
        nickname.setDisable(true);
        nickname.setMinHeight(35);
        nickname.setMinWidth(200);
        nickname.setFont(Font.font("Calibri", 20));

        nicknameHBox = new HBox();
        nicknameHBox.setSpacing(10);
        nicknameHBox.setAlignment(Pos.CENTER);
        nicknameHBox.getChildren().addAll(nicknameLabel, nickname);

        nameError = new ErrorLabel();

        forenameLabel = new Label("Vorname:");

        final Pattern namePattern = Pattern.compile("^(|[A-Z][a-z]*)");

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

        forenameTextField = new TextField(masterController.getUser().getFirstname());
        forenameTextField.setMinHeight(35);
        forenameTextField.setMinWidth(200);
        forenameTextField.setFont(Font.font("Calibri", 20));
        forenameTextField.setTextFormatter(forenameFormatter);

        surnameLabel = new Label("Nachname:");

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

        surnameTextField = new TextField(this.masterController.getUser().getSurname());
        surnameTextField.setMinHeight(35);
        surnameTextField.setMinWidth(200);
        surnameTextField.setFont(Font.font("Calibri", 20));
        forenameTextField.setTextFormatter(surnameFormatter);

        nameHBox = new HBox();
        nameHBox.setSpacing(10);
        nameHBox.setAlignment(Pos.CENTER);
        nameHBox.getChildren().addAll(forenameLabel, forenameTextField, surnameLabel, surnameTextField);

        streetError = new ErrorLabel();

        Pattern streetNamePattern = Pattern.compile("^(|[A-Z][a-z]*\\.?)");

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

        streetNameLabel = new Label("Straße:");

        streetNameTextField = new TextField(masterController.getUser().getStreet());
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

        streetNumberLabel = new Label("Hausnummer:");

        streetNumberTextField = new TextField(String.valueOf(this.masterController.getUser().getStreetNumber()));
        streetNumberTextField.setMinHeight(35);
        streetNumberTextField.setMinWidth(200);
        streetNumberTextField.setTextFormatter(streetNumberFormatter);

        streetHBox = new HBox();
        streetHBox.setSpacing(20);
        streetHBox.setAlignment(Pos.CENTER);
        streetHBox.getChildren().addAll(streetNameLabel, streetNameTextField, streetNumberLabel, streetNumberTextField, streetError);

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

        postcodeLabel = new Label("PLZ:");

        postcodeTextField = new TextField(String.valueOf(this.masterController.getUser().getPostCode()));
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

        cityLabel = new Label("Stadt:");

        cityTextField = new TextField(this.masterController.getUser().getCity());
        cityTextField.setMinHeight(35);
        cityTextField.setMinWidth(200);
        cityTextField.setTextFormatter(cityFormatter);

        cityHBox = new HBox();
        cityHBox.setSpacing(20);
        cityHBox.setAlignment(Pos.CENTER);
        cityHBox.getChildren().addAll(postcodeLabel, postcodeTextField, cityLabel, cityTextField, cityError);

        phoneError = new ErrorLabel();

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

        phoneLabel = new Label("Telefonnummer:");

        phoneTextField = new TextField(Integer.toString(this.masterController.getUser().getPhone()));
        phoneTextField.setMinHeight(35);
        phoneTextField.setMinWidth(200);
        phoneTextField.setTextFormatter(phoneFormatter);

        phoneHBox = new HBox();
        phoneHBox.setSpacing(20);
        phoneHBox.setAlignment(Pos.CENTER);
        phoneHBox.getChildren().addAll(phoneLabel, phoneTextField, phoneError);

        ageError = new ErrorLabel();

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

        ageLabel = new Label("Alter:");

        ageTextField = new TextField(Integer.toString(this.masterController.getUser().getAge()));
        ageTextField.setMinHeight(35);
        ageTextField.setMinWidth(200);
        ageTextField.setTextFormatter(ageFormatter);

        ageHBox = new HBox();
        ageHBox.setSpacing(20);
        ageHBox.setAlignment(Pos.CENTER);
        ageHBox.getChildren().addAll(ageLabel, ageTextField, ageError);

        genderLabel = new Label("Geschlecht:");

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

        if(this.masterController.getUser().getGender().equals("Weiblich")){
            female.setSelected(true);
        }else{
            male.setSelected(true);
        }

        heightLabel = new Label("Körpergröße (in cm):");

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

        heightTextField = new TextField(Integer.toString(this.masterController.getUser().getHeight()));
        heightTextField.setMinHeight(35);
        heightTextField.setMinWidth(200);
        heightTextField.setTextFormatter(heightFormatter);

        heightHBox = new HBox();
        heightHBox.setSpacing(20);
        heightHBox.setAlignment(Pos.CENTER);
        heightHBox.getChildren().addAll(heightLabel, heightTextField, heightError);

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

        weightLabel = new Label("Gewicht (in kg):");

        weightTextField = new TextField(Integer.toString(this.masterController.getUser().getWeight()));
        weightTextField.setMinHeight(35);
        weightTextField.setMinWidth(200);
        weightTextField.setTextFormatter(weightFormatter);

        weightHBox = new HBox();
        weightHBox.setSpacing(20);
        weightHBox.setAlignment(Pos.CENTER);
        weightHBox.getChildren().addAll(weightLabel, weightTextField, weightError);

        preferedFoodLabel = new Label("Essgewohnheit:");

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

        String s = this.masterController.getUser().getPreferedFood();
        if(s.equals("Vegetarisch")){
            veggie.setSelected(true);
        }else if(s.equals("Vegan")){
            vegan.setSelected(true);
        }else {
            eatAll.setSelected(true);
        }

        preferedFoodHBox = new HBox();
        preferedFoodHBox.getChildren().addAll(veggie, vegan, eatAll);
        preferedFoodHBox.setAlignment(Pos.CENTER);
        preferedFoodHBox.setSpacing(20);

        incompatibilityLabel = new Label("Unverträglichkeiten:");

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

        incompatibilityHBox = new HBox();
        incompatibilityHBox.getChildren().addAll(lactose, gluten, wheat);
        incompatibilityHBox.setAlignment(Pos.CENTER);
        incompatibilityHBox.setSpacing(20);

        ArrayList<String> incompatibilityList = this.masterController.getUser().getIncompatibilities();
        for(String t : incompatibilityList){
            if(t.equals("Lactose")){
                lactose.setSelected(true);
            }
            if(t.equals("Gluten")){
                gluten.setSelected(true);
            }
            if(t.equals("Weizen")){
                wheat.setSelected(true);
            }
        }



        contentVBox = new VBox();
        contentVBox.setAlignment(Pos.CENTER);
        contentVBox.setSpacing(10);
        contentVBox.getChildren().addAll(nicknameHBox, nameHBox, streetHBox, cityHBox, phoneHBox, ageHBox, genderLabel,
                gender, heightHBox, weightHBox, preferedFoodLabel, preferedFoodHBox, incompatibilityLabel, incompatibilityHBox);

        hBoxForVBox = new HBox();
        hBoxForVBox.setAlignment(Pos.CENTER);
        hBoxForVBox.getChildren().add(contentVBox);

        scrollPane = new ScrollPane();
        scrollPane.setPannable(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(hBoxForVBox);

        editCancel = new Button("Abbrechen");
        editCancel.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        editSave = new Button("Speichern");
        editSave.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        deleteProfile = new Button("Profil unwiderruflich löschen");
        deleteProfile.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        editButtons = new HBox();
        editButtons.setAlignment(Pos.CENTER);
        editButtons.setSpacing(10);
        editButtons.setMinHeight(75);
        editButtons.getChildren().addAll(editCancel, editSave, deleteProfile);

        borderPane = new BorderPane();
        borderPane.setTop(editTitle);
        borderPane.setCenter(scrollPane);
        borderPane.setBottom(editButtons);

        this.standardScene.setSceneContent(borderPane);

        editCancel.setOnAction(actionEvent -> {
            this.standardScene.getDailyRoutineScene().setScene(this.standardScene, this.masterController);
        });

        editSave.setOnAction(actionEvent -> {
            String nick = nickname.getText();
            String forename = forenameTextField.getText();
            String surname = surnameTextField.getText();
            String street = streetNameTextField.getText();
            int streetNumber = Integer.parseInt(streetNumberTextField.getText());
            int postCode = Integer.parseInt(postcodeTextField.getText());
            String city = cityTextField.getText();
            int phone = Integer.parseInt(phoneTextField.getText());
            int age = Integer.parseInt(ageTextField.getText());
            String gender;
            if(male.isSelected()){
                gender = "Männlich";
            }else{
                gender = "Weiblich";
            }
            int height = Integer.parseInt(heightTextField.getText());
            int weight = Integer.parseInt(weightTextField.getText());

            String preferedFood;
            if(veggie.isSelected()){
                preferedFood = "Vegetarisch";
            }else if(vegan.isSelected()){
                preferedFood = "Vegan";
            }else{
                preferedFood = "Alles";
            }

            ArrayList<String> incompatibilities = new ArrayList<>();
            if(lactose.isSelected()){
                incompatibilities.add("Lactose");
            }
            if(gluten.isSelected()){
                incompatibilities.add("Gluten");
            }
            if(wheat.isSelected()){
                incompatibilities.add("Weizen");
            }
            this.masterController.getStartController().callUpdateUser(nick, forename, surname, street, streetNumber, postCode, city, phone, age, gender, height, weight, preferedFood, incompatibilities);
            this.dailyRoutineScene = new DailyRoutineScene();
            this.dailyRoutineScene.setScene(this.standardScene, this.masterController);
        });

        deleteProfile.setOnAction(actionEvent -> {
            this.masterController.getStartController().callDeleteUser();
            MainMenuScene mainMenuScene = new MainMenuScene();
            mainMenuScene.setScene(standardScene, masterController);
        });

    }

}

