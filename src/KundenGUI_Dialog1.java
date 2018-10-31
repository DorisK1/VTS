import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

public class KundenGUI_Dialog1 extends Dialog<Integer> {

	// OBJEKTE
	Kunde k = new Kunde();
	Ski sk = new Ski();
	SkiFX skfx = new SkiFX();
	Snowboard sb = new Snowboard();
	Kreditkarte kk = new Kreditkarte();
	// SUCHE Kundennummer
	Label lb1 = new Label("Falls Sie bereits eine Kundennummer haben, bitte hier eingeben: ");
	Label lb2 = new Label();
	TextField tf1 = new TextField();
	HBox hb1 = new HBox();
	VBox vb1 = new VBox();
	Button bt1 = new Button("Suche");
	Boolean b = false;
	// ACCORDION
	Accordion accordion = new Accordion();
	TitledPane tp1 = new TitledPane();
	TitledPane tp2 = new TitledPane();
	TitledPane tp3 = new TitledPane();
	// TP1
	Button bt1tp1 = new Button("Weiter");
	VBox vb1tp1 = new VBox();
	GridPane gridPanetp1 = new GridPane();
	TextField tf1tp1 = new TextField(); // Alter
	TextField tf2tp1 = new TextField(); // Gewicht
	TextField tf3tp1 = new TextField(); // SChuhgrösse
	ComboBox<String> cob1tp1 = new ComboBox<>(); // Techn.
	ComboBox<String> cob2tp1 = new ComboBox<>(); // Pisten
	ComboBox<String> cob3tp1 = new ComboBox<>(); // BEinst.
	ComboBox<String> cob4tp1 = new ComboBox<>(); // schuh
	Label lb1tp1 = new Label("Vielen Dank. Sie haben Ski gewählt. Bitte vervollständigen Sie untenstehende Angaben: ");
	Label lb2tp1 = new Label("Alter");
	Label lb3tp1 = new Label("Gewicht");
	Label lb4tp1 = new Label("Schuhgröße");
	Label lb5tp1 = new Label("Technisches Können");
	Label lb6tp1 = new Label("Pistenpräferenz");
	Label lb7tp1 = new Label("Beinstellung"); // nur für Snowboard!!!
	Label lb8tp1 = new Label("Schuhart"); // nur für Snowboard!!!
	Label lb9tp1 = new Label(); // Fehlermeldung für Alter
	Label lb10tp1 = new Label(); // Fehlermeldung für Gewicht
	Label lb11tp1 = new Label(); // Fehlermeldung für Schuhgröße

	// TP2
	HBox hb1tp2 = new HBox();
	HBox hb2tp2 = new HBox();
	HBox hb3tp2 = new HBox();
	HBox hb4tp2 = new HBox();
	VBox vb1tp2 = new VBox();
	VBox vb2tp2 = new VBox();
	GridPane gridPanetp2 = new GridPane();
	Label lb1tp2 = new Label("Gemäß Ihren Angaben können wir Ihnen folgende Produkte zur Auswahl anbieten: ");
	Label lb2tp2 = new Label(); // Leihstart - Datum
	Label lb3tp2 = new Label(); // Leihende - Datum
	Label lb4tp2 = new Label("von: ");
	Label lb5tp2 = new Label(" bis: ");
	Button bt1tp2 = new Button("Weiter");
	RadioButton rb1tp2 = new RadioButton("");
	RadioButton rb2tp2 = new RadioButton("");
	RadioButton rb3tp2 = new RadioButton("");
	ToggleGroup grouptp2 = new ToggleGroup();
	// set Radiobuttons
	VBox vb3tp2 = new VBox();
	Label lb6tp2 = new Label(); // preis
	Label lb7tp2 = new Label(); // preis
	Label lb8tp2 = new Label(); // preis
	Label lb9tp2 = new Label(); // abstand
	Label lb10tp2 = new Label(); // abstand
	Label lb11tp2 = new Label(); // abstand

