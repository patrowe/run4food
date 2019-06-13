package gui;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.regex.Pattern;

public class OrderTextfield extends TextField {

    private final Pattern quantityPattern = Pattern.compile("\\d{0,2}");

    public OrderTextfield(String text){
        this.setText(text);
        this.setTextFormatter(new TextFormatter<>(change -> {
            if(quantityPattern.matcher(change.getControlNewText()).matches()) {
                return change;
            }else{
                return null;
            }
        }));
    }
}
