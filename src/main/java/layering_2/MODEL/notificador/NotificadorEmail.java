package layering_2.MODEL.notificador;

import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class NotificadorEmail implements Notificador {

    private String emisor;
    private String asunto;
    private String cuerpo;

    final String username = "d84e36c103e3f5";
    final String password = "4cec2de3b26f70";

    String host = "sandbox.smtp.mailtrap.io";

    public NotificadorEmail() {
        this.emisor = "your.recipient@email.com";
        this.asunto = "Mensaje de felicidades";
        this.cuerpo = "Feliz cumpleaños!!";
    }


    @Override
    public void  notificar(String destinatario) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "false");                // Desactivando startTLS porque no erconoce el certificado del servidor de Mailtrap cuando intenta usar startTLS
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");                              //Cambiando 587 por 25 --> puerto sin TLS

        Session session = Session.getInstance(props,                    //Instancia de sesion con las propiedades configuradas
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(this.emisor));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(this.asunto);
            message.setText(this.cuerpo);

            Transport.send(message);
            System.out.println("El mensaje se envió correctamente");

        } catch (MessagingException e) {
            throw new RuntimeException("Falló el envío.", e);
        }
    }
}
