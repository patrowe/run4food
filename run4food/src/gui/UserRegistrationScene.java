package gui;

import controller.MasterController;
import controller.StartController;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;

/**
 * @author Christoph
 * Diese Klasse ist für das Fenster verantwortlich, in dem der Nutzer seine Daten eingeben und damit sein eigenes
 * Profil erstellen kann.
 */

public class UserRegistrationScene extends RegistrationScene{

    TextField nickname;
    VBox registrationVBox;
    private Button registrationSave;
    private DailyRoutineScene dailyRoutineScene;
    private MasterController masterController;
    private StandardScene standardScene;

    UserRegistrationScene(){
        super();
    }

    public void setScene(StandardScene standardScene, MasterController masterController){
        super.setScene(standardScene, masterController, "Registrierung");
        this.standardScene = standardScene;
        this.masterController = masterController;

        questionNickname = new Label("Wie soll ich dich nennen?");
        questionNickname.setFont(Font.font("Calibri", 25));
        questionNickname.setMinHeight(50);

        nickname = new TextField();
        nickname.setMinHeight(35);
        nickname.setMinWidth(200);
        nickname.setFont(Font.font("Calibri", 20));

        LabelRegistrationHints nickNameHint = new LabelRegistrationHints("(Nickname)", 200);

        registrationSave = new Button("Profil speichern");
        registrationSave.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        super.registrationButtons.getChildren().add(registrationSave);

        this.registrationVBox = super.registrationVBox;

        //Die registrationVBox wird von der erbenden Klasse erstellt und hier werden ihr nur die Elemente zugeordnet.
        this.registrationVBox.getChildren().addAll(questionNickname, nickname, nickNameHint, questionName, nameHBox, nameHints,
                questionLiving, streetHBox, streetHints, cityHBox, cityHints, questionPhone, phoneHBox, phoneHint, questionAge, ageHBox, ageHint,
                questionGender, gender, questionHeight, heightHBox, heightHint, questionweight, weightHBox, weightHint, questionPreferedFood, preferedFood, questionIncompatibility, incompatibility);

        this.standardScene.setSceneContent(super.registrationBorderPane);

        // ActionListener bzw. -handler

        /**
         * Dieser ActionListener bzw. -handler liest den Inhalt der Textfelder aus und gibt sie an den startController weiterm
         * der aus den Daten ein Profil erstellen lässt.
         */
        registrationSave.setOnAction(actionEvent -> {
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
            this.masterController.getStartController().callSaveUser(nick, forename, surname, street, streetNumber, postCode, city, phone, age, gender, height, weight, preferedFood, incompatibilities);
            this.dailyRoutineScene = new DailyRoutineScene();
            this.dailyRoutineScene.setScene(this.standardScene, this.masterController);
        });



    }
}
