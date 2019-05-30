package gui;

import javafx.scene.control.TextField;

// Source for methods: https://stackoverflow.com/a/18959399

public class NumberTextField extends TextField {

    private DailyRoutineScene dailyRoutineScene;

    public NumberTextField(String s){
        setText(s);
        dailyRoutineScene = new DailyRoutineScene();
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