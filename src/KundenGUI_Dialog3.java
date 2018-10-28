import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

public class KundenGUI_Dialog3 extends Dialog<ButtonType> { // NÖTIG? Besser über ALERT?

	public KundenGUI_Dialog3(String s) {
		super();
		this.setTitle("WARNUNG");
		Label lb1 = new Label(s);
		this.getDialogPane().setContent(lb1);
		ButtonType close = ButtonType.OK; // zurück zu dialog 1???
		this.getDialogPane().getButtonTypes().addAll(close);
		final Button btOk = (Button) this.getDialogPane().lookupButton(ButtonType.OK);
		btOk.addEventFilter(ActionEvent.ACTION, event -> {
			event.consume();
			getDialogPane().isDisable();
		});

	}
}
