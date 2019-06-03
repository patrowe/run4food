package gui;

import controller.MasterController;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainMenuWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StandardScene standardScene = new StandardScene(stage);
        MasterController masterController = new MasterController();
        MainMenuScene mainMenuScene = new MainMenuScene();
        mainMenuScene.setScene(standardScene, masterController);

    }

}

