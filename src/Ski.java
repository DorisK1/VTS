
public class Ski {

	private int skiNr;
	private int skiKategorieNr;
	private String skiProduktname;
	private String skiTyp;
	private String skiBildpfad;
	private String regalNr;
	private double tagespreis;
	private String farbe; 
	
	public Ski(int skiNr, int skiKategorieNr, String skiProduktname, String skiTyp, String skiBildpfad, String regalNr, double tagespreis,
			String farbe) {
		super();
		this.skiNr = skiNr;
		this.skiKategorieNr = skiKategorieNr;
		this.skiProduktname = skiProduktname;
		this.skiTyp = skiTyp;
		this.skiBildpfad = skiBildpfad;
		this.regalNr = regalNr;
		this.tagespreis = tagespreis;
		this.farbe = farbe;
	}

	public Ski() {
		// TODO Auto-generated constructor stub
	}

	public void setSkiNr(int skiNr) {
		this.skiNr = skiNr;
	}

	public void setSkiKategorieNr(int skiKategorieNr) {
		this.skiKategorieNr = skiKategorieNr;
	}

	public void setSkiProduktname(String skiProduktname) {
		this.skiProduktname = skiProduktname;
	}

	public void setSkiTyp(String skiTyp) {
		this.skiTyp = skiTyp;
	}

	public void setSkiBildpfad(String skiBildpfad) {
		this.skiBildpfad = skiBildpfad;
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

	public int getSkiNr() {
		return skiNr;
	}

	public int getSkiKategorieNr() {
		return skiKategorieNr;
	}

	public String getSkiProduktname() {
		return skiProduktname;
	}

	public String getSkiTyp() {
		return skiTyp;
	}

	public String getSkiBildpfad() {
		return skiBildpfad;
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
	
	
}
