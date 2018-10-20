import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class KundenGUI_Dialog1 extends Dialog<Integer> {

	// OBJEKTE
	Kunde k = new Kunde();
	Ausleihe a = new Ausleihe();
	Ski sk = new Ski();
	SkiFX skfx = new SkiFX();
	Snowboard sb = new Snowboard();
	Kreditkarte kk = new Kreditkarte();
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
	// TP2
	HBox hb1tp2 = new HBox();
	HBox hb2tp2 = new HBox();
	HBox hb3tp2 = new HBox();
	VBox vb1tp2 = new VBox();
	GridPane gridPanetp2 = new GridPane();
	Label lb1tp2 = new Label("Gem�� Ihren Angaben k�nnen wir Ihnen folgende Produkte zur Auswahl anbieten: ");
	Label lb2tp2 = new Label();
	Label lb3tp2 = new Label();
	Label lb4tp2 = new Label("von: ");
	Label lb5tp2 = new Label(" bis: ");
	Label lb6tp2 = new Label("pic");
	Label lb7tp2 = new Label("pic");
	Label lb8tp2 = new Label("pic");
	Button bt1tp2 = new Button("Weiter");
	RadioButton rb1tp2 = new RadioButton("");
	RadioButton rb2tp2 = new RadioButton("");
	RadioButton rb3tp2 = new RadioButton("");
	ToggleGroup grouptp2 = new ToggleGroup();
	// TP3
	VBox vb1tp3 = new VBox();
	GridPane gridPanetp3 = new GridPane();
	TextField tf1tp3 = new TextField(); // Anrede
	TextField tf2tp3 = new TextField(); // Vorn
	TextField tf3tp3 = new TextField(); // Nachn
	TextField tf4tp3 = new TextField(); // tel
	TextField tf5tp3 = new TextField(); // str
	TextField tf6tp3 = new TextField(); // hausnr
	TextField tf7tp3 = new TextField(); // wohnort
	TextField tf8tp3 = new TextField(); // plz
	TextField tf9tp3 = new TextField(); // land
	TextField tf10tp3 = new TextField(); // krediknr
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

	public KundenGUI_Dialog1(String s, LocalDate selpickupDate, LocalDate selreturnDate) {
		super();
		this.setTitle("DIALOG 1");
		this.setHeaderText("Details zu ");

		// Anlage TITLED PANES
		tp1.setText("SCHRITT 1: Basisangaben");
		tp2.setText("SCHRITT 2: Produktauswahl");
		tp3.setText("SCHRITT 3: Dateneingabe");
		// TP Methoden
		displayTp1(s, skfx, sb);
		displayTp2(selpickupDate, selreturnDate);
		displayTp3();
		// accordion set up
		accordion.setPrefHeight(600);
		accordion.setPrefWidth(600);
		accordion.setExpandedPane(tp1); // erstes tp ge�ffnet
		this.getDialogPane().setContent(accordion);
		// button types
		ButtonType close = ButtonType.OK;
		ButtonType cancel = ButtonType.CANCEL;
		this.getDialogPane().getButtonTypes().addAll(close, cancel);
		// OK Button function
		this.setResultConverter(new Callback<ButtonType, Integer>() {
			@Override
			public Integer call(ButtonType arg0) {
				if (arg0 == close)
					if (!tf1tp1.getText().isEmpty() && !tf2tp1.getText().isEmpty()) { // alle TF??
						try {
							// TP1 TF INPUT abfragen
							k.setAlter(Integer.parseInt(tf1tp1.getText()));
							k.setGewicht(Integer.parseInt(tf2tp1.getText()));
							k.setSchuhgroesse(Integer.parseInt(tf3tp1.getText()));
							k.setTechnik(cob1tp1.getSelectionModel().getSelectedItem());
							k.setPistenPraef(cob2tp1.getSelectionModel().getSelectedItem());
							k.setBeinstellung(Boolean.parseBoolean(cob3tp1.getSelectionModel().getSelectedItem()));
							k.setBindungstyp(Boolean.parseBoolean(cob4tp1.getSelectionModel().getSelectedItem()));
							// TP2 Auswahl abfragen

							// TP3 TF Input abfragen
							k.setAnrede(Integer.parseInt(tf1tp3.getText()));
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

							// in DB speichern
							Datenbank.postKunde(k);
							// Ausgabe Kunden in Konsole
							Datenbank.getKunden();
							// Ausleihe: Abholnummer mit Kdnr speichern
							// Datenbank.postAusleihe(k, a, sk, sb);

							new KundenGUI_Dialog2(k.getKundenNr()).showAndWait();
						} catch (IOException e) {

							e.printStackTrace();
						}
					} else
						try {
							new KundenGUI_Dialog2(k.getKundenNr()).showAndWait();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				return null;
			}
		});

	}

	private void displayTp3() {

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

		gridPanetp3.add(tf1tp3, 1, 0);
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

		// BORDERPANE
		BorderPane borderPanetp3 = new BorderPane();
		borderPanetp3.setPadding(new Insets(5));
		borderPanetp3.setPrefSize(700, 580);
		borderPanetp3.setTop(lb1tp3);
		borderPanetp3.setCenter(gridPanetp3);

		tp3.setContent(borderPanetp3);
		accordion.getPanes().add(tp3);

	}

	private void displayTp2(LocalDate selpickupDate, LocalDate selreturnDate) {

		rb1tp2.setToggleGroup(grouptp2); // damit nur 1 radiobutton ausgew�hlt werden kann!
		rb2tp2.setToggleGroup(grouptp2);
		rb3tp2.setToggleGroup(grouptp2);
		lb2tp2.setText(selpickupDate.toString());
		lb3tp2.setText(selreturnDate.toString());
		hb1tp2.getChildren().addAll(lb4tp2, lb2tp2, lb5tp2, lb3tp2);
		hb2tp2.getChildren().addAll(rb1tp2, rb2tp2, rb3tp2);
		hb3tp2.getChildren().addAll(lb6tp2, lb7tp2, lb8tp2);
		vb1tp2.getChildren().addAll(hb1tp2, hb2tp2, hb3tp2);
		// BORDERPANE
		BorderPane borderPanetp2 = new BorderPane();
		borderPanetp2.setPadding(new Insets(5));
		borderPanetp2.setPrefSize(700, 580);
		// borderPanetp2.setTop(lb1tp2);
		borderPanetp2.setCenter(vb1tp2);
		borderPanetp2.setBottom(bt1tp2);

		tp2.setContent(borderPanetp2);
		accordion.getPanes().add(tp2);

		grouptp2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> arg0, Toggle oldToggle, Toggle newToggle) {
				if (rb1tp2.isSelected()) {
					a.setSkiNr(Datenbank.getSki(rb1tp2.getText()));
					System.out.println(rb1tp2.getText() + " gew�hlt");
				} else if (rb2tp2.isSelected()) {
					a.setSkiNr(Datenbank.getSki(rb2tp2.getText()));
					System.out.println(rb2tp2.getText() + " gew�hlt");
				} else if (rb3tp2.isSelected()) {
					a.setSkiNr(Datenbank.getSki(rb3tp2.getText()));
					System.out.println(rb3tp2.getText() + " gew�hlt");
				}
			}

		});

		bt1tp2.setOnAction(bp -> {
			accordion.setExpandedPane(tp3);
		});

	}

	private void displayTp1(String s, SkiFX skfx, Snowboard sb) {

		// GRIDPANE LABELS
		gridPanetp1.setPadding(new Insets(10, 10, 10, 10));
		gridPanetp1.setVgap(5);
		gridPanetp1.setHgap(5);
		gridPanetp1.add(lb2tp1, 0, 0);
		gridPanetp1.add(lb3tp1, 0, 1);
		gridPanetp1.add(lb4tp1, 0, 2);
		gridPanetp1.add(lb5tp1, 0, 3);
		gridPanetp1.add(lb6tp1, 0, 4);
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
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")) {
				System.out.println("Skikategorie 1 gew�hlt");
				Datenbank.getSki(1);

				// ArrayList<Ski> skiIds = Datenbank.getSki(1);
				// ObservableList<SkiFX> skiListe = FXCollections.observableArrayList();;
				// ArrayList<Ski> skiIDs = Datenbank.getSki(1);
				// for (Ski sk : skiIDs) {
				// r += sk.getSkiProduktname() + " " + sk.getFarbe() + ", ";
				// Ski w = new Ski(0, 0, r, r, r, r, 0, r);
				// skiListe.add(new SkiFX(w));
				// rb1tp2.setText(r.substring(0, r.length() - 2));
				// }
				String r1 = Datenbank.getSki(1).get(0).getSkiProduktname();
				rb1tp2.setText(r1);
				String r2 = Datenbank.getSki(1).get(1).getSkiProduktname();
				rb2tp2.setText(r2);
				String r3 = Datenbank.getSki(1).get(2).getSkiProduktname();
				rb3tp2.setText(r3);

				URI uri = Paths.get(Datenbank.getSki(1).get(0).getSkiBildpfad()).toUri();
				ImageView imageView = new ImageView(uri.toString());
				imageView.setFitHeight(100);
				imageView.setFitWidth(100);
				rb1tp2.setGraphic(imageView);

			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Skikategorie 1 gew�hlt");
				Datenbank.getSki(1);

				// --> Ski KAT2
			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")) {
				System.out.println("Skikategorie 2 gew�hlt");
				Datenbank.getSki(2);

			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Skikategorie 2 gew�hlt");
				Datenbank.getSki(2);

				// --> Ski KAT3
			} else if (s.equals("Ski") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")) {
				System.out.println("Skikategorie 3 gew�hlt");
				Datenbank.getSki(3);

				// SNOWBOARD KAT1
			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("schlecht")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("Halfpipe")) {
				System.out.println("Snowboardkategorie 1 gew�hlt");
				Datenbank.getSnowboard(1);
				rb1tp2.setText(" test ");
				rb2tp2.setText(" test ");
				rb3tp2.setText(" test ");

			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Snowboardkategorie 1 gew�hlt");
				Datenbank.getSnowboard(1);

				// --> Sb KAT2
			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("mittel")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("Halfpipe")) {
				System.out.println("Snowboardkategorie 2 gew�hlt");
				Datenbank.getSnowboard(2);

			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("blau")) {
				System.out.println("Snowboardkategorie 2 gew�hlt");
				Datenbank.getSnowboard(2);

				// --> Sb KAT3
			} else if (s.equals("Snowboard") && cob1tp1.getSelectionModel().getSelectedItem().equals("sehr gut")
					&& cob2tp1.getSelectionModel().getSelectedItem().equals("rot")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("schwarz")
					|| cob2tp1.getSelectionModel().getSelectedItem().equals("Halfpipe")) {
				System.out.println("Snowboardkategorie 3 gew�hlt");
				Datenbank.getSnowboard(3);

			}

			accordion.setExpandedPane(tp2);
		});

	}

}
