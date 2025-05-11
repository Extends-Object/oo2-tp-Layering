import layering_2.MODEL.Email;
import layering_2.MODEL.Notificador;

import java.util.ArrayList;
import java.util.List;

public class NotificadorFake implements Notificador {
    private final List<String> mensajesEnviados = new ArrayList<>();

    @Override
    public void notificar(Email notificacion) {

        this.mensajesEnviados.add("Para: " + notificacion.destinatario() + ", Asunto: " + notificacion.asunto() + ", Mensaje: " + notificacion.cuerpo());

    }

    public List<String> getMensajesEnviados() {
        return mensajesEnviados;
    }

    public boolean seNotifico() {
        return !mensajesEnviados.isEmpty();
    }
}
