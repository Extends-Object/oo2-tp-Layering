package layering_1.MODEL;

import java.sql.SQLException;

public class DefaultApi implements IApi {

    private RegistroParticipante persistencia;

    public DefaultApi(RegistroParticipante persistencia) {
        this.persistencia = persistencia;
    }

    @Override
    public void onBotonCargar(String nombre, String telefono, String region) throws SQLException {
        Participante participante = new Participante(nombre, telefono, region);
        this.persistencia.guardar(participante);
    }
}
