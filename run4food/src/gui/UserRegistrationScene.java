package gui;

import controller.MasterController;
import controller.StartController;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;

public class UserRegistrationScene extends RegistrationScene{

    private TextFieldRegistration nickname;
    private Button registrationSave;
    private StartController startController;
    private DailyRoutineScene dailyRoutineScene;

    UserRegistrationScene(){
        super();
    }

    public void setScene(StandardScene standardScene, MasterController masterController){
        super.setScene(standardScene, masterController, "Registrierung");

        questionNickname = new Label("Wie soll ich dich nennen?");
        questionNickname.setFont(Font.font("Calibri", 25));
        questionNickname.setMinHeight(50);

        nickname = new TextFieldRegistration("");
        nickname.setFont(Font.font("Calibri", 20));

        LabelRegistrationHints nickNameHint = new LabelRegistrationHints("(Nickname)", 200);

        registrationSave = new Button("Profil speichern");
        registrationSave.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        super.registrationButtons.getChildren().add(registrationSave);

        super.registrationVBox.getChildren().addAll(questionNickname, nickname, nickNameHint, questionName, nameHBox, nameHints,
                questionLiving, streetHBox, streetHints, cityHBox, cityHints, questionPhone, phoneHBox, phoneHint, questionAge, ageHBox, ageHint,
                questionGender, gender, questionHeight, heightHBox, heightHint, questionweight, weightHBox, weightHint, questionPreferedFood, preferedFood, questionIncompatibility, incompatibility);

        standardScene.setSceneContent(super.registrationBorderPane);

        // ActionListeners for the buttons

        registrationSave.setOnAction(actionEvent -> {
            startController = new StartController(masterController);
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
            masterController.setNickname(nick);
            dailyRoutineScene.setScene(standardScene, masterController);
        });



    }
}
