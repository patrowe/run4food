package gui;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class NavigationButton extends Button {

    public NavigationButton(String text){
        this.setText(text);
        this.setFont(Font.font("Calibri", FontWeight.BOLD, 25));
    }
}
