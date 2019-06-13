package gui;

import javafx.scene.control.Button;

public class OrderButton extends Button {

    MenuCardScene menuCardScene;

    public OrderButton(String text, MenuCardScene menuCardScene){
        setMinWidth(25);
        setMinHeight(25);
        setText(text);
        this.menuCardScene = menuCardScene;
        setOnAction(actionEvent -> {
            menuCardScene.handleOrderButtonEvent(this);
        });
    }
}
