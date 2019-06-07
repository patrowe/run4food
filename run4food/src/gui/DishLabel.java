package gui;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class DishLabel extends Label {

    DishLabel(String text){
        setMinWidth(250);
        setMinHeight(25);
        setFont(Font.font("Calibri", 16));
        setText(text);
    }
}
