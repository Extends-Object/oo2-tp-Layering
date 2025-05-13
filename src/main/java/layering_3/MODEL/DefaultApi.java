package layering_3.MODEL;

import layering_3.DATABASE.PersistenciaConcursoApi;
import layering_3.DATABASE.PersistenciaInscriptosApi;

import java.time.LocalDate;
import java.util.List;

public class DefaultApi implements IApi {

    private PersistenciaConcursoApi gestionConcursos;
    private PersistenciaInscriptosApi gestionInscriptos;

    public DefaultApi(PersistenciaConcursoApi gestionConcursos, PersistenciaInscriptosApi gestionInscriptos) {
        this.gestionConcursos = gestionConcursos;
        this.gestionInscriptos = gestionInscriptos;
    }


    @Override
    public List<Concurso> todosLosConcursos(LocalDate fechaActual) {
        return this.gestionConcursos.listaConcursosActivos(fechaActual);
    }

    @Override
    public void saveInscription(String apellido, String nombre, int dni, String email, String telefono, Concurso concurso) {
        Participante participante = new Participante(apellido, nombre, email, telefono);
        Inscripcion inscripcion = new Inscripcion(participante, concurso.getId());
        this.gestionInscriptos.registrarInscripto(inscripcion);
    }


}
