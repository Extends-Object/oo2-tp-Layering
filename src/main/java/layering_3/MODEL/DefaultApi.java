package layering_3.MODEL;

import layering_3.DATABASE.concurso.ConcursoAPI_BD;
import layering_3.DATABASE.concurso.ConcursoAPI_archivo;
import layering_3.DATABASE.inscriptos.InscriptosAPI_BD;
import layering_3.DATABASE.inscriptos.InscriptosAPI_archivo;
import layering_3.MODEL.dto.ConcursoDTO;
import layering_3.MODEL.formateador.Formateador;
import layering_3.MODEL.formateador.FormateadorConcurso;
import layering_3.MODEL.formateador.FormateadorInscripto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefaultApi implements IApi {

    private ConcursoAPI concursos_archivo;
    private ConcursoAPI concursos_bd;

    private InscriptosAPI inscriptos_archivo;
    private InscriptosAPI inscriptos_bd;

    private Formateador<Concurso> formateadorConcurso = new FormateadorConcurso();
    private Formateador<Inscripcion> formateadorInscripcion = new FormateadorInscripto();


    public DefaultApi(String rutaArchivoConcursos, String rutaArchivoInscriptos) {

        concursos_archivo = new ConcursoAPI_archivo(rutaArchivoConcursos, formateadorConcurso);
        concursos_bd = new ConcursoAPI_BD();

        inscriptos_archivo = new InscriptosAPI_archivo(rutaArchivoInscriptos, formateadorInscripcion);
        inscriptos_bd = new InscriptosAPI_BD();

        cargarDatos();
    }

    private void cargarDatos(){

        Concurso a = new Concurso("Concurso A",                 //en fecha
                LocalDate.of(2025, 6, 10),
                LocalDate.of(2025, 6, 25));

        Concurso b = new Concurso("Concurso B",                 //futuro
                LocalDate.of(2025, 6, 21),
                LocalDate.of(2025, 6, 29));

        Concurso c = new Concurso("Concurso C",                 //vencido
                LocalDate.of(2025, 6, 5),
                LocalDate.of(2025, 6, 10));

        concursos_archivo.registrarConcurso(a);
        concursos_archivo.registrarConcurso(b);
        concursos_archivo.registrarConcurso(c);

        concursos_bd.registrarConcurso(a);
        concursos_bd.registrarConcurso(b);
        concursos_bd.registrarConcurso(c);
    }


    @Override
    public List<ConcursoDTO> todosLosConcursos(LocalDate fechaActual) {

        //List<Concurso> activos = this.concursos_archivo.listaConcursosActivos(fechaActual);
        List<Concurso> activos = this.concursos_bd.listaConcursosActivos(fechaActual);

        List<ConcursoDTO> activosDTO = new ArrayList<>();
        for (Concurso c : activos){
            activosDTO.add(convertir(c));
        }
        return activosDTO;
    }

    @Override
    public void saveInscription(String apellido, String nombre, int dni, String email, String telefono, ConcursoDTO concurso) {

        Participante participante = new Participante(apellido, nombre, telefono, email);
        Inscripcion inscripcion = new Inscripcion(participante, concurso.id());

        this.inscriptos_archivo.registrarInscripto(inscripcion);
        this.inscriptos_bd.registrarInscripto(inscripcion);
    }


    private ConcursoDTO convertir (Concurso c){
        return new ConcursoDTO(c.id(), c.nombre(), c.fechaInicioInscripcion(), c.fechaCierreInscripcion());
    }
}
