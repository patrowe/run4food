package gui;

import javafx.scene.control.ChoiceBox;

public class ActivityChoiceBox<String> extends ChoiceBox<String> {

    public ActivityChoiceBox(String ...items){
        super.getItems().addAll(items);
    }

}