	// TP3
	VBox vb1tp3 = new VBox();
	GridPane gridPanetp3 = new GridPane();
	ScrollPane sp = new ScrollPane();
	TitledPane tp = new TitledPane();
	ComboBox<String> cob1tp3 = new ComboBox<>(); // Anrede
	TextField tf2tp3 = new TextField(); // Vorn
	TextField tf3tp3 = new TextField(); // Nachn
	TextField tf4tp3 = new TextField(); // tel
	TextField tf5tp3 = new TextField(); // str
	TextField tf6tp3 = new TextField(); // hausnr
	TextField tf7tp3 = new TextField(); // wohnort
	TextField tf8tp3 = new TextField(); // plz
	TextField tf9tp3 = new TextField(); // land
	TextField tf10tp3 = new TextField(); // kknr
	TextField tf11tp3 = new TextField(); // kkname
	TextField tf12tp3 = new TextField(); // kkinhabername
	TextField tf13tp3 = new TextField(); // kkprüf
	TextField tf14tp3 = new TextField(); // kkgült
	Label lb1tp3 = new Label("Vielen Dank für Ihre Auswahl. Bitte vervollständigen Sie untenstehende Angaben: ");
	Label lb2tp3 = new Label("Anrede");
	Label lb3tp3 = new Label("Vorname");
	Label lb4tp3 = new Label("Nachname");
	Label lb5tp3 = new Label("Telefonnummer");
	Label lb6tp3 = new Label("Strasse");
	Label lb7tp3 = new Label("Hausnummer");
	Label lb8tp3 = new Label("Wohnort");
	Label lb9tp3 = new Label("PLZ");
	Label lb10tp3 = new Label("Land");
	Label lb11tp3 = new Label("Kreditkartennummer");
	Label lb12tp3 = new Label("Kreditkartenname");
	Label lb13tp3 = new Label("Kreditkarteninhabername");
	Label lb14tp3 = new Label("Kreditkartenprüfnummer");
	Label lb15tp3 = new Label("Kreditkartengültigkeit");
	Label lb16tp3 = new Label("");
	// Fehleranzeigen
	Label lb17tp3 = new Label("");
	Label lb18tp3 = new Label("");
	Label lb19tp3 = new Label("");
	Label lb20tp3 = new Label("");
	Label lb21tp3 = new Label("");
	Label lb22tp3 = new Label("");
	Label lb23tp3 = new Label("");
	Label lb24tp3 = new Label("");
	Label lb25tp3 = new Label("");
	Label lb26tp3 = new Label("");
	Label lb27tp3 = new Label("");
	Label lb28tp3 = new Label("");
	Label lb29tp3 = new Label("");

