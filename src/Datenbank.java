import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbank {

	public static final String DBlocation = "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Datenbank\\DB1";
	public static final String connString = "jdbc:derby:" + DBlocation + ";create=true";

	public static void createTables() { //Kunde k --> object übergeben hier nötig?

		Connection conn = null;
		Statement stmt = null;
		//PreparedStatement pstmt = null;
		//ResultSet rs = null; 

		try {
			conn = DriverManager.getConnection(connString);
			System.out.println("Connection established");
			stmt = conn.createStatement();
			try {
				stmt.executeUpdate("DROP TABLE kunden");
				stmt.executeUpdate("DROP TABLE kreditkarten");
				//alle weiteren tables...
				System.out.println("Tables dropped");
			} catch (Exception e) {
			}
			
			// TABLE KUNDEN ANLEGEN
			String s1 = "CREATE TABLE kunden (" 
					+ "kundenNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," //automatisch
					+ "kreditkartenNr		VARCHAR(200)," // foreign key aus table kreditkarten
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

			stmt.executeUpdate(s1);
			System.out.println("Table 'kunden' created");
			
			// TABLE KREDITKARTEN ANLEGEN
			String s2 = "CREATE TABLE kreditkarten (" 
					+ "kreditkartenNr       	VARCHAR(200)," 
					+ "kundenNr					integer," // foreign key aus table kreditkarten
					+ "kreditkartenname			VARCHAR(200),"
					+ "inhabername 				VARCHAR(200),"
					+ "kreditkartenpruefzahl   	integer," 
					+ "kreditkartengueltigkeit	VARCHAR(5)," 
					+ "CONSTRAINT kundenNr_fk FOREIGN KEY (kundenNr) REFERENCES kunden(kundenNr),"
					+ "PRIMARY KEY(kreditkartenNr))";

			stmt.executeUpdate(s2);
			System.out.println("Table 'kreditkarten' created");
			
			// FK kreditkartennr in table kunden anlegen (nur im Nachhinein möglich)
			String s3 = "ALTER TABLE kunden ADD CONSTRAINT kreditkartenNr_fk FOREIGN KEY (kreditkartenNr) "
					+ "REFERENCES kreditkarten(kreditkartenNr)";

			stmt.executeUpdate(s3);
			System.out.println("In Table 'kunden' foreign key added");
			
			// TABLE AUSLEIHEN ANLEGEN
			String s4 = "CREATE TABLE ausleihen (" 
					+ "abholNr       		integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," //automatisch
					+ "kundenNr				integer,"
					+ "skiNr				integer,"
					+ "snowboardNr			integer,"
					+ "leihstart			TIMESTAMP," //??
					+ "leihende				TIMESTAMP," //??
					+ "mietpreis			double,"
					+ "kaution 				double,"
					+ "nachzahlung   		double," 
					+ "gesamtpreis			double," 
					//+ "CONSTRAINT kundenNr_fk FOREIGN KEY (kundenNr) REFERENCES kunden(kundenNr),"
					+ "PRIMARY KEY(abholNr))";

			stmt.executeUpdate(s4);
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

}
