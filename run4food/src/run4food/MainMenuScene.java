package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainMenuScene extends StandardScene{

    private Button registration, loginAsUser, loginAsGuest, order, about;
    private Label welcome, heading;
    private BorderPane borderPane;
    private VBox vBox;
    private HBox hBox;
    private RegistrationScene registrationScene;
    private GuestLoginScene guestLoginScene;
    private UserListScene userListScene;
    private AboutScene aboutScene;

    public void setScene(){

        heading = new Label("Hauptmenü");
        heading.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        heading.setMinHeight(100);
        heading.setPadding(new Insets(10));

        welcome = new Label("Herzlich Willkommen bei WeRun4Food! Was möchtest du tun?");
        welcome.setMinHeight(160);
        welcome.setFont(Font.font("Calibri", FontWeight.LIGHT, 30));

        registration = new Button("Neuen Benutzer registrieren");
        registration.setFont(Font.font("Calibri", FontWeight.NORMAL, 22));
        registration.setMaxWidth(600);
        registration.setMinHeight(50);

        loginAsUser = new Button("Als registrierter Benutzer einloggen und bestellen");
        loginAsUser.setFont(Font.font("Calibri", FontWeight.NORMAL, 22));
        loginAsUser.setMaxWidth(600);
        loginAsUser.setMinHeight(50);

        loginAsGuest = new Button("Als Gast anmelden und bestellen");
        loginAsGuest.setFont(Font.font("Calibri", FontWeight.NORMAL, 22));
        loginAsGuest.setMaxWidth(600);
        loginAsGuest.setMinHeight(50);

        order = new Button("Ohne Anmeldung direkt zur Bestellung");
        order.setFont(Font.font("Calibri", FontWeight.NORMAL, 22));
        order.setMaxWidth(600);
        order.setMinHeight(50);

        about = new Button("Über WeRun4Food");
        about.setFont(Font.font("Calibri", FontWeight.NORMAL, 22));
        about.setMaxWidth(600);
        about.setMinHeight(50);

        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        hBox.getChildren().add(vBox);
        vBox.getChildren().addAll(welcome, registration, loginAsUser, loginAsGuest, order, about);

        borderPane = new BorderPane();
        borderPane.setTop(heading);
        borderPane.setCenter(hBox);

        scene.setRoot(borderPane);

        registration.setOnAction(actionEvent -> {
            registrationScene = new RegistrationScene();
            registrationScene.setScene();
        });

        loginAsGuest.setOnAction(actionEvent -> {
            guestLoginScene = new GuestLoginScene();
            guestLoginScene.setScene();
        });

        loginAsUser.setOnAction(actionEvent -> {
            userListScene = new UserListScene();
            userListScene.setScene();
            //DailyRoutineScene dailyRoutineScene = new DailyRoutineScene();
            //dailyRoutineScene.setScene(mainStage);
        });

        order.setOnAction(actionEvent -> {

        });

        about.setOnAction(actionEvent -> {
            aboutScene = new AboutScene();
            aboutScene.setScene();
        });

    }
}
