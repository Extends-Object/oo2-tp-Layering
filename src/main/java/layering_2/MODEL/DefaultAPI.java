package layering_2.MODEL;

import layering_2.MODEL.notificador.Notificador;

import java.time.LocalDate;
import java.util.List;

public class DefaultAPI implements IApi {

    private PersistenciaAPI registroEmpleados;
    private Notificador notificador;

    public DefaultAPI(PersistenciaAPI registroEmpleados, Notificador notificador) {
        this.registroEmpleados = registroEmpleados;
        this.notificador = notificador;
    }

    @Override
    public void cargarEmpleado(Empleado empleado) {
        this.registroEmpleados.registrarEmpleado(empleado);
    }

    @Override
    public List<Empleado> listaEmpleados() {
        return this.registroEmpleados.listaEmpleados();
    }

    @Override
    public void saludarPorCumpleaños(LocalDate fechaActual) {
        List<Empleado> listaEmpleados = this.listaEmpleados();
        for(Empleado empleado : listaEmpleados){
            if (empleado.esSuCumpleaños(fechaActual)){
                this.notificador.notificar(empleado.email());
                System.out.printf("Se ha notificado por su cumpleaños a: " + empleado.nombre() + "\n");
            }
        }
    }
}
