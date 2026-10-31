package loginForm;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/myform");
    private static final String USER = System.getenv().getOrDefault("DB_USER", "root");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (PASSWORD == null || PASSWORD.isBlank()) {
                throw new IllegalStateException("Set DB_PASSWORD in the environment.");
            }
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }
    }
}

