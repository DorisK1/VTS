import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class KundenGUI_Dialog2 extends Dialog<ButtonType> {

	Ausleihe a = new Ausleihe();
	Kunde k = new Kunde();
	VBox vb1 = new VBox();
	GridPane gridPane = new GridPane();
	Label lb1 = new Label("Ihre Abholnummer lautet: ");
	Label lb1a = new Label(); //Abholnummer
	Label lb2 = new Label("Rückgabe am: ");
	Label lb2a = new Label(); //Rückgabedatum
	Label lb3 = new Label("Ihr AlpineStar Team wünscht Ihnen viel Spaß mit Ihrem Produkt");

	public KundenGUI_Dialog2(int kundenNr) throws IOException {
		super();
		this.setTitle("DIALOG 2");
		this.setHeaderText("Abholnummer");
		lb1a.setText(Integer.toString(Datenbank.getNewAusleihe(kundenNr).getAbholNr()));
		lb2a.setText(Datenbank.getNewAusleihe(kundenNr).getLeihende().toString());

		// VBOX
		vb1.getChildren().addAll(lb1, lb1a, lb2, lb2a);

		// BILD
		URI uri = Paths.get("C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\002.jpg").toUri();
		ImageView imageView = new ImageView(uri.toString());
		imageView.setFitHeight(200);
		imageView.setFitWidth(300);
		Label labelBild = new Label();
		labelBild.setGraphic(imageView);
		
		// BORDERPANE
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));
		borderPane.setPrefSize(700, 400);
		borderPane.setTop(vb1);
		//borderPane.setCenter();
		borderPane.setLeft(labelBild);
		borderPane.setBottom(lb3);

		this.getDialogPane().setContent(borderPane);
		ButtonType close = ButtonType.OK;
		this.getDialogPane().getButtonTypes().addAll(close);

	}

}
