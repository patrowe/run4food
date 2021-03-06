package gui;

import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class NumberTextField extends TextField{

    private ErrorLabel label;

    NumberTextField(String text, ErrorLabel label){
        setText(text);
        setFont(Font.font("Calibri", 17));
        setMinHeight(35);
        setMinWidth(200);
        setMaxWidth(200);
        this.label = label;
    }

    @Override
    public void replaceText(int start, int end, String text){
        if(check(text)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text){
        if(check(text)){
            super.replaceSelection(text);
        }
    }

    private boolean check(String text){
        if(text.matches("[0-9]*")){
            label.setText("");
            label.setBlack();
            return true;
        }else if(text.matches("[A-Za-z]")){
            label.setText("Du darfst hier keine Buchstaben eingeben.");
            label.setRed();
            return false;
        }else{
            label.setText("Du darfst hier nur Zahlen eingeben.");
            label.setRed();
            return false;
        }
    }

}