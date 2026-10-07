import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        String createTableSQL =
                "CREATE TABLE IF NOT EXISTS users (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "email VARCHAR(100))";

        String insertSQL =
                "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";

        try (Connection connection =
                     DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement createStatement =
                     connection.prepareStatement(createTableSQL)) {

            createStatement.executeUpdate();

            try (PreparedStatement insertStatement =
                         connection.prepareStatement(insertSQL)) {

                insertStatement.setInt(1, 1);
                insertStatement.setString(2, "John Doe");
                insertStatement.setString(3, "john@example.com");
                insertStatement.executeUpdate();

                insertStatement.setInt(1, 2);
                insertStatement.setString(2, "Jane Doe");
                insertStatement.setString(3, "jane@example.com");
                insertStatement.executeUpdate();
            }

            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
