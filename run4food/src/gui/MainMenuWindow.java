package gui;

import controller.MasterController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Christoph
 */

public class MainMenuWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @param stage: Ein neues Fenster, erstmal ohne Inhalt
     * Das ist die Methode, die den JavaFX-Teil des Programms startet. masterController und standardScene werden erstellt
     * und weitergereicht, damit dort der aktuelle Nutzer, Stage und Szene gespeichert werden.
     */
    @Override
    public void start(Stage stage) {
        StandardScene standardScene = new StandardScene(stage);
        MasterController masterController = new MasterController();
        MainMenuScene mainMenuScene = new MainMenuScene();
        mainMenuScene.setScene(standardScene, masterController);

    }

}

