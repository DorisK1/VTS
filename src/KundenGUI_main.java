
import java.net.URI;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class KundenGUI_main extends Application {
	
	// statischer Initialisierer analog VinothekJerseyResoure - DB wird nur 1x erstellt
	static {
		Datenbank.createTables();
	}

	@Override
	public void start(Stage primaryStage) {

		// BORDERPANE
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));

		// BILD
		URI uri = Paths.get("C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\001.jpg").toUri();
		ImageView imageView = new ImageView(uri.toString());
		Label labelBild = new Label();
		labelBild.setGraphic(imageView);

		// ÜBERSCHRIFT
		Label lbl1 = new Label("Willkommen bei Ski- und Snowboardverleih AlpineStar!");
		lbl1.setFont(Font.font("Verdana", 20));

		// LEIHDATUM
		Label lbl2 = new Label("\nBitte geben Sie die gewünschte Ausleihdauer an:\n");
		Label lbl3 = new Label("von: ");
		Label lbl4 = new Label("bis: ");
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		tf1.setPromptText("dd.mm.jjjj"); // erscheint nicht wenn Cursor im ersten TF ist?!?!
		tf2.setPromptText("dd.mm.jjjj");
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(lbl3, tf1, lbl4, tf2);

		// BUTTONS
		Button bt1 = new Button("SKI");
		bt1.setPrefSize(120, 60);
		bt1.setTextFill(Color.BLUE);
		bt1.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		bt1.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		// mit Hintergrundfarbe sieht man anklicken nicht mehr?!?
		Button bt2 = new Button("SNOWBOARD");
		bt2.setPrefSize(120, 60);
		bt2.setTextFill(Color.BLUE);
		// bt2.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null,
		// null)));
		bt2.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(bt1, bt2);

		bt1.setOnAction(gd -> {
			System.out.println("SKI Button clicked");
			new KundenGUI_Dialog1("Ski").showAndWait();
		});

		bt2.setOnAction(gd -> {
			System.out.println("SNOWBOARD Button clicked");
			new KundenGUI_Dialog1("Snowboard").showAndWait();
		});

		// VBOXES
		VBox vb1 = new VBox();
		VBox vb2 = new VBox();
		vb1.getChildren().addAll(lbl2, hb1); // TEXT U TEXTFELDER
		vb2.getChildren().addAll(labelBild, hb2); // BUTTONS UND BILD

		// ANORDNUNG
		borderPane.setPrefSize(700, 580);
		borderPane.setTop(lbl1);
		borderPane.setLeft(vb1);
		borderPane.setBottom(vb2);

		// PRIMARYSTAGE
		primaryStage.setScene(new Scene(borderPane));
		primaryStage.setTitle("SKI- und SNOWBOARDVERLEIH");
		primaryStage.setResizable(true);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
