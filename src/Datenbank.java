import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbank {

	public static final String DBlocation = "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Datenbank\\DB1";
	public static final String connString = "jdbc:derby:" + DBlocation + ";create=true";
	public static Statement stmt = null;
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	//ResultSet rs = null; 

	public static void createTables() { //Kunde k --> object übergeben hier nötig?

		try {
			conn = DriverManager.getConnection(connString);
			System.out.println("Connection established");
			stmt = conn.createStatement();
			try {
				stmt.executeUpdate("DROP TABLE kunden"); 
				stmt.executeUpdate("DROP TABLE kreditkarten");
				stmt.executeUpdate("DROP TABLE skikategorien");
				stmt.executeUpdate("DROP TABLE snowboardkategorien");
				stmt.executeUpdate("DROP TABLE ski");
				stmt.executeUpdate("DROP TABLE snowboard");
				stmt.executeUpdate("DROP TABLE ausleihen");
				System.out.println("Tables dropped"); //wird nicht mehr ausgegeben:
				//Putting ‘drop table’ in front of it ensure you don't get an error if the table already exist (and get stuck with the old table).
			} catch (Exception e) {
			}
			
			// TABLE KUNDEN ANLEGEN
			String s1 = "CREATE TABLE kunden (" 
					+ "kundenNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," //automatisch
					+ "kreditkartenNr		VARCHAR(200)," // FK aus table kreditkarten
					+ "anrede	  			integer,"
					+ "vorname  			VARCHAR(200),"
					+ "nachname  			VARCHAR(200),"
					+ "telefonNr   			VARCHAR(200)," 
					+ "strasse     			VARCHAR(200)," 
					+ "hausNr   			VARCHAR(200),"
					+ "plz		   			VARCHAR(200),"
					+ "land		   			VARCHAR(200),"
					+ "kundenalter	  		integer," //alter geht nicht - Achtung: diskrepanz zu kundenklassen
					+ "pistenPraef 			VARCHAR(200),"
					+ "gewicht				integer," 
					+ "schuhgroesse			double,"
					+ "technik				integer,"
					+ "beinstellung			BOOLEAN," 
					+ "bindungstyp			BOOLEAN," 
					+ "PRIMARY KEY(kundenNr))"; //FK anlegen für kreditkartenNr geht erst später!

			stmt.executeUpdate(s1); //könnte man alle strings zusammenfassen in einem update?
			System.out.println("Table 'kunden' created");
			
			// TABLE KREDITKARTEN ANLEGEN
			String s2 = "CREATE TABLE kreditkarten (" 
					+ "kreditkartenNr       	VARCHAR(200)," 
					+ "kundenNr					integer," // FK aus table kunden
					+ "kreditkartenname			VARCHAR(200),"
					+ "inhabername 				VARCHAR(200),"
					+ "kreditkartenpruefzahl   	integer," 
					+ "kreditkartengueltigkeit	VARCHAR(5)," 
					+ "CONSTRAINT kundenNr_fk FOREIGN KEY (kundenNr) REFERENCES kunden(kundenNr),"
					+ "PRIMARY KEY(kreditkartenNr))";

			stmt.executeUpdate(s2);
			System.out.println("Table 'kreditkarten' created");
			
			
			// TABLE SKIKATEGORIE ANLEGEN
			String s4 = "CREATE TABLE skikategorien (" 
					+ "skiKategorieNr			integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," 
					+ "skiKategorieName			VARCHAR(200)," 
					+ "PRIMARY KEY(skiKategorieNr))";

			stmt.executeUpdate(s4);
			System.out.println("Table 'skikategorien' created");
			
			// TABLE SNOWBOARDKATEGORIE ANLEGEN
			String s5 = "CREATE TABLE snowboardkategorien (" 
					+ "snowboardKategorieNr			integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," 
					+ "snowboardKategorieName		VARCHAR(200)," 
					+ "PRIMARY KEY(snowboardKategorieNr))";
			
			stmt.executeUpdate(s5);
			System.out.println("Table 'snowboardkategorien' created");
			
			// TABLE SKI ANLEGEN
			String s6 = "CREATE TABLE ski (" 
					+ "skiNr       			integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," //automatisch
					+ "skiKategorieNr		integer,"
					+ "skiProduktname		VARCHAR(200),"
					+ "skiTyp		 		VARCHAR(200)," 
					+ "regalNr				VARCHAR(200)," 
					+ "tagespreis			double,"
					+ "farbe				VARCHAR(200),"
					+ "CONSTRAINT skiKategorieNr_fk FOREIGN KEY (skiKategorieNr) REFERENCES skikategorien (skiKategorieNr),"
					+ "PRIMARY KEY(skiNr))";

			stmt.executeUpdate(s6);
			System.out.println("Table 'ski' created");
			
			// TABLE SNOWBOARD ANLEGEN
			String s7 = "CREATE TABLE snowboard (" 
					+ "snowboardNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," //automatisch
					+ "snowboardKategorieNr		integer,"
					+ "snowboardProduktname		VARCHAR(200),"
					+ "snowboardTyp		 		VARCHAR(200)," 
					+ "regalNr					VARCHAR(200)," 
					+ "tagespreis				double,"
					+ "farbe					VARCHAR(200),"
					+ "beinstellung				BOOLEAN," //gemeinsames Merkmal mit kunde...?
					+ "bindungstyp				BOOLEAN," //gemeinsames Merkmal mit kunde...?
					+ "CONSTRAINT snowboardKategorieNr_fk FOREIGN KEY (snowboardKategorieNr) REFERENCES snowboardkategorien (snowboardKategorieNr),"
					+ "PRIMARY KEY(snowboardNr))";

			stmt.executeUpdate(s7);
			System.out.println("Table 'snowboard' created");
			
			// TABLE AUSLEIHEN ANLEGEN
			String s8 = "CREATE TABLE ausleihen (" 
					+ "abholNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," //automatisch
					+ "kundenNr				integer," //FK
					+ "skiNr				integer," //FK
					+ "snowboardNr			integer," //FK
					+ "leihstart			TIMESTAMP," // korrekter Datentyp?
					+ "leihende				TIMESTAMP," // korrekter Datentyp?
					+ "mietpreis			double,"
					+ "kaution 				double,"
					+ "nachzahlung   		double," 
					+ "gesamtpreis			double," 
					+ "CONSTRAINT kundenNr_fk2 FOREIGN KEY (kundenNr) REFERENCES kunden(kundenNr),"
					+ "CONSTRAINT skiNr_fk FOREIGN KEY (skiNr) REFERENCES ski(skiNr),"
					+ "CONSTRAINT snowboardNr_fk FOREIGN KEY (snowboardNr) REFERENCES snowboard(snowboardNr),"
					+ "PRIMARY KEY(abholNr))";
			
			stmt.executeUpdate(s8);
			System.out.println("Table 'ausleihen' created");
			
			
			// insert statements in methoden?
//			String s2 = "INSERT INTO kunden VALUES (?,?,?,?,?,?)";
//			pstmt = conn.prepareStatement(s2);
//
//			pstmt.setString(1, "ISBN1");
//			pstmt.setString(2, k.getVorname());
//			pstmt.setString(3, "Thema1");
//			pstmt.setString(4, "A1");
//			pstmt.setInt(5, 1990);
//			pstmt.setInt(6, 25);
//			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return;
			}
		}

	}
	
	//db methoden

}
