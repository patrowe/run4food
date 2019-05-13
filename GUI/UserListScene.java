package GUI;

import Controller.UserManagementController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UserListScene {

    private Stage mainStage;
    private Scene scene;
    private Label heading;
    private Button backToMenu;
    private HBox hbox;
    private UserManagementController userManagementController;
    private BorderPane borderPane;

    UserListScene(){
        userManagementController = new UserManagementController();
    }

    public void setScene(Stage stage){

        mainStage = stage;

        heading = new Label("Profile");
        heading.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        heading.setMinHeight(100);
        heading.setPadding(new Insets(10));

        backToMenu = new Button("Abbrechen und zum Hauptmenü zurückkehren");
        backToMenu.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        hbox.setMinHeight(75);
        hbox.getChildren().addAll(backToMenu);

        borderPane = new BorderPane();
        borderPane.setTop(heading);
        borderPane.setBottom(hbox);

        scene = new Scene(borderPane);
        mainStage.setScene(scene);
        mainStage.setMaximized(false);
        mainStage.setMaximized(true);
    }
}
