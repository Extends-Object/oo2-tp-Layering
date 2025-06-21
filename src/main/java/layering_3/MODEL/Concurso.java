package layering_3.MODEL;

import java.time.LocalDate;

public class Concurso {

    private static int id = 1;
    private int idConcurso;
    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaCierreInscripcion;

    public Concurso() { }

    public Concurso (String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaCierreInscripcion) {
        this.idConcurso = this.id;
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.id++;
    }

    public int id() { return idConcurso;}

    public String nombre(){
        return nombre;
    }

    public LocalDate fechaInicioInscripcion() { return fechaInicioInscripcion; }

    public LocalDate fechaCierreInscripcion() { return fechaCierreInscripcion; }

    public void setIdConcurso(int idConcurso) { this.idConcurso = idConcurso; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) { this.fechaInicioInscripcion = fechaInicioInscripcion; }

    public void setFechaCierreInscripcion(LocalDate fechaCierreInscripcion) { this.fechaCierreInscripcion = fechaCierreInscripcion; }
}
