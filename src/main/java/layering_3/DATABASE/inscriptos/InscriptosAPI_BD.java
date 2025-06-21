package layering_3.DATABASE.inscriptos;

import layering_3.DATABASE.ConnectionManager;
import layering_3.MODEL.Inscripcion;
import layering_3.MODEL.InscriptosAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InscriptosAPI_BD implements InscriptosAPI {
    @Override
    public void registrarInscripto(Inscripcion inscripcion) {
        String sentenciaSQL = "insert into inscriptos(apellido, nombre, telefono, email, idConcurso) values(?,?,?,?,?)";

        try (
                Connection conn = ConnectionManager.getConnection();
                PreparedStatement st = conn.prepareStatement(sentenciaSQL);

        ){

            st.setString(1, inscripcion.participante().apellido());
            st.setString(2, inscripcion.participante().nombre());
            st.setString(3, inscripcion.participante().telefono());
            st.setString(4, inscripcion.participante().email());
            st.setInt(5, inscripcion.idConcurso());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al procesar la sentencia.");
            throw new RuntimeException("Error en la conexión: ", e);
        } finally {
            ConnectionManager.disconnect();
        }
    }
}
