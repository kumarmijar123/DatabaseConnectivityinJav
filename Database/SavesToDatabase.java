import java.sql.*;

public class SavesToDatabase {
	

	  
	
    public static void main(String[] args) {
    	
    	
    	String server ="//DESKTOP-Q0CLC7L";
  	  int port = 1433;
  	  String database ="VedasCsit";
  	  String connectionStr="jdbc:sqlserver:"+server+":"+port+
  			  ";databaseName="+database+";IntegratedSecurity=true";
  	  
  	  
  	  System.out.println("Connection obtained");
    	
    	
        String url = "jdbc:mysql://localhost/mydatabase";
        String user = "username";
        String password = "password";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = con.prepareStatement("INSERT INTO ContactInfo (Firstname, Lastname, ContactNumber) VALUES (?, ?, ?)")) {

            stmt.setString(1, "John");
            stmt.setString(2, "Doe");
            stmt.setString(3, "1234567890");

            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
