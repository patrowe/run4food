package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class PreviewLabel extends Label {

    public PreviewLabel(String text){
        setText(text);
        setMinWidth(100);
        setMinHeight(25);
        setAlignment(Pos.CENTER);
        setFont(Font.font("Calibri", 12));
    }
}
