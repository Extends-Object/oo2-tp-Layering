package layering_3.DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    //private static String DRIVER = "com.mysql.jdbc.Driver";				//SIEMPRE ES EL MISMO
    private static String URL_DB = "jdbc:mysql://localhost:3306/";		//SIEMPRE EL MISMO
    protected static String DB = "concursos_inscriptos";
    protected static String user = "root";
    protected static String pass = "root";
    protected static Connection conn = null;

    public static void connect() {
        try {
            conn = DriverManager.getConnection(URL_DB + DB, user, pass);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException sqlEx) {
            System.out.println("No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage());
        }
    }

    public static void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                System.out.println("Conexión cerrada exitosamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        } else {
            System.out.println("No existe conexión activa para cerrar.");
        }
    }

    public static void reconnect() {
        disconnect();
        connect();
    }

    public static Connection getConnection() {
        if (conn == null) {
            connect();
        }
        return conn;
    }
}