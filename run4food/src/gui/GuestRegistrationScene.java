package gui;

import controller.MasterController;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class GuestRegistrationScene extends RegistrationScene{

    private Button registrationSave;
    private MasterController masterController;
    private StandardScene standardScene;
    private DailyRoutineScene dailyRoutineScene;

    GuestRegistrationScene(){
        mainMenuScene = new MainMenuScene();
    }

    public void setScene(StandardScene standardScene, MasterController masterController){

        this.masterController = masterController;
        this.standardScene = standardScene;

        super.setScene(this.standardScene, this.masterController, "Anmeldung als Gast");

        registrationSave = new Button("Mit diesen Daten anmelden");
        registrationSave.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        super.registrationButtons.getChildren().addAll(registrationSave);

        registrationVBox.getChildren().addAll(questionName, nameHBox, nameHints, questionLiving, streetHBox,
                streetHints, cityHBox, cityHints, questionPhone, phoneHBox, phoneHint, questionAge, ageHBox, ageHint,
                questionGender, gender, questionHeight, heightHBox, heightHint, questionweight, weightHBox,
                weightHint, questionPreferedFood, preferedFood, questionIncompatibility, incompatibility);

        standardScene.setSceneContent(registrationBorderPane);

        //
        // ActionListener für die Buttons
        //

        registrationSave.setOnAction(actionEvent -> {
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
            this.masterController.getStartController().saveGuest(forename, surname, street, streetNumber, postCode, city, phone, age, gender, height, weight, preferedFood, incompatibilities);
            this.dailyRoutineScene = new DailyRoutineScene();
            this.dailyRoutineScene.setScene(this.standardScene, this.masterController);
        });


    }
}
