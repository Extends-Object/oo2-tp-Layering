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

        this.persistencia.insertarParticipante(participante);

        /*
        if (nombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe cargar un nombre");
            return;
        }
        if (telefono.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe cargar un telefono");
            return;
        }
        if (!validarTelefono(telefono.getText())) {
            JOptionPane.showMessageDialog(this, "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
            return;
        }
        if (!region.getText().equals("China") && !region.getText().equals("US") && !
                region.getText().equals("Europa")) {
            JOptionPane.showMessageDialog(this, "Region desconocida. Las conocidas son: China, US, Europa");
            return;
        }

        */
    }


}
