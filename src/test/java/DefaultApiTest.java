import layering_2.DATABASE.PersistenciaArchivo;
import layering_2.MODEL.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefaultApiTest {

    String rutaArchivo;
    Formateador<Empleado> formateador;
    PersistenciaAPI registroEmpleados;
    Notificador notificador;
    Consola consola;
    IApi api;

    Empleado empleado1;
    Empleado empleado2;
    Empleado empleado3;

    @BeforeEach
    public void setUp(){
        rutaArchivo = "src/main/java/ArchivoEmpleados";
        formateador = new FormateadorEmpleado();
        registroEmpleados = new PersistenciaArchivo(rutaArchivo, formateador);

        notificador = new NotificadorFake();
        consola = new Consola(formateador);

        api = new DefaultAPI(registroEmpleados, notificador, consola);

        empleado1 = new Empleado("Young", "Angus", LocalDate.of(1982,10, 8), "angus@acdc.com");
        empleado2 = new Empleado("Johnson", "Brian", LocalDate.of(1975,9, 11), "brian@acdc.com");
        empleado3 = new Empleado("Perez", "Pepa", LocalDate.of(1990,5, 11), "pepa@acdc.com");

    }

    @Test
    public void cargarEmpleadoTest(){

        //Exercise
        api.cargarEmpleado(empleado1);
        api.cargarEmpleado(empleado2);
        api.cargarEmpleado(empleado3);

        //Verify
        assertEquals(3, registroEmpleados.listaEmpleados().size(), "La cantidad de empleados no coincide con la insertada.");

    }

    @Test
    public void listaEmpleadosTest(){

        // Exercise
/*        api.cargarEmpleado(empleado1);
        api.cargarEmpleado(empleado2);
        api.cargarEmpleado(empleado3);*/

        List<Empleado> listaEmpleados = api.listaEmpleados();

        // Verify
        assertEquals(3, listaEmpleados.size(), "La cantidad de empleados no coincide con la insertada.");

        System.out.println(listaEmpleados.get(1));
        System.out.println(listaEmpleados.get(2));
        System.out.println(listaEmpleados.get(0));
        System.out.println(empleado1);


        assertTrue(listaEmpleados.contains(empleado1.email()));
        //assertTrue(listaEmpleados.contains(empleado2));
        //assertTrue(listaEmpleados.contains(empleado3));

    }

    /*
    @Test
    public void mostrarListaTest() {

        //Excercise
        consola.imprimir(registroEmpleados.listaEmpleados());

        //Verify
        assertEquals("Young Angus, 08/10/1982, angus@acdc.com\n" +
                "Johnson Brian, 11/09/1975, brian@acdc.com\n" +
                "Perez Pepa, 11/05/1990, pepa@acdc.com\n", consola.generarStringLista(registroEmpleados.listaEmpleados()));
    }

    */
    /*
    @Test
    public void saludarPorCumpleaños() {

        //Exercise
        // Exercise
        api.cargarEmpleado(empleado1);
        api.cargarEmpleado(empleado2);
        api.cargarEmpleado(empleado3);



    }

     */
}
