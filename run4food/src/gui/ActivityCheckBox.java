package gui;

import javafx.scene.control.CheckBox;

public class ActivityCheckBox extends CheckBox {

    public ActivityCheckBox(String s){
        super.setText(s);
        this.setMinHeight(25);
        this.setMinWidth(150);
    }
}
