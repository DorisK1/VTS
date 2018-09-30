import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class KundenGUI_Dialog2 extends Dialog<ButtonType> {
	
	HBox hb1 = new HBox();
	GridPane gridPane = new GridPane();
	Label lb1 = new Label("Gemäß Ihren Angaben können wir Ihnen folgende Produkte zur Auswahl anbieten: ");
	Button bt1 = new Button("OK");
	RadioButton rb1 = new RadioButton("");
	RadioButton rb2 = new RadioButton("");
	RadioButton rb3 = new RadioButton("");
	ToggleGroup group = new ToggleGroup();
		
	public KundenGUI_Dialog2 () {
		super();
		this.setTitle("Auswahlliste");
		this.setHeaderText("abc");
		
		rb1.setToggleGroup(group);
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		
		hb1.getChildren().addAll(rb1, rb2, rb3);
		
		
		// BORDERPANE
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));
		borderPane.setPrefSize(700, 580);
		borderPane.setTop(lb1);
		borderPane.setCenter(hb1);
		borderPane.setBottom(bt1);
		
		//borderPane.getChildren().addAll(lb1);
		
		this.getDialogPane().setContent(borderPane);
		//ButtonType close = ButtonType.OK;
		ButtonType cancel = ButtonType.CANCEL;
		this.getDialogPane().getButtonTypes().addAll(cancel);
		
		bt1.setOnAction(gd -> {
			System.out.println("Präferenzen gewählt");
			new KundenGUI_Dialog2().showAndWait();
		});
	}

}
