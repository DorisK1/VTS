import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class MitarbeiterGUI_Dialog1 extends Dialog<Integer> {

	Ski sk = new Ski();
	Snowboard sb = new Snowboard();
	GridPane gridPanetp1 = new GridPane();
	// LB 
	Label lb1 = new Label("Kategorienummer");
	Label lb2 = new Label("Produktname");
	Label lb3 = new Label("Typ");
	Label lb4 = new Label("Bildpfad");
	Label lb5 = new Label("RegalNr");
	Label lb6 = new Label("Tagespreis");
	Label lb7 = new Label("Farbe"); 
	// input validation messages 
	Label lb8 = new Label();
	Label lb9 = new Label();
	Label lb10 = new Label();
	Label lb11 = new Label();
	Label lb12 = new Label();
	Label lb13 = new Label();
	Label lb14 = new Label();
	// TF
	TextField tf1 = new TextField();
	TextField tf2 = new TextField();
	TextField tf3 = new TextField();
	TextField tf4 = new TextField();
	TextField tf5 = new TextField();
	TextField tf6 = new TextField();
	TextField tf7 = new TextField();

	public MitarbeiterGUI_Dialog1(String s) {
		super();
		this.setTitle("DIALOG 1");
		this.setHeaderText("Neues Produkt anlegen");

		gridPanetp1.setPadding(new Insets(10, 10, 10, 10));
		gridPanetp1.setVgap(5);
		gridPanetp1.setHgap(5);
		// LB
		gridPanetp1.add(lb1, 0, 0);
		gridPanetp1.add(lb2, 0, 1);
		gridPanetp1.add(lb3, 0, 2);
		gridPanetp1.add(lb4, 0, 3);
		gridPanetp1.add(lb5, 0, 4);
		gridPanetp1.add(lb6, 0, 5);
		gridPanetp1.add(lb7, 0, 6);

		gridPanetp1.add(lb8, 2, 0);
		gridPanetp1.add(lb9, 2, 1);
		gridPanetp1.add(lb10, 2, 2);
		gridPanetp1.add(lb11, 2, 3);
		gridPanetp1.add(lb12, 2, 4);
		gridPanetp1.add(lb13, 2, 5);
		gridPanetp1.add(lb14, 2, 6);
		// TF
		gridPanetp1.add(tf1, 1, 0);
		gridPanetp1.add(tf2, 1, 1);
		gridPanetp1.add(tf3, 1, 2);
		gridPanetp1.add(tf4, 1, 3);
		gridPanetp1.add(tf5, 1, 4);
		gridPanetp1.add(tf6, 1, 5);
		gridPanetp1.add(tf7, 1, 6);
		// Prompttext
		tf1.setPromptText("1");
		tf2.setPromptText("Alpin XYZ");
		tf3.setPromptText("Alpin");
		tf4.setPromptText("C:\\Users\\Doris\\Bilder\\001.jpg");
		tf5.setPromptText("R999");
		tf6.setPromptText("19.5");
		tf7.setPromptText("ROT");
		// Input validation
		tf1.focusedProperty().addListener((observable, oldValue, newValue) -> { // Kategorienummer
			if (observable != null) {
				if (!tf1.getText().matches("[1-3]")) {
					tf1.setStyle("-fx-background-color: khaki;");
					lb8.setText("Bitte Kategorie 1, 2 oder 3 wählen!");
				} else {
					tf1.setStyle("-fx-background-color: white;");
					lb8.setText("");
				}
			}
		});

		tf2.focusedProperty().addListener((observable, oldValue, newValue) -> { // Produktname
			if (observable != null) {
				if (!tf2.getText().matches("[a-zA-z ]*")) {
					tf2.setStyle("-fx-background-color: khaki;");
					lb9.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf2.setStyle("-fx-background-color: white;");
					lb9.setText("");
				}
			}
		});

		tf3.focusedProperty().addListener((observable, oldValue, newValue) -> { // Typ
			if (observable != null) {
				if (!tf3.getText().matches("[a-zA-z ]*")) {
					tf3.setStyle("-fx-background-color: khaki;");
					lb10.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf3.setStyle("-fx-background-color: white;");
					lb10.setText("");
				}
			}
		});

		tf4.focusedProperty().addListener((observable, oldValue, newValue) -> { // Bildpfad
			if (observable != null) {
				if (!tf4.getText().matches("[a-zA-z.\\:]*")) {
					tf4.setStyle("-fx-background-color: khaki;");
					lb11.setText("Falsche Eingabe - nur Buchstaben und Sonderzeichen ':' '.' '\'!");
				} else {
					tf4.setStyle("-fx-background-color: white;");
					lb11.setText("");
				}
			}
		});

		tf5.focusedProperty().addListener((observable, oldValue, newValue) -> { // RegalNr
			if (observable != null) {
				if (!tf5.getText().matches("[a-zA-z0-9]*")) {
					tf5.setStyle("-fx-background-color: khaki;");
					lb12.setText("Falsche Eingabe - nur Buchstaben und Zahlen!");
				} else {
					tf5.setStyle("-fx-background-color: white;");
					lb12.setText("");
				}
			}
		});

		tf6.focusedProperty().addListener((observable, oldValue, newValue) -> { // Tagespreis
			if (observable != null) {
				if (!tf6.getText().matches("[0-9.]*")) {
					tf6.setStyle("-fx-background-color: khaki;");
					lb13.setText("Falsche Eingabe - nur Ganz- und Gleitkommazahlen!");
				} else {
					tf6.setStyle("-fx-background-color: white;");
					lb13.setText("");
				}
			}
		});

		tf7.focusedProperty().addListener((observable, oldValue, newValue) -> { // Farbe
			if (observable != null) {
				if (!tf7.getText().matches("[a-zA-Z]*")) {
					tf7.setStyle("-fx-background-color: khaki;");
					lb14.setText("Falsche Eingabe - nur Buchstaben!");
				} else {
					tf7.setStyle("-fx-background-color: white;");
					lb14.setText("");
				}
			}
		});

		BorderPane borderPane1 = new BorderPane();
		borderPane1.setPadding(new Insets(5));
		borderPane1.setPrefSize(700, 580);
		borderPane1.setCenter(gridPanetp1);
		ButtonType close = ButtonType.OK;
		ButtonType cancel = ButtonType.CANCEL;

		this.getDialogPane().setContent(borderPane1);
		this.getDialogPane().getButtonTypes().addAll(close, cancel);
		final Button btOk = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
		btOk.addEventFilter(ActionEvent.ACTION, event -> {
			if (!isInputValid()) {
				event.consume();

			}
		});

		// OK Button function
		this.setResultConverter(new Callback<ButtonType, Integer>() { // neues Produkt in der Datenbank abspeichern
			@Override
			public Integer call(ButtonType arg0) {
				if (arg0 == close)
					if (!tf1.getText().isEmpty() && !tf2.getText().isEmpty()) { // alle TF??
						if (s.equals("Ski")) {
							sk.setSkiKategorieNr(Integer.parseInt(tf1.getText()));
							sk.setSkiProduktname(tf2.getText());
							sk.setSkiTyp(tf3.getText());
							sk.setSkiBildpfad(tf4.getText());
							sk.setRegalNr(tf5.getText());
							sk.setTagespreis(Double.parseDouble(tf6.getText()));
							sk.setFarbe(tf7.getText());

							Datenbank.postSki(sk); // Ski in der Datenbank ablegen
						} else {
							sb.setSnowboardKategorieNr(Integer.parseInt(tf1.getText()));
							sb.setSnowboardProduktname(tf2.getText());
							sb.setSnowboardTyp(tf3.getText());
							sb.setSnowboardBildpfad(tf4.getText());
							sb.setRegalNr(tf5.getText());
							sb.setTagespreis(Double.parseDouble(tf6.getText()));
							sb.setFarbe(tf7.getText());

							Datenbank.postSnowboard(sb); // Snowboard in der Datenbank ablegen
						}
						return 1;
					} else {

					}
				return null;
			}
		});

	}

	public boolean isInputValid() { // prüft ob alle Inputfelder befüllt wurden; falls nicht kommt warnhinweis

		Boolean b = false;
		// String s = null;
		// ALTER
		if (!(tf1.getText() == null || tf1.getText().length() == 0)
				&& !(tf2.getText() == null || tf2.getText().length() == 0)
				&& !(tf3.getText() == null || tf3.getText().length() == 0)
				&& !(tf4.getText() == null || tf4.getText().length() == 0)
				&& !(tf5.getText() == null || tf5.getText().length() == 0)
				&& !(tf6.getText() == null || tf6.getText().length() == 0)
				&& !(tf7.getText() == null || tf7.getText().length() == 0)) {
			b = true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("FEHLERHAFTE EINGABE!");
			alert.setContentText("DATEN FEHLEN!!!");
			alert.showAndWait();

		}
		return b;
	}
}