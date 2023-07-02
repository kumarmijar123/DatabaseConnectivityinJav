

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SaveToDatabase {
	Connection con;
   private static final String DB_URL = "jdbc:mysql://localhost/mydatabase";
   private static final String DB_USER = "username";
   private static final String DB_PASSWORD = "password";
   
   


   public static void main(String[] args) {
      try {
         // Connect to the database
         Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         System.out.println("Connected to database");

         // Get input from user
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter first name: ");
         String firstName = scanner.nextLine();
         System.out.print("Enter last name: ");
         String lastName = scanner.nextLine();
         System.out.print("Enter contact number: ");
         String contactNumber = scanner.nextLine();

         // Prepare SQL statement
         String sql = "INSERT INTO people (first_name, last_name, contact_number) VALUES (?, ?, ?)";
         PreparedStatement statement = conn.prepareStatement(sql);
         statement.setString(1, firstName);
         statement.setString(2, lastName);
         statement.setString(3, contactNumber);

         // Execute SQL statement
         int rowsInserted = statement.executeUpdate();
         if (rowsInserted > 0) {
            System.out.println("Data inserted successfully");
         } else {
            System.out.println("Data insertion failed");
         }

         // Close resources
         statement.close();
         conn.close();
         scanner.close();
      } catch (SQLException e) {
         System.out.println("Error: " + e.getMessage());
      }
   }
}

