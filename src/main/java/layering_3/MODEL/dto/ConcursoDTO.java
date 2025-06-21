package layering_3.MODEL.dto;

import java.time.LocalDate;

public class ConcursoDTO {

    private int id;
    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaCierreInscripcion;

    public ConcursoDTO(String nombre) {
        this.nombre = nombre;
    }

    public ConcursoDTO(int id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaCierreInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public int id (){ return id; }
}
