package layering_3.MODEL;

import java.time.LocalDate;

public class Concurso {

    private static int idConcurso = 1;
    private int id;
    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaCierreInscripcion;


    public Concurso (String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaCierreInscripcion) {
        this.idConcurso++;
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }

    public Concurso (int id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaCierreInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }

    public int getId() {
        return id;
    }

}
