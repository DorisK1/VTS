import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Datenbank {

	public static final String DBlocation = "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Datenbank\\DB1";
	public static final String connString = "jdbc:derby:" + DBlocation + ";create=true";
	public static Statement stmt = null;
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	Kunde k = new Kunde();
	Ausleihe a = new Ausleihe();
	// ResultSet rs = null;

	public static void createTables() { 

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

				// wird nicht ausgegeben wenn keine tables vorhanden sind. Exception statement
				// ist dann ok.
				// Putting ‘drop table’ in front of it ensure you don't get an error if the
				// table already exist (and get stuck with the old table).

			} catch (Exception e) {
				System.out.println(e);
			}

			// TABLE KUNDEN ANLEGEN
			String s1 = "CREATE TABLE kunden ("
					+ "kundenNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," // automatisch
					+ "anrede	  			integer," + "vorname  			VARCHAR(200),"
					+ "nachname  			VARCHAR(200)," + "telefonNr   			VARCHAR(200),"
					+ "strasse     			VARCHAR(200)," + "hausNr   			VARCHAR(200),"
					+ "wohnort				VARCHAR(200),"	
					+ "plz		   			VARCHAR(200)," + "land		   			VARCHAR(200),"
					+ "kundenalter	  		integer," // alter geht nicht - Achtung: diskrepanz zu kundenklassen
					+ "pistenPraef 			VARCHAR(200)," + "gewicht				integer,"
					+ "schuhgroesse			double," + "technik				integer,"
					+ "beinstellung			BOOLEAN," + "bindungstyp			BOOLEAN," + "PRIMARY KEY(kundenNr))";

			stmt.executeUpdate(s1); // könnte man alle strings zusammenfassen in einem update?
			System.out.println("Table 'kunden' created");

			// TABLE KREDITKARTEN ANLEGEN
			String s2 = "CREATE TABLE kreditkarten (" + "kreditkartenNr       	VARCHAR(200),"
					+ "kundenNr					integer," // FK aus table kunden
					+ "kreditkartenname			VARCHAR(200)," + "inhabername 				VARCHAR(200),"
					+ "kreditkartenpruefzahl   	integer," + "kreditkartengueltigkeit	VARCHAR(5),"
					+ "CONSTRAINT kundenNr_fk FOREIGN KEY (kundenNr) REFERENCES kunden(kundenNr),"
					+ "PRIMARY KEY(kreditkartenNr))";

			stmt.executeUpdate(s2);
			System.out.println("Table 'kreditkarten' created");

			// TABLE SKIKATEGORIE ANLEGEN
			String s4 = "CREATE TABLE skikategorien (" + "skiKategorieNr			integer NOT NULL," // nicht
																										// automatisch
																										// anlegen!
					+ "skiKategorieName			VARCHAR(200)," + "PRIMARY KEY(skiKategorieNr))";

			stmt.executeUpdate(s4);
			System.out.println("Table 'skikategorien' created");

			// TABLE SNOWBOARDKATEGORIE ANLEGEN
			String s5 = "CREATE TABLE snowboardkategorien (" + "snowboardKategorieNr			integer NOT NULL," // nicht
																													// automatisch
																													// anlegen!
					+ "snowboardKategorieName		VARCHAR(200)," + "PRIMARY KEY(snowboardKategorieNr))";

			stmt.executeUpdate(s5);
			System.out.println("Table 'snowboardkategorien' created");

			// TABLE SKI ANLEGEN
			String s6 = "CREATE TABLE ski ("
					+ "skiNr       			integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," // automatisch
					+ "skiKategorieNr		integer," + "skiProduktname		VARCHAR(200),"
					+ "skiTyp		 		VARCHAR(200)," + "regalNr				VARCHAR(200),"
					+ "tagespreis			double," + "farbe				VARCHAR(200),"
					+ "CONSTRAINT skiKategorieNr_fk FOREIGN KEY (skiKategorieNr) REFERENCES skikategorien (skiKategorieNr),"
					+ "PRIMARY KEY(skiNr))";

			stmt.executeUpdate(s6);
			System.out.println("Table 'ski' created");

			// TABLE SNOWBOARD ANLEGEN
			String s7 = "CREATE TABLE snowboard ("
					+ "snowboardNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," // automatisch
					+ "snowboardKategorieNr		integer," + "snowboardProduktname		VARCHAR(200),"
					+ "snowboardTyp		 		VARCHAR(200)," + "regalNr					VARCHAR(200),"
					+ "tagespreis				double," + "farbe					VARCHAR(200),"
					+ "beinstellung				BOOLEAN," // gemeinsames Merkmal mit kunde...?
					+ "bindungstyp				BOOLEAN," // gemeinsames Merkmal mit kunde...?
					+ "CONSTRAINT snowboardKategorieNr_fk FOREIGN KEY (snowboardKategorieNr) REFERENCES snowboardkategorien (snowboardKategorieNr),"
					+ "PRIMARY KEY(snowboardNr))";

			stmt.executeUpdate(s7);
			System.out.println("Table 'snowboard' created");

			// TABLE AUSLEIHEN ANLEGEN
			String s8 = "CREATE TABLE ausleihen ("
					+ "abholNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," // automatisch
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

	public static void insertRows() throws SQLException {

		// SKIKATEGORIEN ANLEGEN
		conn = DriverManager.getConnection(connString);

		// KAT 1
		String s10 = "INSERT INTO skikategorien (skikategorienr, skiKategorieName) VALUES (?,?)";
		pstmt = conn.prepareStatement(s10);
		pstmt.setInt(1, 1); // skikategorienr
		pstmt.setString(2, "Carver"); // skiKategorieName, String

		pstmt.executeUpdate();
		System.out.println("Skikategorie 1 angelegt");

		// KAT 2
		String s11 = "INSERT INTO skikategorien (skikategorienr, skiKategorieName) VALUES (?,?)";
		pstmt = conn.prepareStatement(s11);
		pstmt.setInt(1, 2); // skikategorienr
		pstmt.setString(2, "Alpincarver"); // skiKategorieName, String

		pstmt.executeUpdate();
		System.out.println("Skikategorie 2 angelegt");

		// KAT 3
		String s12 = "INSERT INTO skikategorien (skikategorienr, skiKategorieName) VALUES (?,?)";
		pstmt = conn.prepareStatement(s12);
		pstmt.setInt(1, 3); // skikategorienr
		pstmt.setString(2, "Race Ski"); // skiKategorieName, String

		pstmt.executeUpdate();
		System.out.println("Skikategorie 3 angelegt");

		// SKI ANLEGEN

		// in KAT 1
		String s9 = "INSERT INTO ski (skikategorienr, skiProduktname, skiTyp, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s9);
		// skinr nicht anlegen, da autogenerated
		pstmt.setInt(1, 1); // skikategorienr
		pstmt.setString(2, "Carver A"); // skiProduktname, String
		pstmt.setString(3, "Carver"); // skiTyp, String
		pstmt.setString(4, "R123"); // regalNr, String
		pstmt.setDouble(5, 12.50); // tagesPreis, double
		pstmt.setString(6, "ROT"); // farbe, String

		pstmt.executeUpdate();
		System.out.println("Ski in KAT 1 angelegt");

		// in KAT 2
		String s13 = "INSERT INTO ski (skikategorienr, skiProduktname, skiTyp, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s13);
		pstmt.setInt(1, 2); // skikategorienr
		pstmt.setString(2, "Alpin A"); // skiProduktname, String
		pstmt.setString(3, "Carver"); // skiTyp, String
		pstmt.setString(4, "R129"); // regalNr, String
		pstmt.setDouble(5, 15.50); // tagesPreis, double
		pstmt.setString(6, "BLAU"); // farbe, String

		pstmt.executeUpdate();
		System.out.println("Ski in KAT 2 angelegt");

		// in KAT 3
		String s14 = "INSERT INTO ski (skikategorienr, skiProduktname, skiTyp, regalNr, tagesPreis, farbe) VALUES (?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(s14);
		pstmt.setInt(1, 2); // skikategorienr
		pstmt.setString(2, "Racer A"); // skiProduktname, String
		pstmt.setString(3, "Racer"); // skiTyp, String
		pstmt.setString(4, "R122"); // regalNr, String
		pstmt.setDouble(5, 20.50); // tagesPreis, double
		pstmt.setString(6, "GRAU"); // farbe, String

		pstmt.executeUpdate();
		System.out.println("Ski in KAT 3 angelegt");

	}

	public static Boolean postKunde(Kunde k) { 

		System.out.println("neuen Kunden anlegen");
		try {
			conn = DriverManager.getConnection(connString);
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
			pstmt.setInt(14, k.getTechnik());
			pstmt.setBoolean(15, k.isBeinstellung());
			pstmt.setBoolean(16, k.isBindungstyp());
			
			pstmt.executeUpdate();
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

	public static Kunde getKunde(int kundenNr) {

		Connection conn = null;

		ResultSet rs = null;
		Kunde k = new Kunde();
		System.out.println("Query ALLE KUNDEN");
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
				System.out.println("kundenNr = " + rs.getInt("kundenNr") + "anrede = " + rs.getInt("anrede") + " vorname = " + rs.getString("vorname") + " nachname = "
						+ rs.getString("nachname") + " telefonNr = " + rs.getString("telefonNr") + " strasse = " + rs.getString("strasse")
						+ " hausNr = " + rs.getString("hausNr") + " wohnort = " + rs.getString("wohnort") + " plz = " + rs.getString("plz")
						+ " land = " + rs.getString("land") + " kundenalter = " + rs.getInt("kundenalter"));
				
//				KUNDEN OBJ ANLEGEN
//				k.setId(rs.getInt("ID"));
//				k.setName(rs.getString("NAME"));
//				k.setDesc(rs.getString("DESCR"));
//				k.setPreis(rs.getDouble("PREIS"));
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

	public static ArrayList<Kunde> getKunden() {
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
				System.out.println("kundenNr = " + rs.getInt("kundenNr") + " anrede = " + rs.getInt("anrede") + " vorname = " + rs.getString("vorname") + " nachname = "
						+ rs.getString("nachname") + " telefonNr = " + rs.getString("telefonNr") + " strasse = " + rs.getString("strasse")
						+ " hausNr = " + rs.getString("hausNr") + " wohnort = " + rs.getString("wohnort") + " plz = " + rs.getString("plz")
						+ " land = " + rs.getString("land") + " kundenalter = " + rs.getInt("kundenalter"));

				kl.add(new Kunde(rs.getInt("kundenNr"), rs.getInt("anrede"), rs.getString("vorname"), rs.getString("nachname"),
						rs.getString("telefonNr"), rs.getString("strasse"), rs.getString("hausNr"), rs.getString("wohnort"),
						rs.getString("plz"), rs.getString("land"), rs.getInt("kundenalter"), rs.getString("pistenPraef"), rs.getInt("gewicht"), 
						rs.getDouble("schuhgroesse"), rs.getInt("technik"), 
						rs.getBoolean("beinstellung"), rs.getBoolean("bindungstyp")));
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

	public static Boolean postAusleihe(Kunde k, Ausleihe a) { 

		System.out.println("neue Ausleihe anlegen");
		try {
			conn = DriverManager.getConnection(connString);
			pstmt = conn.prepareStatement("INSERT INTO ausleihen(kundenNr, skiNr, snowboardNr, leihstart, leihende, mietpreis, "
					+ "kaution, nachzahlung, gesamtpreis) VALUES(?,?,?,?,?,?,?,?,?) ");
			
			pstmt.setInt(1, k.getKundenNr());
//			pstmt.setString(2, );
//			pstmt.setString(3, );
			pstmt.setDate(4, a.getLeihStart());
			pstmt.setDate(5, a.getLeihEnde());
			pstmt.setDouble(6, a.getMietpreis());
			pstmt.setDouble(7, a.getKaution());
			pstmt.setDouble(8, a.getNachzahlung());
			pstmt.setDouble(9, a.getGesamtpreis());
			pstmt.executeUpdate();
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

}
