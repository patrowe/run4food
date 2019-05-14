package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AboutScene {

    private Stage mainStage;
    private Scene scene;
    private Label heading;
    private Text text;
    private Button backToMenu;
    private HBox hbox;
    private BorderPane borderPane;
    private MainMenuScene mainMenuScene;

    AboutScene(){
        mainMenuScene = new MainMenuScene();
    }

    public void setScene(Stage stage){

        mainStage = stage;

        heading = new Label("Über WeRun4Food");
        heading.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        heading.setMinHeight(100);
        heading.setPadding(new Insets(10));

        text = new Text("Hier steht etwas über das Programm.");
        text.setFont(Font.font("Calibri", 14));

        backToMenu = new Button("Zurück zum Hauptmenü");
        backToMenu.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setMinHeight(75);
        hbox.getChildren().add(backToMenu);

        borderPane = new BorderPane();
        borderPane.setTop(heading);
        borderPane.setCenter(text);
        borderPane.setBottom(hbox);

        scene = new Scene(borderPane);
        mainStage.setScene(scene);
        mainStage.setMaximized(false);
        mainStage.setMaximized(true);

        backToMenu.setOnAction(actionEvent -> {
            mainMenuScene.setScene(mainStage);
        });

    }
}
