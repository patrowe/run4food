package gui;

import controller.MasterController;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GuestRegistrationScene extends RegistrationScene{

    private Button registrationSave;

    GuestRegistrationScene(){
        mainMenuScene = new MainMenuScene();
    }

    public void setScene(StandardScene standardScene, MasterController masterController){

        super.setScene(standardScene, masterController, "Anmeldung als Gast");

        registrationSave = new Button("Mit diesen Daten anmelden");
        registrationSave.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        super.registrationButtons.getChildren().addAll(registrationSave);

        registrationVBox.getChildren().addAll(questionName, nameHBox, nameHints, questionLiving, streetHBox,
                streetHints, cityHBox, cityHints, questionPhone, phoneHBox, phoneHint, questionAge, ageHBox, ageHint,
                questionGender, gender, questionHeight, heightHBox, heightHint, questionweight, weightHBox,
                weightHint, questionPreferedFood, preferedFood, questionIncompatibility, incompatibility);

        standardScene.setSceneContent(registrationBorderPane);

        registrationSave.setOnAction(actionEvent -> {

        });


    }
}
