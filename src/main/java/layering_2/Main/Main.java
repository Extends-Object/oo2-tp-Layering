package layering_2.Main;

import layering_2.MODEL.PersistenciaAPI;
import layering_2.DATABASE.PersistenciaArchivo;
import layering_2.MODEL.*;
import layering_2.MODEL.formateador.Formateador;
import layering_2.MODEL.formateador.FormateadorEmpleado;
import layering_2.MODEL.notificador.Notificador;
import layering_2.MODEL.notificador.NotificadorEmail;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {

        String rutaArchivo = "src/main/java/ArchivoEmpleados";
        Formateador<Empleado> formateador = new FormateadorEmpleado();
        PersistenciaAPI registroEmpleados = new PersistenciaArchivo(rutaArchivo, formateador);

        Notificador notificador = new NotificadorEmail();

        IApi api = new DefaultAPI(registroEmpleados, notificador);

        Empleado empleado1 = new Empleado("Young", "Angus", LocalDate.of(1982,6, 20), "angus@acdc.com");
        Empleado empleado2 = new Empleado("Johnson", "Brian", LocalDate.of(1975,9, 11), "brian@acdc.com");
        Empleado empleado3 = new Empleado("Perez", "Pepa", LocalDate.of(1990,5, 11), "pepa@acdc.com");

        api.cargarEmpleado(empleado1);
        api.cargarEmpleado(empleado2);
        api.cargarEmpleado(empleado3);

        System.out.printf("\nSaludando por cumpleaños...\n");
        api.saludarPorCumpleaños(LocalDate.now());

    }
}