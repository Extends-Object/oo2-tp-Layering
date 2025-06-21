package layering_3.DATABASE.concurso;

import layering_3.DATABASE.ConnectionManager;
import layering_3.MODEL.Concurso;
import layering_3.MODEL.ConcursoAPI;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConcursoAPI_BD implements ConcursoAPI {

    @Override
    public void registrarConcurso(Concurso concurso) {

        String sentenciaSQL = "insert into concursos(id, nombre, fecha_inicio_inscripcion, fecha_fin_inscripcion) values(?,?,?,?)";

        try (
                Connection conn = ConnectionManager.getConnection();
                PreparedStatement st = conn.prepareStatement(sentenciaSQL);

        ){

            st.setInt(1, concurso.id());
            st.setString(2, concurso.nombre());
            st.setDate(3, Date.valueOf(concurso.fechaInicioInscripcion()));
            st.setDate(4, Date.valueOf(concurso.fechaCierreInscripcion()));

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al procesar la sentencia.");
            throw new RuntimeException("Error en la conexión: ", e);
        } finally {
            ConnectionManager.disconnect();
        }
    }

    @Override
    public List<Concurso> listaConcursosActivos(LocalDate fechaActual) {
        List<Concurso> activos = new ArrayList<>();

        String query = "SELECT id, nombre, fecha_inicio_inscripcion, fecha_fin_inscripcion FROM concursos";

        try (
                Connection conn = ConnectionManager.getConnection();
                PreparedStatement st = conn.prepareStatement(query);
                ResultSet rs = st.executeQuery();
        ) {
            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                LocalDate fechaInicio = rs.getDate("fecha_inicio_inscripcion").toLocalDate();
                LocalDate fechaFin = rs.getDate("fecha_fin_inscripcion").toLocalDate();


                if (!fechaActual.isBefore(fechaInicio) && !fechaActual.isAfter(fechaFin)) {
                    Concurso concurso = new Concurso();
                    concurso.setIdConcurso(id);
                    concurso.setNombre(nombre);
                    concurso.setFechaInicioInscripcion(fechaInicio);
                    concurso.setFechaCierreInscripcion(fechaFin);
                    activos.add(concurso);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar concursos.");
            throw new RuntimeException("Error al acceder a la base de datos", e);
        } finally {
            ConnectionManager.disconnect();
        }

        return activos;
    }
}
