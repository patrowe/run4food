package gui;

import controller.MasterController;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ProfileListButton extends Button{

    private MasterController masterController;
    private StandardScene standardScene;
    private DailyRoutineScene dailyRoutineScene;

    public ProfileListButton(String string, StandardScene standardScene, MasterController masterController){
        this.standardScene = standardScene;
        this.masterController = masterController;
        this.setFont(Font.font("Calibri", 25));
        this.setMaxWidth(600);
        this.setMinHeight(50);
        this.setText(string);
        setOnAction(actionEvent -> {
            this.masterController.getStartController().callLoadOneUser(this.getText());
            dailyRoutineScene = new DailyRoutineScene();
            dailyRoutineScene.setScene(this.standardScene, this.masterController);
        });
    }

}
