package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    /* Objetos para la conexión de la base de datos */
    private static Connection cn;
    private static String USER = "user=sa;";
    private static String PASSWORD = "password=1234;";
    private static String databaseName = "databaseName=Finance;";
    private static String URL = "jdbc:sqlserver://localhost:1433;" + databaseName + USER + PASSWORD;

    public static Connection conexion() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
