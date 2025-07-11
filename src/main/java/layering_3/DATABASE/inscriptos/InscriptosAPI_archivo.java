package layering_3.DATABASE.inscriptos;

import layering_3.MODEL.Inscripcion;
import layering_3.MODEL.InscriptosAPI;
import layering_3.MODEL.formateador.Formateador;

import java.io.*;

public class InscriptosAPI_archivo implements InscriptosAPI {

    private String rutaArchivo;
    private Formateador formateador;


    public InscriptosAPI_archivo(String rutaArchivo, Formateador formateador) {
        this.rutaArchivo = rutaArchivo;
        this.formateador = formateador;
    }


    @Override
    public void registrarInscripto(Inscripcion inscripcion) {
        File archivo = new File(this.rutaArchivo);
        String inscriptoString = this.formateador.formatear(inscripcion);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(inscriptoString);
            salida.close();
            System.out.println("Se actualizó en el archivo correctamente.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: No se encontró el archivo", e);
        } catch (IOException e) {
            throw new RuntimeException("Error: no se pudo actualizar el archivo", e);
        }
    }

    /*
    @Override
    public List<Participante> listaInscriptos() {
        List<Participante> listaInscriptos = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;       //lo que va MODEL.a recuperar del archivo

            while ((linea = lector.readLine()) != null) {       //se fija si la linea leida es null
                String[] campos = linea.split(", ");        //reconoce los campos separados por coma

                if (campos.length == 5) {

                    String apellido = campos[0];
                    String nombre = campos[1];
                    String telefono = campos[2];
                    String email = campos[3];
                    int idConcursoInsc = Integer.parseInt(campos[4]);

                    Participante inscripto = new Participante(apellido, nombre, telefono, email, idConcursoInsc);
                    listaInscriptos.add(inscripto);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo. ", e);
        }
        return listaInscriptos;
    }
    */
}
