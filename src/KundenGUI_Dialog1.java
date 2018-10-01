import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class KundenGUI_Dialog1 extends Dialog<ButtonType> {
	
	VBox vb1 = new VBox();
	GridPane gridPane = new GridPane();
	TextField tf1 = new TextField();
	TextField tf2 = new TextField();
	TextField tf3 = new TextField();
	TextField tf4 = new TextField();
	TextField tf5 = new TextField();
	
	Label lb1 = new Label("Vielen Dank. Sie haben Ski gewählt. Bitte vervollständigen Sie untenstehende Angaben: ");
	Label lb2 = new Label("Geburtsdatum");
	Label lb3 = new Label("Gewicht");
	Label lb4 = new Label("Schuhgröße");
	Label lb5 = new Label("Technisches Können");
	Label lb6 = new Label("Pistenpräferenz");
	
	Button bt1 = new Button("OK");
	
	
	public KundenGUI_Dialog1 () {
		super();
		this.setTitle("Präferenzen");
		this.setHeaderText("Details zu ");
		
		
		// GRIDPANE
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.add(lb2, 0, 0);
		gridPane.add(lb3, 0, 1);
		gridPane.add(lb4, 0, 2);
		gridPane.add(lb5, 0, 3);
		gridPane.add(lb6, 0, 4);
		gridPane.add(tf1, 1, 0);
		gridPane.add(tf2, 1, 1);
		gridPane.add(tf3, 1, 2);
		gridPane.add(tf4, 1, 3);
		gridPane.add(tf5, 1, 4);
		
		// BORDERPANE
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));
		borderPane.setPrefSize(700, 580);
		borderPane.setTop(lb1);
		borderPane.setCenter(gridPane);
		borderPane.setBottom(bt1);
		
		//borderPane.getChildren().addAll(lb1);
		
		this.getDialogPane().setContent(borderPane);
		//ButtonType close = ButtonType.OK;
		ButtonType cancel = ButtonType.CANCEL;
		this.getDialogPane().getButtonTypes().addAll(cancel);
		bt1.setPrefSize(120, 60);
		bt1.setOnAction(gd -> {
			System.out.println("Präferenzen gewählt");
			new KundenGUI_Dialog2().showAndWait();
		});
	}

}
