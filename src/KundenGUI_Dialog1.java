import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class KundenGUI_Dialog1 extends Dialog<Integer> {

	// BESSER: Dialoge 1-3 als Akkordion! Dialog 4 extra, Optional buttontype
	// bleibt!
	Accordion accordion = new Accordion();
	TitledPane tp1 = new TitledPane();
	TitledPane tp2 = new TitledPane();
	TitledPane tp3 = new TitledPane();
	Button bt1 = new Button("OK");

	// TP1
	VBox vb1tp1 = new VBox();
	GridPane gridPanetp1 = new GridPane();
	TextField tf1tp1 = new TextField();
	TextField tf2tp1 = new TextField();
	TextField tf3tp1 = new TextField();
	TextField tf4tp1 = new TextField();
	TextField tf5tp1 = new TextField();
	TextField tf6tp1 = new TextField();
	TextField tf7tp1 = new TextField();
	
	Label lb1tp1 = new Label("Vielen Dank. Sie haben Ski gewählt. Bitte vervollständigen Sie untenstehende Angaben: ");
	Label lb2tp1 = new Label("Geburtsdatum");
	Label lb3tp1 = new Label("Gewicht");
	Label lb4tp1 = new Label("Schuhgröße");
	Label lb5tp1 = new Label("Technisches Können");
	Label lb6tp1 = new Label("Pistenpräferenz");
	Label lb7tp1 = new Label("Beinstellung"); //nur für Snowboard!!!
	Label lb8tp1 = new Label("Schuhart"); //nur für Snowboard!!!
	

	// TP2
	HBox hb1tp2 = new HBox();
	GridPane gridPanetp2 = new GridPane();
	Label lb1tp2 = new Label("Gemäß Ihren Angaben können wir Ihnen folgende Produkte zur Auswahl anbieten: ");
	Button bt1tp2 = new Button("OK");
	RadioButton rb1tp2 = new RadioButton("");
	RadioButton rb2tp2 = new RadioButton("");
	RadioButton rb3tp2 = new RadioButton("");
	ToggleGroup grouptp2 = new ToggleGroup();

	// TP3
	VBox vb1tp3 = new VBox();
	GridPane gridPanetp3 = new GridPane();
	TextField tf1tp3 = new TextField();
	TextField tf2tp3 = new TextField();
	TextField tf3tp3 = new TextField();
	TextField tf4tp3 = new TextField();
	TextField tf5tp3 = new TextField();
	TextField tf6tp3 = new TextField();
	TextField tf7tp3 = new TextField();
	TextField tf8tp3 = new TextField();
	TextField tf9tp3 = new TextField();
	TextField tf10tp3 = new TextField();
	TextField tf11tp3 = new TextField();
	TextField tf12tp3 = new TextField();
	Label lb1tp3 = new Label("Vielen Dank für Ihre Auswahl. Bitte vervollständigen Sie untenstehende Angaben: ");
	Label lb2tp3 = new Label("Anrede");
	Label lb3tp3 = new Label("Vorname");
	Label lb4tp3 = new Label("Nachname");
	Label lb5tp3 = new Label("Telefonnummer");
	Label lb6tp3 = new Label("Strasse");
	Label lb7tp3 = new Label("Wohnort");
	Label lb8tp3 = new Label("PLZ");
	Label lb9tp3 = new Label("Land");
	Label lb10tp3 = new Label("Kreditkartennummer");
	Label lb11tp3 = new Label("Kreditkartenname");
	Label lb12tp3 = new Label("Kreditkartenprüfnummer");
	Label lb13tp3 = new Label("Kreditkartengültigkeit");

	public KundenGUI_Dialog1() {
		super();
		this.setTitle("DIALOG 1");
		this.setHeaderText("Details zu ");

		// TITLED PANES
		tp1.setText("SCHRITT 1: Präferenzen");
		tp2.setText("SCHRITT 2: Produktauswahl");
		tp3.setText("SCHRITT 3: Dateneingabe");

		displayTp1();
		displayTp2();
		displayTp3();

		// accordion.getPanes().addAll(tp1, tp2, tp3);
		accordion.setPrefHeight(600);
		accordion.setPrefWidth(600);
		accordion.setExpandedPane(tp1); // erstes tp geöffnet

		this.getDialogPane().setContent(accordion);

		ButtonType close = ButtonType.OK;
		ButtonType cancel = ButtonType.CANCEL;
		this.getDialogPane().getButtonTypes().addAll(close, cancel);
		this.setResultConverter(new Callback<ButtonType, Integer>() {

			@Override
			public Integer call(ButtonType arg0) {
				if (arg0 == close) {
					try {
						new KundenGUI_Dialog2().showAndWait();
					} catch (IOException e) {

						e.printStackTrace();
					}
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

		// BORDERPANE
		BorderPane borderPanetp3 = new BorderPane();
		borderPanetp3.setPadding(new Insets(5));
		borderPanetp3.setPrefSize(700, 580);
		borderPanetp3.setTop(lb1tp3);
		borderPanetp3.setCenter(gridPanetp3);

		tp3.setContent(borderPanetp3);
		accordion.getPanes().add(tp3);

	}

	private void displayTp2() {
		rb1tp2.setToggleGroup(grouptp2);
		rb2tp2.setToggleGroup(grouptp2);
		rb3tp2.setToggleGroup(grouptp2);

		hb1tp2.getChildren().addAll(rb1tp2, rb2tp2, rb3tp2);

		// BORDERPANE
		BorderPane borderPanetp2 = new BorderPane();
		borderPanetp2.setPadding(new Insets(5));
		borderPanetp2.setPrefSize(700, 580);
		borderPanetp2.setTop(lb1tp2);
		borderPanetp2.setCenter(hb1tp2);
		borderPanetp2.setBottom(bt1tp2);

		tp2.setContent(borderPanetp2);
		accordion.getPanes().add(tp2);

	}

	private void displayTp1() {
		// GRIDPANE
		gridPanetp1.setPadding(new Insets(10, 10, 10, 10));
		gridPanetp1.setVgap(5);
		gridPanetp1.setHgap(5);
		gridPanetp1.add(lb2tp1, 0, 0);
		gridPanetp1.add(lb3tp1, 0, 1);
		gridPanetp1.add(lb4tp1, 0, 2);
		gridPanetp1.add(lb5tp1, 0, 3);
		gridPanetp1.add(lb6tp1, 0, 4);
		gridPanetp1.add(lb7tp1, 0, 5);
		gridPanetp1.add(lb8tp1, 0, 6);
		
		gridPanetp1.add(tf1tp1, 1, 0);
		gridPanetp1.add(tf2tp1, 1, 1);
		gridPanetp1.add(tf3tp1, 1, 2);
		gridPanetp1.add(tf4tp1, 1, 3);
		gridPanetp1.add(tf5tp1, 1, 4);
		gridPanetp1.add(tf6tp1, 1, 5);
		gridPanetp1.add(tf7tp1, 1, 6);

		// BORDERPANE
		BorderPane borderPanetp1 = new BorderPane();
		borderPanetp1.setPadding(new Insets(5));
		borderPanetp1.setPrefSize(700, 580);
		borderPanetp1.setTop(lb1tp1);
		borderPanetp1.setCenter(gridPanetp1);

		tp1.setContent(borderPanetp1);
		accordion.getPanes().add(tp1);

	}

}
