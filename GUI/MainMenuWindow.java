package GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainMenuWindow extends Application {

    private Stage mainStage;
    private MainMenuScene mainMenuScene;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        mainStage.setTitle("WeRun4Food");
        mainStage.setMaximized(true);
        mainMenuScene = new MainMenuScene();
        mainMenuScene.setScene(mainStage);

    }

}

