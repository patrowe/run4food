package gui;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ErrorLabel extends Label {

    ErrorLabel(){
        setFont(Font.font("Calibri", 11));
        setMinWidth(180);
        setMinHeight(35);
    }

    public void setRed(){
        setTextFill(Color.RED);
    }

    public void setBlack(){
        setTextFill(Color.BLACK);
    }
}
