import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class KundeFX {

	private Kunde kundefx;
	private SimpleIntegerProperty kundenNr;
	private SimpleStringProperty kreditkartenNr;
	private SimpleStringProperty anrede;
	private SimpleStringProperty vorname;
	private SimpleStringProperty nachname;
	private SimpleStringProperty telefonNr;
	private SimpleStringProperty strasse;
	private SimpleStringProperty hausNr;
	private SimpleStringProperty plz;
	private SimpleStringProperty land;
	private SimpleIntegerProperty alter;
	private SimpleStringProperty pistenPraef;
	private SimpleIntegerProperty gewicht;
	private SimpleDoubleProperty schuhgroesse;
	private SimpleIntegerProperty technik; // enum???
	private SimpleBooleanProperty beinstellung;
	private SimpleBooleanProperty bindungstyp;

	public KundeFX(Kunde k) {
		kundefx = k;
		kundenNr = new SimpleIntegerProperty(kundefx.getKundenNr());
		kreditkartenNr = new SimpleStringProperty(kundefx.getKreditkartenNr());
		anrede = new SimpleStringProperty(kundefx.getAnrede());
		vorname = new SimpleStringProperty(kundefx.getVorname());
		nachname = new SimpleStringProperty(kundefx.getNachname());
		telefonNr = new SimpleStringProperty(kundefx.getTelefonNr());
		strasse = new SimpleStringProperty(kundefx.getStrasse());
		hausNr = new SimpleStringProperty(kundefx.getHausNr());
		plz = new SimpleStringProperty(kundefx.getPlz());
		land = new SimpleStringProperty(kundefx.getLand());
		alter = new SimpleIntegerProperty(kundefx.getAlter());
		pistenPraef = new SimpleStringProperty(kundefx.getPistenPraef());
		gewicht = new SimpleIntegerProperty(kundefx.getGewicht());
		schuhgroesse = new SimpleDoubleProperty(kundefx.getSchuhgroesse());
		technik = new SimpleIntegerProperty(kundefx.getTechnik());
		beinstellung = new SimpleBooleanProperty(kundefx.isBeinstellung());
		bindungstyp = new SimpleBooleanProperty(kundefx.isBindungstyp());

	}

	public int getKundenNr() {
		return kundenNr.get();
	}

	public void setKundenNr(int i) {
		kundenNr.set(i);
		kundefx.setKundenNr(i);
	}

	public SimpleIntegerProperty kundenNrProperty() {
		return kundenNr;
	}

	public String getKreditkartenNr() {
		return kreditkartenNr.get();
	}

	public void setKreditkartenNr(String s) {
		kreditkartenNr.set(s);
		kundefx.setKreditkartenNr(s);
	}

	public SimpleStringProperty KreditkartenNrProperty() {
		return kreditkartenNr;
	}
	
	public String getAnrede() {
		return anrede.get();
	}

	public void setAnrede(String s) {
		anrede.set(s);
		kundefx.setAnrede(s);
	}

	public SimpleStringProperty AnredeProperty() {
		return anrede;
	}
	
	public String getVorname() {
		return vorname.get();
	}

	public void setVorname(String s) {
		vorname.set(s);
		kundefx.setVorname(s);
	}

	public SimpleStringProperty VornameProperty() {
		return vorname;
	}
	
	public String getNachname() {
		return nachname.get();
	}

	public void setNachname(String s) {
		nachname.set(s);
		kundefx.setNachname(s);
	}

	public SimpleStringProperty NachnameProperty() {
		return nachname;
	}
	
	public String getTelefonNr() {
		return telefonNr.get();
	}

	public void setTelefonNr(String s) {
		telefonNr.set(s);
		kundefx.setTelefonNr(s);
	}

	public SimpleStringProperty TelefonNrProperty() {
		return telefonNr;
	}
	
	public String getStrasse() {
		return strasse.get();
	}

	public void setStrasse(String s) {
		strasse.set(s);
		kundefx.setStrasse(s);
	}

	public SimpleStringProperty StrasseProperty() {
		return strasse;
	}
	
	public String getHausNr() {
		return hausNr.get();
	}

	public void setHausNr(String s) {
		hausNr.set(s);
		kundefx.setHausNr(s);
	}

	public SimpleStringProperty HausNrProperty() {
		return hausNr;
	}
	
	public String getPlz() {
		return plz.get();
	}

	public void setPlz(String s) {
		plz.set(s);
		kundefx.setPlz(s);
	}

	public SimpleStringProperty PlzProperty() {
		return plz;
	}
	
	public String getLand() {
		return land.get();
	}

	public void setLand(String s) {
		land.set(s);
		kundefx.setLand(s);
	}

	public SimpleStringProperty LandProperty() {
		return land;
	}
	
	public int getAlter() {
		return alter.get();
	}

	public void setAlter(int i) {
		alter.set(i);
		kundefx.setAlter(i);
	}

	public SimpleIntegerProperty AlterProperty() {
		return alter;
	}
	
	public String getPistenPraef() {
		return pistenPraef.get();
	}

	public void setPistenPraef(String s) {
		pistenPraef.set(s);
		kundefx.setPistenPraef(s);
	}

	public SimpleStringProperty PistenPraefProperty() {
		return pistenPraef;
	}
	
	public int getGewicht() {
		return gewicht.get();
	}

	public void setGewicht(int i) {
		gewicht.set(i);
		kundefx.setGewicht(i);
	}

	public SimpleIntegerProperty GewichtProperty() {
		return gewicht;
	}
	
	public double getSchuhgroesse() {
		return schuhgroesse.get();
	}

	public void setSchuhgroesse(double d) {
		schuhgroesse.set(d);
		kundefx.setSchuhgroesse(d);
	}

	public SimpleDoubleProperty SchuhgroesseProperty() {
		return schuhgroesse;
	}
	
	public int getTechnik() {
		return technik.get();
	}

	public void setTechnik(int i) {
		technik.set(i);
		kundefx.setTechnik(i);
	}

	public SimpleIntegerProperty TechnikProperty() {
		return technik;
	}
	
	public Boolean getBeinstellung() {
		return beinstellung.get();
	}

	public void setBeinstellung(Boolean b) {
		beinstellung.set(b);
		kundefx.setBeinstellung(b);
	}

	public SimpleBooleanProperty BeinstellungProperty() {
		return beinstellung;
	}
	
	public Boolean getBindungstyp() {
		return bindungstyp.get();
	}

	public void setBindungstyp(Boolean b) {
		bindungstyp.set(b);
		kundefx.setBindungstyp(b);
	}

	public SimpleBooleanProperty BindungstypProperty() {
		return bindungstyp;
	}
}
