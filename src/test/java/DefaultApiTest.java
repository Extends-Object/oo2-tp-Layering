import layering_2.MODEL.*;
import layering_2.MODEL.formateador.Formateador;
import layering_2.MODEL.formateador.FormateadorEmpleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultApiTest {

    PersistenciaFake registroFake;
    NotificadorFake notificadorFake;

    IApi api;

    Empleado empleado1;
    Empleado empleado2;

    @BeforeEach
    public void setUp(){
        registroFake = new PersistenciaFake();

        notificadorFake = new NotificadorFake();

        api = new DefaultAPI(registroFake, notificadorFake);

        empleado1 = new Empleado("Young", "Angus", LocalDate.of(1982,10, 8), "angus@acdc.com");
        empleado2 = new Empleado("Johnson", "Brian", LocalDate.of(1975,9, 11), "brian@acdc.com");
    }

    @Test
    public void saludarPorCumpleaños_SI_CUMPLE() {
        LocalDate fechaFake = LocalDate.of(2025, 10, 8);

        api.cargarEmpleado(empleado1);
        api.cargarEmpleado(empleado2);

        api.saludarPorCumpleaños(fechaFake);

        assertTrue(notificadorFake.seNotifico());
    }

    @Test
    public void saludarPorCumpleaños_NO_CUMPLE(){
        LocalDate fechaFake = LocalDate.of(2025, 6, 20);

        api.cargarEmpleado(empleado1);
        api.cargarEmpleado(empleado2);

        api.saludarPorCumpleaños(fechaFake);

        assertFalse(notificadorFake.seNotifico());
    }

}
