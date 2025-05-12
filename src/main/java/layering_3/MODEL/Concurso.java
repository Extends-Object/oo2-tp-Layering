package layering_3.MODEL;

import java.time.LocalDate;

public class Concurso {

    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaCierreInscripcion;


    public Concurso(String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaCierreInscripcion) {
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }

    private void todosLosConcursos() {
        // carga del archivo de texto concursos.txt los concursos
    }
}
