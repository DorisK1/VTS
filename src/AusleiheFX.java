import java.sql.Date;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class AusleiheFX {

	private Ausleihe ausleihefx;
	private SimpleIntegerProperty abholNr;
	private SimpleIntegerProperty kundenNr;
	private SimpleIntegerProperty skiNr;
	private SimpleIntegerProperty snowboardNr;
	private SimpleObjectProperty<Date> leihstart; // ??
	private SimpleObjectProperty<Date> leihende; // ??
	private SimpleDoubleProperty mietpreis;
	private SimpleDoubleProperty kaution;
	private SimpleDoubleProperty nachzahlung;
	private SimpleDoubleProperty gesamtpreis;

	public AusleiheFX(Ausleihe a) {
		ausleihefx = a;
		abholNr = new SimpleIntegerProperty(ausleihefx.getAbholNr());
		kundenNr = new SimpleIntegerProperty(ausleihefx.getKundenNr());
		skiNr = new SimpleIntegerProperty(ausleihefx.getSkiNr());
		snowboardNr = new SimpleIntegerProperty(ausleihefx.getSnowboardNr());
		leihstart = new SimpleObjectProperty<Date>(ausleihefx.getLeihstart());
		leihende = new SimpleObjectProperty<Date>(ausleihefx.getLeihende());
		mietpreis = new SimpleDoubleProperty(ausleihefx.getMietpreis());
		kaution = new SimpleDoubleProperty(ausleihefx.getKaution());
		nachzahlung = new SimpleDoubleProperty(ausleihefx.getNachzahlung());
		gesamtpreis = new SimpleDoubleProperty(ausleihefx.getGesamtpreis());

	}

	public AusleiheFX() {
		// TODO Auto-generated constructor stub
	}

	public int getAbholNr() {
		return abholNr.get();
	}

	public void setAbholNr(int i) {
		abholNr.set(i);
		ausleihefx.setAbholNr(i);
	}

	public SimpleIntegerProperty abholNrProperty() {
		return abholNr;
	}

	public int getKundenNr() {
		return kundenNr.get();
	}

	public void setKundenNr(int i) {
		kundenNr.set(i);
		ausleihefx.setKundenNr(i); // klasse kunde!
	}

	public SimpleIntegerProperty kundenNrProperty() {
		return kundenNr;
	}

	public int getSkiNr() {
		return skiNr.get();
	}

	public void setSkiNr(int i) {
		skiNr.set(i);
		ausleihefx.setSkiNr(i);
	}

	public SimpleIntegerProperty skiNrProperty() {
		return skiNr;
	}

	public int getSnowboardNr() {
		return snowboardNr.get();
	}

	public void setSnowboardNr(int i) {
		snowboardNr.set(i);
		ausleihefx.setSnowboardNr(i);
	}

	public SimpleIntegerProperty snowboardNrProperty() {
		return snowboardNr;
	}

	public double getMietpreis() {
		return mietpreis.get();
	}

	public void setMietpreis(double d) {
		mietpreis.set(d);
		ausleihefx.setMietpreis(d);
	}

	public SimpleDoubleProperty mietpreisProperty() {
		return mietpreis;
	}

	public Date getLeihstart() {
		return leihstart.get();
	}

	public void setLeihstart(Date d) {
		leihstart.set(d);
		ausleihefx.setLeihstart(d);
	}

	public SimpleObjectProperty<Date> leihstartProperty() {
		return leihstart;
	}
	
	public Date getLeihende() {
		return leihende.get();
	}

	public void setLeihende(Date d) {
		leihende.set(d);
		ausleihefx.setLeihende(d);
	}

	public SimpleObjectProperty<Date> leihendeProperty() {
		return leihende;
	}

	public double getKaution() {
		return kaution.get();
	}

	public void setKaution(double d) {
		kaution.set(d);
		ausleihefx.setKaution(d);
	}

	public SimpleDoubleProperty kautionProperty() {
		return kaution;
	}

	public double getNachzahlung() {
		return nachzahlung.get();
	}

	public void setNachzahlung(double d) {
		nachzahlung.set(d);
		ausleihefx.setNachzahlung(d);
	}

	public SimpleDoubleProperty nachzahlungProperty() {
		return nachzahlung;
	}

	public double getGesamtpreis() {
		return gesamtpreis.get();
	}

	public void setGesamtpreis(double d) {
		gesamtpreis.set(d);
		ausleihefx.setGesamtpreis(d);
	}

	public SimpleDoubleProperty gesamtpreisProperty() {
		return gesamtpreis;
	}

}
