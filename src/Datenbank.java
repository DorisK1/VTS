import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbank {
	
	public static final String DBlocation = "C:\\Users\\Doris\\Documents\\WIFI\\PROJEKT_PRUEFUNG\\Datenbank";
	public static final String connString = "jdbc:derby:" + DBlocation + ";create=true";
	
	public static void createTable() {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(connString);
			System.out.println("Connection established");
			stmt = conn.createStatement();
			try {
				stmt.executeUpdate("DROP TABLE buecherShop");
				System.out.println("Table dropped");
			} catch (Exception e) {
			}
			String s1 = "CREATE TABLE buecherShop (" 
					+ "isbn       VARCHAR(20) NOT NULL," 
					+ "titel  	VARCHAR(20),"
					+ "thema      VARCHAR(20)," 
					+ "autor      VARCHAR(20)," 
					+ "erschJahr  integer,"
					+ "preis		integer," 
					+ "PRIMARY KEY(isbn))";

			stmt.executeUpdate(s1);
			System.out.println("Table created");
			String s2 = "INSERT INTO buecherShop VALUES (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(s2);

			pstmt.setString(1, "ISBN1");
			pstmt.setString(2, "Titel1");
			pstmt.setString(3, "Thema1");
			pstmt.setString(4, "A1");
			pstmt.setInt(5, 1990);
			pstmt.setInt(6, 25);
			pstmt.executeUpdate();
			
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
