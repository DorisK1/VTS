
public class Kunde { //dies als Datenbankklasse (normale java class) + FX Klasse mit Simple property! auch für ski und snowboard!!! analog
	//projekt restfuljersey weindetails class und wein class
	
	private int kundenNr;
	private int anrede;
	private String vorname;
	private String nachname;
	private String telefonNr;
	private String strasse;
	private String hausNr;
	private String wohnort;
	private String plz;
	private String land;
	private int alter;
	private String pistenPraef;
	private int gewicht;
	private double schuhgroesse;
	private int technik; //enum???
	private boolean beinstellung;
	private boolean bindungstyp;
	
	public Kunde(int kundenNr, String kreditkartenNr, int anrede, String vorname, String nachname, String telefonNr,
			String strasse, String hausNr, String wohnort, String plz, String land, int alter, String pistenPraef, int gewicht,
			double schuhgroesse, int technik, boolean beinstellung, boolean bindungstyp) {
		super();
		this.kundenNr = kundenNr;
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefonNr = telefonNr;
		this.strasse = strasse;
		this.hausNr = hausNr;
		this.wohnort = wohnort;
		this.plz = plz;
		this.land = land;
		this.alter = alter;
		this.pistenPraef = pistenPraef;
		this.gewicht = gewicht;
		this.schuhgroesse = schuhgroesse;
		this.technik = technik;
		this.beinstellung = beinstellung;
		this.bindungstyp = bindungstyp;
	}
	
	public Kunde() {
		// TODO Auto-generated constructor stub
	}

	public int getKundenNr() {
		return kundenNr;
	}

	public int getAnrede() {
		return anrede;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public String getTelefonNr() {
		return telefonNr;
	}

	public String getStrasse() {
		return strasse;
	}

	public String getHausNr() {
		return hausNr;
	}
	
	public String getWohnort() {
		return wohnort;
	}

	public String getPlz() {
		return plz;
	}

	public String getLand() {
		return land;
	}

	public int getAlter() {
		return alter;
	}

	public String getPistenPraef() {
		return pistenPraef;
	}

	public int getGewicht() {
		return gewicht;
	}

	public double getSchuhgroesse() {
		return schuhgroesse;
	}

	public int getTechnik() {
		return technik;
	}

	public boolean isBeinstellung() {
		return beinstellung;
	}

	public boolean isBindungstyp() {
		return bindungstyp;
	}

	public void setKundenNr(int kundenNr) {
		this.kundenNr = kundenNr;
	}

	public void setAnrede(int anrede) {
		this.anrede = anrede;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public void setTelefonNr(String telefonNr) {
		this.telefonNr = telefonNr;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public void setHausNr(String hausNr) {
		this.hausNr = hausNr;
	}
	
	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public void setPistenPraef(String pistenPraef) {
		this.pistenPraef = pistenPraef;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

	public void setSchuhgroesse(double schuhgroesse) {
		this.schuhgroesse = schuhgroesse;
	}

	public void setTechnik(int technik) {
		this.technik = technik;
	}

	public void setBeinstellung(boolean beinstellung) {
		this.beinstellung = beinstellung;
	}

	public void setBindungstyp(boolean bindungstyp) {
		this.bindungstyp = bindungstyp;
	}

	

}
