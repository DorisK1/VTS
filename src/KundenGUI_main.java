
import java.net.URI;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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

	// statischer Initialisierer analog VinothekJerseyResoure - DB wird nur 1x
	// erstellt
	// MUSS auskommentiert werden sobald die Datenbank steht - Methode soll dann
	// nicht mehr aufgerufen werden!
	// ODER: DB Ordner l�schen!!!
	// Achtung: bei kd nr vergabe nach auskommentierung immer +100!?!?
	
//	static {
//		try {
//			Ski sk = new Ski();
//			Snowboard sb = new Snowboard();
//			Datenbank.createTables();
//			Datenbank.insertRows(sk, sb);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Override
	public void start(Stage primaryStage) {

		// Ausleihe Objekt zur Verspeicherung des Datums
		// AusleiheFX ausleihe = new AusleiheFX();

		// BORDERPANE
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));

		// BILD
		URI uri = Paths.get("C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\001.jpg").toUri();
		ImageView imageView = new ImageView(uri.toString());
		Label labelBild = new Label();
		labelBild.setGraphic(imageView);

		// �BERSCHRIFT
		Label lbl1 = new Label("Willkommen bei Ski- und Snowboardverleih AlpineStar!");
		lbl1.setFont(Font.font("Verdana", 20));

		// LEIHDATUM
		Label lbl2 = new Label("\nBitte geben Sie die gew�nschte Ausleihdauer an:\n");
		Label lbl3 = new Label("von: ");
		Label lbl4 = new Label("bis: ");

		// DATEPICKER
		DatePicker datePicker1 = new DatePicker();
		DatePicker datePicker2 = new DatePicker();
		datePicker1.setValue(LocalDate.now());
		datePicker2.setValue(LocalDate.now());

		HBox hb1 = new HBox();
		hb1.getChildren().addAll(lbl3, datePicker1, lbl4, datePicker2);

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
			new KundenGUI_Dialog1("Ski", datePicker1.getValue(), datePicker2.getValue()).showAndWait();
		});

		bt2.setOnAction(gd -> {
			System.out.println("SNOWBOARD Button clicked");
			new KundenGUI_Dialog1("Snowboard", datePicker1.getValue(), datePicker2.getValue()).showAndWait();
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
