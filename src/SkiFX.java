import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SkiFX {

	private Ski ski;
	private SimpleIntegerProperty skiNr;
	private SimpleIntegerProperty skiKategorieNr;
	private SimpleStringProperty skiProduktname;
	private SimpleStringProperty skiTyp;
	private SimpleStringProperty skiBildpfad;
	private SimpleStringProperty regalNr;
	private SimpleDoubleProperty tagespreis;
	private SimpleStringProperty farbe; 

	public SkiFX(Ski sk) {
		ski = sk;
		skiNr = new SimpleIntegerProperty(ski.getSkiNr());
		skiKategorieNr = new SimpleIntegerProperty(ski.getSkiKategorieNr());
		skiProduktname = new SimpleStringProperty(ski.getSkiProduktname());
		skiTyp = new SimpleStringProperty(ski.getSkiTyp());
		skiBildpfad = new SimpleStringProperty(ski.getSkiBildpfad());
		regalNr = new SimpleStringProperty(ski.getRegalNr());
		tagespreis = new SimpleDoubleProperty(ski.getTagespreis());
		farbe = new SimpleStringProperty(ski.getFarbe());

	}

	public SkiFX() {
		// TODO Auto-generated constructor stub
	}

	public SkiFX(int int1, int int2, String string, String string2, String string3, String string4, double double1,
			String string5) {
		skiNr = new SimpleIntegerProperty(ski.getSkiNr());
		skiKategorieNr = new SimpleIntegerProperty(ski.getSkiKategorieNr());
		skiProduktname = new SimpleStringProperty(ski.getSkiProduktname());
		skiTyp = new SimpleStringProperty(ski.getSkiTyp());
		skiBildpfad = new SimpleStringProperty(ski.getSkiBildpfad());
		regalNr = new SimpleStringProperty(ski.getRegalNr());
		tagespreis = new SimpleDoubleProperty(ski.getTagespreis());
		farbe = new SimpleStringProperty(ski.getFarbe());
	}

	public int getSkiNr() {
		return skiNr.get();
	}

	public void setSkiNr(int i) {
		skiNr.set(i);
		ski.setSkiNr(i);
	}

	public SimpleIntegerProperty skiNrProperty() {
		return skiNr;
	}
	
	public int getSkiKategorieNr() {
		return skiKategorieNr.get();
	}

	public void setSkiKategorieNr(int i) {
		skiKategorieNr.set(i);
		ski.setSkiKategorieNr(i);
	}

	public SimpleIntegerProperty skiKategorieNrProperty() {
		return skiKategorieNr;
		
	}
	public String getSkiProduktname() {
		return skiProduktname.get();
	}

	public void setSkiProduktname(String s) {
		skiProduktname.set(s);
		ski.setSkiProduktname(s);
	}

	public SimpleStringProperty skiProduktnameProperty() {
		return skiProduktname;
	}

	public String getSkiTyp() {
		return skiTyp.get();
	}

	public void setSkiTyp(String s) {
		skiTyp.set(s);
		ski.setSkiTyp(s);
	}

	public SimpleStringProperty skiTypProperty() {
		return skiTyp;
	}
	
	public String getSkiBildpfad() {
		return skiBildpfad.get();
	}

	public void setSkiBildpfad(String s) {
		skiBildpfad.set(s);
		ski.setSkiBildpfad(s);
	}

	public SimpleStringProperty skiBildpfadProperty() {
		return skiBildpfad;
	}
	
	public String getRegalNr() {
		return regalNr.get();
	}

	public void setRegalNr(String s) {
		regalNr.set(s);
		ski.setRegalNr(s);
	}

	public SimpleStringProperty regalNrProperty() {
		return regalNr;
	}
	
	public Double getTagespreis() {
		return tagespreis.get();
	}

	public void setTagespreis(Double d) {
		tagespreis.set(d);
		ski.setTagespreis(d);
	}

	public SimpleDoubleProperty tagespreisProperty() {
		return tagespreis;
	}
	
	public String getFarbe() {
		return farbe.get();
	}

	public void setFarbe(String s) {
		farbe.set(s);
		ski.setFarbe(s);
	}

	public SimpleStringProperty farbeProperty() {
		return farbe;
	}

}
