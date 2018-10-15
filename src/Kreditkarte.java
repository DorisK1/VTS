
public class Kreditkarte {
	
	private String kreditkartenNr;
	private int kundenNr;
	private String kreditkartenName;
	private String inhaberName;
	private String pruefzahl;
	private String gueltigkeit;
	
	public Kreditkarte(String kreditkartenNr, int kundenNr, String kreditkartenName, String inhaberName,
			String pruefzahl, String gueltigkeit) {
		super();
		this.kreditkartenNr = kreditkartenNr;
		this.kundenNr = kundenNr;
		this.kreditkartenName = kreditkartenName;
		this.inhaberName = inhaberName;
		this.pruefzahl = pruefzahl;
		this.gueltigkeit = gueltigkeit;
	}

	public Kreditkarte() {
		// TODO Auto-generated constructor stub
	}

	public void setKreditkartenNr(String kreditkartenNr) {
		this.kreditkartenNr = kreditkartenNr;
	}

	public void setKundenNr(int kundenNr) {
		this.kundenNr = kundenNr;
	}

	public void setKreditkartenName(String kreditkartenName) {
		this.kreditkartenName = kreditkartenName;
	}

	public void setInhaberName(String inhaberName) {
		this.inhaberName = inhaberName;
	}

	public void setPruefzahl(String pruefzahl) {
		this.pruefzahl = pruefzahl;
	}

	public void setGueltigkeit(String gueltigkeit) {
		this.gueltigkeit = gueltigkeit;
	}

	public String getKreditkartenNr() {
		return kreditkartenNr;
	}

	public int getKundenNr() {
		return kundenNr;
	}

	public String getKreditkartenName() {
		return kreditkartenName;
	}

	public String getInhaberName() {
		return inhaberName;
	}

	public String getPruefzahl() {
		return pruefzahl;
	}

	public String getGueltigkeit() {
		return gueltigkeit;
	}

	
}