	public KundenGUI_Dialog1(String s, LocalDate selpickupDate, LocalDate selreturnDate, Ausleihe a) {
		super();
		this.setTitle("DIALOG 1");
		this.setHeaderText("Details zu ");

		// Anlage TITLED PANES
		tp1.setText("SCHRITT 1: Basisangaben");
		tp2.setText("SCHRITT 2: Produktauswahl");
		tp3.setText("SCHRITT 3: Dateneingabe");
		// Kundennummernsuche
		tf1.setPromptText("Kundennummer");
		hb1.getChildren().addAll(lb1, tf1, bt1);

		bt1.setOnAction(gd -> {
			System.out.println("Kundennummersuche");
			if (Datenbank.getKunde(Integer.parseInt(tf1.getText())).getKundenNr() > 0) {
				lb2.setText("Kundennummer gefunden! Guten Tag "
						+ Datenbank.getKunde(Integer.parseInt(tf1.getText())).getVorname() + " "
						+ Datenbank.getKunde(Integer.parseInt(tf1.getText())).getNachname() + "!");
				tf1tp1.setText(Integer.toString(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getAlter()));
				tf2tp1.setText(Double.toString(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getGewicht()));
				tf3tp1.setText(Double.toString(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getSchuhgroesse()));

				cob1tp3.getItems();
				if (Datenbank.getKunde(Integer.parseInt(tf1.getText())).getAnrede() == 1) {
					cob1tp3.setValue("Frau");
				} else if (Datenbank.getKunde(Integer.parseInt(tf1.getText())).getAnrede() == 2) {
					cob1tp3.setValue("Herr");
				} else if (Datenbank.getKunde(Integer.parseInt(tf1.getText())).getAnrede() == 3) {
					cob1tp3.setValue("divers");
				}

				tf2tp3.setText(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getVorname());
				tf3tp3.setText(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getNachname());
				tf4tp3.setText(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getTelefonNr());
				tf5tp3.setText(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getStrasse());
				tf6tp3.setText(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getHausNr());
				tf7tp3.setText(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getWohnort());
				tf8tp3.setText(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getPlz());
				tf9tp3.setText(Datenbank.getKunde(Integer.parseInt(tf1.getText())).getLand());
				tf10tp3.setText(Datenbank.getKreditkarte(Integer.parseInt(tf1.getText())).getKreditkartenNr());
				tf11tp3.setText(Datenbank.getKreditkarte(Integer.parseInt(tf1.getText())).getKreditkartenName());
				tf12tp3.setText(Datenbank.getKreditkarte(Integer.parseInt(tf1.getText())).getInhaberName());
				tf13tp3.setText(
						Integer.toString(Datenbank.getKreditkarte(Integer.parseInt(tf1.getText())).getPruefzahl()));
				tf14tp3.setText(Datenbank.getKreditkarte(Integer.parseInt(tf1.getText())).getGueltigkeit());

				b = true; // später KEIN neues KundenOBJ sondern NUR Ausleihe speichern!
			} else {
				lb2.setText("Kundennummer nicht gefunden! Bitte geben Sie Ihre Daten ein.");
				b = false;
			}

		});

		// TP Methoden
		displayTp1(s, skfx, sb);
		displayTp2(selpickupDate, selreturnDate, a, s);
		displayTp3();
		// accordion set up
		accordion.setPrefHeight(600);
		accordion.setPrefWidth(600);
		accordion.setExpandedPane(tp1); // erstes tp geöffnet
		vb1.getChildren().addAll(hb1, lb2, accordion);
		this.getDialogPane().setContent(vb1);
		this.getDialogPane().setPrefSize(700, 600);
		// button types
		ButtonType close = ButtonType.OK;
		ButtonType cancel = ButtonType.CANCEL;
		this.getDialogPane().getButtonTypes().addAll(close, cancel);
		// OK Button function --> erst wenn OK geklickt wird, werden die Daten in der
		// Datenbank gespeichert
		final Button btOk = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
		btOk.addEventFilter(ActionEvent.ACTION, event -> {
			if (!isInputValid()) {
				event.consume();

			}
			// getDialogPane().isDisable();
		});
		this.setResultConverter(new Callback<ButtonType, Integer>() {
			@Override
			public Integer call(ButtonType arg0) {
				if (arg0 == close)
					try {
						// Kundenobjekt anlegen NUR wenn NEUKUNDE
						if (b == false) { // = NEUKUNDE
							// TP1 TF INPUT abfragen und
							k.setAlter(Integer.parseInt(tf1tp1.getText()));
							k.setGewicht(Integer.parseInt(tf2tp1.getText()));
							k.setSchuhgroesse(Integer.parseInt(tf3tp1.getText()));
							k.setTechnik(cob1tp1.getSelectionModel().getSelectedItem());
							k.setPistenPraef(cob2tp1.getSelectionModel().getSelectedItem());
							k.setBeinstellung(Boolean.parseBoolean(cob3tp1.getSelectionModel().getSelectedItem()));
							// wenn keine Angabe dann by default false!
							k.setBindungstyp(Boolean.parseBoolean(cob4tp1.getSelectionModel().getSelectedItem()));
							// TP3 TF Input abfragen
							if (cob1tp3.getSelectionModel().getSelectedItem().equals("Frau")) {
								k.setAnrede(1);
							} else if (cob1tp3.getSelectionModel().getSelectedItem().equals("Herr")) {
								k.setAnrede(2);
							} else
								k.setAnrede(3);
							k.setVorname(tf2tp3.getText());
							k.setNachname(tf3tp3.getText());
							k.setTelefonNr(tf4tp3.getText());
							k.setStrasse(tf5tp3.getText());
							k.setHausNr(tf6tp3.getText());
							k.setWohnort(tf7tp3.getText());
							k.setPlz(tf8tp3.getText());
							k.setLand(tf9tp3.getText());
							Datenbank.postKunde(k); // Kunde in DB speichern

							// Kreditkarteninformationen
							kk.setKundenNr(k.getKundenNr());
							kk.setKreditkartenNr(tf10tp3.getText());
							kk.setKreditkartenName(tf11tp3.getText());
							kk.setInhaberName(tf12tp3.getText());
							kk.setPruefzahl(Integer.parseInt(tf13tp3.getText()));
							kk.setGueltigkeit(tf14tp3.getText());
							Datenbank.postKreditkarte(kk); // Kreditkarteninformationen in DB speichern

							// Abfragen
							Datenbank.getKunden(); // Ausgabe aller Kunden in Konsole zur Überprüfung
							Datenbank.getKreditkarten(); // Ausgabe aller KK in Konsole zur Überprüfung

							// Kundennummer NEU
							a.setKundenNr(k.getKundenNr());
						} else {
							// Kundennummer bereits vorhanden
							a.setKundenNr(Integer.parseInt(tf1.getText()));
						}

						// Ausleihe Obj anlegen - für NEU- und Bestandskunden
						a.setKaution(200); // zuerst immer 200 - kann sich später noch ändern
						a.setNachzahlung(0); // zuerst im 0 - kann sich später noch ändern
						a.setGesamtpreis(a.getMietpreis() + a.getKaution() + a.getNachzahlung());

						// Ausleihe in DB anlegen und holen
						Datenbank.postAusleihe(a); // Ausleihe in der Datenbank speichern
						Datenbank.getAusleihe(a.getAbholNr()); // letzte Ausleihe anzeigen - Falsch?
						Datenbank.getAusleihen(); // alle Ausleihen anzeigen

						new KundenGUI_Dialog2(a.getAbholNr(), a.getKundenNr()).showAndWait(); // nächsten Dialog öffnen

					} catch (IOException e) {
						e.printStackTrace();

					}

				return null;
			}

		});

	}

