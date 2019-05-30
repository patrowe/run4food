package gui;

import controller.DailyRoutineController;
import controller.OrderController;
import controller.StartController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class StandardScene {

    private Stage mainStage;
    private Scene mainScene;


    StandardScene(Stage stage){
        this.mainStage = stage;
        this.mainScene = new Scene(new BorderPane());
        this.mainStage.setScene(this.mainScene);
        this.mainStage.setTitle("WeRun4Food");
        this.mainStage.setMaximized(true);
        this.mainStage.show();
    }

    StandardScene(){

    }

    void setSceneContent(Parent parent){
        this.mainScene.setRoot(parent);
    }

}
