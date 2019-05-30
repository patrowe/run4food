package gui;

import controller.StartController;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StandardButton extends Button{

    private StartController startController;

    public StandardButton(String string){
        super.setFont(Font.font("Calibri", 25));
        super.setMaxWidth(600);
        super.setMinHeight(50);
        super.setText(string);

    }

}
