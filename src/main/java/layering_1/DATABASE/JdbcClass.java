package layering_1.DATABASE;


import layering_1.MODEL.Participante;
import layering_1.MODEL.RegistroParticipante;

import java.sql.*;

public class JdbcClass implements RegistroParticipante {

//    private String url = "jdbc:derby://localhost:1527/participantes";
//    private String user = "app";
//    private String password = "app";

    @Override
    public void guardar (Participante participante) {

        String sentenciaSQL = "insert into participantes(nombre, telefono, region) values(?,?,?)";

        try (
                Connection conn = ConnectionManager.getConnection();
                PreparedStatement st = conn.prepareStatement(sentenciaSQL);

        ){

            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al procesar la sentencia.");
            throw new RuntimeException("Error en la conexión: ", e);
        } finally {
            ConnectionManager.disconnect();
        }
    }

//    private Connection setupBaseDeDatos() {
//        String url = "jdbc:derby://localhost:1527/participantes";
//        String user = "app";
//        String password = "app";
//
//        try {
//            return DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error en la conexion", e);
//        }
//    }
}