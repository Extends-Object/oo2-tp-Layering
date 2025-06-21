package layering_3.MODEL;

import layering_3.MODEL.dto.ConcursoDTO;

import java.time.LocalDate;
import java.util.List;

public interface IApi {

    public List<ConcursoDTO> todosLosConcursos (LocalDate fechaActual);

    public void saveInscription (String apellido, String nombre, int dni, String email, String telefono, ConcursoDTO concurso);
}