	public boolean isInputValid() { // prüft ob alle Inputfelder befüllt wurden; falls nicht kommt warnhinweis

		Boolean b = false;
		if (!(tf1tp1.getText() == null || tf1tp1.getText().length() == 0)
				&& !(tf2tp1.getText() == null || tf2tp1.getText().length() == 0)
				&& !(tf3tp1.getText() == null || tf3tp1.getText().length() == 0) && !(cob1tp1.getValue() == null)
				&& !(cob2tp1.getValue() == null) && (rb1tp2.isSelected() || rb2tp2.isSelected() || rb3tp2.isSelected())
				&& !(cob1tp3.getValue() == null) && !(tf2tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf3tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf4tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf5tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf6tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf7tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf8tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf9tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf10tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf11tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf12tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf13tp3.getText() == null || tf3tp1.getText().length() == 0)
				&& !(tf14tp3.getText() == null || tf3tp1.getText().length() == 0)) {
			b = true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("FEHLERHAFTE EINGABE!");
			alert.setContentText("DATEN FEHLEN! Bitte kontrollieren Sie Ihre Eingabe");
			alert.showAndWait();

		}
		return b;
	}

	private double calcMietpreis(LocalDate selpickupDate, LocalDate selreturnDate, String produktname, String s) { // berechnet
																													// Miete
																													// aus
																													// Datum

		Period period = Period.between(selpickupDate, selreturnDate);
		int tage = period.getDays() + 1;
		if (s.equals("Ski")) {
			double miete = Datenbank.getNewSki(produktname).getTagespreis() * tage;
			System.out.println("Tage: " + tage);
			System.out.println("Miete: " + miete);
			return miete;
		} else {
			double miete = Datenbank.getNewSnowboard(produktname).getTagespreis() * tage;
			System.out.println("Tage: " + tage);
			System.out.println("Miete: " + miete);
			return miete;
		}
	}

