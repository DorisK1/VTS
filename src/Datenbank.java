import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbank {

	public static final String DBlocation = "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Datenbank\\DB1";
	public static final String connString = "jdbc:derby:" + DBlocation + ";create=true";

	public static void createTables() { //Kunde k --> object übergeben nötig?

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
				//alle weiteren tables...?
				System.out.println("Table dropped");
			} catch (Exception e) {
			}
			
			// TABLE KUNDEN
			String s1 = "CREATE TABLE kunden (" 
					+ "kundenNr       		integer NOT NULL," //automatisch??
					+ "kreditkartenNr		VARCHAR(200),"
					+ "anrede	  			integer,"
					+ "vorname  			VARCHAR(200),"
					+ "nachname  			VARCHAR(200),"
					+ "telefonNr   			VARCHAR(200)," 
					+ "strasse     			VARCHAR(200)," 
					+ "hausNr   			VARCHAR(200),"
					+ "plz		   			VARCHAR(200),"
					+ "land		   			VARCHAR(200),"
					+ "kundenalter	  			integer,"
					+ "pistenPraef 			VARCHAR(200),"
					+ "gewicht				integer," 
					+ "schuhgroesse			double,"
					+ "technik				integer,"
					+ "beinstellung			BOOLEAN," 
					+ "bindungstyp			BOOLEAN," 
					//+ CONSTRAINT kreditkarten_kreditkartenNr_ref FOREIGN KEY (kreditkartenNr) REFERENCES kreditkarten(kreditkartenNr)
					+ "PRIMARY KEY(kundenNr))";

			stmt.executeUpdate(s1);
			System.out.println("Table kunden created");
			
			// TABLE KREDITKARTEN
			
			
			
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
