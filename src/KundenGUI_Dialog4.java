import java.io.IOException;
import java.util.Optional;

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
import javafx.stage.Stage;

public class KundenGUI_Dialog4 extends Dialog<ButtonType> {
	
	HBox hb1 = new HBox();
	GridPane gridPane = new GridPane();
	Label lb1 = new Label("Ihre Abholnummer lautet: ");
	Button bt1 = new Button("FERTIG");
	private Stage primaryStage;
		
	public KundenGUI_Dialog4 () throws IOException {
		super();
		this.setTitle("");
		this.setHeaderText("");
			
		// BORDERPANE
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));
		borderPane.setPrefSize(700, 580);
		borderPane.setTop(lb1);
		borderPane.setCenter(hb1);
		borderPane.setBottom(bt1);
				
		//borderPane.getChildren().addAll(lb1);
		this.getDialogPane().setContent(borderPane);
		ButtonType close = ButtonType.FINISH; // --> Rückkehr zum Startbildschirm?!?!?
		ButtonType cancel = ButtonType.CANCEL;
		this.getDialogPane().getButtonTypes().addAll(close, cancel);
		bt1.setPrefSize(120, 60);
		
//		KundenGUI_main startScreen = new KundenGUI_main();
//		Optional<ButtonType> back = startScreen.showAndWait();
		
		bt1.setOnAction(gd -> {
			System.out.println("Zurück zum Start");
			new KundenGUI_main().start(primaryStage);
		});
		
		
	}

}
