package layering_3.MODEL;

import java.time.LocalDate;
import java.util.List;

public interface ConcursoAPI {

    public void registrarConcurso(Concurso concurso);

    public List<Concurso> listaConcursosActivos (LocalDate fechaActual);

}
