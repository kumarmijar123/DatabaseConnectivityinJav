import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	Connection con;
          public Database() throws ClassNotFoundException, SQLException {
        	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	  String server ="//DESKTOP-Q0CLC7L";
        	  int port = 1433;
        	  String database ="CSITdb";
        	  String connectionStr="jdbc:sqlserver:"+server+":"+port+
        			  ";databaseName="+database+";IntegratedSecurity=true";
        	  
        	  con=DriverManager.getConnection(connectionStr);
        	  System.out.println("Connection obtained");
        	  
        	  
          }
          
          Connection getConnection() {
      		return con;
      	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
              new Database();
	}

}	