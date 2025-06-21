import layering_2.MODEL.Empleado;
import layering_2.MODEL.PersistenciaAPI;

import java.util.ArrayList;
import java.util.List;

public class PersistenciaFake implements PersistenciaAPI {

    private final List<Empleado> listaEmpleados = new ArrayList<>();

    @Override
    public void registrarEmpleado(Empleado empleado) {
        this.listaEmpleados.add(empleado);
    }

    @Override
    public List<Empleado> listaEmpleados() {
        return this.listaEmpleados;
    }
}
