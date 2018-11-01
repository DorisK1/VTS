
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MitarbeiterGUI_main extends Application {

	VBox vb1 = new VBox();
	Label lb1 = new Label("Bitte Abholnummer eingeben:");
	Label lb2 = new Label(); // input validation message
	TextField tf1 = new TextField();
	Button bt1 = new Button("Suche");

	// ACCORDION
	Accordion accordion = new Accordion();
	TitledPane tp1 = new TitledPane();
	TitledPane tp2 = new TitledPane();
	TitledPane tp3 = new TitledPane();
	TitledPane tp4 = new TitledPane();
	TitledPane tp5 = new TitledPane();
	TitledPane tp6 = new TitledPane();

	// TP1
	VBox vb1tp1 = new VBox();
	GridPane gridPanetp1 = new GridPane();
	Button bt1tp1 = new Button("OK");
	TextField tf1tp1 = new TextField();
	TextField tf2tp1 = new TextField();
	TextField tf3tp1 = new TextField();
	TextField tf4tp1 = new TextField();
	Label lb1tp1 = new Label("Produktnummer");
	Label lb2tp1 = new Label("Regalplatz");
	Label lb3tp1 = new Label("Zeitpunkt der Ausleihe");
	Label lb4tp1 = new Label("Kundennummer");

	// TP2
	VBox vb1tp2 = new VBox();
	GridPane gridPanetp2 = new GridPane();
	Button bt1tp2 = new Button("OK");
	TextField tf1tp2 = new TextField();
	TextField tf2tp2 = new TextField();
	TextField tf3tp2 = new TextField();
	TextField tf4tp2 = new TextField();
	TextField tf5tp2 = new TextField();
	TextField tf6tp2 = new TextField();
	Label lb1tp2 = new Label("Produktnummer");
	Label lb2tp2 = new Label("Regalplatz");
	Label lb3tp2 = new Label("Miete endet am: ");
	Label lb4tp2 = new Label("Entstandene Zusatzkosten");
	Label lb5tp2 = new Label("Zu refundierende Kaution");
	Label lb6tp2 = new Label("Kundennummer");

	// TP3
	BorderPane borderPanetp3 = new BorderPane();
	Label lb1tp3 = new Label();

	// TP4
	BorderPane borderPanetp4 = new BorderPane();
	// Label lb1tp4 = new Label("test");
	Button bt1tp4 = new Button("NEU");
	Button bt2tp4 = new Button("LÖSCHEN");
	HBox h1tp4 = new HBox();

	// TP5
	BorderPane borderPanetp5 = new BorderPane();
	Label lb1tp5 = new Label();
	Button bt1tp5 = new Button("NEU");
	Button bt2tp5 = new Button("LÖSCHEN");
	HBox h1tp5 = new HBox();

	// TP6
	BorderPane borderPanetp6 = new BorderPane();

	@Override
	public void start(Stage primaryStage) {

		Kunde k = new Kunde();
		Ausleihe a = new Ausleihe();
		tf1.setMaxWidth(60);
		tp1.setText("AUSGABE");
		tp2.setText("RÜCKNAHME");
		tp3.setText("KUNDEN");
		tp4.setText("SKI");
		tp5.setText("SNOWBOARD");
		tp6.setText("AUSLEIHEN");

		displayTp1();
		displayTp2();
		displayTp3();
		displayTp4();
		displayTp5();
		displayTp6();

		accordion.setExpandedPane(tp6); // Ausleihen werden als ersten angezeigt

		// Input validation der Abholnummer - nur Zahlen erlaubt
		tf1.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (observable != null) {
				if (!tf1.getText().matches("[0-9]*")) {
					tf1.setStyle("-fx-background-color: orangered;");
					lb2.setText("Falsche Eingabe - nur Zahlen!");
				} else {
					tf1.setStyle("-fx-background-color: white;");
					lb2.setText("");
				}
			}
		});

		accordion.setPrefHeight(600);
		accordion.setPrefWidth(800);
		accordion.getPanes().addAll(tp1, tp2, tp3, tp4, tp5, tp6);
		vb1.getChildren().addAll(lb1, tf1, bt1, lb2, accordion);

		// PRIMARY STAGE
		primaryStage.setScene(new Scene(vb1));
		primaryStage.setTitle("MITARBEITERANSICHT");
		primaryStage.setResizable(true);
		primaryStage.show();

		// Suche nach der Abhonummer UND Auswahl ob es sich um eine Ausgabe oder
		// Rücknahme handelt
		bt1.setOnAction(gd -> {

			System.out.println("Abholnummer " + tf1.getText() + " suchen");
			// wenn das vom kunden angegebene startdatum dem heutigen tag entspricht, dann
			// muss die Ausleihe befüllt werden --> TP1
			// wenn LEIHSTART = LEIHENDE --> entscheidet die Uhrzeit LocalDateTime!!!
			
			
			if (Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getAbholNr() > 0) {
				lb2.setText("Abholnummer gefunden!"); // lb2 wird auch für die input validation message verwendet!
				// wenn LEIHSTART != LEIHENDE
				if (!Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getLeihstart()
						.equals(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getLeihende())) { 
					// wenn LEIHSTART = HEUTE --> Ausleihe
					if (Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getLeihstart() 
							.equals(java.sql.Date.valueOf(LocalDate.now()))) {
						// Prüfen ob SKI oder SNOWBOARD (wenn SkiNr vorhanden...)
						if (Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr() > 0) { 
							tf1tp1.setText(Integer
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr())); // skiNr
							tf2tp1.setText(Datenbank
									.getNewSki(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr())
									.getRegalNr()); // regalNr SKI
						// Snowboard
						} else {
							tf1tp1.setText(Integer
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSnowboardNr())); // snowb.Nr
							tf2tp1.setText(Datenbank
									.getNewSnowboard(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSnowboardNr())
									.getRegalNr()); // regalNr Snowboard
						}
						tf3tp1.setText(
								Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getLeihstart().toString()); // ausleihstart
						tf4tp1.setText(
								Integer.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getKundenNr())); // Kundennummer
						tp1.setExpanded(true);
						// TP2
					} else { // Rücknahme WENN Leihstart in der Vergangenheit liegt
						// Wenn SKI NR vorhanden dann..
						if (Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr() > 0) {
							tf1tp2.setText(Integer
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr())); // skiNr
							tf2tp2.setText(Datenbank
									.getNewSki(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr())
									.getRegalNr()); // regalNr Ski
						// Snowboard
						} else {
							tf1tp2.setText(Integer
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSnowboardNr())); // snowb.Nr
							tf2tp2.setText(Datenbank
									.getNewSnowboard(
											Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSnowboardNr())
									.getRegalNr()); // regalNr Snowboard
						}

						tf3tp2.setText(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getLeihende().toString());
						// WENN LEIHENDE = HEUTE --> KEINE NACHZAHLUNG
						if (Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getLeihende()
								.equals(java.sql.Date.valueOf(LocalDate.now()))) {
							tf4tp2.setText(Double
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getNachzahlung()));
						} else { // nachzahlung mit UPDATE in db
							Datenbank.updateAusleihe(Integer.parseInt(tf1.getText()), calcNachzahlung(
									LocalDate.parse(tf3tp2.getText()), Integer.parseInt(tf1.getText())));
							tf4tp2.setText(Double
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getNachzahlung()));
						}
						tf5tp2.setText(
								Double.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getKaution()));
						tf6tp2.setText(
								Integer.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getKundenNr()));
						tp2.setExpanded(true);

					}
				} else {
					if (LocalDateTime.now().getHour() <= 12) { // = Ausleihe wenn VOR 12H, sonst Rücknahme
						// wenn Skinr vorhanden...
						if (Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr() > 0) { // PRÜFEN OB SKINR
							// vorhanden
							tf1tp1.setText(Integer
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr())); // skiNr
							tf2tp1.setText(Datenbank
									.getNewSki(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr())
									.getRegalNr()); // regalNr SKI
						} else {
							tf1tp1.setText(Integer
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSnowboardNr())); // snowb.Nr
							tf2tp1.setText(Datenbank
									.getNewSki(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSnowboardNr())
									.getRegalNr()); // regalNr Snowboard
						}
						tf3tp1.setText(
								Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getLeihstart().toString()); // ausleihstart
						tf4tp1.setText(
								Integer.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getKundenNr())); // Kundennummer
						tp1.setExpanded(true);

					} else { // Rücknahme
						if (Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr() > 0) {
							tf1tp2.setText(Integer
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr())); // skiNr
							tf2tp2.setText(Datenbank
									.getNewSki(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSkiNr())
									.getRegalNr()); // regalNr Ski
						} else {
							tf1tp2.setText(Integer
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSnowboardNr())); // snowb.Nr
							tf2tp2.setText(Datenbank
									.getNewSnowboard(
											Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getSnowboardNr())
									.getRegalNr()); // regalNr Snowboard
						}

						tf3tp2.setText(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getLeihende().toString());
						// WENN LEIHENDE = HEUTE --> KEINE NACHZAHLUNG
						if (Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getLeihende()
								.equals(java.sql.Date.valueOf(LocalDate.now()))) {
							tf4tp2.setText(Double
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getNachzahlung()));
						} else { // nachzahlung mit UPDATE in db
							Datenbank.updateAusleihe(Integer.parseInt(tf1.getText()), calcNachzahlung(
									LocalDate.parse(tf3tp2.getText()), Integer.parseInt(tf1.getText())));
							tf4tp2.setText(Double
									.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getNachzahlung()));

						}
						tf5tp2.setText(
								Double.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getKaution()));
						tf6tp2.setText(
								Integer.toString(Datenbank.getAusleihe(Integer.parseInt(tf1.getText())).getKundenNr()));
						tp2.setExpanded(true);
					}
				}
			} else {
				lb2.setText("Abholnummer NICHT gefunden! Bitte um erneute Eingabe einer korrekten Nummer");
			}
		});
	}

	private double calcNachzahlung(LocalDate selreturnDate, int abholNr) { // berechnet Nachzahlung wenn das Produkt
																			// nach dem Leihende retourniert wird
		
		Period period = Period.between(selreturnDate, LocalDate.now());
		int tage = period.getDays();
		double nachzahlung = 0;
		if (Datenbank.getAusleihe(abholNr).getSkiNr() > 0) {
			nachzahlung = Datenbank.getNewSki(Integer.parseInt(tf1tp2.getText())).getTagespreis() * tage;
			System.out.println("Tage: " + tage);
			System.out.println("Nachzahlung: " + nachzahlung);
		} else {
			nachzahlung = Datenbank.getNewSnowboard(Integer.parseInt(tf1tp2.getText())).getTagespreis() * tage;
			System.out.println("Tage: " + tage);
			System.out.println("Nachzahlung: " + nachzahlung);
		}
		return nachzahlung;
	}

	@SuppressWarnings("unchecked")
	private void displayTp6() { // Listung ALLER Ausleihen
		// TABLE VIEW
		borderPanetp6.setPadding(new Insets(5));
		// Columns
		TableColumn<AusleiheFX, Integer> ausleiheIdCol = new TableColumn<>("abholNr");
		ausleiheIdCol.setCellValueFactory(new PropertyValueFactory<>("abholNr"));
		ausleiheIdCol.setMinWidth(100);
		TableColumn<AusleiheFX, Integer> customerIdCol = new TableColumn<>("kundenNr");
		customerIdCol.setCellValueFactory(new PropertyValueFactory<>("kundenNr"));
		customerIdCol.setMinWidth(100);
		TableColumn<AusleiheFX, Integer> skiNrCol = new TableColumn<>("skiNr");
		skiNrCol.setCellValueFactory(new PropertyValueFactory<>("skiNr"));
		skiNrCol.setMinWidth(100);
		TableColumn<AusleiheFX, Integer> snowboardNrCol = new TableColumn<>("snowboardNr");
		snowboardNrCol.setCellValueFactory(new PropertyValueFactory<>("snowboardNr"));
		snowboardNrCol.setMinWidth(100);
		TableColumn<AusleiheFX, Date> leihstartCol = new TableColumn<>("leihstart");
		leihstartCol.setCellValueFactory(new PropertyValueFactory<>("leihstart"));
		leihstartCol.setMinWidth(100);
		TableColumn<AusleiheFX, Date> leihendeCol = new TableColumn<>("leihende");
		leihendeCol.setCellValueFactory(new PropertyValueFactory<>("leihende"));
		leihendeCol.setMinWidth(100);
		TableColumn<AusleiheFX, Double> gesamtpreisCol = new TableColumn<>("gesamtpreis");
		gesamtpreisCol.setCellValueFactory(new PropertyValueFactory<>("gesamtpreis"));
		gesamtpreisCol.setMinWidth(100);

		TableView<AusleiheFX> table = new TableView<>();
		ObservableList<AusleiheFX> ausleihenFXListe = FXCollections.observableArrayList();
		ArrayList<Ausleihe> ausleihenNrs = Datenbank.getAusleihen();

		for (Ausleihe au : ausleihenNrs) { // Ausleihe auf AusleiheFX umschreiben
			Ausleihe ausleihe = new Ausleihe(au.getAbholNr(), au.getKundenNr(), au.getSkiNr(), au.getSnowboardNr(),
					au.getLeihstart(), au.getLeihende(), au.getMietpreis(), au.getKaution(), au.getNachzahlung(),
					au.getGesamtpreis());
			ausleihenFXListe.add(new AusleiheFX(ausleihe));
		}

		table.setItems(ausleihenFXListe);
		table.getColumns().addAll(ausleiheIdCol, customerIdCol, skiNrCol, snowboardNrCol, leihstartCol, leihendeCol,
				gesamtpreisCol);

		borderPanetp6.setCenter(table);
		tp6.setContent(borderPanetp6);

	}

	@SuppressWarnings("unchecked")
	private void displayTp5() { // Listung aller Snowboards aus der Datenbank
		// TABLE VIEW
		borderPanetp5.setPadding(new Insets(5));
		h1tp5.getChildren().addAll(bt1tp5, bt2tp5);
		borderPanetp5.setBottom(h1tp5);

		TableColumn<SnowboardFX, Integer> snowboardNrCol = new TableColumn<>("snowboardNr");
		snowboardNrCol.setCellValueFactory(new PropertyValueFactory<>("snowboardNr"));
		snowboardNrCol.setMinWidth(100);
		TableColumn<SnowboardFX, Integer> snowboardKategorieNrCol = new TableColumn<>("snowboardKategorieNr");
		snowboardKategorieNrCol.setCellValueFactory(new PropertyValueFactory<>("snowboardKategorieNr"));
		snowboardKategorieNrCol.setMinWidth(100);
		TableColumn<SnowboardFX, String> snowboardProduktnameCol = new TableColumn<>("snowboardProduktname");
		snowboardProduktnameCol.setCellValueFactory(new PropertyValueFactory<>("snowboardProduktname"));
		snowboardProduktnameCol.setMinWidth(100);
		TableColumn<SnowboardFX, String> snowboardTypCol = new TableColumn<>("snowboardTyp");
		snowboardTypCol.setCellValueFactory(new PropertyValueFactory<>("snowboardTyp"));
		snowboardTypCol.setMinWidth(200);
		TableColumn<SnowboardFX, String> regalNrCol = new TableColumn<>("regalNr");
		regalNrCol.setCellValueFactory(new PropertyValueFactory<>("regalNr"));
		regalNrCol.setMinWidth(70);
		TableColumn<SnowboardFX, Double> tagespreisCol = new TableColumn<>("tagespreis");
		tagespreisCol.setCellValueFactory(new PropertyValueFactory<>("tagespreis"));
		tagespreisCol.setMinWidth(70);
		TableColumn<SnowboardFX, String> farbeCol = new TableColumn<>("farbe");
		farbeCol.setCellValueFactory(new PropertyValueFactory<>("farbe"));
		farbeCol.setMinWidth(70);

		ObservableList<SnowboardFX> sbFXListe = FXCollections.observableArrayList();
		TableView<SnowboardFX> table1 = new TableView<>();
		ArrayList<Snowboard> sbNrs = Datenbank.getSnowboard();

		for (Snowboard sb : sbNrs) { // Snowboard auf SnowboardFX umschreiben
			Snowboard snowboard = new Snowboard(sb.getSnowboardNr(), sb.getSnowboardKategorieNr(),
					sb.getSnowboardProduktname(), sb.getSnowboardTyp(), sb.getSnowboardBildpfad(), sb.getRegalNr(),
					sb.getTagespreis(), sb.getFarbe(), sb.isBeinstellung(), sb.isBindungstyp());
			sbFXListe.add(new SnowboardFX(snowboard));
		}

		table1.setItems(sbFXListe);
		table1.getColumns().addAll(snowboardNrCol, snowboardKategorieNrCol, snowboardProduktnameCol, snowboardTypCol,
				regalNrCol, tagespreisCol, farbeCol);

		borderPanetp5.setCenter(table1);
		tp5.setContent(borderPanetp5);

		bt1tp5.setOnAction(bt -> { // Snowboard NEU ANLEGEN
			System.out.println("Neues Snowboard anlegen");
			String s = "Snowboard";
			Optional<Integer> newSnowboard = new MitarbeiterGUI_Dialog1(s).showAndWait();
			if (newSnowboard.isPresent()) {
				ArrayList<Snowboard> sbNrs1 = Datenbank.getSnowboard();
				sbFXListe.clear();
				for (Snowboard sb : sbNrs1) { // Snowboard auf SnowboardFX umschreiben
					Snowboard snowboard = new Snowboard(sb.getSnowboardNr(), sb.getSnowboardKategorieNr(),
							sb.getSnowboardProduktname(), sb.getSnowboardTyp(), sb.getSnowboardBildpfad(),
							sb.getRegalNr(), sb.getTagespreis(), sb.getFarbe(), sb.isBeinstellung(),
							sb.isBindungstyp());
					sbFXListe.add(new SnowboardFX(snowboard));
				}
			}
		});

		bt2tp5.setOnAction(bt -> { // Snowboard LÖSCHEN

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("WARNUNG!");
			alert.setContentText("Wollen Sie das Produkt wirklich löschen?");
			// alert.showAndWait();
			alert.getButtonTypes().clear();
			alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.CANCEL);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.YES) {

				SnowboardFX selectedItem = table1.getSelectionModel().getSelectedItem();
				Datenbank.deleteSnowboard(table1.getSelectionModel().getSelectedItem().getSnowboardNr()); // LÖSCHEN aus
																											// DB
				// table1.getItems().remove(selectedItem);
				sbFXListe.remove(selectedItem);// LÖSCHEN aus Anzeige

			}
		});

	}

	@SuppressWarnings("unchecked")
	private void displayTp4() { // Listung aller Ski aus der Datenbank
		// TABLE VIEW
		borderPanetp4.setPadding(new Insets(5));
		h1tp4.getChildren().addAll(bt1tp4, bt2tp4);
		borderPanetp4.setBottom(h1tp4);
		// Columns
		TableColumn<SkiFX, Integer> skiNrCol = new TableColumn<>("skiNr");
		skiNrCol.setCellValueFactory(new PropertyValueFactory<>("skiNr"));
		skiNrCol.setMinWidth(100);
		TableColumn<SkiFX, Integer> skiKategorieNrCol = new TableColumn<>("skiKategorieNr");
		skiKategorieNrCol.setCellValueFactory(new PropertyValueFactory<>("skiKategorieNr"));
		skiKategorieNrCol.setMinWidth(100);
		TableColumn<SkiFX, String> skiProduktnameCol = new TableColumn<>("skiProduktname");
		skiProduktnameCol.setCellValueFactory(new PropertyValueFactory<>("skiProduktname"));
		skiProduktnameCol.setMinWidth(100);
		TableColumn<SkiFX, String> skiTypCol = new TableColumn<>("skiTyp");
		skiTypCol.setCellValueFactory(new PropertyValueFactory<>("skiTyp"));
		skiTypCol.setMinWidth(200);
		TableColumn<SkiFX, String> regalNrCol = new TableColumn<>("regalNr");
		regalNrCol.setCellValueFactory(new PropertyValueFactory<>("regalNr"));
		regalNrCol.setMinWidth(70);
		TableColumn<SkiFX, Double> tagespreisCol = new TableColumn<>("tagespreis");
		tagespreisCol.setCellValueFactory(new PropertyValueFactory<>("tagespreis"));
		tagespreisCol.setMinWidth(70);
		TableColumn<SkiFX, String> farbeCol = new TableColumn<>("farbe");
		farbeCol.setCellValueFactory(new PropertyValueFactory<>("farbe"));
		farbeCol.setMinWidth(70);

		TableView<SkiFX> table = new TableView<>();
		ObservableList<SkiFX> skiFXListe = FXCollections.observableArrayList();
		ArrayList<Ski> skiNrs = Datenbank.getSki();

		for (Ski sk : skiNrs) { // Ski auf SkiFX umschreiben
			Ski ski = new Ski(sk.getSkiNr(), sk.getSkiKategorieNr(), sk.getSkiProduktname(), sk.getSkiTyp(),
					sk.getSkiBildpfad(), sk.getRegalNr(), sk.getTagespreis(), sk.getFarbe());
			skiFXListe.add(new SkiFX(ski));
		}
		table.setItems(skiFXListe);
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		table.getColumns().addAll(skiNrCol, skiKategorieNrCol, skiProduktnameCol, skiTypCol, regalNrCol, tagespreisCol,
				farbeCol); // Anzeige OHNE skiBildpfad!!!!

		borderPanetp4.setCenter(table);
		tp4.setContent(borderPanetp4);

		// NEUEN SKI ANLEGEN
		bt1tp4.setOnAction(bt -> {
			System.out.println("Neuen Ski anlegen");
			String s = "Ski";
			Optional<Integer> newSki = new MitarbeiterGUI_Dialog1(s).showAndWait(); // Dialog liefert 1 zurück
			// LISTE für TableView NEU laden!
			if (newSki.isPresent()) { // ja - weil newSki = 1
				ArrayList<Ski> skiNrs1 = Datenbank.getSki();
				skiFXListe.clear();
				for (Ski sk : skiNrs1) { // Ski auf SkiFX umschreiben
					Ski ski = new Ski(sk.getSkiNr(), sk.getSkiKategorieNr(), sk.getSkiProduktname(), sk.getSkiTyp(),
							sk.getSkiBildpfad(), sk.getRegalNr(), sk.getTagespreis(), sk.getFarbe());
					skiFXListe.add(new SkiFX(ski));
				}
			}
		});

		// Ski LÖSCHEN

		bt2tp4.setOnAction(bt -> {
			// Pop up Alert - Rückfrage ob man wirklich löschen will
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("WARNUNG!");
			alert.setContentText("Wollen Sie das Produkt wirklich löschen?");
			alert.getButtonTypes().clear();
			alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.CANCEL);

			Optional<ButtonType> result = alert.showAndWait();
			// nur wenn man OK klickt dann wird gelöscht - sonst Abbruch
			if (result.isPresent() && result.get() == ButtonType.YES) {
				SkiFX selectedItem = table.getSelectionModel().getSelectedItem();
				Datenbank.deleteSki(table.getSelectionModel().getSelectedItem().getSkiNr());
				// table.getItems().remove(selectedItem); --> falsch
				// direkt von der liste löschen - denn bei NEU wird liste ja erneut geladen!
				skiFXListe.remove(selectedItem);
			}
		});

	}

	@SuppressWarnings("unchecked")
	private void displayTp3() { // Listung aller Kunden aus der Datenbank
		// TABLE VIEW
		borderPanetp3.setPadding(new Insets(5));
		borderPanetp3.setBottom(lb1tp3);
		// Columns
		TableColumn<KundeFX, Integer> customerIdCol = new TableColumn<>("KundenNr");
		customerIdCol.setCellValueFactory(new PropertyValueFactory<>("kundenNr"));
		customerIdCol.setMinWidth(70);
		TableColumn<KundeFX, String> firstNameCol = new TableColumn<>("Vorname");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
		firstNameCol.setMinWidth(100);
		TableColumn<KundeFX, String> lastNameCol = new TableColumn<>("Nachname");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
		lastNameCol.setMinWidth(100);
		TableColumn<KundeFX, String> ortCol = new TableColumn<>("Wohnort");
		ortCol.setCellValueFactory(new PropertyValueFactory<>("wohnort"));
		ortCol.setMinWidth(50);
		TableColumn<KundeFX, String> landCol = new TableColumn<>("Land");
		landCol.setCellValueFactory(new PropertyValueFactory<>("land"));
		landCol.setMinWidth(50);
		TableColumn<KundeFX, String> phoneCol = new TableColumn<>("TelefonNr");
		phoneCol.setCellValueFactory(new PropertyValueFactory<>("telefonNr"));
		phoneCol.setMinWidth(100);
		TableColumn<KundeFX, String> ageCol = new TableColumn<>("Alter");
		ageCol.setCellValueFactory(new PropertyValueFactory<>("alter"));
		ageCol.setMinWidth(50);
		TableColumn<KundeFX, Integer> weightCol = new TableColumn<>("Gewicht");
		weightCol.setCellValueFactory(new PropertyValueFactory<>("gewicht"));
		weightCol.setMinWidth(50);
		TableColumn<KundeFX, Double> sizeCol = new TableColumn<>("Schuhgroesse");
		sizeCol.setCellValueFactory(new PropertyValueFactory<>("schuhgroesse"));
		sizeCol.setMinWidth(50);
		TableColumn<KundeFX, String> pisteCol = new TableColumn<>("PistenPraef");
		pisteCol.setCellValueFactory(new PropertyValueFactory<>("pistenPraef"));
		pisteCol.setMinWidth(50);
		// TableColumn<KundeFX, Boolean> beinCol = new TableColumn<>("Beinstellung");
		// beinCol.setCellValueFactory(new PropertyValueFactory<>("beinstellung"));
		// beinCol.setMinWidth(70);

		TableView<KundeFX> table = new TableView<>();
		ObservableList<KundeFX> kundenFXListe = FXCollections.observableArrayList();
		ArrayList<Kunde> kundenNrs = Datenbank.getKunden();

		for (Kunde ku : kundenNrs) { // kundenobj auf kundenFX umschreiben für Darstellung in TableView
			Kunde kunde = new Kunde(ku.getKundenNr(), ku.getAnrede(), ku.getVorname(), ku.getNachname(),
					ku.getTelefonNr(), ku.getStrasse(), ku.getHausNr(), ku.getWohnort(), ku.getPlz(), ku.getLand(),
					ku.getAlter(), ku.getPistenPraef(), ku.getGewicht(), ku.getSchuhgroesse(), ku.getTechnik(),
					ku.isBeinstellung(), ku.isBindungstyp());
			kundenFXListe.add(new KundeFX(kunde));
		}

		table.setItems(kundenFXListe);
		table.getColumns().addAll(customerIdCol, firstNameCol, lastNameCol, ortCol, landCol, phoneCol, ageCol,
				weightCol, sizeCol, pisteCol);

		borderPanetp3.setCenter(table);
		tp3.setContent(borderPanetp3);

	}

	private void displayTp2() { // Anzeige dieser TP bei Rücknahme des Produkts
		// GRIDPANE LABELS
		gridPanetp2.setPadding(new Insets(10, 10, 10, 10));
		gridPanetp2.setVgap(5);
		gridPanetp2.setHgap(5);
		gridPanetp2.add(lb1tp2, 0, 0);
		gridPanetp2.add(lb2tp2, 0, 1);
		gridPanetp2.add(lb3tp2, 0, 2);
		gridPanetp2.add(lb4tp2, 0, 3);
		gridPanetp2.add(lb5tp2, 0, 4);
		gridPanetp2.add(lb6tp2, 0, 5);

		// GRIDPANE TEXTFELDER
		gridPanetp2.add(tf1tp2, 1, 0);
		gridPanetp2.add(tf2tp2, 1, 1);
		gridPanetp2.add(tf3tp2, 1, 2);
		gridPanetp2.add(tf4tp2, 1, 3);
		gridPanetp2.add(tf5tp2, 1, 4);
		gridPanetp2.add(tf6tp2, 1, 5);

		// BORDERPANE
		BorderPane borderPanetp2 = new BorderPane();
		borderPanetp2.setPadding(new Insets(5));
		borderPanetp2.setPrefSize(700, 580);
		borderPanetp2.setCenter(gridPanetp2);
		borderPanetp2.setBottom(bt1tp2);
		tp2.setContent(borderPanetp2);

		bt1tp2.setOnAction(bt -> {
			Datenbank.updateAusleiheKaution(Integer.parseInt(tf1.getText()), Double.parseDouble(tf5tp2.getText())); // kaution
																													// updaten
			tp2.setExpanded(false);
		});

	}

	private void displayTp1() { // Anzeige dieser TP bei Ausleihe des Produkts

		// GRIDPANE LABELS
		gridPanetp1.setPadding(new Insets(10, 10, 10, 10));
		gridPanetp1.setVgap(5);
		gridPanetp1.setHgap(5);
		gridPanetp1.add(lb1tp1, 0, 0);
		gridPanetp1.add(lb2tp1, 0, 1);
		gridPanetp1.add(lb3tp1, 0, 2);
		gridPanetp1.add(lb4tp1, 0, 3);

		// GRIDPANE TEXTFELDER
		gridPanetp1.add(tf1tp1, 1, 0);
		gridPanetp1.add(tf2tp1, 1, 1);
		gridPanetp1.add(tf3tp1, 1, 2);
		gridPanetp1.add(tf4tp1, 1, 3);

		// BORDERPANE
		BorderPane borderPanetp1 = new BorderPane();
		borderPanetp1.setPadding(new Insets(5));
		borderPanetp1.setPrefSize(700, 580);
		borderPanetp1.setCenter(gridPanetp1);
		borderPanetp1.setBottom(bt1tp1);
		tp1.setContent(borderPanetp1);

		bt1tp1.setOnAction(bt -> {
			tp1.setExpanded(false);
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
