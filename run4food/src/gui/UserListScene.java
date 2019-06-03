package gui;

import com.sun.tools.javac.Main;
import controller.MasterController;
import controller.StartController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;


public class UserListScene extends StandardScene{

    private Label heading;
    private Button backToMenu;
    private HBox hbox;
    private VBox vBox;
    private StartController startController;
    private BorderPane borderPane;
    private ArrayList<String> nickList;

    public void setScene(StandardScene standardScene, MasterController masterController){

        heading = new Label("Profile");
        heading.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        heading.setMinHeight(100);
        heading.setPadding(new Insets(10));

        nickList = new ArrayList<>();
        startController = new StartController(masterController);
        nickList = startController.loadNicknames();

        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        for(String nick : nickList){
            vBox.getChildren().add(new ProfileListButton(nick, standardScene, masterController));
        }


        backToMenu = new Button("Abbrechen und zum Hauptmenü zurückkehren");
        backToMenu.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        hbox.setMinHeight(75);
        hbox.getChildren().addAll(backToMenu);

        borderPane = new BorderPane();
        borderPane.setTop(heading);
        borderPane.setCenter(vBox);
        borderPane.setBottom(hbox);

        standardScene.setSceneContent(borderPane);

        backToMenu.setOnAction(actionEvent -> {
            MainMenuScene mainMenuScene = new MainMenuScene();
            mainMenuScene.setScene(standardScene, masterController);
        });
    }
}
