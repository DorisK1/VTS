
public class Snowboard {
	
	private int snowboardNr;
	private int snowboardKategorieNr;
	private String snowboardProduktname;
	private String snowboardTyp;
	private String snowboardBildpfad;
	private String regalNr;
	private double tagespreis;
	private String farbe; //enum??
	private boolean beinstellung;
	private boolean bindungstyp;
	
	public Snowboard(int snowboardNr, int snowboardKategorieNr, String snowboardProduktname, String snowboardTyp,
			String snowboardBildpfad, String regalNr, double tagespreis, String farbe, boolean beinstellung, boolean bindungstyp) {
		super();
		this.snowboardNr = snowboardNr;
		this.snowboardKategorieNr = snowboardKategorieNr;
		this.snowboardProduktname = snowboardProduktname;
		this.snowboardTyp = snowboardTyp;
		this.snowboardBildpfad = snowboardBildpfad;
		this.regalNr = regalNr;
		this.tagespreis = tagespreis;
		this.farbe = farbe;
		this.beinstellung = beinstellung;
		this.bindungstyp = bindungstyp;
	}

	public Snowboard() {
		// TODO Auto-generated constructor stub
	}

	public void setSnowboardNr(int snowboardNr) {
		this.snowboardNr = snowboardNr;
	}

	public void setSnowboardKategorieNr(int snowboardKategorieNr) {
		this.snowboardKategorieNr = snowboardKategorieNr;
	}

	public void setSnowboardProduktname(String snowboardProduktname) {
		this.snowboardProduktname = snowboardProduktname;
	}

	public void setSnowboardTyp(String snowboardTyp) {
		this.snowboardTyp = snowboardTyp;
	}

	public void setRegalNr(String regalNr) {
		this.regalNr = regalNr;
	}

	public void setTagespreis(double tagespreis) {
		this.tagespreis = tagespreis;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public void setBeinstellung(boolean beinstellung) {
		this.beinstellung = beinstellung;
	}

	public void setBindungstyp(boolean bindungstyp) {
		this.bindungstyp = bindungstyp;
	}

	public int getSnowboardNr() {
		return snowboardNr;
	}

	public int getSnowboardKategorieNr() {
		return snowboardKategorieNr;
	}

	public String getSnowboardProduktname() {
		return snowboardProduktname;
	}

	public String getSnowboardTyp() {
		return snowboardTyp;
	}

	public String getRegalNr() {
		return regalNr;
	}

	public double getTagespreis() {
		return tagespreis;
	}

	public String getFarbe() {
		return farbe;
	}

	public boolean isBeinstellung() {
		return beinstellung;
	}

	public boolean isBindungstyp() {
		return bindungstyp;
	}

	public String getSnowboardBildpfad() {
		return snowboardBildpfad;
	}

	public void setSnowboardBildpfad(String snowboardBildpfad) {
		this.snowboardBildpfad = snowboardBildpfad;
	}
	
	

}
