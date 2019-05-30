package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainMenuWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("WeRun4Food");
        StandardScene.mainStage = stage;
        BorderPane borderPane = new BorderPane();
        StandardScene.scene = new Scene(borderPane);
        StandardScene.mainStage.setScene(StandardScene.scene);
        StandardScene.mainStage.setMaximized(true);
        StandardScene.mainStage.show();
        MainMenuScene mainMenuScene = new MainMenuScene();
        mainMenuScene.setScene();

    }

}

