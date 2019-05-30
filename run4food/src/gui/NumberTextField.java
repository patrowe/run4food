package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

// Source for methods: https://stackoverflow.com/a/18959399

public class NumberTextField extends TextField {



    public NumberTextField(String s){
        setText(s);
    }

    public NumberTextField(String text, int height){
        setText(text);
        setMinHeight(height);
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(3));
    }

    @Override
    public void replaceText(int start, int end, String text)
    {
        if (validate(text)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text)
    {
        if (validate(text))
        {
            super.replaceSelection(text);
        }
    }

    private boolean validate(String text)
    {
        return text.matches("[0-9]*");
    }

}