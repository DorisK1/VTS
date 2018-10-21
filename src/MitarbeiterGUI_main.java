
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MitarbeiterGUI_main extends Application {

	VBox vb1 = new VBox();
	Label lb1 = new Label("Bitte Abholnummer eingeben:");
	TextField tf1 = new TextField();
	Button bt1 = new Button("Suche");
	
	// ACCORDION
	Accordion accordion = new Accordion();
	TitledPane tp1 = new TitledPane();
	TitledPane tp2 = new TitledPane();
	TitledPane tp3 = new TitledPane();
	TitledPane tp4 = new TitledPane();
	TitledPane tp5 = new TitledPane();

	// TP1
	VBox vb1tp1 = new VBox();
	GridPane gridPanetp1 = new GridPane();
	TextField tf1tp1 = new TextField();
	TextField tf2tp1 = new TextField();
	TextField tf3tp1 = new TextField();
	TextField tf4tp1 = new TextField();
	Label lb1tp1 = new Label("Produktnummer");
	Label lb2tp1 = new Label("Regalplatz");
	Label lb3tp1 = new Label("Zeitpunkt der Ausleihe");
	Label lb4tp1 = new Label("Kundendaten");

	// TP2
	VBox vb1tp2 = new VBox();
	GridPane gridPanetp2 = new GridPane();
	TextField tf1tp2 = new TextField();
	TextField tf2tp2 = new TextField();
	TextField tf3tp2 = new TextField();
	TextField tf4tp2 = new TextField();
	TextField tf5tp2 = new TextField();
	TextField tf6tp2 = new TextField();
	Label lb1tp2 = new Label("Produktnummer");
	Label lb2tp2 = new Label("Regalplatz");
	Label lb3tp2 = new Label("Zeitpunkt der Rücknahme");
	Label lb4tp2 = new Label("Entstandene Zusatzkosten");
	Label lb5tp2 = new Label("Zu refundierende Kaution");
	Label lb6tp2 = new Label("Kundendaten");

	// TP3
	BorderPane borderPanetp3 = new BorderPane();
	Label lb1tp3 = new Label();

	// TP4
	BorderPane borderPanetp4 = new BorderPane();
	Label lb1tp4 = new Label();
	Button bt1tp4 = new Button("NEU");
	Button bt2tp4 = new Button("LÖSCHEN");
	HBox h1tp4 = new HBox();

	// TP5
	BorderPane borderPanetp5 = new BorderPane();
	Label lb1tp5 = new Label();
	Button bt1tp5 = new Button("NEU");
	Button bt2tp5 = new Button("LÖSCHEN");
	HBox h1tp5 = new HBox();

	@Override
	public void start(Stage primaryStage) {

		Kunde k = new Kunde();
		tf1.setMaxWidth(60);
		tp1.setText("AUSGABE");
		tp2.setText("RÜCKNAHME");
		tp3.setText("KUNDEN");
		tp4.setText("SKI");
		tp5.setText("SNOWBOARD");

		displayTp1();
		displayTp2();
		displayTp3(k);
		displayTp4();
		displayTp5();

		accordion.setPrefHeight(600);
		accordion.setPrefWidth(800);
		accordion.getPanes().addAll(tp1, tp2, tp3, tp4, tp5);
		vb1.getChildren().addAll(lb1, tf1, bt1, accordion);

		// PRIMARY STAGE
		primaryStage.setScene(new Scene(vb1));
		primaryStage.setTitle("MITARBEITERANSICHT");
		primaryStage.setResizable(true);
		primaryStage.show();
		
		bt1.setOnAction(gd -> {
			System.out.println("Abholnummer " + tf1.getText() + " suchen");
			tf1tp1.setText(null); //getProduktNr über Abholnummer

		});

	}

	@SuppressWarnings("unchecked")
	private void displayTp5() {
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

		for (Snowboard sb : sbNrs) {
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

	}

	@SuppressWarnings("unchecked")
	private void displayTp4() {
		// TABLE VIEW
		borderPanetp4.setPadding(new Insets(5));
		h1tp4.getChildren().addAll(bt1tp4, bt2tp4);
		borderPanetp4.setBottom(h1tp4);

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

		ObservableList<SkiFX> skiFXListe = FXCollections.observableArrayList();
		TableView<SkiFX> table = new TableView<>();
		ArrayList<Ski> skiNrs = Datenbank.getSki();

		for (Ski sk : skiNrs) {
			Ski ski = new Ski(sk.getSkiNr(), sk.getSkiKategorieNr(), sk.getSkiProduktname(), sk.getSkiTyp(),
					sk.getSkiBildpfad(), sk.getRegalNr(), sk.getTagespreis(), sk.getFarbe());
			skiFXListe.add(new SkiFX(ski));
		}

		table.setItems(skiFXListe);
		table.getColumns().addAll(skiNrCol, skiKategorieNrCol, skiProduktnameCol, skiTypCol, regalNrCol, tagespreisCol,
				farbeCol); // Anzeige OHNE skiBildpfad!!!!

		borderPanetp4.setCenter(table);
		tp4.setContent(borderPanetp4);
	}

	@SuppressWarnings("unchecked")
	private void displayTp3(Kunde k) {

		// TABLE VIEW
		borderPanetp3.setPadding(new Insets(5));
		borderPanetp3.setBottom(lb1tp3);

		TableColumn<KundeFX, Integer> customerIdCol = new TableColumn<>("kundenNr");
		customerIdCol.setCellValueFactory(new PropertyValueFactory<>("kundenNr"));
		customerIdCol.setMinWidth(100);
		TableColumn<KundeFX, String> firstNameCol = new TableColumn<>("Vorname");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
		firstNameCol.setMinWidth(100);
		TableColumn<KundeFX, String> lastNameCol = new TableColumn<>("Nachname");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
		lastNameCol.setMinWidth(100);
		TableColumn<KundeFX, String> ageCol = new TableColumn<>("Alter");
		ageCol.setCellValueFactory(new PropertyValueFactory<>("alter"));
		ageCol.setMinWidth(200);
		TableColumn<KundeFX, Integer> weightCol = new TableColumn<>("Gewicht");
		weightCol.setCellValueFactory(new PropertyValueFactory<>("gewicht"));
		weightCol.setMinWidth(70);

		TableView<KundeFX> table = new TableView<>();
		ObservableList<KundeFX> kundenFXListe = FXCollections.observableArrayList();
		ArrayList<Kunde> kundenNrs = Datenbank.getKunden();
		
		for (Kunde ku : kundenNrs) {
			Kunde kunde = new Kunde(ku.getKundenNr(), ku.getAnrede(), ku.getVorname(), ku.getNachname(), ku.getTelefonNr(),
					ku.getStrasse(), ku.getHausNr(), ku.getWohnort(), ku.getPlz(), ku.getLand(), ku.getAlter(), ku.getPistenPraef(), ku.getGewicht(),
					ku.getSchuhgroesse(), ku.getTechnik(), ku.isBeinstellung(), ku.isBindungstyp());
			kundenFXListe.add(new KundeFX(kunde));
		}
		
		table.setItems(kundenFXListe);
		table.getColumns().addAll(customerIdCol, firstNameCol, lastNameCol, ageCol, weightCol);

		borderPanetp3.setCenter(table);
		tp3.setContent(borderPanetp3);

	}

	private void displayTp2() {
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

		tp2.setContent(borderPanetp2);

	}

	private void displayTp1() {

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

		tp1.setContent(borderPanetp1);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
