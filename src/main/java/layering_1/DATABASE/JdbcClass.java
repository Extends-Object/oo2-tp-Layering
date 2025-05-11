package layering_1.DATABASE;


import layering_1.MODEL.Participante;
import layering_1.MODEL.RegistroParticipante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcClass implements RegistroParticipante {

    private String url = "jdbc:derby://localhost:1527/participantes";
    private String user = "app";
    private String password = "app";

    @Override
    public void insertarParticipante (Participante participante) {

        String sentenciaSQL = "insert into participantes(nombre, telefono, region) values(?,?,?)";

        try (              //llama al close automaticamente si algo de lo que esta en el try sale mal
                Connection dbConn = setupBaseDeDatos();
                PreparedStatement st = dbConn.prepareStatement(sentenciaSQL);

                ){

            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());

            st.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Error", e);
        }
    }

    private Connection setupBaseDeDatos() {
        String url = "jdbc:derby://localhost:1527/participantes";
        String user = "app";
        String password = "app";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error en la conexion", e);
        }
    }
}
