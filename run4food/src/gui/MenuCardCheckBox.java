package gui;

import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.Iterator;

public class MenuCardCheckBox extends CheckBox {

    public MenuCardCheckBox(VBox vbox){
        setOnAction(actionEvent -> {
                    Iterator iterator = vbox.getChildren().iterator();
                    if (this.isSelected()) {
                        while (iterator.hasNext()) {
                            CheckBox box = (CheckBox) iterator.next();
                            if (!(box.equals(this))) {
                                box.setDisable(true);
                            }
                        }
                    } else {
                        while (iterator.hasNext()) {
                            CheckBox box = (CheckBox) iterator.next();
                            if (!(box.equals(this))) {
                                box.setDisable(false);
                            }


                        }
                    }
        }
        );
    }

}
