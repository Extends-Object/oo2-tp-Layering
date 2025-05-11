package layering_2.MODEL;

import java.util.List;

public interface PersistenciaAPI {

    void registrarEmpleado (Empleado empleado);

    List<Empleado> listaEmpleados ();

}
