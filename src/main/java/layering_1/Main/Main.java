package layering_1.Main;

import layering_1.DATABASE.JdbcClass;
import layering_1.MODEL.DefaultApi;
import layering_1.MODEL.IApi;
import layering_1.MODEL.RegistroParticipante;
import layering_1.UI.AgregarParticipanteVista;

import java.sql.SQLException;

import java.awt.EventQueue;


public class Main {

    public static void main(String[] args) throws SQLException {

        RegistroParticipante registroParticipante = new JdbcClass();
        IApi api = new DefaultApi(registroParticipante);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipanteVista(api);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}