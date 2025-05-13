package layering_3.DATABASE;

import layering_3.MODEL.Concurso;
import layering_3.MODEL.Participante;

import java.time.LocalDate;
import java.util.List;

public interface PersistenciaConcursoApi {

    public void registrarConcurso(Concurso concurso);

    public List<Concurso> listaConcursos ();

    public List<Concurso> listaConcursosActivos (LocalDate fechaActual);

}
