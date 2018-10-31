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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class KundenGUI_Dialog2 extends Dialog<ButtonType> {

	Ausleihe a = new Ausleihe(); 
	Kunde k = new Kunde();
	VBox vb1 = new VBox();
	VBox vb2 = new VBox(); //Produktinfos
	HBox hb1 = new HBox();
	HBox hb2 = new HBox();
	GridPane gridPane = new GridPane();
	Label lb1 = new Label();
	Label lb1a = new Label(); //Abholnummer
	Label lb2 = new Label("Rückgabe am "); 
	Label lb2a = new Label(); //Rückgabedatum
	Label lb2b = new Label(" bitte bis spätestens 18 Uhr!");
	Label lb3 = new Label("Ihr AlpineStar Team wünscht Ihnen viel Spaß mit Ihrem Produkt");
	Label lb4 = new Label("Zahlungsinformationen");
	Label lb5 = new Label();
	Label lb6 = new Label();
	Label lb7 = new Label();
	Label lb8 = new Label();
	
	

	public KundenGUI_Dialog2(int abholNr, int kundenNr) throws IOException {
		super();
		this.setTitle("DIALOG 2");
		this.setHeaderText("Abholnummer");
		lb1a.setText(Integer.toString(abholNr));
		lb2a.setText(Datenbank.getAusleihe(abholNr).getLeihende().toString());
		lb1.setText("Sehr geehrte/r " + Datenbank.getKunde(kundenNr).getVorname() + " " 
				+ Datenbank.getKunde(kundenNr).getNachname()
				+ ", vielen Dank für Buchung! Ihre Abholnummer lautet:   " + " ");
		lb5.setText("Miete: " + "EUR " + Double.toString(Datenbank.getAusleihe(abholNr).getMietpreis()) + ".-");
		lb6.setText("Kaution: EUR 200.-");
		lb7.setText("Gesamtpreis: " + "EUR " + Double.toString(Datenbank.getAusleihe(abholNr).getGesamtpreis()));

		// BOXEN
		hb1.getChildren().addAll(lb2, lb2a, lb2b);
		hb2.getChildren().addAll(lb1, lb1a);
		vb1.getChildren().addAll(hb2, hb1);
		// Labeltext Abholnummer
		lb1a.setFont(Font.font("Verdana", 20));
		// Labeltext "Ihr AlpineStar Team wünscht Ihnen viel Spaß mit Ihrem Produkt"
		lb3.setFont(Font.font("Verdana", 20));
		// BILD
		URI uri = Paths.get("C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\002.jpg").toUri();
		ImageView imageView = new ImageView(uri.toString());
		imageView.setFitHeight(300);
		imageView.setFitWidth(400);
		Label labelBild = new Label();
		labelBild.setGraphic(imageView);
		
		vb2.getChildren().addAll(labelBild, lb5, lb6, lb7);
		//gridPane
		
		
		
		// BORDERPANE
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(5));
		borderPane.setPrefSize(700, 400);
		borderPane.setTop(vb1);
		//borderPane.setCenter();
		borderPane.setLeft(vb2);
		borderPane.setBottom(lb3);

		this.getDialogPane().setContent(borderPane);
		ButtonType close = ButtonType.OK;
		this.getDialogPane().getButtonTypes().addAll(close);

	}

}
