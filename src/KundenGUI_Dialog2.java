import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class KundenGUI_Dialog2 extends Dialog<ButtonType> {
	
	HBox hb1 = new HBox();
	GridPane gridPane = new GridPane();
	Label lb1 = new Label("Ihre Abholnummer lautet: ");
		
	public KundenGUI_Dialog2 () throws IOException {
		super();
		this.setTitle("DIALOG 2");
		this.setHeaderText("Abholnummer");
			
		// BORDERPANE
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));
		borderPane.setPrefSize(700, 580);
		borderPane.setTop(lb1);
		borderPane.setCenter(hb1);
		
		this.getDialogPane().setContent(borderPane);
		ButtonType close = ButtonType.OK; 
		this.getDialogPane().getButtonTypes().addAll(close);
		
	}

}
