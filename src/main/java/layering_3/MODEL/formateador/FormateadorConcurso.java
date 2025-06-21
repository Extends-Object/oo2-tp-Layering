package layering_3.MODEL.formateador;

import layering_3.MODEL.Concurso;

import java.time.format.DateTimeFormatter;

public class FormateadorConcurso implements Formateador<Concurso> {

    @Override
    public String formatear(Concurso concurso) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        return concurso.id() + ", " + concurso.nombre() + ", " + concurso.fechaInicioInscripcion().format(formatter) + ", " +
                concurso.fechaCierreInscripcion().format(formatter);
    }
}