	private void displayTp3() { // Aufbau TP 3 - Kundendaten + input validation

		// GRIDPANE
		gridPanetp3.setPadding(new Insets(10, 10, 10, 10));
		gridPanetp3.setVgap(5);
		gridPanetp3.setHgap(5);
		gridPanetp3.add(lb2tp3, 0, 0);
		gridPanetp3.add(lb3tp3, 0, 1);
		gridPanetp3.add(lb4tp3, 0, 2);
		gridPanetp3.add(lb5tp3, 0, 3);
		gridPanetp3.add(lb6tp3, 0, 4);
		gridPanetp3.add(lb7tp3, 0, 5);
		gridPanetp3.add(lb8tp3, 0, 6);
		gridPanetp3.add(lb9tp3, 0, 7);
		gridPanetp3.add(lb10tp3, 0, 8);
		gridPanetp3.add(lb11tp3, 0, 9);
		gridPanetp3.add(lb12tp3, 0, 10);
		gridPanetp3.add(lb13tp3, 0, 11);
		gridPanetp3.add(lb14tp3, 0, 12);
		gridPanetp3.add(lb15tp3, 0, 13);
		// Fehleranzeigen
		gridPanetp3.add(lb17tp3, 2, 1);
		gridPanetp3.add(lb18tp3, 2, 2);
		gridPanetp3.add(lb19tp3, 2, 3);
		gridPanetp3.add(lb20tp3, 2, 4);
		gridPanetp3.add(lb21tp3, 2, 5);
		gridPanetp3.add(lb22tp3, 2, 6);
		gridPanetp3.add(lb23tp3, 2, 7);
		gridPanetp3.add(lb24tp3, 2, 8);
		gridPanetp3.add(lb25tp3, 2, 9);
		gridPanetp3.add(lb26tp3, 2, 10);
		gridPanetp3.add(lb27tp3, 2, 11);
		gridPanetp3.add(lb28tp3, 2, 12);
		gridPanetp3.add(lb29tp3, 2, 13);
		// Textfelder
		gridPanetp3.add(cob1tp3, 1, 0);
		gridPanetp3.add(tf2tp3, 1, 1);
		gridPanetp3.add(tf3tp3, 1, 2);
		gridPanetp3.add(tf4tp3, 1, 3);
		gridPanetp3.add(tf5tp3, 1, 4);
		gridPanetp3.add(tf6tp3, 1, 5);
		gridPanetp3.add(tf7tp3, 1, 6);
		gridPanetp3.add(tf8tp3, 1, 7);
		gridPanetp3.add(tf9tp3, 1, 8);
		gridPanetp3.add(tf10tp3, 1, 9);
		gridPanetp3.add(tf11tp3, 1, 10);
		gridPanetp3.add(tf12tp3, 1, 11);
		gridPanetp3.add(tf13tp3, 1, 12);
		gridPanetp3.add(tf14tp3, 1, 13);
		cob1tp3.setItems(FXCollections.observableArrayList("Frau", "Herr", "divers"));

		// tf13tp3.setPromptText("999");

		// Validation user input - Textfelder Kundendaten

		tf2tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // Vorn

			if (observable != null) {
				if (!tf2tp3.getText().matches("[a-zA-ZäöüÖÄÜß]*")) { // keine Beschränkung in der Länge
					tf2tp3.setStyle("-fx-background-color: khaki;");
					lb17tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf2tp3.setStyle("-fx-background-color: white;");
					lb17tp3.setText("");
				}
			}
		});

		tf3tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // Nachn

			if (observable != null) {
				if (!tf3tp3.getText().matches("[a-zA-ZäöüÖÄÜß]*")) { // keine Beschränkung in der Länge
					tf3tp3.setStyle("-fx-background-color: khaki;");
					lb18tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf3tp3.setStyle("-fx-background-color: white;");
					lb18tp3.setText("");
				}
			}
		});

		tf4tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // tel

			if (observable != null) {
				if (!tf4tp3.getText().matches("[0-9+ ]*")) { // keine Beschränkung in der Länge
					tf4tp3.setStyle("-fx-background-color: khaki;");
					lb19tp3.setText("Falsche Eingabe - nur Zahlen und '+' !");
				} else {
					tf4tp3.setStyle("-fx-background-color: white;");
					lb19tp3.setText("");
				}
			}
		});

		tf5tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // str

			if (observable != null) {
				if (!tf5tp3.getText().matches("[a-zA-ZäöüÖÄÜß ]*")) { // keine Beschränkung in der Länge
					tf5tp3.setStyle("-fx-background-color: khaki;");
					lb20tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf5tp3.setStyle("-fx-background-color: white;");
					lb20tp3.setText("");
				}
			}
		});

		tf6tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // hausnr

			if (observable != null) {
				if (!tf6tp3.getText().matches("[0-9a-zA-Z ]*")) { // keine Beschränkung in der Länge
					tf6tp3.setStyle("-fx-background-color: khaki;");
					lb21tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf6tp3.setStyle("-fx-background-color: white;");
					lb21tp3.setText("");
				}
			}
		});

		tf7tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // wohnort

			if (observable != null) {
				if (!tf7tp3.getText().matches("[a-zA-ZäöüÖÄÜß ]*")) { // keine Beschränkung in der Länge
					tf7tp3.setStyle("-fx-background-color: khaki;");
					lb22tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf7tp3.setStyle("-fx-background-color: white;");
					lb22tp3.setText("");
				}
			}
		});

		tf8tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // plz

			if (observable != null) {
				if (!tf8tp3.getText().matches("[0-9a-zA-Z ]*")) { // keine Beschränkung in der Länge
					tf8tp3.setStyle("-fx-background-color: khaki;");
					lb23tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf8tp3.setStyle("-fx-background-color: white;");
					lb23tp3.setText("");
				}
			}
		});

		tf9tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // land

			if (observable != null) {
				if (!tf9tp3.getText().matches("[a-zA-ZäöüÖÄÜß]*")) { // keine Beschränkung in der Länge
					tf9tp3.setStyle("-fx-background-color: khaki;");
					lb24tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf9tp3.setStyle("-fx-background-color: white;");
					lb24tp3.setText("");
				}
			}
		});

		tf10tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // kknr

			if (observable != null) {
				if (!tf10tp3.getText().matches("[0-9- ]*")) { // keine Beschränkung in der Länge
					tf10tp3.setStyle("-fx-background-color: khaki;");
					lb25tp3.setText("Falsche Eingabe - nur Zahlen!");
				} else {
					tf10tp3.setStyle("-fx-background-color: white;");
					lb25tp3.setText("");
				}
			}
		});

		tf11tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // kkname

			if (observable != null) {
				if (!tf11tp3.getText().matches("[a-zA-ZäöüÖÄÜß ]*")) { // keine Beschränkung in der Länge
					tf11tp3.setStyle("-fx-background-color: khaki;");
					lb26tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf11tp3.setStyle("-fx-background-color: white;");
					lb26tp3.setText("");
				}
			}
		});

		tf12tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // kkinhabername

			if (observable != null) {
				if (!tf12tp3.getText().matches("[a-zA-ZäöüÖÄÜß ]*")) { // keine Beschränkung in der Länge
					tf12tp3.setStyle("-fx-background-color: khaki;");
					lb27tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf12tp3.setStyle("-fx-background-color: white;");
					lb27tp3.setText("");
				}
			}
		});

		tf13tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // kkprüf

			if (observable != null) {
				if (!tf13tp3.getText().matches("[0-9]{3}")) { // genau 3 Stellen
					tf13tp3.setStyle("-fx-background-color: khaki;");
					lb28tp3.setText("Bitte 3-stellige Kartenprüfnummer eingeben.");
				} else {
					tf13tp3.setStyle("-fx-background-color: white;");
					lb28tp3.setText("");
				}
			}
		});

		tf14tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // kkgült

			if (observable != null) {
				if (!tf14tp3.getText().matches("[0-9]{2}[/]{1}[0-9]{2}")) { // zb 10/20
					tf14tp3.setStyle("-fx-background-color: khaki;");
					lb29tp3.setText("Bitte Gültigkeit __/__ eingeben");
				} else {
					tf14tp3.setStyle("-fx-background-color: white;");
					lb29tp3.setText("");
				}
			}
		});

		// Scrollpane
		sp.vbarPolicyProperty().setValue(ScrollBarPolicy.AS_NEEDED);
		sp.hbarPolicyProperty().setValue(ScrollBarPolicy.ALWAYS);

		// BORDERPANE
		BorderPane borderPanetp3 = new BorderPane(sp);
		borderPanetp3.setPadding(new Insets(5));
		borderPanetp3.setPrefSize(700, 400);
		borderPanetp3.setTop(lb1tp3);
		borderPanetp3.setCenter(gridPanetp3);
		sp.setContent(borderPanetp3);
		tp.setContent(sp);
		tp3.setContent(sp);
		accordion.getPanes().add(tp3);

	}

	private void displayTp2(LocalDate selpickupDate, LocalDate selreturnDate, Ausleihe a, String s) { // AUFBAU TP2
																										// Produktauswahl
		rb1tp2.setToggleGroup(grouptp2); // damit nur 1 radiobutton ausgewählt werden kann!
		rb2tp2.setToggleGroup(grouptp2);
		rb3tp2.setToggleGroup(grouptp2);
		lb2tp2.setText(selpickupDate.toString());
		lb3tp2.setText(selreturnDate.toString());
		lb9tp2.setText(" ");
		lb10tp2.setText(" ");
		lb11tp2.setText(" ");
		hb1tp2.getChildren().addAll(lb4tp2, lb2tp2, lb5tp2, lb3tp2); // Datumsanzeige
		vb1tp2.getChildren().addAll(rb1tp2, lb6tp2, lb9tp2, rb2tp2, lb7tp2, lb10tp2, rb3tp2, lb8tp2, lb11tp2); // rb +
																												// preis

		// BORDERPANE
		BorderPane borderPanetp2 = new BorderPane();
		borderPanetp2.setPadding(new Insets(5));
		borderPanetp2.setPrefSize(700, 580);
		borderPanetp2.setCenter(vb1tp2);
		borderPanetp2.setBottom(bt1tp2);

		tp2.setContent(borderPanetp2);
		accordion.getPanes().add(tp2);

		grouptp2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() { // Aktionen bei Auswahl eines
																						// Radionbuttons

			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle oldToggle, Toggle newToggle) {
				String produktname = null;

				if (rb1tp2.isSelected()) {
					if (s.equals("Ski")) {
						a.setSnowboardNr(0);
						a.setSkiNr(Datenbank.getSki(rb1tp2.getText())); // Auswahl ins Ausleihe-Obj speichern
					} else {
						a.setSkiNr(0);
						a.setSnowboardNr(Datenbank.getNewSnowboard(rb1tp2.getText()).getSnowboardNr());
					}

					produktname = rb1tp2.getText();
					a.setMietpreis(calcMietpreis(selpickupDate, selreturnDate, produktname, s)); // Mietpreis berechnen
					System.out.println(rb1tp2.getText() + " gewählt");
				} else if (rb2tp2.isSelected()) {
					if (s.equals("Ski")) {
						a.setSnowboardNr(0);
						a.setSkiNr(Datenbank.getSki(rb2tp2.getText()));
					} else {
						a.setSkiNr(0);
						a.setSnowboardNr(Datenbank.getNewSnowboard(rb2tp2.getText()).getSnowboardNr());
					}
					produktname = rb2tp2.getText();
					a.setMietpreis(calcMietpreis(selpickupDate, selreturnDate, produktname, s));
					System.out.println(rb2tp2.getText() + " gewählt");
				} else if (rb3tp2.isSelected()) {
					if (s.equals("Ski")) {
						a.setSkiNr(Datenbank.getSki(rb3tp2.getText()));
					} else {
						a.setSkiNr(0);
						a.setSnowboardNr(Datenbank.getNewSnowboard(rb3tp2.getText()).getSnowboardNr());
					}
					produktname = rb3tp2.getText();
					a.setMietpreis(calcMietpreis(selpickupDate, selreturnDate, produktname, s));
					System.out.println(rb3tp2.getText() + " gewählt");
				}
			}

		});

		bt1tp2.setOnAction(bp -> {
			accordion.setExpandedPane(tp3);
		});

	}

	private void displayTp1(String s, SkiFX skfx, Snowboard sb) { // AUFBAU TP1 Basisdaten

		// GRIDPANE LABELS
		gridPanetp1.setPadding(new Insets(10, 10, 10, 10));
		gridPanetp1.setVgap(5);
		gridPanetp1.setHgap(5);
		gridPanetp1.add(lb2tp1, 0, 0);
		gridPanetp1.add(lb3tp1, 0, 1);
		gridPanetp1.add(lb4tp1, 0, 2);
		gridPanetp1.add(lb5tp1, 0, 3);
		gridPanetp1.add(lb6tp1, 0, 4);
		gridPanetp1.add(lb9tp1, 2, 0); // Fehleranzeige
		gridPanetp1.add(lb10tp1, 2, 1); // Fehleranzeige
		gridPanetp1.add(lb11tp1, 2, 2); // Fehleranzeige

		// nur für Snowboard
		if (s.equals("Snowboard")) {
			gridPanetp1.add(lb7tp1, 0, 5);
			gridPanetp1.add(lb8tp1, 0, 6);
		}
		// GRIDPANE TEXTFELDER
		gridPanetp1.add(tf1tp1, 1, 0);
		gridPanetp1.add(tf2tp1, 1, 1);
		gridPanetp1.add(tf3tp1, 1, 2);
		gridPanetp1.add(cob1tp1, 1, 3);
		gridPanetp1.add(cob2tp1, 1, 4);
		// nur für Snowboard
		if (s.equals("Snowboard")) {
			gridPanetp1.add(cob3tp1, 1, 5);
			gridPanetp1.add(cob4tp1, 1, 6);
		}
		// COMBO-BOXEN
		cob1tp1.setItems(FXCollections.observableArrayList("sehr gut", "mittel", "schlecht"));
		if (s.equals("Ski")) {
			cob2tp1.setItems(FXCollections.observableArrayList("blau", "rot", "schwarz"));
		} else {
			cob2tp1.setItems(FXCollections.observableArrayList("blau", "rot", "schwarz", "Halfpipe"));
		}
		cob3tp1.setItems(FXCollections.observableArrayList("regular", "goofy"));
		cob4tp1.setItems(FXCollections.observableArrayList("soft", "hart"));
		// BORDERPANE

		// Check ALTER
		tf1tp1.focusedProperty().addListener((observable, oldValue, newValue) -> {

			if (observable != null) { // ("[0-9]*")
				if (!tf1tp1.getText().matches("[1-9]{1}[0-9]{0,1}")) { // Alter zwischen 1-99
					tf1tp1.setStyle("-fx-background-color: khaki;");
					lb9tp1.setText("Bitte Altersangabe machen.");
				} else {
					tf1tp1.setStyle("-fx-background-color: white;");
					lb9tp1.setText("");
				}
			}
		});

		// CHECK GEWICHT
		tf2tp1.focusedProperty().addListener((observable, oldValue, newValue) -> {

			if (observable != null) {
				if (!tf2tp1.getText().matches("[1-9]{1}[0-9]{1}[0-9]{0,1}")) { // von 10-999
					tf2tp1.setStyle("-fx-background-color: khaki;");
					lb10tp1.setText("Bitte Gewichtsangabe machen (min. 10).");
				} else {
					tf2tp1.setStyle("-fx-background-color: white;");
					lb10tp1.setText("");
				}
			}
		});
		// CHECK SCHUHGRÖSSE
		tf3tp1.focusedProperty().addListener((observable, oldValue, newValue) -> { // 1-99

			if (observable != null) {
				if (!tf3tp1.getText().matches("[1-9]{1}[0-9]{0,1}")) {
					tf3tp1.setStyle("-fx-background-color: khaki;");
					lb11tp1.setText("Bitte Schuhgrösse angeben.");
				} else {
					tf3tp1.setStyle("-fx-background-color: white;");
					lb11tp1.setText("");
				}
			}
		});

		BorderPane borderPanetp1 = new BorderPane();
		borderPanetp1.setPadding(new Insets(5));
		borderPanetp1.setPrefSize(700, 580);
		borderPanetp1.setTop(lb1tp1);
		borderPanetp1.setCenter(gridPanetp1);
		borderPanetp1.setBottom(bt1tp1);
		tp1.setContent(borderPanetp1);
		accordion.getPanes().add(tp1);

		// KATEGORIE-BERECHNUNG für TP2 mit Weiter Button
		bt1tp1.setOnAction(bp -> { // --> Ski KAT1 2xif
			if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("schlecht")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("blau")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz"))) {
				System.out.println("Skikategorie 1 gewählt");
				int i = 1;
				setRadioButtons(i, s);

			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Skikategorie 1 gewählt");
				int i = 1;
				setRadioButtons(i, s);

				// --> Ski KAT2
			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz"))) {
				System.out.println("Skikategorie 2 gewählt");
				int i = 2;
				setRadioButtons(i, s);

			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Skikategorie 2 gewählt");
				int i = 2;
				setRadioButtons(i, s);

				// --> Ski KAT3
			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz"))) {
				System.out.println("Skikategorie 3 gewählt");
				int i = 3;
				setRadioButtons(i, s);

				// SNOWBOARD KAT1
			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("schlecht")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("blau")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("Halfpipe"))) {
				System.out.println("Snowboardkategorie 1 gewählt");
				int i = 1;
				setRadioButtons(i, s);

			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Snowboardkategorie 1 gewählt");
				int i = 1;
				setRadioButtons(i, s);

				// --> Sb KAT2
			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("Halfpipe"))) {
				System.out.println("Snowboardkategorie 2 gewählt");
				int i = 2;
				setRadioButtons(i, s);

			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Snowboardkategorie 2 gewählt");
				int i = 2;
				setRadioButtons(i, s);

				// --> Sb KAT3
			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("Halfpipe"))) {
				System.out.println("Snowboardkategorie 3 gewählt");
				int i = 3;
				setRadioButtons(i, s);

			}

			accordion.setExpandedPane(tp2);
		});

	}

	private void setRadioButtons(int i, String s) { // Radiobuttons werden mit Bildern der jeweiligen
													// Skikategorie/Snowb.Kat. und dem Tagespreis befüllt

		if (s.equals("Ski")) {
			Datenbank.getSki(i);
			rb1tp2.setText(Datenbank.getSki(i).get(0).getSkiProduktname());
			rb1tp2.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
			lb6tp2.setText(
					" für EUR " + Datenbank.getSki(i).get(0).getTagespreis() + " pro Tag (zzgl. Kaution EUR 200.-)");
			rb2tp2.setText(Datenbank.getSki(i).get(1).getSkiProduktname());
			rb2tp2.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
			lb7tp2.setText(
					" für EUR " + Datenbank.getSki(i).get(1).getTagespreis() + " pro Tag (zzgl. Kaution EUR 200.-)");
			rb3tp2.setText(Datenbank.getSki(i).get(2).getSkiProduktname());
			rb3tp2.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
			lb8tp2.setText(
					" für EUR " + Datenbank.getSki(i).get(2).getTagespreis() + " pro Tag (zzgl. Kaution EUR 200.-)");

			URI uri1 = Paths.get(Datenbank.getSki(i).get(0).getSkiBildpfad()).toUri();
			ImageView imageView1 = new ImageView(uri1.toString());
			imageView1.setFitHeight(100);
			imageView1.setFitWidth(100);
			rb1tp2.setGraphic(imageView1);

			URI uri2 = Paths.get(Datenbank.getSki(i).get(1).getSkiBildpfad()).toUri();
			ImageView imageView2 = new ImageView(uri2.toString());
			imageView2.setFitHeight(100);
			imageView2.setFitWidth(100);
			rb2tp2.setGraphic(imageView2);

			URI uri3 = Paths.get(Datenbank.getSki(i).get(2).getSkiBildpfad()).toUri();
			ImageView imageView3 = new ImageView(uri3.toString());
			imageView3.setFitHeight(100);
			imageView3.setFitWidth(100);
			rb3tp2.setGraphic(imageView3);

		} else {
			Datenbank.getSnowboard(i);
			rb1tp2.setText(Datenbank.getSnowboard(i).get(0).getSnowboardProduktname());
			rb1tp2.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
			lb6tp2.setText(" für EUR " + Datenbank.getSnowboard(i).get(0).getTagespreis()
					+ " pro Tag (zzgl. Kaution EUR 200.-)");
			rb2tp2.setText(Datenbank.getSnowboard(i).get(1).getSnowboardProduktname());
			rb2tp2.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
			lb7tp2.setText(" für EUR " + Datenbank.getSnowboard(i).get(1).getTagespreis()
					+ " pro Tag (zzgl. Kaution EUR 200.-)");
			rb3tp2.setText(Datenbank.getSnowboard(i).get(2).getSnowboardProduktname());
			rb3tp2.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
			lb8tp2.setText(" für EUR " + Datenbank.getSnowboard(i).get(2).getTagespreis()
					+ " pro Tag (zzgl. Kaution EUR 200.-)");

			URI uri1 = Paths.get(Datenbank.getSnowboard(i).get(0).getSnowboardBildpfad()).toUri();
			ImageView imageView1 = new ImageView(uri1.toString());
			imageView1.setFitHeight(100);
			imageView1.setFitWidth(100);
			rb1tp2.setGraphic(imageView1);

			URI uri2 = Paths.get(Datenbank.getSnowboard(i).get(1).getSnowboardBildpfad()).toUri();
			ImageView imageView2 = new ImageView(uri2.toString());
			imageView2.setFitHeight(100);
			imageView2.setFitWidth(100);
			rb2tp2.setGraphic(imageView2);

			URI uri3 = Paths.get(Datenbank.getSnowboard(i).get(2).getSnowboardBildpfad()).toUri();
			ImageView imageView3 = new ImageView(uri3.toString());
			imageView3.setFitHeight(100);
			imageView3.setFitWidth(100);
			rb3tp2.setGraphic(imageView3);
		}
	}

}
