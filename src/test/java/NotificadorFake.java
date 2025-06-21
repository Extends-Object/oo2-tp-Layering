import layering_2.MODEL.notificador.Notificador;

import java.util.ArrayList;
import java.util.List;

public class NotificadorFake implements Notificador {
    private final List<String> empleadosNotificados = new ArrayList<>();

    @Override
    public void notificar(String destinatario) {
        this.empleadosNotificados.add(destinatario);
    }

    public boolean seNotifico() {
        System.out.printf("\nCantidad de empleados que cumple años: " + empleadosNotificados.size());
        return !empleadosNotificados.isEmpty();
    }
}
