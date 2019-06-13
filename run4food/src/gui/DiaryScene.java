package gui;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

import controller.MasterController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DiaryScene extends StandardScene{

    private Label heading;
   
    private Button backButton;
    private HBox hbox;
    private BorderPane borderPane;
    private DailyRoutineScene dailyRoutineScene;

   
   
    public void setScene(StandardScene standardScene, MasterController masterController){

        heading = new Label("Dein Tagebuch");
        heading.setFont(Font.font("Calibri", FontWeight.THIN, 40));
        heading.setMinHeight(100);
        heading.setPadding(new Insets(10));
        
        
        TreeMap<String, Integer[]> diary = masterController.getDailyRoutineController().getDiary();
		
        //Definition der Asen
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		xAxis.setLabel("Datum");       
		yAxis.setLabel("kcal");
		// erstellen des Diagramms
		final LineChart<String,Number> lineChart = 
				new LineChart<String,Number>(xAxis,yAxis);

		lineChart.setTitle("Deine Statistik");
		//Anlegen der Datensätze
		XYChart.Series<String, Number> series1 = new Series<String, Number>();
		series1.setName("verdiente Kalorien");
		XYChart.Series<String, Number> series2 = new Series<String, Number>();
		series2.setName("verbrauchte Kalorien");
		XYChart.Series<String, Number> series3 = new Series<String, Number>();
		series3.setName("freie Kalorien");
		
		NavigableSet <String> days = diary.navigableKeySet();
		
		Iterator<String> it = days.iterator();
		String s;
		Integer[] value;
		
		while (it.hasNext()) {
			s= it.next();
			value = diary.get(s); 
			series1.getData().add(new XYChart.Data(s, value[0]));
			series2.getData().add(new XYChart.Data(s, value[1]));
			series3.getData().add(new XYChart.Data(s, value[2]));
		}
		
		Scene scene  = new Scene(lineChart,800,600);
		lineChart.getData().addAll(series1, series2, series3);
		
		//Anlegen des Buttons
        backButton = new Button("Fenster schliessen");
        backButton.setFont(Font.font("Calibri", FontWeight.BOLD, 25));

        hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setMinHeight(75);
        hbox.getChildren().add(backButton);

        borderPane = new BorderPane();
        borderPane.setTop(heading);
        borderPane.setCenter(lineChart);
        borderPane.setBottom(hbox);

        standardScene.setSceneContent(borderPane);
        
        //zurück zur Dailyroutine
        backButton.setOnAction(actionEvent -> { 
            dailyRoutineScene=standardScene.getDailyRoutineScene();
            dailyRoutineScene.setScene(standardScene, masterController);
        });

    }
}

