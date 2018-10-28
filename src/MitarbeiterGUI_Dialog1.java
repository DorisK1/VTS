import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class MitarbeiterGUI_Dialog1 extends Dialog<Integer> {

	Ski sk = new Ski();
	Snowboard sb = new Snowboard();
	GridPane gridPanetp1 = new GridPane();
	Label lb1 = new Label("Kategorienummer");
	Label lb2 = new Label("Produktname");
	Label lb3 = new Label("Typ");
	Label lb4 = new Label("Bildpfad");
	Label lb5 = new Label("RegalNr");
	Label lb6 = new Label("Tagespreis");
	Label lb7 = new Label("Farbe");
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
		gridPanetp1.add(lb1, 0, 0);
		gridPanetp1.add(lb2, 0, 1);
		gridPanetp1.add(lb3, 0, 2);
		gridPanetp1.add(lb4, 0, 3);
		gridPanetp1.add(lb5, 0, 4);
		gridPanetp1.add(lb6, 0, 5);
		gridPanetp1.add(lb7, 0, 6);
		gridPanetp1.add(tf1, 1, 0);
		gridPanetp1.add(tf2, 1, 1);
		gridPanetp1.add(tf3, 1, 2);
		gridPanetp1.add(tf4, 1, 3);
		gridPanetp1.add(tf5, 1, 4);
		gridPanetp1.add(tf6, 1, 5);
		gridPanetp1.add(tf7, 1, 6); 
		//Input validation einbauen
		
		BorderPane borderPane1 = new BorderPane();
		borderPane1.setPadding(new Insets(5));
		borderPane1.setPrefSize(700, 580);
		borderPane1.setCenter(gridPanetp1);
		ButtonType close = ButtonType.OK;
		ButtonType cancel = ButtonType.CANCEL;

		this.getDialogPane().setContent(borderPane1);
		this.getDialogPane().getButtonTypes().addAll(close, cancel);
		
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
										
							Datenbank.postSki(sk); //Ski in der Datenbank ablegen	
						} else {
							sb.setSnowboardKategorieNr(Integer.parseInt(tf1.getText()));
							sb.setSnowboardProduktname(tf2.getText());
							sb.setSnowboardTyp(tf3.getText());
							sb.setSnowboardBildpfad(tf4.getText());
							sb.setRegalNr(tf5.getText());
							sb.setTagespreis(Double.parseDouble(tf6.getText()));
							sb.setFarbe(tf7.getText());
												
							Datenbank.postSnowboard(sb); //Snowboard in der Datenbank ablegen
						}
					} else {
						
					}
				return null;
			}
		});

	}

}