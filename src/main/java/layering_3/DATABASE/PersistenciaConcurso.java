package layering_3.DATABASE;

import layering_2.MODEL.formateador.Formateador;
import layering_3.MODEL.Concurso;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaConcurso implements PersistenciaConcursoApi{

    private String rutaArchivo;
    private Formateador formateador;


    public PersistenciaConcurso (String rutaArchivo, Formateador formateador) {
        this.rutaArchivo = rutaArchivo;
        this.formateador = formateador;
    }

    @Override
    public void registrarConcurso(Concurso concurso) {

        File archivo = new File(this.rutaArchivo);
        String concursoString = this.formateador.formatear(concurso);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(concursoString);
            salida.close();
            System.out.println("Se actualizó en el archivo correctamente.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: No se encontró el archivo", e);
        } catch (IOException e) {
            throw new RuntimeException("Error: no se pudo actualizar el archivo", e);
        }
    }

    @Override
    public List<Concurso> listaConcursos() {
        List<Concurso> listaConcursos = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;       //lo que va MODEL.a recuperar del archivo

            while ((linea = lector.readLine()) != null) {       //se fija si la linea leida es null
                String[] campos = linea.split(", ");        //reconoce los campos separados por coma

                if (campos.length == 4) {

                    int id = Integer.parseInt(campos[0]);
                    String nombre = campos[1];

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fechaInicioInscripcion = LocalDate.parse(campos[2], formatter);
                    LocalDate fechaCierreInscripcion = LocalDate.parse(campos[3], formatter);

                    Concurso concurso = new Concurso(id, nombre, fechaInicioInscripcion, fechaCierreInscripcion);
                    listaConcursos.add(concurso);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo. ", e);
        }
        return listaConcursos;
    }

    @Override
    public List<Concurso> listaConcursosActivos(LocalDate fechaActual) {
        return List.of();
    }

}
