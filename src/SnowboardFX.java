import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SnowboardFX {
	
	private Snowboard snowboard;
	private SimpleIntegerProperty snowboardNr;
	private SimpleIntegerProperty snowboardKategorieNr;
	private SimpleStringProperty snowboardProduktname;
	private SimpleStringProperty snowboardTyp;
	private SimpleStringProperty snowboardBildpfad;
	private SimpleStringProperty regalNr;
	private SimpleDoubleProperty tagespreis;
	private SimpleStringProperty farbe; 
	private SimpleBooleanProperty beinstellung;
	private SimpleBooleanProperty bindungstyp;
	
	public SnowboardFX (Snowboard sb) {
		snowboard = sb;
		snowboardNr = new SimpleIntegerProperty(snowboard.getSnowboardNr());
		snowboardKategorieNr = new SimpleIntegerProperty(snowboard.getSnowboardKategorieNr());
		snowboardProduktname = new SimpleStringProperty(snowboard.getSnowboardProduktname());
		snowboardTyp = new SimpleStringProperty(snowboard.getSnowboardTyp());
		snowboardBildpfad = new SimpleStringProperty(snowboard.getSnowboardBildpfad());
		regalNr = new SimpleStringProperty(snowboard.getRegalNr());
		tagespreis = new SimpleDoubleProperty(snowboard.getTagespreis());
		farbe = new SimpleStringProperty(snowboard.getFarbe());
		beinstellung = new SimpleBooleanProperty(snowboard.isBeinstellung());
		bindungstyp = new SimpleBooleanProperty(snowboard.isBindungstyp());
		
	}
	
	public SnowboardFX() {
		// TODO Auto-generated constructor stub
	}

	public int getSnowboardNr() {
		return snowboardNr.get();
	}

	public void setSnowboardNr(int i) {
		snowboardNr.set(i);
		snowboard.setSnowboardNr(i); //klasse kunde!
	}
	
	public SimpleIntegerProperty snowboardNrProperty() {
		return snowboardNr;
	}
	
	public int getSnowboardKategorieNr() {
		return snowboardKategorieNr.get();
	}

	public void setSnowboardKategorieNr(int i) {
		snowboardKategorieNr.set(i);
		snowboard.setSnowboardKategorieNr(i); //klasse kunde!
	}
	
	public SimpleIntegerProperty snowboardKategorieNrProperty() {
		return snowboardKategorieNr;
	}
	
	public String getSnowboardProduktname() {
		return snowboardProduktname.get();
	}

	public void setSnowboardProduktname(String s) {
		snowboardProduktname.set(s);
		snowboard.setSnowboardProduktname(s); //klasse kunde!
	}
	
	public SimpleStringProperty snowboardProduktnameProperty() {
		return snowboardProduktname;
	}
	
	public String getSnowboardTyp() {
		return snowboardTyp.get();
	}

	public void setSnowboardTyp(String s) {
		snowboardTyp.set(s);
		snowboard.setSnowboardTyp(s); //klasse kunde!
	}
	
	public SimpleStringProperty snowboardTypProperty() {
		return snowboardTyp;
	}
	
	public String getSnowboardBildpfad() {
		return snowboardBildpfad.get();
	}

	public void setSnowboardBildpfad(String s) {
		snowboardBildpfad.set(s);
		snowboard.setSnowboardBildpfad(s); //klasse kunde!
	}
	
	public SimpleStringProperty snowboardBildpfadProperty() {
		return snowboardBildpfad;
	}
	
	public String getRegalNr() {
		return regalNr.get();
	}

	public void setRegalNr(String s) {
		regalNr.set(s);
		snowboard.setRegalNr(s);
	}

	public SimpleStringProperty regalNrProperty() {
		return regalNr;
	}
	
	public Double getTagespreis() {
		return tagespreis.get();
	}

	public void setTagespreis(Double d) {
		tagespreis.set(d);
		snowboard.setTagespreis(d);
	}

	public SimpleDoubleProperty tagespreisProperty() {
		return tagespreis;
	}
	
	public String getFarbe() {
		return farbe.get();
	}

	public void setFarbe(String s) {
		farbe.set(s);
		snowboard.setFarbe(s);
	}

	public SimpleStringProperty farbeProperty() {
		return farbe;
	}
	
	public Boolean getBeinstellung() {
		return beinstellung.get();
	}

	public void setBeinstellung(Boolean b) {
		beinstellung.set(b);
		snowboard.setBeinstellung(b);
	}

	public SimpleBooleanProperty BeinstellungProperty() {
		return beinstellung;
	}
	
	public Boolean getBindungstyp() {
		return bindungstyp.get();
	}

	public void setBindungstyp(Boolean b) {
		bindungstyp.set(b);
		snowboard.setBindungstyp(b);
	}

	public SimpleBooleanProperty BindungstypProperty() {
		return bindungstyp;
	}
	
}
