import java.sql.*;

public class UpdateAndDeleteExample {

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=CSITdb";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            // Update row data using PreparedStatement
            String updateQuery = "UPDATE students SET gpa = ? WHERE id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setDouble(1, 3.5); // set new gpa value
            updateStmt.setInt(2, 1); // set student ID
            int updateCount = updateStmt.executeUpdate();
            System.out.println("Rows updated: " + updateCount);

            // Delete row data using PreparedStatement
            String deleteQuery = "DELETE FROM students WHERE id = ?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, 2); // set student ID to delete
            int deleteCount = deleteStmt.executeUpdate();
            System.out.println("Rows deleted: " + deleteCount);

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
