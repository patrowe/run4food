package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

class LabelRegistrationHints extends Label {

     LabelRegistrationHints(String string, double d){
        setFont(Font.font("Calibri", 11));
        setAlignment(Pos.TOP_LEFT);
        setText(string);
        setMinHeight(20);
        setMinWidth(d);
    }
}
