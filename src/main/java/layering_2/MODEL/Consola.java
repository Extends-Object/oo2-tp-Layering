package layering_2.MODEL;

import java.util.List;

public class Consola {

    private Formateador<Empleado> formateador;

    public Consola(Formateador<Empleado> formateador) {
        this.formateador = formateador;
    }

    public void imprimir(List<Empleado> listaEmpleados){
        for(Empleado empleado : listaEmpleados){
            System.out.println(this.formateador.formatear(empleado));
        }
    }

    public String generarStringLista(List<Empleado> listaEmpleados){
        StringBuffer st = new StringBuffer();
        for(Empleado empleado : listaEmpleados){
            st.append(this.formateador.formatear(empleado)).append(System.lineSeparator());
        }
        return st.toString();
    }
}
