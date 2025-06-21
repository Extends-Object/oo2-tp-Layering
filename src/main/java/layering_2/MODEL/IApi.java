package layering_2.MODEL;

import java.time.LocalDate;
import java.util.List;

public interface IApi {

    void cargarEmpleado(Empleado empleado);

    List<Empleado> listaEmpleados();

    void saludarPorCumpleaños(LocalDate fechaActual);

}
