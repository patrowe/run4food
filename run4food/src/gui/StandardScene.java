package gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

class StandardScene {

    private Stage mainStage;
    private Scene mainScene;
    private RegistrationScene registrationScene;
    private UserRegistrationScene userRegistrationScene;
    private GuestRegistrationScene guestRegistrationScene;
    private DailyRoutineScene dailyRoutineScene;

    StandardScene(){

    }

    StandardScene(Stage stage){
        this.mainStage = stage;
        this.mainScene = new Scene(new BorderPane());
        this.mainStage.setScene(this.mainScene);
        this.mainStage.setTitle("WeRun4Food");
        this.mainStage.setMaximized(true);
        this.mainStage.show();
        registrationScene = new RegistrationScene();
        userRegistrationScene = new UserRegistrationScene();
        guestRegistrationScene = new GuestRegistrationScene();
        dailyRoutineScene = new DailyRoutineScene();
    }

    public RegistrationScene getRegistrationScene() {
        return registrationScene;
    }

    public UserRegistrationScene getUserRegistrationScene() {
        return userRegistrationScene;
    }

    public GuestRegistrationScene getGuestRegistrationScene() {
        return guestRegistrationScene;
    }

    public DailyRoutineScene getDailyRoutineScene() {
        return dailyRoutineScene;
    }

    void setSceneContent(Parent parent){
        this.mainScene.setRoot(parent);
    }

}
