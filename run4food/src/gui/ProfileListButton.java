package gui;

import controller.MasterController;
import controller.StartController;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ProfileListButton extends Button{

    public ProfileListButton(String string, StandardScene standardScene, MasterController masterController){
        this.setFont(Font.font("Calibri", 25));
        this.setMaxWidth(600);
        this.setMinHeight(50);
        this.setText(string);
        setOnAction(actionEvent -> {
            StartController startController = new StartController(masterController);
            startController.callLoadOneUser(this.getText());
            DailyRoutineScene dailyRoutineScene = new DailyRoutineScene();
            dailyRoutineScene.setScene(standardScene, masterController);
        });
    }

}
