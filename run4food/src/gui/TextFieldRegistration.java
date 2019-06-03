package gui;

import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class TextFieldRegistration extends TextField {
    TextFieldRegistration(String string){
        setMaxWidth(200);
        setText(string);
        setFont(Font.font("Calibri", 20));
    }
}
