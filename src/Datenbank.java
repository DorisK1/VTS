import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Datenbank {

	public static final String DBlocation = "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Datenbank\\DB1";
	public static final String connString = "jdbc:derby:" + DBlocation + ";create=true";
	public static Statement stmt = null;
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;

	public static void createTables() { // erstellt Tabellen in der Datenbank

		try {
			conn = DriverManager.getConnection(connString);
			System.out.println("Connection established");
			stmt = conn.createStatement();
			try {
				stmt.executeUpdate("DROP TABLE kreditkarten");
				stmt.executeUpdate("DROP TABLE ausleihen");
				stmt.executeUpdate("DROP TABLE kunden");
				stmt.executeUpdate("DROP TABLE ski");
				stmt.executeUpdate("DROP TABLE snowboard");
				stmt.executeUpdate("DROP TABLE skikategorien");
				stmt.executeUpdate("DROP TABLE snowboardkategorien");
				System.out.println("Tables dropped");

			} catch (Exception e) {
				System.out.println(e);
			}

			// TABLE KUNDEN ANLEGEN
			String s1 = "CREATE TABLE kunden ("
					+ "kundenNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," // automatisch
					+ "anrede	  			integer," + "vorname  			VARCHAR(200),"
					+ "nachname  			VARCHAR(200)," + "telefonNr   			VARCHAR(200),"
					+ "strasse     			VARCHAR(200)," + "hausNr   			VARCHAR(200),"
					+ "wohnort				VARCHAR(200)," + "plz		   			VARCHAR(200),"
					+ "land		   			VARCHAR(200)," + "kundenalter	  		integer,"
					+ "pistenPraef 			VARCHAR(200)," + "gewicht				integer,"
					+ "schuhgroesse			double," + "technik				VARCHAR(200),"
					+ "beinstellung			BOOLEAN," + "bindungstyp			BOOLEAN," + "PRIMARY KEY(kundenNr))";

			stmt.executeUpdate(s1);
			System.out.println("Table 'kunden' created");

			// TABLE KREDITKARTEN ANLEGEN
			String s2 = "CREATE TABLE kreditkarten (" + "kreditkartenNr       	VARCHAR(200),"
					+ "kundenNr					integer," + "kreditkartenname			VARCHAR(200),"
					+ "inhabername 				VARCHAR(200)," + "kreditkartenpruefzahl   	integer,"
					+ "kreditkartengueltigkeit	VARCHAR(5),"
					+ "CONSTRAINT kundenNr_fk FOREIGN KEY (kundenNr) REFERENCES kunden(kundenNr),"
					+ "PRIMARY KEY(kreditkartenNr))";

			stmt.executeUpdate(s2);
			System.out.println("Table 'kreditkarten' created");

			// TABLE SKIKATEGORIE ANLEGEN
			String s4 = "CREATE TABLE skikategorien (" + "skiKategorieNr			integer NOT NULL,"
					+ "skiKategorieName			VARCHAR(200)," + "PRIMARY KEY(skiKategorieNr))";

			stmt.executeUpdate(s4);
			System.out.println("Table 'skikategorien' created");

			// TABLE SNOWBOARDKATEGORIE ANLEGEN
			String s5 = "CREATE TABLE snowboardkategorien (" + "snowboardKategorieNr			integer NOT NULL,"
					+ "snowboardKategorieName		VARCHAR(200)," + "PRIMARY KEY(snowboardKategorieNr))";

			stmt.executeUpdate(s5);
			System.out.println("Table 'snowboardkategorien' created");

			// TABLE SKI ANLEGEN
			String s6 = "CREATE TABLE ski ("
					+ "skiNr       			integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "skiKategorieNr		integer," + "skiProduktname		VARCHAR(200),"
					+ "skiTyp		 		VARCHAR(200)," + "skiBildpfad			VARCHAR(1500),"
					+ "regalNr				VARCHAR(200)," + "tagespreis			double,"
					+ "farbe				VARCHAR(200),"
					+ "CONSTRAINT skiKategorieNr_fk FOREIGN KEY (skiKategorieNr) REFERENCES skikategorien (skiKategorieNr),"
					+ "PRIMARY KEY(skiNr))";

			stmt.executeUpdate(s6);
			System.out.println("Table 'ski' created");

			// TABLE SNOWBOARD ANLEGEN
			String s7 = "CREATE TABLE snowboard ("
					+ "snowboardNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "snowboardKategorieNr		integer," + "snowboardProduktname		VARCHAR(200),"
					+ "snowboardTyp		 		VARCHAR(200)," + "snowboardBildpfad		VARCHAR(1500),"
					+ "regalNr					VARCHAR(200)," + "tagespreis				double,"
					+ "farbe					VARCHAR(200)," + "beinstellung				BOOLEAN,"
					+ "bindungstyp				BOOLEAN,"
					+ "CONSTRAINT snowboardKategorieNr_fk FOREIGN KEY (snowboardKategorieNr) REFERENCES snowboardkategorien (snowboardKategorieNr),"
					+ "PRIMARY KEY(snowboardNr))";

			stmt.executeUpdate(s7);
			System.out.println("Table 'snowboard' created");

			// TABLE AUSLEIHEN ANLEGEN
			String s8 = "CREATE TABLE ausleihen ("
					+ "abholNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "kundenNr				integer," // FK
					+ "skiNr				integer," // FK
					+ "snowboardNr			integer," // FK
					+ "leihstart			DATE," + "leihende				DATE," + "mietpreis			double,"
					+ "kaution 				double," + "nachzahlung   		double," + "gesamtpreis			double,"
					+ "CONSTRAINT kundenNr_fk2 FOREIGN KEY (kundenNr) REFERENCES kunden(kundenNr),"
					+ "CONSTRAINT skiNr_fk FOREIGN KEY (skiNr) REFERENCES ski(skiNr),"
					+ "CONSTRAINT snowboardNr_fk FOREIGN KEY (snowboardNr) REFERENCES snowboard(snowboardNr),"
					+ "PRIMARY KEY(abholNr))";

			stmt.executeUpdate(s8);
			System.out.println("Table 'ausleihen' created");

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

	public static void insertSkiRows(Ski sk) throws SQLException { // legt Kategorien für Ski und Produkte an

		conn = DriverManager.getConnection(connString);
		stmt = conn.createStatement();
		// SKIKATEGORIEN ANLEGEN
		// KAT 1
		String s10 = "INSERT INTO skikategorien (skikategorienr, skiKategorieName) VALUES (?,?)";
		pstmt = conn.prepareStatement(s10);
		pstmt.setInt(1, 1); // skikategorienr
		pstmt.setString(2, "Kat1 - Carver"); // skiKategorieName, String
		pstmt.executeUpdate();
		System.out.println("Skikategorie 1 angelegt");
		// KAT 2
		String s11 = "INSERT INTO skikategorien (skiKategorieNr, skiKategorieName) VALUES (?,?)";
		pstmt = conn.prepareStatement(s11);
		pstmt.setInt(1, 2); // skikategorienr
		pstmt.setString(2, "Kat2 - Alpin"); // skiKategorieName, String
		pstmt.executeUpdate();
		System.out.println("Skikategorie 2 angelegt");
		// KAT 3
		String s12 = "INSERT INTO skikategorien (skiKategorieNr, skiKategorieName) VALUES (?,?)";
		pstmt = conn.prepareStatement(s12);
		pstmt.setInt(1, 3); // skikategorienr
		pstmt.setString(2, "Kat3 - Race"); // skiKategorieName, String
		pstmt.executeUpdate();
		System.out.println("Skikategorie 3 angelegt");

		// SKI ANLEGEN
		// in KAT 1 CARVER
		// kat1 Ski 1
		String s9 = "INSERT INTO ski (skiKategorieNr, skiProduktname, skiTyp, skiBildpfad, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s9); // skinr nicht anlegen, da autogenerated
		pstmt.setInt(1, 1); // skikategorienr
		pstmt.setString(2, "Carver A"); // skiProduktname, String
		pstmt.setString(3, "Carver"); // skiTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sk_rot.jpg"); // skiBildpfad,
																										// String
		pstmt.setString(5, "R123"); // regalNr, String
		pstmt.setDouble(6, 12.50); // tagesPreis, double
		pstmt.setString(7, "ROT"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Carver A in KAT 1 angelegt");
		// hier skinr setzen!!! analog postKunde
		String autowert = "SELECT IDENTITY_VAL_LOCAL() FROM ski"; // spezieller derby sql befehl
		ResultSet rs = stmt.executeQuery(autowert);
		rs.next();
		int skiNr1 = rs.getInt("1");
		sk.setSkiNr(skiNr1);
		System.out.println("SkiNr: " + skiNr1);
		rs = null;

		// kat1 ski 2
		String s9a = "INSERT INTO ski (skiKategorieNr, skiProduktname, skiTyp, skiBildpfad, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s9a); // skinr nicht anlegen, da autogenerated
		pstmt.setInt(1, 1); // skikategorienr
		pstmt.setString(2, "Carver B"); // skiProduktname, String
		pstmt.setString(3, "Carver"); // skiTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sk_blau.jpg");
		pstmt.setString(5, "R124"); // regalNr, String
		pstmt.setDouble(6, 11.50); // tagesPreis, double
		pstmt.setString(7, "BLAU"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Carver B in KAT 1 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int skiNr2 = rs.getInt("1");
		sk.setSkiNr(skiNr2);
		System.out.println("SkiNr: " + skiNr2);
		rs = null;

		// kat1 ski 3
		String s9b = "INSERT INTO ski (skiKategorieNr, skiProduktname, skiTyp, skiBildpfad, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s9b); // skinr nicht anlegen, da autogenerated
		pstmt.setInt(1, 1); // skikategorienr
		pstmt.setString(2, "Carver C"); // skiProduktname, String
		pstmt.setString(3, "Carver"); // skiTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sk_schwarz.jpg");
		pstmt.setString(5, "R125"); // regalNr, String
		pstmt.setDouble(6, 13.50); // tagesPreis, double
		pstmt.setString(7, "SCHWARZ"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Carver C in KAT 1 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int skiNr3 = rs.getInt("1");
		sk.setSkiNr(skiNr3);
		System.out.println("SkiNr: " + skiNr3);
		rs = null;
		// in KAT 2
		// kat2 ski 1
		String s13 = "INSERT INTO ski (skiKategorieNr, skiProduktname, skiTyp, skiBildpfad, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s13);
		pstmt.setInt(1, 2); // skikategorienr
		pstmt.setString(2, "Alpin A"); // skiProduktname, String
		pstmt.setString(3, "Alpin"); // skiTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sk_orange.jpg");
		pstmt.setString(5, "R129"); // regalNr, String
		pstmt.setDouble(6, 15.50); // tagesPreis, double
		pstmt.setString(7, "ORANGE"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Alpin A in KAT 2 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int skiNr4 = rs.getInt("1");
		sk.setSkiNr(skiNr4);
		System.out.println("SkiNr: " + skiNr4);
		rs = null;
		// kat2 ski 2
		String s13a = "INSERT INTO ski (skiKategorieNr, skiProduktname, skiTyp, skiBildpfad, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s13a);
		pstmt.setInt(1, 2); // skikategorienr
		pstmt.setString(2, "Alpin B"); // skiProduktname, String
		pstmt.setString(3, "Alpin"); // skiTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sk_blau.jpg");
		pstmt.setString(5, "R130"); // regalNr, String
		pstmt.setDouble(6, 18.50); // tagesPreis, double
		pstmt.setString(7, "BLAU"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Alpin B in KAT 2 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int skiNr5 = rs.getInt("1");
		sk.setSkiNr(skiNr5);
		System.out.println("SkiNr: " + skiNr5);
		rs = null;
		// kat2 ski 3
		String s13b = "INSERT INTO ski (skiKategorieNr, skiProduktname, skiTyp, skiBildpfad, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s13b);
		pstmt.setInt(1, 2); // skikategorienr
		pstmt.setString(2, "Alpin C"); // skiProduktname, String
		pstmt.setString(3, "Alpin"); // skiTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sk_schwarz.jpg");
		pstmt.setString(5, "R131"); // regalNr, String
		pstmt.setDouble(6, 19.50); // tagesPreis, double
		pstmt.setString(7, "SCHWARZ"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Alpin C in KAT 2 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int skiNr6 = rs.getInt("1");
		sk.setSkiNr(skiNr6);
		System.out.println("SkiNr: " + skiNr6);
		rs = null;
		// in KAT 3
		// kat3 ski 1
		String s14 = "INSERT INTO ski (skiKategorieNr, skiProduktname, skiTyp, skiBildpfad, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s14);
		pstmt.setInt(1, 3); // skikategorienr
		pstmt.setString(2, "Racer A"); // skiProduktname, String
		pstmt.setString(3, "Racer"); // skiTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sk_tuerkis.jpg");
		pstmt.setString(5, "R100"); // regalNr, String
		pstmt.setDouble(6, 20.50); // tagesPreis, double
		pstmt.setString(7, "TÜRKIS"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Racer A in KAT 3 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int skiNr7 = rs.getInt("1");
		sk.setSkiNr(skiNr7);
		System.out.println("SkiNr: " + skiNr7);
		rs = null;
		// kat3 ski 2
		String s14a = "INSERT INTO ski (skiKategorieNr, skiProduktname, skiTyp, skiBildpfad, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s14a);
		pstmt.setInt(1, 3); // skikategorienr
		pstmt.setString(2, "Racer B"); // skiProduktname, String
		pstmt.setString(3, "Racer"); // skiTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sk_gruen.jpg");
		pstmt.setString(5, "R101"); // regalNr, String
		pstmt.setDouble(6, 21.50); // tagesPreis, double
		pstmt.setString(7, "GRÜN"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Racer B in KAT 3 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int skiNr8 = rs.getInt("1");
		sk.setSkiNr(skiNr8);
		System.out.println("SkiNr: " + skiNr8);
		rs = null;
		// kat3 ski 3
		String s14b = "INSERT INTO ski (skiKategorieNr, skiProduktname, skiTyp, skiBildpfad, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s14b);
		pstmt.setInt(1, 3); // skikategorienr
		pstmt.setString(2, "Racer C"); // skiProduktname, String
		pstmt.setString(3, "Racer"); // skiTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sk_orange.jpg");
		pstmt.setString(5, "R102"); // regalNr, String
		pstmt.setDouble(6, 22.50); // tagesPreis, double
		pstmt.setString(7, "ORANGE"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Racer C in KAT 3 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int skiNr9 = rs.getInt("1");
		sk.setSkiNr(skiNr9);
		System.out.println("SkiNr: " + skiNr9);
		rs = null;

	}

	public static void insertSnowboardRows(Snowboard sb) throws SQLException { // legt Kategorien für Snowboards und
																				// Produkte an
		conn = DriverManager.getConnection(connString);
		stmt = conn.createStatement();
		// SNOWBOARDKategorien anlegen
		// KAT 1
		String s15 = "INSERT INTO snowboardkategorien (snowboardKategorieNr, snowboardKategorieName) VALUES (?,?)";
		pstmt = conn.prepareStatement(s15);
		pstmt.setInt(1, 1); // skikategorienr
		pstmt.setString(2, "Kat1 - Freestyle"); // skiKategorieName, String
		pstmt.executeUpdate();
		System.out.println("Snowboardkategorie 1 angelegt");

		// KAT 2
		String s15a = "INSERT INTO snowboardkategorien (snowboardKategorieNr, snowboardKategorieName) VALUES (?,?)";
		pstmt = conn.prepareStatement(s15a);
		pstmt.setInt(1, 2); // skikategorienr
		pstmt.setString(2, "Kat2 - Freeride"); // skiKategorieName, String
		pstmt.executeUpdate();
		System.out.println("Snowboardkategorie 2 angelegt");
		// KAT 3
		String s15b = "INSERT INTO snowboardkategorien (snowboardKategorieNr, snowboardKategorieName) VALUES (?,?)";
		pstmt = conn.prepareStatement(s15b);
		pstmt.setInt(1, 3); // skikategorienr
		pstmt.setString(2, "Kat3 - All Mountain"); // skiKategorieName, String
		pstmt.executeUpdate();
		System.out.println("Snowboardkategorie 3 angelegt");

		// SNOWBOARDS ANLEGEN
		// in KAT 1 FREESTYLE
		// kat1 Snowboard 1
		String s16 = "INSERT INTO snowboard (snowboardKategorieNr, snowboardProduktname, snowboardTyp, snowboardBildpfad, "
				+ "regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s16);
		pstmt.setInt(1, 1); // snowboardkategorienr
		pstmt.setString(2, "Freestyle A"); // snowboardProduktname, String
		pstmt.setString(3, "Freestyle"); // snowboardTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sb_schwarz.jpg");
		pstmt.setString(5, "S102"); // regalNr, String
		pstmt.setDouble(6, 15.50); // tagesPreis, double
		pstmt.setString(7, "SCHWARZ"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Freestyle A in KAT 1 angelegt");
		String autowert = "SELECT IDENTITY_VAL_LOCAL() FROM snowboard"; // spezieller derby sql befehl
		ResultSet rs = stmt.executeQuery(autowert);
		rs = stmt.executeQuery(autowert); // immer noch autowert für ski??? deshalb immer gleiche id?!?
		rs.next();
		int snowboardNr1 = rs.getInt("1");
		sb.setSnowboardNr(snowboardNr1);
		System.out.println("SnowboardNr: " + snowboardNr1);
		rs = null;
		// kat1 Snowboard 2
		String s16a = "INSERT INTO snowboard (snowboardKategorieNr, snowboardProduktname, snowboardTyp, snowboardBildpfad, "
				+ "regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s16a);
		pstmt.setInt(1, 1); // snowboardkategorienr
		pstmt.setString(2, "Freestyle B"); // snowboardProduktname, String
		pstmt.setString(3, "Freestyle"); // snowboardTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sb_bunt.jpg");
		pstmt.setString(5, "S103"); // regalNr, String
		pstmt.setDouble(6, 16.50); // tagesPreis, double
		pstmt.setString(7, "BUNT"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Freestyle B in KAT 1 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int snowboardNr2 = rs.getInt("1");
		sb.setSnowboardNr(snowboardNr2);
		System.out.println("SnowboardNr: " + snowboardNr2);
		rs = null;
		// kat1 Snowboard 3
		String s16b = "INSERT INTO snowboard (snowboardKategorieNr, snowboardProduktname, snowboardTyp, snowboardBildpfad, "
				+ "regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s16b);
		pstmt.setInt(1, 1); // snowboardkategorienr
		pstmt.setString(2, "Freestyle C"); // snowboardProduktname, String
		pstmt.setString(3, "Freestyle"); // snowboardTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sb_rot.jpg");
		pstmt.setString(5, "S104"); // regalNr, String
		pstmt.setDouble(6, 16.50); // tagesPreis, double
		pstmt.setString(7, "ROT"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Freestyle C in KAT 1 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int snowboardNr3 = rs.getInt("1");
		sb.setSnowboardNr(snowboardNr3);
		System.out.println("SnowboardNr: " + snowboardNr3);
		rs = null;
		// in KAT 2 FREERIDE
		// kat2 Snowboard 1
		String s17 = "INSERT INTO snowboard (snowboardKategorieNr, snowboardProduktname, snowboardTyp, snowboardBildpfad, "
				+ "regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s17);
		pstmt.setInt(1, 2); // snowboardkategorienr
		pstmt.setString(2, "Freeride A"); // snowboardProduktname, String
		pstmt.setString(3, "Freeride"); // snowboardTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sb_blau.jpg");
		pstmt.setString(5, "S120"); // regalNr, String
		pstmt.setDouble(6, 11.50); // tagesPreis, double
		pstmt.setString(7, "BLAU"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Freeride A in KAT 2 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int snowboardNr4 = rs.getInt("1");
		sb.setSnowboardNr(snowboardNr4);
		System.out.println("SnowboardNr: " + snowboardNr4);
		rs = null;
		// kat2 Snowboard 2
		String s17a = "INSERT INTO snowboard (snowboardKategorieNr, snowboardProduktname, snowboardTyp, snowboardBildpfad, "
				+ "regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s17a);
		pstmt.setInt(1, 2); // snowboardkategorienr
		pstmt.setString(2, "Freeride B"); // snowboardProduktname, String
		pstmt.setString(3, "Freeride"); // snowboardTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sb_pink.jpg");
		pstmt.setString(5, "S128"); // regalNr, String
		pstmt.setDouble(6, 10.50); // tagesPreis, double
		pstmt.setString(7, "PINK"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Freeride B in KAT 2 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int snowboardNr5 = rs.getInt("1");
		sb.setSnowboardNr(snowboardNr5);
		System.out.println("SnowboardNr: " + snowboardNr5);
		rs = null;
		// kat2 Snowboard 3
		String s17b = "INSERT INTO snowboard (snowboardKategorieNr, snowboardProduktname, snowboardTyp, snowboardBildpfad, "
				+ "regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s17b);
		pstmt.setInt(1, 2); // snowboardkategorienr
		pstmt.setString(2, "Freeride C"); // snowboardProduktname, String
		pstmt.setString(3, "Freeride"); // snowboardTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sb_rot.jpg");
		pstmt.setString(5, "S129"); // regalNr, String
		pstmt.setDouble(6, 10.50); // tagesPreis, double
		pstmt.setString(7, "ROT"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("Freeride C in KAT 2 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int snowboardNr6 = rs.getInt("1");
		sb.setSnowboardNr(snowboardNr6);
		System.out.println("SnowboardNr: " + snowboardNr6);
		rs = null;
		// in KAT 3 All Mountain
		// kat3 Snowboard 1
		String s18 = "INSERT INTO snowboard (snowboardKategorieNr, snowboardProduktname, snowboardTyp, "
				+ "snowboardBildpfad, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s18);
		pstmt.setInt(1, 3); // snowboardkategorienr
		pstmt.setString(2, "All Mountain A"); // snowboardProduktname, String
		pstmt.setString(3, "All Mountain"); // snowboardTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sb_bunt.jpg");
		pstmt.setString(5, "S180"); // regalNr, String
		pstmt.setDouble(6, 18.50); // tagesPreis, double
		pstmt.setString(7, "BUNT"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("All Mountain A in KAT 3 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int snowboardNr7 = rs.getInt("1");
		sb.setSnowboardNr(snowboardNr7);
		System.out.println("SnowboardNr: " + snowboardNr7);
		rs = null;
		// kat3 Snowboard 2
		String s18a = "INSERT INTO snowboard (snowboardKategorieNr, snowboardProduktname, snowboardTyp, snowboardBildpfad, "
				+ "regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s18a);
		pstmt.setInt(1, 3); // snowboardkategorienr
		pstmt.setString(2, "All Mountain B"); // snowboardProduktname, String
		pstmt.setString(3, "All Mountain"); // snowboardTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sb_schwarz.jpg");
		pstmt.setString(5, "S181"); // regalNr, String
		pstmt.setDouble(6, 17.50); // tagesPreis, double
		pstmt.setString(7, "SCHWARZ"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("All Mountain B in KAT 3 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int snowboardNr8 = rs.getInt("1");
		sb.setSnowboardNr(snowboardNr8);
		System.out.println("SnowboardNr: " + snowboardNr8);
		rs = null;
		// kat3 Snowboard 3
		String s18b = "INSERT INTO snowboard (snowboardKategorieNr, snowboardProduktname, snowboardTyp, snowboardBildpfad, "
				+ "regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s18b);
		pstmt.setInt(1, 3); // snowboardkategorienr
		pstmt.setString(2, "All Mountain C"); // snowboardProduktname, String
		pstmt.setString(3, "All Mountain"); // snowboardTyp, String
		pstmt.setString(4, "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Bilder\\sb_blau.jpg");
		pstmt.setString(5, "S182"); // regalNr, String
		pstmt.setDouble(6, 15.50); // tagesPreis, double
		pstmt.setString(7, "BLAU"); // farbe, String
		pstmt.executeUpdate();
		System.out.println("All Mountain C in KAT 3 angelegt");
		rs = stmt.executeQuery(autowert);
		rs.next();
		int snowboardNr9 = rs.getInt("1");
		sb.setSnowboardNr(snowboardNr9);
		System.out.println("SnowboardNr: " + snowboardNr9);
		rs = null;
	}

	public static void insertCustomerRows(Kunde k) throws SQLException { // Kunden anlegen
		conn = DriverManager.getConnection(connString);
		stmt = conn.createStatement();
		String s = "INSERT INTO kunden (anrede, vorname, nachname, telefonNr, strasse, hausNr, wohnort, plz, land, kundenalter, "
				+ "pistenPraef, gewicht, schuhgroesse, technik, beinstellung, bindungstyp) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		// Kunde 1
		pstmt = conn.prepareStatement(s);
		pstmt.setInt(1, 1); // anrede
		pstmt.setString(2, "Maria"); // vorname
		pstmt.setString(3, "Mustermann"); // nachname
		pstmt.setString(4, "+43-664-1584798"); // telefonNr
		pstmt.setString(5, "Musterstrasse"); // strasse
		pstmt.setString(6, "1a"); // hausNr
		pstmt.setString(7, "Wien"); // wohnort
		pstmt.setString(8, "1020"); // plz
		pstmt.setString(9, "AT"); // land
		pstmt.setInt(10, 44); // kundenalter
		pstmt.setString(11, "blau"); // pistenPraef
		pstmt.setDouble(12, 59.5); // gewicht
		pstmt.setDouble(13, 38.5); // schuhgroesse
		pstmt.setString(14, "mittel"); // technik
		pstmt.setBoolean(15, true); // beinstellung
		pstmt.setBoolean(16, false); // bindungstyp
		pstmt.executeUpdate();

		String autowert = "SELECT IDENTITY_VAL_LOCAL() FROM kunden";
		ResultSet rs = stmt.executeQuery(autowert);
		rs.next();
		int kundenNr1 = rs.getInt("1");
		k.setKundenNr(kundenNr1);
		System.out.println("Kunde mit KundenNr: " + kundenNr1 + " angelegt");
		rs = null;

		// Kunde 2
		pstmt = conn.prepareStatement(s);
		pstmt.setInt(1, 2); // anrede
		pstmt.setString(2, "Max"); // vorname
		pstmt.setString(3, "Mustermann"); // nachname
		pstmt.setString(4, "+43-664-1584798"); // telefonNr
		pstmt.setString(5, "Musterstrasse"); // strasse
		pstmt.setString(6, "1a"); // hausNr
		pstmt.setString(7, "Wien"); // wohnort
		pstmt.setString(8, "1020"); // plz
		pstmt.setString(9, "AT"); // land
		pstmt.setInt(10, 44); // kundenalter
		pstmt.setString(11, "blau"); // pistenPraef
		pstmt.setDouble(12, 81.5); // gewicht
		pstmt.setDouble(13, 42.5); // schuhgroesse
		pstmt.setString(14, "sehr gut"); // technik
		pstmt.setBoolean(15, true); // beinstellung
		pstmt.setBoolean(16, false); // bindungstyp
		pstmt.executeUpdate();

		rs = stmt.executeQuery(autowert);
		rs.next();
		int kundenNr2 = rs.getInt("1");
		k.setKundenNr(kundenNr2);
		System.out.println("Kunde mit KundenNr: " + kundenNr2 + " angelegt");
		rs = null;

		// Kunde 3
		pstmt = conn.prepareStatement(s);
		pstmt.setInt(1, 3); // anrede
		pstmt.setString(2, "Tanja"); // vorname
		pstmt.setString(3, "Toll"); // nachname
		pstmt.setString(4, "+43-664-35879655"); // telefonNr
		pstmt.setString(5, "Tollstrasse"); // strasse
		pstmt.setString(6, "1a"); // hausNr
		pstmt.setString(7, "Mannheim"); // wohnort
		pstmt.setString(8, "48946"); // plz
		pstmt.setString(9, "DE"); // land
		pstmt.setInt(10, 27); // kundenalter
		pstmt.setString(11, "rot"); // pistenPraef
		pstmt.setDouble(12, 55.5); // gewicht
		pstmt.setDouble(13, 37.5); // schuhgroesse
		pstmt.setString(14, "sehr gut"); // technik
		pstmt.setBoolean(15, false); // beinstellung
		pstmt.setBoolean(16, false); // bindungstyp
		pstmt.executeUpdate();

		rs = stmt.executeQuery(autowert);
		rs.next();
		int kundenNr3 = rs.getInt("1");
		k.setKundenNr(kundenNr3);
		System.out.println("Kunde mit KundenNr: " + kundenNr3 + " angelegt");
		rs = null;

		pstmt = conn.prepareStatement(s);
		pstmt.setInt(1, 2); // anrede
		pstmt.setString(2, "Thomas"); // vorname
		pstmt.setString(3, "Müller"); // nachname
		pstmt.setString(4, "+43-664-3889985"); // telefonNr
		pstmt.setString(5, "Ringstrasse"); // strasse
		pstmt.setString(6, "17"); // hausNr
		pstmt.setString(7, "München"); // wohnort
		pstmt.setString(8, "42187"); // plz
		pstmt.setString(9, "DE"); // land
		pstmt.setInt(10, 59); // kundenalter
		pstmt.setString(11, "schwarz"); // pistenPraef
		pstmt.setDouble(12, 89); // gewicht
		pstmt.setDouble(13, 43); // schuhgroesse
		pstmt.setString(14, "sehr gut"); // technik
		pstmt.setBoolean(15, false); // beinstellung
		pstmt.setBoolean(16, false); // bindungstyp
		pstmt.executeUpdate();

		rs = stmt.executeQuery(autowert);
		rs.next();
		int kundenNr4 = rs.getInt("1");
		k.setKundenNr(kundenNr4);
		System.out.println("Kunde mit KundenNr: " + kundenNr4 + " angelegt");
		rs = null;

	}

	public static void insertCreditCardRows(Kreditkarte kk) throws SQLException { // legt Kreditkarteninformationen an

		conn = DriverManager.getConnection(connString);
		stmt = conn.createStatement();
		String s = "INSERT INTO kreditkarten (kreditkartenNr, kundenNr, kreditkartenname, inhabername, kreditkartenpruefzahl, "
				+ "kreditkartengueltigkeit) VALUES (?,?,?,?,?,?)";

		// KK 1 - Kunde 1
		pstmt = conn.prepareStatement(s);
		pstmt.setString(1, "7894-5461-7894-7897"); // kreditkartenNr
		pstmt.setInt(2, 1); // kundenNr
		pstmt.setString(3, "Mastercard"); // kreditkartenname
		pstmt.setString(4, "Maria Mustermann"); // inhabername
		pstmt.setInt(5, 899); // kreditkartenpruefzahl
		pstmt.setString(6, "12/22"); // kreditkartengueltigkeit
		pstmt.executeUpdate();
		System.out.println("Kreditkarte 1 angelegt");
		// KK 2 - Kunde 2
		pstmt = conn.prepareStatement(s);
		pstmt.setString(1, "1565-5461-6465-5454"); // kreditkartenNr
		pstmt.setInt(2, 2); // kundenNr
		pstmt.setString(3, "Visa"); // kreditkartenname
		pstmt.setString(4, "Max Mustermann"); // inhabername
		pstmt.setInt(5, 588); // kreditkartenpruefzahl
		pstmt.setString(6, "04/25"); // kreditkartengueltigkeit
		pstmt.executeUpdate();
		System.out.println("Kreditkarte 2 angelegt");
		// KK 3 - Kunde 3
		pstmt = conn.prepareStatement(s);
		pstmt.setString(1, "2465-8465-6655-5454"); // kreditkartenNr
		pstmt.setInt(2, 3); // kundenNr
		pstmt.setString(3, "Visa"); // kreditkartenname
		pstmt.setString(4, "Tanja Toll"); // inhabername
		pstmt.setInt(5, 485); // kreditkartenpruefzahl
		pstmt.setString(6, "08/19"); // kreditkartengueltigkeit
		pstmt.executeUpdate();
		System.out.println("Kreditkarte 3 angelegt");
		// KK 4 - Kunde 4
		pstmt = conn.prepareStatement(s);
		pstmt.setString(1, "8799-8953-9987-3333"); // kreditkartenNr
		pstmt.setInt(2, 4); // kundenNr
		pstmt.setString(3, "American Express"); // kreditkartenname
		pstmt.setString(4, "Thomas Müller"); // inhabername
		pstmt.setInt(5, 485); // kreditkartenpruefzahl
		pstmt.setString(6, "01/20"); // kreditkartengueltigkeit
		pstmt.executeUpdate();
		System.out.println("Kreditkarte 4 angelegt");
	}

	public static Boolean postKunde(Kunde k) { // Speichert einen neuen Kunden in der Datenbank ab

		System.out.println("neuen Kunden anlegen");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement("INSERT INTO kunden(anrede, vorname, nachname, telefonNr, strasse, hausNr, "
					+ "wohnort, plz, land, kundenalter, pistenPraef, gewicht, schuhgroesse, "
					+ "technik, beinstellung, bindungstyp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			pstmt.setInt(1, k.getAnrede());
			pstmt.setString(2, k.getVorname());
			pstmt.setString(3, k.getNachname());
			pstmt.setString(4, k.getTelefonNr());
			pstmt.setString(5, k.getStrasse());
			pstmt.setString(6, k.getHausNr());
			pstmt.setString(7, k.getWohnort());
			pstmt.setString(8, k.getPlz());
			pstmt.setString(9, k.getLand());
			pstmt.setInt(10, k.getAlter());
			pstmt.setString(11, k.getPistenPraef());
			pstmt.setInt(12, k.getGewicht());
			pstmt.setDouble(13, k.getSchuhgroesse());
			pstmt.setString(14, k.getTechnik());
			pstmt.setBoolean(15, k.isBeinstellung());
			pstmt.setBoolean(16, k.isBindungstyp());
			pstmt.executeUpdate();
			// die automatisch generierte kundenNr muss erst in ein Kundenobjekt gespeichert
			// werden!
			String autowert = "SELECT IDENTITY_VAL_LOCAL() FROM kunden"; // spezieller derby sql befehl
			ResultSet rs = stmt.executeQuery(autowert);
			rs.next();
			int kundenNr = rs.getInt("1");
			k.setKundenNr(kundenNr);
			System.out.println("Kundennummer: " + kundenNr);
			rs = null;
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}

	}

	public static Kunde getKunde(int kundenNr) { // holt sich einen Kunden über die Kundennummer aus der Datenbank

		Connection conn = null;
		ResultSet rs = null;
		Kunde k = new Kunde();
		System.out.println("Query Kunde über Kundennummer");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kunden WHERE kundenNr =" + kundenNr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("kundenNr = " + rs.getInt("kundenNr") + "anrede = " + rs.getInt("anrede")
						+ " vorname = " + rs.getString("vorname") + " nachname = " + rs.getString("nachname")
						+ " telefonNr = " + rs.getString("telefonNr") + " strasse = " + rs.getString("strasse")
						+ " hausNr = " + rs.getString("hausNr") + " wohnort = " + rs.getString("wohnort") + " plz = "
						+ rs.getString("plz") + " land = " + rs.getString("land") + " kundenalter = "
						+ rs.getInt("kundenalter"));

				// KUNDEN OBJ ANLEGEN
				k.setKundenNr(rs.getInt("kundenNr"));
				k.setAnrede(rs.getInt("anrede"));
				k.setVorname(rs.getString("vorname"));
				k.setNachname(rs.getString("nachname"));
				k.setTelefonNr(rs.getString("telefonNr"));
				k.setStrasse(rs.getString("strasse"));
				k.setHausNr(rs.getString("hausNr"));
				k.setWohnort(rs.getString("wohnort"));
				k.setPlz(rs.getString("plz"));
				k.setLand(rs.getString("land"));
				k.setAlter(rs.getInt("kundenalter"));
				k.setPistenPraef(rs.getString("pistenPraef"));
				k.setGewicht(rs.getInt("gewicht"));
				k.setSchuhgroesse(rs.getDouble("schuhgroesse"));
				k.setTechnik(rs.getString("technik"));
				k.setBeinstellung(rs.getBoolean("beinstellung"));
				k.setBindungstyp(rs.getBoolean("bindungstyp"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return k;
	}

	public static ArrayList<Kunde> getKunden() { // gibt eine ArrayList aller Kunden zurück
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Kunde> kl = new ArrayList<Kunde>();

		System.out.println("Query ALLE KUNDEN");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kunden  ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("kundenNr = " + rs.getInt("kundenNr") + " vorname = " + rs.getString("vorname")
						+ " nachname = " + rs.getString("nachname") + " land = " + rs.getString("land")
						+ " kundenalter = " + rs.getInt("kundenalter") + " technik = " + rs.getString("technik"));

				kl.add(new Kunde(rs.getInt("kundenNr"), rs.getInt("anrede"), rs.getString("vorname"),
						rs.getString("nachname"), rs.getString("telefonNr"), rs.getString("strasse"),
						rs.getString("hausNr"), rs.getString("wohnort"), rs.getString("plz"), rs.getString("land"),
						rs.getInt("kundenalter"), rs.getString("pistenPraef"), rs.getInt("gewicht"),
						rs.getDouble("schuhgroesse"), rs.getString("technik"), rs.getBoolean("beinstellung"),
						rs.getBoolean("bindungstyp")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return kl;
	}

	public static Boolean postAusleihe(Ausleihe a) { // Speichert eine neuen Ausleihe in der Datenbank ab

		System.out.println("neue Ausleihe anlegen");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement("INSERT INTO ausleihen(kundenNr,"
					+ (a.getSkiNr() > 0 ? " skiNr," : " snowboardNr,") + " leihstart, leihende, mietpreis, "
					+ "kaution, nachzahlung, gesamtpreis) " + "VALUES(?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, a.getKundenNr());
			pstmt.setInt(2, a.getSkiNr() > 0 ? a.getSkiNr() : a.getSnowboardNr());
			pstmt.setDate(3, a.getLeihstart());
			pstmt.setDate(4, a.getLeihende());
			pstmt.setDouble(5, a.getMietpreis()); // tagespreis*az der tage
			pstmt.setDouble(6, a.getKaution());
			pstmt.setDouble(7, a.getNachzahlung());
			pstmt.setDouble(8, a.getGesamtpreis());
			pstmt.executeUpdate();

			// abholnummer abfragen
			String autowert = "SELECT IDENTITY_VAL_LOCAL() FROM ausleihen"; // spezieller derby sql befehl
			ResultSet rs = stmt.executeQuery(autowert);
			rs.next();
			int abholNr = rs.getInt("1");
			a.setAbholNr(abholNr);
			System.out.println(a);
			rs = null;
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}

	}

	public static Ausleihe getAusleihe(int abholNr) { // holt sich Ausleihe über die Abholnummer

		Connection conn = null;
		ResultSet rs = null;
		Ausleihe a = new Ausleihe();
		System.out.println("Query Ausleihen Suche nach AbholNr");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM ausleihen WHERE abholNr =" + abholNr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("kundenNr = " + rs.getInt("kundenNr") + "abholNr = " + rs.getInt("abholNr"));

				// AUSLEIHE OBJ ANLEGeN aus DB
				a.setAbholNr(rs.getInt("abholNr"));
				a.setKundenNr(rs.getInt("kundenNr"));
				a.setSkiNr(rs.getInt("skiNr")); 
				a.setSnowboardNr(rs.getInt("snowboardNr"));
				a.setLeihstart(rs.getDate("leihstart"));
				a.setLeihende(rs.getDate("leihende"));
				a.setMietpreis(rs.getDouble("mietpreis"));
				a.setKaution(rs.getDouble("kaution"));
				a.setNachzahlung(rs.getDouble("nachzahlung"));
				a.setGesamtpreis(rs.getDouble("gesamtpreis"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return a;

	}

	public static Ausleihe getNewAusleihe(int kundenNr) { // holt sich Ausleihe über die Kundennummer

		Connection conn = null;
		ResultSet rs = null;
		Ausleihe a = new Ausleihe();
		System.out.println("Query Ausleihen Suche nach kundenNr");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM ausleihen WHERE kundenNr =" + kundenNr);
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		try {
			while (rs.next()) {
				System.out.println("kundenNr = " + rs.getInt("kundenNr") + "abholNr = " + rs.getInt("abholNr"));

				// AUSLEIHE OBJ ANLEGeN aus DB
				a.setAbholNr(rs.getInt("abholNr"));
				a.setKundenNr(rs.getInt("kundenNr"));
				// a.setSkiNr(rs.getInt("skiNr") > 0 ? a.setSkiNr(rs.getInt("skiNr")) :
				// a.setSnowboardNr(rs.getInt("snowboardNr")));
				// a.setSkiNr(rs.getInt("skiNr")); // pstmt.setInt(2, a.getSkiNr() > 0 ?
				// a.getSkiNr() :
				// // a.getSnowboardNr());
				// a.setSnowboardNr(rs.getInt("snowboardNr"));
				// a.setLeihstart(rs.getDate("leihstart"));
				a.setLeihende(rs.getDate("leihende"));
				a.setMietpreis(rs.getDouble("mietpreis"));
				a.setKaution(rs.getDouble("kaution"));
				a.setNachzahlung(rs.getDouble("nachzahlung"));
				a.setGesamtpreis(rs.getDouble("gesamtpreis"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return a;

	}

	public static ArrayList<Ausleihe> getAusleihen() { // gibt eine ArrayList aller Ausleihen zurück
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Ausleihe> kl = new ArrayList<Ausleihe>();

		System.out.println("Query ALLE Ausleihen");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM ausleihen  ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("abholNr = " + rs.getInt("abholNr") + " kundenNr = " + rs.getInt("kundenNr")
						+ " skiNr = " + rs.getInt("skiNr") + " snowboardNr = " + rs.getInt("snowboardNr")
						+ " leihstart = " + rs.getDate("leihstart") + " leihende = " + rs.getDate("leihende")
						+ " gesamtpreis = " + rs.getDouble("gesamtpreis"));

				kl.add(new Ausleihe(rs.getInt("abholNr"), rs.getInt("kundenNr"), rs.getInt("skiNr"),
						rs.getInt("snowboardNr"), rs.getDate("leihstart"), rs.getDate("leihende"),
						rs.getDouble("mietpreis"), rs.getDouble("kaution"), rs.getDouble("nachzahlung"),
						rs.getDouble("gesamtpreis")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return kl;
	}

	public static ArrayList<Ski> getSki(int skiKategorieNr) { // gibt eine ArrayList aller Ski einer bestimmten Kat.Nr
																// zurück
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Ski> sl = new ArrayList<Ski>();

		System.out.println("Query ALLE SKI in Kategorie: " + skiKategorieNr);
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM ski WHERE skiKategorieNr =" + skiKategorieNr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			while (rs.next()) {
				System.out.println("skiNr = " + rs.getInt("skiNr") + " skiKategorieNr = " + rs.getInt("skiKategorieNr")
						+ " skiProduktname = " + rs.getString("skiProduktname"));

				sl.add(new Ski(rs.getInt("skiNr"), rs.getInt("skiKategorieNr"), rs.getString("skiProduktname"),
						rs.getString("skiTyp"), rs.getString("skiBildpfad"), rs.getString("regalNr"),
						rs.getDouble("tagespreis"), rs.getString("farbe")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return sl;
	}

	public static ArrayList<Ski> getSki() { // gibt eine ArrayList aller Ski zurück
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Ski> sl = new ArrayList<Ski>();

		System.out.println("Query ALLE SKI");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM ski  ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("skiNr = " + rs.getInt("skiNr") + " skiKategorieNr = " + rs.getInt("skiKategorieNr")
						+ " skiProduktname = " + rs.getString("skiProduktname"));

				sl.add(new Ski(rs.getInt("skiNr"), rs.getInt("skiKategorieNr"), rs.getString("skiProduktname"),
						rs.getString("skiTyp"), rs.getString("skiBildpfad"), rs.getString("regalNr"),
						rs.getDouble("tagespreis"), rs.getString("farbe")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return sl;
	}

	public static ArrayList<SkiFX> getSkiFX() throws SQLException { // Testklasse für denn ListChangeListener
																	// in MitarbeiterGUI
		ArrayList<SkiFX> array2 = new ArrayList<SkiFX>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(connString);
			System.out.println("Connection established");
			stmt = conn.createStatement();

			String s = "SELECT* from ski";

			rs = stmt.executeQuery(s);
			while (rs.next()) {

				array2.add(new SkiFX(rs.getInt("skiNr"), rs.getInt("skiKategorieNr"), rs.getString("skiProduktname"),
						rs.getString("skiTyp"), rs.getString("skiBildpfad"), rs.getString("regalNr"),
						rs.getDouble("tagespreis"), rs.getString("farbe")));
			}

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
			}

		}

		return array2;

	}

	public static int getSki(String skiProduktname) { // gibt eine skinr über den Produktnamen zurück - UNNÖTIG? s.u.

		Connection conn = null;
		ResultSet rs = null;
		int s = 0;

		System.out.println("Query SKI mit Namen: " + skiProduktname);
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM ski WHERE skiProduktname =" + "'" + skiProduktname + "'"); // Phrase
																												// weil
																												// 2
																												// wörter?
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("skiNr = " + rs.getInt("skiNr") + " skiKategorieNr = " + rs.getInt("skiKategorieNr")
						+ " skiProduktname = " + rs.getString("skiProduktname"));

				s = rs.getInt("skiNr");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return s;
	}

	public static Ski getNewSki(String skiProduktname) { // gibt ein Skiobjekt über den Produktnamen zurück

		Connection conn = null;
		ResultSet rs = null;
		Ski sk = new Ski();
		System.out.println("Query SKI mit Namen: " + skiProduktname);

		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM ski WHERE skiProduktname =" + "'" + skiProduktname + "'"); // Phrase
																												// weil
																												// 2
																												// wörter
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("skiNr = " + rs.getInt("skiNr") + " skiKategorieNr = " + rs.getInt("skiKategorieNr")
						+ " skiProduktname = " + rs.getString("skiProduktname"));

				sk.setTagespreis(rs.getDouble("tagespreis"));
				sk.setSkiNr(rs.getInt("skiNr"));
				// ff!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}
		}
		return sk;
	}

	public static Ski getNewSki(int skiNr) { // gibt ein Skiobjekt über die SkiNr zurück

		Connection conn = null;
		ResultSet rs = null;
		Ski sk = new Ski();
		System.out.println("Query SKI mit Nr: " + skiNr);

		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM ski WHERE skiNr =" + skiNr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("skiNr = " + rs.getInt("skiNr") + " skiKategorieNr = " + rs.getInt("skiKategorieNr")
						+ " skiProduktname = " + rs.getString("skiProduktname"));

				sk.setTagespreis(rs.getDouble("tagespreis"));
				sk.setSkiNr(rs.getInt("skiNr"));
				sk.setRegalNr(rs.getString("regalNr"));
				// ff!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}
		}
		return sk;
	}
	
	public static Snowboard getNewSnowboard(int snowboardNr) { // gibt ein Snowboardobjekt über die SbNr zurück

		Connection conn = null;
		ResultSet rs = null;
		Snowboard sb = new Snowboard();
		System.out.println("Query Snowboard mit Nr: " + snowboardNr);

		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM snowboard WHERE snowboardNr =" + snowboardNr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("snowboardNr = " + rs.getInt("snowboardNr") + " snowboardKategorieNr = " + rs.getInt("snowboardKategorieNr")
						+ " snowboardProduktname = " + rs.getString("snowboardProduktname"));

				sb.setTagespreis(rs.getDouble("tagespreis"));
				sb.setSnowboardNr(rs.getInt("snowboardNr"));
				sb.setRegalNr(rs.getString("regalNr"));
				// ff!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}
		}
		return sb;
	}

	public static ArrayList<Snowboard> getSnowboard(int snowboardKategorieNr) { // gibt eine ArrayList aller Snowboards
																				// einer bestimmten Kat.Nr zurück
		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Snowboard> sl = new ArrayList<Snowboard>();

		System.out.println("Query ALLE Snowboards in Kategorie: " + snowboardKategorieNr);
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM snowboard WHERE snowboardKategorieNr =" + snowboardKategorieNr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("snowboardNr = " + rs.getInt("snowboardNr") + " snowboardKategorieNr = "
						+ rs.getInt("snowboardKategorieNr") + " snowboardProduktname = "
						+ rs.getString("snowboardProduktname"));

				sl.add(new Snowboard(rs.getInt("snowboardNr"), rs.getInt("snowboardKategorieNr"),
						rs.getString("snowboardProduktname"), rs.getString("snowboardTyp"),
						rs.getString("snowboardBildpfad"), rs.getString("regalNr"), rs.getDouble("tagespreis"),
						rs.getString("farbe"), rs.getBoolean("beinstellung"), rs.getBoolean("bindungstyp")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return sl;
	}

	public static ArrayList<Snowboard> getSnowboard() { // gibt eine ArrayList aller Snowboards zurück

		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Snowboard> sl = new ArrayList<Snowboard>();

		System.out.println("Query ALLE Snowboards");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM snowboard  ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("snowboardNr = " + rs.getInt("snowboardNr") + " snowboardKategorieNr = "
						+ rs.getInt("snowboardKategorieNr") + " snowboardProduktname = "
						+ rs.getString("snowboardProduktname"));

				sl.add(new Snowboard(rs.getInt("snowboardNr"), rs.getInt("snowboardKategorieNr"),
						rs.getString("snowboardProduktname"), rs.getString("snowboardTyp"),
						rs.getString("snowboardBildpfad"), rs.getString("regalNr"), rs.getDouble("tagespreis"),
						rs.getString("farbe"), rs.getBoolean("beinstellung"), rs.getBoolean("bindungstyp")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return sl;
	}

	public static Snowboard getNewSnowboard(String snowboardProduktname) { // gibt ein Snowboardobjekt über den
																			// Produktnamen zurück

		Connection conn = null;
		ResultSet rs = null;
		Snowboard sb = new Snowboard();
		System.out.println("Query SNOWBOARD mit Namen: " + snowboardProduktname);

		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT * FROM snowboard WHERE snowboardProduktname =" + "'" + snowboardProduktname + "'"); // Phrase
			// weil
			// 2
			// wörter
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("snowboardNr = " + rs.getInt("snowboardNr") + " snowboardKategorieNr = "
						+ rs.getInt("snowboardKategorieNr") + " snowboardProduktname = "
						+ rs.getString("snowboardProduktname"));

				sb.setTagespreis(rs.getDouble("tagespreis"));
				sb.setSnowboardNr(rs.getInt("snowboardNr"));
				// ff!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}
		}

		return sb;
	}

	public static Boolean postSki(Ski sk) { // Speichert einen neuen Ski in der Datenbank ab
		System.out.println("neuen Ski anlegen");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(
					"INSERT INTO ski(skiKategorieNr, skiProduktname, skiTyp, skiBildpfad, regalNr, tagespreis, farbe) "
							+ "VALUES(?,?,?,?,?,?,?) ");
			pstmt.setInt(1, sk.getSkiKategorieNr());
			pstmt.setString(2, sk.getSkiProduktname());
			pstmt.setString(3, sk.getSkiTyp());
			pstmt.setString(4, sk.getSkiBildpfad());
			pstmt.setString(5, sk.getRegalNr());
			pstmt.setDouble(6, sk.getTagespreis());
			pstmt.setString(7, sk.getFarbe());
			pstmt.executeUpdate();

			String autowert = "SELECT IDENTITY_VAL_LOCAL() FROM ski";
			ResultSet rs = stmt.executeQuery(autowert);
			rs.next();
			int skiNr = rs.getInt("1");
			sk.setSkiNr(skiNr);
			System.out.println("Neuer Ski angelegt mit der SkiNr: " + skiNr);
			rs = null;
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}

	}

	public static Boolean postSnowboard(Snowboard sb) { // Speichert ein neues Snowboard in der Datenbank ab
		System.out.println("neues Snowboard anlegen");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			pstmt = conn
					.prepareStatement("INSERT INTO snowboard(snowboardKategorieNr, snowboardProduktname, snowboardTyp, "
							+ "snowboardBildpfad, regalNr, tagespreis, farbe) " + "VALUES(?,?,?,?,?,?,?) ");
			pstmt.setInt(1, sb.getSnowboardKategorieNr());
			pstmt.setString(2, sb.getSnowboardProduktname());
			pstmt.setString(3, sb.getSnowboardTyp());
			pstmt.setString(4, sb.getSnowboardBildpfad());
			pstmt.setString(5, sb.getRegalNr());
			pstmt.setDouble(6, sb.getTagespreis());
			pstmt.setString(7, sb.getFarbe());
			pstmt.executeUpdate();

			String autowert = "SELECT IDENTITY_VAL_LOCAL() FROM snowboard";
			ResultSet rs = stmt.executeQuery(autowert);
			rs.next();
			int snowboardNr = rs.getInt("1");
			sb.setSnowboardNr(snowboardNr);
			System.out.println("Neues Snowboard angelegt mit der SnowboardNr: " + snowboardNr);
			rs = null;
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}

	}

	public static void deleteSki(int skiNr) { // löscht einen Ski aus der Datenbank
		System.out.println("Ski löschen");
		try {
			conn = DriverManager.getConnection(connString);
			pstmt = conn.prepareStatement("DELETE FROM ski WHERE skiNr = " + skiNr);
			pstmt.executeUpdate();
			System.out.println("Ski mit SkiNr: " + skiNr + " gelöscht");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}
		}
	}

	public static void deleteSnowboard(int snowboardNr) { // löscht ein Snowboard aus der Datenbank
		System.out.println("Snowboard löschen");
		try {
			conn = DriverManager.getConnection(connString);
			pstmt = conn.prepareStatement("DELETE FROM snowboard WHERE snowboardNr = " + snowboardNr);
			pstmt.executeUpdate();
			System.out.println("Snowboard mit SnowboardNr: " + snowboardNr + " gelöscht");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}

	}

	public static void updateAusleihe(int abholNr, double nachzahlung) { // aktualisiert eine Ausleihe mit neuem Wert
																			// der Nachzahlung bei verspäteter Rückgabe

		System.out.println("Ausleihe ändern");

		try {
			conn = DriverManager.getConnection(connString);
			pstmt = conn.prepareStatement(
					"UPDATE ausleihen SET nachzahlung = " + nachzahlung + "WHERE abholNr = " + abholNr);
			pstmt.executeUpdate();
			System.out.println("Ausleihe mit AbholNr: " + abholNr + " aktualisiert");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}

	}

	public static void updateAusleiheKaution(int abholNr, double kaution) { // aktualisiert eine Ausleihe mit neuem Wert für Kaution
		// der Nachzahlung bei verspäteter Rückgabe

		System.out.println("Ausleihe ändern");

		try {
			conn = DriverManager.getConnection(connString);
			pstmt = conn.prepareStatement(
					"UPDATE ausleihen SET kaution = " + kaution + "WHERE abholNr = " + abholNr);
			pstmt.executeUpdate();
			System.out.println("Kaution in der Ausleihe mit AbholNr: " + abholNr + " aktualisiert");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}

	}

	public static Boolean postKreditkarte(Kreditkarte kk) { // legt für einen Kunden eine neue Kreditkarte an

		System.out.println("neue Kreditkarte anlegen");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(
					"INSERT INTO kreditkarten(kreditkartenNr, kundenNr, kreditkartenname, inhabername, "
							+ "kreditkartenpruefzahl, kreditkartengueltigkeit) VALUES(?,?,?,?,?,?) ");
			pstmt.setString(1, kk.getKreditkartenNr());
			pstmt.setInt(2, kk.getKundenNr());
			pstmt.setString(3, kk.getKreditkartenName());
			pstmt.setString(4, kk.getInhaberName());
			pstmt.setInt(5, kk.getPruefzahl());
			pstmt.setString(6, kk.getGueltigkeit());
			pstmt.executeUpdate();
			System.out.println("Kreditkarte angelegt");
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}

	}

	public static ArrayList<Kreditkarte> getKreditkarten() { // holt sich alle Kreditkarten aus der Datenbanl

		Connection conn = null;
		ResultSet rs = null;
		ArrayList<Kreditkarte> kkl = new ArrayList<Kreditkarte>();

		System.out.println("Query ALLE Kreditkarten");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kreditkarten  ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		try {
			while (rs.next()) {
				System.out.println("kreditkartenNr = " + rs.getString("kreditkartenNr") + " kundenNr = "
						+ rs.getInt("kundenNr") + " kreditkartenname = " + rs.getString("kreditkartenname")
						+ " inhabername = " + rs.getString("inhabername") + " kreditkartenpruefzahl = "
						+ rs.getInt("kreditkartenpruefzahl") + " kreditkartengueltigkeit = "
						+ rs.getString("kreditkartengueltigkeit"));

				kkl.add(new Kreditkarte(rs.getString("kreditkartenNr"), rs.getInt("kundenNr"),
						rs.getString("kreditkartenname"), rs.getString("inhabername"),
						rs.getInt("kreditkartenpruefzahl"), rs.getString("kreditkartengueltigkeit")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return kkl;

	}

	public static Kreditkarte getKreditkarte(int kundenNr) { // holt sich Kreditkarteninformationen über die
																// Kundennummer

		Kreditkarte kk = new Kreditkarte();
		Connection conn = null;
		ResultSet rs = null;
		System.out.println("Query Kreditkarte über Kundennummer");
		try {
			conn = DriverManager.getConnection(connString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM kreditkarten WHERE kundenNr =" + kundenNr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				System.out.println("kreditkartenNr = " + rs.getString("kreditkartenNr") + " kundenNr = "
						+ rs.getInt("kundenNr") + " kreditkartenname = " + rs.getString("kreditkartenname")
						+ " inhabername = " + rs.getString("inhabername") + " kreditkartenpruefzahl = "
						+ rs.getInt("kreditkartenpruefzahl") + " kreditkartengueltigkeit = "
						+ rs.getString("kreditkartengueltigkeit"));

				// KUNDEN OBJ ANLEGEN
				kk.setKreditkartenNr(rs.getString("kreditkartenNr"));
				kk.setKundenNr(rs.getInt("kundenNr"));
				kk.setKreditkartenName(rs.getString("kreditkartenname"));
				kk.setInhaberName(rs.getString("inhabername"));
				kk.setPruefzahl(rs.getInt("kreditkartenpruefzahl"));
				kk.setGueltigkeit(rs.getString("kreditkartengueltigkeit"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				stmt = null;
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();

			}

		}
		return kk;
	}

}
