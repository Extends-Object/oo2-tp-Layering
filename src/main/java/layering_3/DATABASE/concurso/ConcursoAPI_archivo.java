package layering_3.DATABASE.concurso;

import layering_3.MODEL.Concurso;
import layering_3.MODEL.ConcursoAPI;
import layering_3.MODEL.formateador.Formateador;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConcursoAPI_archivo implements ConcursoAPI {

    private String rutaArchivo;
    private Formateador formateador;


    public ConcursoAPI_archivo(String rutaArchivo, Formateador formateador) {
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
    public List<Concurso> listaConcursosActivos(LocalDate fechaActual) {
        List<Concurso> activos = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(", ");

                if (campos.length == 4) {
                    int id = Integer.parseInt(campos[0]);
                    String nombre = campos[1];

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate fechaInicioInscripcion = LocalDate.parse(campos[2], formatter);
                    LocalDate fechaCierreInscripcion = LocalDate.parse(campos[3], formatter);

                    if (!fechaActual.isBefore(fechaInicioInscripcion) && !fechaActual.isAfter(fechaCierreInscripcion)) {
                        Concurso concurso = new Concurso();
                        concurso.setIdConcurso(id);
                        concurso.setNombre(nombre);
                        concurso.setFechaInicioInscripcion(fechaInicioInscripcion);
                        concurso.setFechaCierreInscripcion(fechaCierreInscripcion);
                        activos.add(concurso);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo.", e);
        }
        return activos;
    }

}
