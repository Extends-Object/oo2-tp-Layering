import layering_2.MODEL.Email;
import layering_2.MODEL.Notificador;

import java.util.ArrayList;
import java.util.List;

public class NotificadorFake implements Notificador {
    private final List<String> empleadosNotificados = new ArrayList<>();

    @Override
    public void notificar(String destinatario) {

        this.empleadosNotificados.add(destinatario);
    }

    public List<String> empleadosNotificados() {
        return empleadosNotificados;
    }

    public boolean seNotifico() {
        return !empleadosNotificados.isEmpty();
    }
}
