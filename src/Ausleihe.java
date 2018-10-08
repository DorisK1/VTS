import java.time.LocalDateTime;

public class Ausleihe {
	
	private int abholNr;
	private int kundenNr;
	private Kunde kunde;
	private int skiNr;
	private Ski ski;
	private int snowboardNr;
	private Snowboard snowboard;
	private LocalDateTime leihStart;
	private LocalDateTime leihEnde;
	private double mietpreis;
	private double kaution;
	private double nachzahlung;
	private double gesamtpreis;
	
	public Ausleihe(int abholNr, int kundenNr, Kunde kunde, int skiNr, Ski ski, int snowboardNr, Snowboard snowboard,
			LocalDateTime leihStart, LocalDateTime leihEnde, double mietpreis, double kaution, double nachzahlung,
			double gesamtpreis) {
		super();
		this.abholNr = abholNr;
		this.kundenNr = kundenNr;
		this.kunde = kunde;
		this.skiNr = skiNr;
		this.ski = ski;
		this.snowboardNr = snowboardNr;
		this.snowboard = snowboard;
		this.leihStart = leihStart;
		this.leihEnde = leihEnde;
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

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public void setSkiNr(int skiNr) {
		this.skiNr = skiNr;
	}

	public void setSki(Ski ski) {
		this.ski = ski;
	}

	public void setSnowboardNr(int snowboardNr) {
		this.snowboardNr = snowboardNr;
	}

	public void setSnowboard(Snowboard snowboard) {
		this.snowboard = snowboard;
	}

	public void setLeihStart(LocalDateTime leihStart) {
		this.leihStart = leihStart;
	}

	public void setLeihEnde(LocalDateTime leihEnde) {
		this.leihEnde = leihEnde;
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

	public Kunde getKunde() {
		return kunde;
	}

	public int getSkiNr() {
		return skiNr;
	}

	public Ski getSki() {
		return ski;
	}

	public int getSnowboardNr() {
		return snowboardNr;
	}

	public Snowboard getSnowboard() {
		return snowboard;
	}

	public LocalDateTime getLeihStart() {
		return leihStart;
	}

	public LocalDateTime getLeihEnde() {
		return leihEnde;
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

	
	
}
