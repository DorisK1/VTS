import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	TextField tf3tp1 = new TextField(); // SChuhgr�sse
	ComboBox<String> cob1tp1 = new ComboBox<>(); // Techn.
	ComboBox<String> cob2tp1 = new ComboBox<>(); // Pisten
	ComboBox<String> cob3tp1 = new ComboBox<>(); // BEinst.
	ComboBox<String> cob4tp1 = new ComboBox<>(); // schuh
	Label lb1tp1 = new Label("Vielen Dank. Sie haben Ski gew�hlt. Bitte vervollst�ndigen Sie untenstehende Angaben: ");
	Label lb2tp1 = new Label("Alter");
	Label lb3tp1 = new Label("Gewicht");
	Label lb4tp1 = new Label("Schuhgr��e");
	Label lb5tp1 = new Label("Technisches K�nnen");
	Label lb6tp1 = new Label("Pistenpr�ferenz");
	Label lb7tp1 = new Label("Beinstellung"); // nur f�r Snowboard!!!
	Label lb8tp1 = new Label("Schuhart"); // nur f�r Snowboard!!!
	Label lb9tp1 = new Label(); // Fehlermeldung f�r Alter
	Label lb10tp1 = new Label(); // Fehlermeldung f�r Gewicht
	Label lb11tp1 = new Label(); // Fehlermeldung f�r Schuhgr��e

	// TP2
	HBox hb1tp2 = new HBox();
	HBox hb2tp2 = new HBox();
	HBox hb3tp2 = new HBox();
	HBox hb4tp2 = new HBox();
	VBox vb1tp2 = new VBox();
	VBox vb2tp2 = new VBox();
	GridPane gridPanetp2 = new GridPane();
	Label lb1tp2 = new Label("Gem�� Ihren Angaben k�nnen wir Ihnen folgende Produkte zur Auswahl anbieten: ");
	Label lb2tp2 = new Label(); //Leihstart - Datum
	Label lb3tp2 = new Label(); //Leihende - Datum
	Label lb4tp2 = new Label("von: ");
	Label lb5tp2 = new Label(" bis: ");
	Button bt1tp2 = new Button("Weiter");
	RadioButton rb1tp2 = new RadioButton("");
	RadioButton rb2tp2 = new RadioButton("");
	RadioButton rb3tp2 = new RadioButton("");
	ToggleGroup grouptp2 = new ToggleGroup();
	// set Radiobuttons
	VBox vb3tp2 = new VBox();
	Label lb6tp2 = new Label();
	Label lb7tp2 = new Label();
	Label lb8tp2 = new Label();
	// TP3
	VBox vb1tp3 = new VBox();
	GridPane gridPanetp3 = new GridPane();
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
	TextField tf13tp3 = new TextField(); // kkpr�f
	TextField tf14tp3 = new TextField(); // kkg�lt
	Label lb1tp3 = new Label("Vielen Dank f�r Ihre Auswahl. Bitte vervollst�ndigen Sie untenstehende Angaben: ");
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
	Label lb14tp3 = new Label("Kreditkartenpr�fnummer");
	Label lb15tp3 = new Label("Kreditkarteng�ltigkeit");
	Label lb16tp3 = new Label(""); 
	//Fehleranzeigen ff
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

	public KundenGUI_Dialog1(String s, LocalDate selpickupDate, LocalDate selreturnDate, Ausleihe a) { //AUFBAU des Dialogs
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
				lb2.setText("Kundennummer gefunden!");
			} else {
				lb2.setText("Kundennummer nicht gefunden!");
			}

		});
		
		
		// TP Methoden
		displayTp1(s, skfx, sb);
		displayTp2(selpickupDate, selreturnDate, a, s);
		displayTp3();
		// accordion set up
		accordion.setPrefHeight(600);
		accordion.setPrefWidth(600);
		accordion.setExpandedPane(tp1); // erstes tp ge�ffnet
		vb1.getChildren().addAll(hb1, lb2, accordion);
		this.getDialogPane().setContent(vb1);
		// button types
		ButtonType close = ButtonType.OK;
		ButtonType cancel = ButtonType.CANCEL;
		this.getDialogPane().getButtonTypes().addAll(close, cancel);
		// OK Button function --> erst wenn OK geklickt wird, werden die Daten in der Datenbank gespeichert
		this.setResultConverter(new Callback<ButtonType, Integer>() {
			@Override
			public Integer call(ButtonType arg0) {
				if (arg0 == close)
					if (isInputValid()) { 
						try {
							// TP1 TF INPUT abfragen und Kundenobjekt anlegen
							k.setAlter(Integer.parseInt(tf1tp1.getText()));
							k.setGewicht(Integer.parseInt(tf2tp1.getText()));
							k.setSchuhgroesse(Integer.parseInt(tf3tp1.getText()));
							k.setTechnik(cob1tp1.getSelectionModel().getSelectedItem());
							k.setPistenPraef(cob2tp1.getSelectionModel().getSelectedItem());
							k.setBeinstellung(Boolean.parseBoolean(cob3tp1.getSelectionModel().getSelectedItem())); 
							//wenn keine Angabe dann by default false????
							k.setBindungstyp(Boolean.parseBoolean(cob4tp1.getSelectionModel().getSelectedItem()));
							// TP3 TF Input abfragen
							if (cob1tp3.getSelectionModel().getSelectedItem().equals("Frau")) {
								k.setAnrede(1);
							} else if (cob1tp3.getSelectionModel().getSelectedItem().equals("Mann")) {
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
							kk.setKreditkartenNr(tf10tp3.getText());
							kk.setKreditkartenName(tf11tp3.getText());
							kk.setInhaberName(tf12tp3.getText());
							kk.setPruefzahl(tf13tp3.getText());
							kk.setGueltigkeit(tf14tp3.getText());

							Datenbank.postKunde(k); // Kunde in DB speichern
							Datenbank.getKunden(); // Ausgabe aller Kunden in Konsole zur �berpr�fung

							// Ausleihe Obj anlegen
							a.setKundenNr(k.getKundenNr());
							a.setKaution(200); // immer 200
							a.setNachzahlung(0); //kann sich noch �ndern
							a.setGesamtpreis(a.getMietpreis() + a.getKaution() + a.getNachzahlung());

							// Ausleihe in DB anlegen und holen
							Datenbank.postAusleihe(a); // Ausleihe in der Datenbank speichern
							Datenbank.getAusleihe(a.getAbholNr()); // letzte Ausleihe anzeigen - Falsch?
							Datenbank.getAusleihen(); //alle Ausleihen anzeigen

							new KundenGUI_Dialog2(k.getKundenNr()).showAndWait(); //n�chsten Dialog �ffnen
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else
						System.out.println("FEHLERHAFTE EINGABE");
				return null;
			}

		});

	}

	public boolean isInputValid() { // pr�ft ob alle Inputfelder bef�llt wurden; falls nicht kommt warnhinweis 

		Boolean b = false;
		//String s = null;
		// ALTER
		if (!(tf1tp1.getText() == null || tf1tp1.getText().length() == 0)) { //Auch f�r alle anderen Textfelder schreiben
			b = true;
		} else {
			 Alert alert = new Alert(AlertType.ERROR);
		        alert.setTitle("FEHLERHAFTE EINGABE!");
		        alert.setContentText("DATEN FEHLEN!!!");
		        alert.showAndWait();
		        
			//OPTIONAL gel�st mit DIALOG3 als Warnhinweis - funktioniert aber auch nicht!
//			s = "FEHLERHAFTE EINGABE!";
//			new KundenGUI_Dialog3(s).showAndWait();
		}
		return b;
	}

	private double calcMietpreis(LocalDate selpickupDate, LocalDate selreturnDate, String produktname, String s) { //berechnet Miete aus Datum

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

	private void displayTp3() { // Aufbau der TabPane 3 - Kundendaten

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
		// gridPanetp3.add(lb16tp3, 2, 0);
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

		// Validation user input - Textfelder Kundendaten
		
		tf2tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // Vorn
			
			if (observable != null) {
				if (!tf2tp3.getText().matches("[a-z]*")) {
					tf2tp3.setStyle("-fx-background-color: orangered;");
					lb17tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf2tp3.setStyle("-fx-background-color: white;");
					lb17tp3.setText("");
				}
			}
		});

		tf3tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // Nachn
		
			if (observable != null) {
				if (!tf3tp3.getText().matches("[a-z]*")) {
					tf3tp3.setStyle("-fx-background-color: orangered;");
					lb18tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf3tp3.setStyle("-fx-background-color: white;");
					lb18tp3.setText("");
				}
			}
		});

		tf4tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { 	// tel
			
			if (observable != null) {
				if (!tf4tp3.getText().matches("[a-z]*")) { //UND [0-9]!!!!
					tf4tp3.setStyle("-fx-background-color: orangered;");
					lb19tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf4tp3.setStyle("-fx-background-color: white;");
					lb19tp3.setText("");
				}
			}
		});

		tf5tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // str

			if (observable != null) {
				if (!tf5tp3.getText().matches("[a-z]*")) {
					tf5tp3.setStyle("-fx-background-color: orangered;");
					lb20tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf5tp3.setStyle("-fx-background-color: white;");
					lb20tp3.setText("");
				}
			}
		});

		tf6tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // hausnr

			if (observable != null) {
				if (!tf6tp3.getText().matches("[a-z]*")) { // UND 0-9
					tf6tp3.setStyle("-fx-background-color: orangered;");
					lb21tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf6tp3.setStyle("-fx-background-color: white;");
					lb21tp3.setText("");
				}
			}
		});

		tf7tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // wohnort

			if (observable != null) {
				if (!tf7tp3.getText().matches("[a-z]*")) {
					tf7tp3.setStyle("-fx-background-color: orangered;");
					lb22tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf7tp3.setStyle("-fx-background-color: white;");
					lb22tp3.setText("");
				}
			}
		});

		tf8tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // plz

			if (observable != null) {
				if (!tf8tp3.getText().matches("[a-z]*")) { // UND 0-9!!!
					tf8tp3.setStyle("-fx-background-color: orangered;");
					lb23tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf8tp3.setStyle("-fx-background-color: white;");
					lb23tp3.setText("");
				}
			}
		});

		tf9tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { 	// land

			if (observable != null) {
				if (!tf9tp3.getText().matches("[a-z]*")) {
					tf9tp3.setStyle("-fx-background-color: orangered;");
					lb24tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf9tp3.setStyle("-fx-background-color: white;");
					lb24tp3.setText("");
				}
			}
		});

		tf10tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // kknr

			if (observable != null) {
				if (!tf10tp3.getText().matches("[0-9]*")) {
					tf10tp3.setStyle("-fx-background-color: orangered;");
					lb25tp3.setText("Falsche Eingabe - nur Zahlen!");
				} else {
					tf10tp3.setStyle("-fx-background-color: white;");
					lb25tp3.setText("");
				}
			}
		});

		tf11tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // kkname

			if (observable != null) {
				if (!tf11tp3.getText().matches("[a-z]*")) {
					tf11tp3.setStyle("-fx-background-color: orangered;");
					lb26tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf11tp3.setStyle("-fx-background-color: white;");
					lb26tp3.setText("");
				}
			}
		});

		tf12tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // kkinhabername

			if (observable != null) {
				if (!tf12tp3.getText().matches("[a-z]*")) {
					tf12tp3.setStyle("-fx-background-color: orangered;");
					lb27tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf12tp3.setStyle("-fx-background-color: white;");
					lb27tp3.setText("");
				}
			}
		});

		tf13tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // kkpr�f
			
			if (observable != null) {
				if (!tf13tp3.getText().matches("[0-9]*")) {
					tf13tp3.setStyle("-fx-background-color: orangered;");
					lb28tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf13tp3.setStyle("-fx-background-color: white;");
					lb28tp3.setText("");
				}
			}
		});

		tf14tp3.focusedProperty().addListener((observable, oldValue, newValue) -> { // kkg�lt

			if (observable != null) {
				if (!tf14tp3.getText().matches("[0-9]*")) { //UND Sonderzeichen 10/20/2020
					tf14tp3.setStyle("-fx-background-color: orangered;");
					lb29tp3.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf14tp3.setStyle("-fx-background-color: white;");
					lb29tp3.setText("");
				}
			}
		});

		// BORDERPANE
		BorderPane borderPanetp3 = new BorderPane();
		borderPanetp3.setPadding(new Insets(5));
		borderPanetp3.setPrefSize(700, 580);
		borderPanetp3.setTop(lb1tp3);
		borderPanetp3.setCenter(gridPanetp3);

		tp3.setContent(borderPanetp3);
		accordion.getPanes().add(tp3);

	}

	private void displayTp2(LocalDate selpickupDate, LocalDate selreturnDate, Ausleihe a, String s) { //AUFBAU TP2 Produktauswahl
		rb1tp2.setToggleGroup(grouptp2); // damit nur 1 radiobutton ausgew�hlt werden kann!
		rb2tp2.setToggleGroup(grouptp2);
		rb3tp2.setToggleGroup(grouptp2);
		lb2tp2.setText(selpickupDate.toString());
		lb3tp2.setText(selreturnDate.toString());
		hb1tp2.getChildren().addAll(lb4tp2, lb2tp2, lb5tp2, lb3tp2); // Datumsanzeige
		vb1tp2.getChildren().addAll(rb1tp2, lb6tp2, rb2tp2, lb7tp2, rb3tp2, lb8tp2);

		// BORDERPANE
		BorderPane borderPanetp2 = new BorderPane();
		borderPanetp2.setPadding(new Insets(5));
		borderPanetp2.setPrefSize(700, 580);
		borderPanetp2.setCenter(vb1tp2);
		borderPanetp2.setBottom(bt1tp2);

		tp2.setContent(borderPanetp2);
		accordion.getPanes().add(tp2);

		grouptp2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() { // Aktionen bei Auswahl eines Radionbuttons

			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle oldToggle, Toggle newToggle) {
				String produktname = null;

				if (rb1tp2.isSelected()) {
					if (s.equals("Ski")) {
						a.setSkiNr(Datenbank.getSki(rb1tp2.getText())); //Auswahl ins Ausleihe-Obj speichern
					} else {
						a.setSnowboardNr(Datenbank.getNewSnowboard(rb1tp2.getText()).getSnowboardNr());
					}

					produktname = rb1tp2.getText();
					a.setMietpreis(calcMietpreis(selpickupDate, selreturnDate, produktname, s)); //Mietpreis berechnen
					System.out.println(rb1tp2.getText() + " gew�hlt");
				} else if (rb2tp2.isSelected()) {
					if (s.equals("Ski")) {
						a.setSkiNr(Datenbank.getSki(rb2tp2.getText()));
					} else {
						a.setSnowboardNr(Datenbank.getNewSnowboard(rb2tp2.getText()).getSnowboardNr());
					}
					produktname = rb2tp2.getText();
					a.setMietpreis(calcMietpreis(selpickupDate, selreturnDate, produktname, s));
					System.out.println(rb2tp2.getText() + " gew�hlt");
				} else if (rb3tp2.isSelected()) {
					if (s.equals("Ski")) {
						a.setSkiNr(Datenbank.getSki(rb3tp2.getText()));
					} else {
						a.setSnowboardNr(Datenbank.getNewSnowboard(rb3tp2.getText()).getSnowboardNr());
					}
					produktname = rb3tp2.getText();
					a.setMietpreis(calcMietpreis(selpickupDate, selreturnDate, produktname, s));
					System.out.println(rb3tp2.getText() + " gew�hlt");
				}
			}

		});

		bt1tp2.setOnAction(bp -> {
			accordion.setExpandedPane(tp3);
		});

	}

	private void displayTp1(String s, SkiFX skfx, Snowboard sb) { //AUFBAU TP1 Basisdaten

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

		// nur f�r Snowboard
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
		// nur f�r Snowboard
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
				if (!tf1tp1.getText().matches("[0-9]*")) { // &&{3,110}2.REGEX Bedingung funkt nicht
					tf1tp1.setStyle("-fx-background-color: orangered;");
					lb9tp1.setText("Alter muss zwischen 3 und 110 sein");
				} else {
					tf1tp1.setStyle("-fx-background-color: white;");
					lb9tp1.setText("");
				}
			}
		});

		// CHECK GEWICHT
		tf2tp1.focusedProperty().addListener((observable, oldValue, newValue) -> {

			if (observable != null) {
				if (!tf2tp1.getText().matches("[0-9]*")) {
					tf2tp1.setStyle("-fx-background-color: orangered;");
					lb10tp1.setText("Gewicht eingeben!");
				} else {
					tf2tp1.setStyle("-fx-background-color: white;");
					lb10tp1.setText("");
				}
			}
		});
		// CHECK SCHUHGR�SSE
		tf3tp1.focusedProperty().addListener((observable, oldValue, newValue) -> {

			if (observable != null) {
				if (!tf3tp1.getText().matches("[0-9]*")) {
					tf3tp1.setStyle("-fx-background-color: orangered;");
					lb11tp1.setText("Schuhgr�sse");
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

		// KATEGORIE-BERECHNUNG f�r TP2 mit Weiter Button
		bt1tp1.setOnAction(bp -> { // --> Ski KAT1 2xif
			if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("schlecht")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("blau")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz"))) {
				System.out.println("Skikategorie 1 gew�hlt");
				int i = 1;
				setRadioButtons(i, s);

			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Skikategorie 1 gew�hlt");
				int i = 1;
				setRadioButtons(i, s);

				// --> Ski KAT2
			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz"))) {
				System.out.println("Skikategorie 2 gew�hlt");
				int i = 2;
				setRadioButtons(i, s);

			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Skikategorie 2 gew�hlt");
				int i = 2;
				setRadioButtons(i, s);

				// --> Ski KAT3
			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz"))) {
				System.out.println("Skikategorie 3 gew�hlt");
				int i = 3;
				setRadioButtons(i, s);

				// SNOWBOARD KAT1
			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("schlecht")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("blau")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("Halfpipe"))) {
				System.out.println("Snowboardkategorie 1 gew�hlt");
				int i = 1;
				setRadioButtons(i, s);

			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Snowboardkategorie 1 gew�hlt");
				int i = 1;
				setRadioButtons(i, s);

				// --> Sb KAT2
			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("Halfpipe"))) {
				System.out.println("Snowboardkategorie 2 gew�hlt");
				int i = 2;
				setRadioButtons(i, s);

			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Snowboardkategorie 2 gew�hlt");
				int i = 2;
				setRadioButtons(i, s);

				// --> Sb KAT3
			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& (cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")
							|| cob2tp1.getSelectionModel().getSelectedItem().equals("Halfpipe"))) {
				System.out.println("Snowboardkategorie 3 gew�hlt");
				int i = 3;
				setRadioButtons(i, s);

			}

			accordion.setExpandedPane(tp2);
		});

	}

	private void setRadioButtons(int i, String s) { // Radiobuttons werden mit Bildern der jeweiligen Skikategorie/Snowb.Kat. und dem Tagespreis bef�llt

		if (s.equals("Ski")) {
			Datenbank.getSki(i);
			rb1tp2.setText(Datenbank.getSki(i).get(0).getSkiProduktname());
			lb6tp2.setText(" f�r EUR " + Datenbank.getSki(i).get(0).getTagespreis() + " pro Tag");
			rb2tp2.setText(Datenbank.getSki(i).get(1).getSkiProduktname());
			lb7tp2.setText(" f�r EUR " + Datenbank.getSki(i).get(1).getTagespreis() + " pro Tag");
			rb3tp2.setText(Datenbank.getSki(i).get(2).getSkiProduktname());
			lb8tp2.setText(" f�r EUR " + Datenbank.getSki(i).get(2).getTagespreis() + " pro Tag");

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
			lb6tp2.setText(" f�r EUR " + Datenbank.getSnowboard(i).get(0).getTagespreis() + " pro Tag");
			rb2tp2.setText(Datenbank.getSnowboard(i).get(1).getSnowboardProduktname());
			lb7tp2.setText(" f�r EUR " + Datenbank.getSnowboard(i).get(1).getTagespreis() + " pro Tag");
			rb3tp2.setText(Datenbank.getSnowboard(i).get(2).getSnowboardProduktname());
			lb8tp2.setText(" f�r EUR " + Datenbank.getSnowboard(i).get(2).getTagespreis() + " pro Tag");

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
