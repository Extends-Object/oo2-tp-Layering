package layering_3.DATABASE;

import layering_3.MODEL.Concurso;
import layering_3.MODEL.Inscripcion;
import layering_3.MODEL.Participante;

import java.util.List;

public interface PersistenciaInscriptosApi {

    public void registrarInscripto (Inscripcion inscripcion);

}
