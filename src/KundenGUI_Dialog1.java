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
	// TP2
	HBox hb1tp2 = new HBox();
	HBox hb2tp2 = new HBox();
	HBox hb3tp2 = new HBox();
	HBox hb4tp2 = new HBox();
	VBox vb1tp2 = new VBox();
	VBox vb2tp2 = new VBox();
	GridPane gridPanetp2 = new GridPane();
	Label lb1tp2 = new Label("Gemäß Ihren Angaben können wir Ihnen folgende Produkte zur Auswahl anbieten: ");
	Label lb2tp2 = new Label();
	Label lb3tp2 = new Label();
	Label lb4tp2 = new Label("von: ");
	Label lb5tp2 = new Label(" bis: ");
	Button bt1tp2 = new Button("Weiter");
	RadioButton rb1tp2 = new RadioButton("");
	RadioButton rb2tp2 = new RadioButton("");
	RadioButton rb3tp2 = new RadioButton("");
	ToggleGroup grouptp2 = new ToggleGroup();
	//set Radiobuttons
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
	TextField tf10tp3 = new TextField(); // krediknr
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

	public KundenGUI_Dialog1(String s, LocalDate selpickupDate, LocalDate selreturnDate, Ausleihe a) {
		super();
		this.setTitle("DIALOG 1");
		this.setHeaderText("Details zu ");

		// Anlage TITLED PANES
		tp1.setText("SCHRITT 1: Basisangaben");
		tp2.setText("SCHRITT 2: Produktauswahl");
		tp3.setText("SCHRITT 3: Dateneingabe");
		// TP Methoden
		displayTp1(s, skfx, sb);
		displayTp2(selpickupDate, selreturnDate, a, s);
		displayTp3();
		// accordion set up
		accordion.setPrefHeight(600);
		accordion.setPrefWidth(600);
		accordion.setExpandedPane(tp1); // erstes tp geöffnet
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
							Datenbank.getKunden(); // Ausgabe aller Kunden in Konsole

							// Ausleihe Obj anlegen
							a.setKundenNr(k.getKundenNr());
							System.out.println("Mietpreis: " + a.getMietpreis());
							a.setKaution(200);
							a.setNachzahlung(0);
							a.setGesamtpreis(a.getMietpreis() + a.getKaution() + a.getNachzahlung());

							// Ausleihe in DB anlegen und holen
							Datenbank.postAusleihe(a);
							Datenbank.getAusleihe(33);
							Datenbank.getAusleihen();

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

	private double calcMietpreis(LocalDate selpickupDate, LocalDate selreturnDate, String produktname, String s) {
		
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
		// BORDERPANE
		BorderPane borderPanetp3 = new BorderPane();
		borderPanetp3.setPadding(new Insets(5));
		borderPanetp3.setPrefSize(700, 580);
		borderPanetp3.setTop(lb1tp3);
		borderPanetp3.setCenter(gridPanetp3);

		tp3.setContent(borderPanetp3);
		accordion.getPanes().add(tp3);

	}

	private void displayTp2(LocalDate selpickupDate, LocalDate selreturnDate, Ausleihe a, String s) {

		rb1tp2.setToggleGroup(grouptp2); // damit nur 1 radiobutton ausgewählt werden kann!
		rb2tp2.setToggleGroup(grouptp2);
		rb3tp2.setToggleGroup(grouptp2);
		lb2tp2.setText(selpickupDate.toString());
		lb3tp2.setText(selreturnDate.toString());
		hb1tp2.getChildren().addAll(lb4tp2, lb2tp2, lb5tp2, lb3tp2); //Datum 
//		hb2tp2.getChildren().addAll(rb1tp2, lb6tp2); //RadioButton1
//		hb3tp2.getChildren().addAll(rb2tp2, lb7tp2); //RadioButton2
//		hb4tp2.getChildren().addAll(rb3tp2, lb8tp2); //RadioButton3
		vb1tp2.getChildren().addAll(rb1tp2, lb6tp2, rb2tp2, lb7tp2, rb3tp2, lb8tp2);
		
		
//		vb2tp2.getChildren().addAll(rb1tp2, rb2tp2, rb3tp2); //Radiobuttons
//		vb3tp2.getChildren().addAll(lb6tp2, lb7tp2, lb8tp2); //preise
//		hb2tp2.getChildren().addAll(vb2tp2, vb3tp2);
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
				String produktname = null;

				if (rb1tp2.isSelected()) {
					a.setSkiNr(Datenbank.getSki(rb1tp2.getText())); ///?
					a.setSnowboardNr(0);
					produktname = rb1tp2.getText();
					a.setMietpreis(calcMietpreis(selpickupDate, selreturnDate, produktname, s));
					System.out.println(rb1tp2.getText() + " gewählt");
				} else if (rb2tp2.isSelected()) {
					a.setSkiNr(Datenbank.getSki(rb2tp2.getText()));
					a.setSnowboardNr(0);
					produktname = rb2tp2.getText();
					a.setMietpreis(calcMietpreis(selpickupDate, selreturnDate, produktname, s));
					System.out.println(rb2tp2.getText() + " gewählt");
				} else if (rb3tp2.isSelected()) {
					a.setSkiNr(Datenbank.getSki(rb3tp2.getText()));
					a.setSnowboardNr(0);
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

	private void setRadioButtons(int i, String s) {
		
		if (s.equals("Ski")) {
		Datenbank.getSki(i);
		rb1tp2.setText(Datenbank.getSki(i).get(0).getSkiProduktname());
		lb6tp2.setText(" für EUR " + Datenbank.getSki(i).get(0).getTagespreis() + " pro Tag");
		rb2tp2.setText(Datenbank.getSki(i).get(1).getSkiProduktname());
		lb7tp2.setText(" für EUR " + Datenbank.getSki(i).get(1).getTagespreis() + " pro Tag");
		rb3tp2.setText(Datenbank.getSki(i).get(2).getSkiProduktname());
		lb8tp2.setText(" für EUR " + Datenbank.getSki(i).get(2).getTagespreis() + " pro Tag");

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
			lb6tp2.setText(" für EUR " + Datenbank.getSnowboard(i).get(0).getTagespreis() + " pro Tag");
			rb2tp2.setText(Datenbank.getSnowboard(i).get(1).getSnowboardProduktname());
			lb7tp2.setText(" für EUR " + Datenbank.getSnowboard(i).get(1).getTagespreis() + " pro Tag");
			rb3tp2.setText(Datenbank.getSnowboard(i).get(2).getSnowboardProduktname());
			lb8tp2.setText(" für EUR " + Datenbank.getSnowboard(i).get(2).getTagespreis() + " pro Tag");

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
