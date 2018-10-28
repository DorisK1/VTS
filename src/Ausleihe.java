import java.sql.Date;

public class Ausleihe {
	
	private int abholNr; 
	private int kundenNr;
	private int skiNr;
	private int snowboardNr;
	private Date leihstart; 
	private Date leihende; 
	private double mietpreis;
	private double kaution;
	private double nachzahlung;
	private double gesamtpreis;
	
	public Ausleihe(int abholNr, int kundenNr, int skiNr, int snowboardNr, 
			Date leihstart, Date leihende, double mietpreis, double kaution, double nachzahlung,
			double gesamtpreis) {
		super();
		this.abholNr = abholNr;
		this.kundenNr = kundenNr;
		//this.kunde = kunde;
		this.skiNr = skiNr;
		//this.ski = ski;
		this.snowboardNr = snowboardNr;
		//this.snowboard = snowboard;
		this.leihstart = leihstart;
		this.leihende = leihende;
		this.mietpreis = mietpreis;
		this.kaution = kaution;
		this.nachzahlung = nachzahlung;
		this.gesamtpreis = gesamtpreis;
	}
	
	public Ausleihe() {
		// TODO Auto-generated constructor stub
	}

	public void setAbholNr(int abholNr) {
		this.abholNr = abholNr;
	}

	public void setKundenNr(int kundenNr) {
		this.kundenNr = kundenNr;
	}

	public void setSkiNr(int skiNr) {
		this.skiNr = skiNr;
	}

	public void setSnowboardNr(int snowboardNr) {
		this.snowboardNr = snowboardNr;
	}

	public void setLeihstart(Date leihstart) {
		this.leihstart = leihstart;
	}

	public void setLeihende(Date leihende) {
		this.leihende = leihende;
	}

	public void setMietpreis(double mietpreis) {
		this.mietpreis = mietpreis;
	}

	public void setKaution(double kaution) {
		this.kaution = kaution;
	}

	public void setNachzahlung(double nachzahlung) {
		this.nachzahlung = nachzahlung;
	}

	public void setGesamtpreis(double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	public int getAbholNr() {
		return abholNr;
	}

	public int getKundenNr() {
		return kundenNr;
	}

	public int getSkiNr() {
		return skiNr;
	}

	public int getSnowboardNr() {
		return snowboardNr;
	}

	public Date getLeihstart() {
		return leihstart;
	}

	public Date getLeihende() {
		return leihende;
	}

	public double getMietpreis() {
		return mietpreis;
	}

	public double getKaution() {
		return kaution;
	}

	public double getNachzahlung() {
		return nachzahlung;
	}

	public double getGesamtpreis() {
		return gesamtpreis;
	}

	@Override
	public String toString() {
		return "Ausleihe [abholNr=" + abholNr + ", kundenNr=" + kundenNr + ", skiNr=" + skiNr + ", snowboardNr="
				+ snowboardNr + ", leihStart=" + leihstart + ", leihEnde=" + leihende + ", mietpreis=" + mietpreis
				+ ", kaution=" + kaution + ", nachzahlung=" + nachzahlung + ", gesamtpreis=" + gesamtpreis + "]";
	}

	
	
}
