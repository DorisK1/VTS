
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MitarbeiterGUI_main extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		// ÜBERSCHRIFT
		Label lb1tp1 = new Label("MITARBEITERVERWALTUNG");
		lb1tp1.setFont(Font.font("Verdana", 20));
		//Button bt1 = new Button("OK");
		
		// ACCORDION
		Accordion accordion = new Accordion();
		TitledPane tp1 = new TitledPane();
		TitledPane tp2 = new TitledPane();
		TitledPane tp3 = new TitledPane();
		
		tp1.setText("AUSGABE");
		tp2.setText("RÜCKNAHME");
		tp3.setText("DATENBANK");
		
		accordion.setPrefHeight(300);
		accordion.setPrefWidth(600);
		
		
		accordion.getPanes().addAll(tp1, tp2, tp3);
		
		// PRIMARY STAGE
		primaryStage.setScene(new Scene(accordion));
		primaryStage.setTitle("MITARBEITERANSICHT");
		primaryStage.setResizable(true);
		primaryStage.show();
		
		displayTp1();
		displayTp2();
		displayTp3();

	}

	private void displayTp3() {
		// TODO Auto-generated method stub
		
	}

	private void displayTp2() {
		// TODO Auto-generated method stub
		
	}

	private void displayTp1() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
