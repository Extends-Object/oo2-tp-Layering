package layering_3.MODEL;

import java.time.LocalDate;
import java.util.List;

public interface IApi {

    public List<Concurso> todosLosConcursos (LocalDate fechaActual);

    public void saveInscription (String apellido, String nombre, int dni, String email, String telefono, Concurso concurso);
}
