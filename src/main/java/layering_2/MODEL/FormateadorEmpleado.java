package layering_2.MODEL;

import java.time.format.DateTimeFormatter;

public class FormateadorEmpleado implements Formateador<Empleado>{

    public String formatear(Empleado empleado){

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNac = empleado.fechaNacimiento().format(formato);
        return empleado.apellido() + " " + empleado.nombre() + ", " + fechaNac + ", " + empleado.email();
    }
}
