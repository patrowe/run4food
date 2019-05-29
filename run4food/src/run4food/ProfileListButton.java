package gui;

import controller.StartController;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ProfileListButton extends Button{

    private StartController startController;

    public ProfileListButton(String string){
        this.setFont(Font.font("Calibri", 25));
        this.setMaxWidth(600);
        this.setMinHeight(50);
        this.setText(string);
        setOnAction(actionEvent -> {
            startController = new StartController();
            startController.callLoadOneUser(this.getText());
        });
    }

}
