import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GUI_Dialog1 extends Dialog<ButtonType> {
	
	VBox vb1 = new VBox();
	TextField tf1 = new TextField();
	TextField tf2 = new TextField();
	TextField tf3 = new TextField();
	TextField tf4 = new TextField();
	TextField tf5 = new TextField();
	TextField tf6 = new TextField();
	
	
	public GUI_Dialog1 () {
		super();
		this.setTitle("Präferenzen");
		this.setHeaderText("Details zu ");
		
		// BORDERPANE
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));
		
		vb1.getChildren().addAll(tf1, tf2, tf3, tf4, tf5, tf6);
		
		this.getDialogPane().setContent(vb1);
		ButtonType close = ButtonType.OK;
		ButtonType cancel = ButtonType.CANCEL;
		this.getDialogPane().getButtonTypes().addAll(close, cancel);
	}

}
