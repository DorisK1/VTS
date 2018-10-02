import java.io.IOException;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class KundenGUI_Dialog3 extends Dialog<ButtonType> {
	
	VBox vb1 = new VBox();
	GridPane gridPane = new GridPane();
	TextField tf1 = new TextField();
	TextField tf2 = new TextField();
	TextField tf3 = new TextField();
	TextField tf4 = new TextField();
	TextField tf5 = new TextField();
	TextField tf6 = new TextField();
	TextField tf7 = new TextField();
	TextField tf8 = new TextField();
	TextField tf9 = new TextField();
	TextField tf10 = new TextField();
	TextField tf11 = new TextField();
	TextField tf12 = new TextField();
	
	Label lb1 = new Label("Vielen Dank für Ihre Auswahl. Bitte vervollständigen Sie untenstehende Angaben: ");
	Label lb2 = new Label("Anrede");
	Label lb3 = new Label("Vorname");
	Label lb4 = new Label("Nachname");
	Label lb5 = new Label("Telefonnummer");
	Label lb6 = new Label("Strasse");
	Label lb7 = new Label("Wohnort");
	Label lb8 = new Label("PLZ");
	Label lb9 = new Label("Land");
	Label lb10 = new Label("Kreditkartennummer");
	Label lb11 = new Label("Kreditkartenname");
	Label lb12 = new Label("Kreditkartenprüfnummer");
	Label lb13 = new Label("Kreditkartengültigkeit");
	
	
	Button bt1 = new Button("OK");
	
	
	public KundenGUI_Dialog3 () {
		super();
		this.setTitle("DIALOG 3");
		this.setHeaderText("Kundendaten ");
		
		
		// GRIDPANE
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.add(lb2, 0, 0);
		gridPane.add(lb3, 0, 1);
		gridPane.add(lb4, 0, 2);
		gridPane.add(lb5, 0, 3);
		gridPane.add(lb6, 0, 4);
		gridPane.add(lb7, 0, 5);
		gridPane.add(lb8, 0, 6);
		gridPane.add(lb9, 0, 7);
		gridPane.add(lb10, 0, 8);
		gridPane.add(lb11, 0, 9);
		gridPane.add(lb12, 0, 10);
		gridPane.add(lb13, 0, 11);
		
		gridPane.add(tf1, 1, 0);
		gridPane.add(tf2, 1, 1);
		gridPane.add(tf3, 1, 2);
		gridPane.add(tf4, 1, 3);
		gridPane.add(tf5, 1, 4);
		gridPane.add(tf6, 1, 5);
		gridPane.add(tf7, 1, 6);
		gridPane.add(tf8, 1, 7);
		gridPane.add(tf9, 1, 8);
		gridPane.add(tf10, 1, 9);
		gridPane.add(tf11, 1, 10);
		gridPane.add(tf12, 1, 11);
		
		
		// BORDERPANE
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));
		borderPane.setPrefSize(700, 580);
		borderPane.setTop(lb1);
		borderPane.setCenter(gridPane);
		borderPane.setBottom(bt1);
		
		//borderPane.getChildren().addAll(lb1);
		
		this.getDialogPane().setContent(borderPane);
		//Optional<ButtonType> close = new KundenGUI_Dialog4().showAndWait().;
		ButtonType close = ButtonType.OK;
		ButtonType cancel = ButtonType.CANCEL;
		this.getDialogPane().getButtonTypes().addAll(close, cancel);
		bt1.setPrefSize(120, 60);
		
	
		bt1.setOnAction(gd -> {
			System.out.println("Präferenzen gewählt");
			try {
				Optional<ButtonType> back = new KundenGUI_Dialog4().showAndWait();
				if(back.isPresent()) {
					if(back.get() == ButtonType.OK) {
						this.close();
						
					}
				}
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
