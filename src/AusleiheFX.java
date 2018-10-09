import java.time.LocalDateTime;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class AusleiheFX {
	
	private Ausleihe ausleihefx;
	private SimpleIntegerProperty abholNr;
	private SimpleIntegerProperty kundenNr;
	private Kunde kunde; //??
	//evtl noch kundenname anzeigen
	private SimpleIntegerProperty skiNr;
	private Ski ski; //??
	private SimpleIntegerProperty snowboardNr;
	private Snowboard snowboard; //?? 
	private LocalDateTime leihStart; // ??
	private LocalDateTime leihEnde; //??
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
		ausleihefx.setKundenNr(i); //klasse kunde!
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
	
	//vars notwendig?
	
}
