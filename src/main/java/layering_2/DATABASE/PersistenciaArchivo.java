package layering_2.DATABASE;

import layering_2.MODEL.Empleado;
import layering_2.MODEL.Formateador;
import layering_2.MODEL.FormateadorEmpleado;
import layering_2.MODEL.PersistenciaAPI;

import java.io.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaArchivo implements PersistenciaAPI {

    private String rutaArchivo;
    private Formateador formateador;


    public PersistenciaArchivo (String rutaArchivo, Formateador formateador) {
        this.rutaArchivo = rutaArchivo;
        this.formateador = formateador;
    }


    @Override
    public void registrarEmpleado(Empleado empleado) {

        File archivo = new File(this.rutaArchivo);
        String empleadoString = this.formateador.formatear(empleado);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(empleadoString);
            salida.close();
            System.out.println("Se actualizó en el archivo correctamente.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error: No se encontró el archivo", e);
        } catch (IOException e) {
            throw new RuntimeException("Error: no se pudo actualizar el archivo", e);
        }
    }

    @Override
    public List<Empleado> listaEmpleados() {
        List<Empleado> listaEmpleados = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;       //lo que va MODEL.a recuperar del archivo

            while ((linea = lector.readLine()) != null) {       //se fija si la linea leida es null
                String[] campos = linea.split(", ");        //reconoce los campos separados por coma

                if (campos.length == 3) {

                    String[] nombreApellido = campos[0].split(" "); //separa apellido y nombre segun space

                    String apellido = nombreApellido[0];
                    String nombre = nombreApellido[1];

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fechaNacimiento = LocalDate.parse(campos[1], formatter);

                    String email = campos[2];

                    Empleado empleado = new Empleado(apellido, nombre, fechaNacimiento, email);
                    listaEmpleados.add(empleado);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo. ", e);
        }
        return listaEmpleados;
    }
}
