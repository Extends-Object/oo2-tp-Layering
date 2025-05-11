package layering_2.MODEL;

import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class NotificadorEmail implements Notificador {

    //Credenciales que me da mailtrap
    final String username = "d84e36c103e3f5";
    final String password = "4cec2de3b26f70";

    //Host address
    String host = "sandbox.smtp.mailtrap.io";

    @Override
    public void notificar(Email email) {

        //Propiedades (vienen configuradas por defecto)
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "false");                // Desactivando startTLS porque no erconoce el certificado del servidor de Mailtrap cuando intenta usar startTLS
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");                              //Cambiando 587 por 25 --> puerto sin TLS

        // create the mail Session object
        Session session = Session.getInstance(props,                    //Instancia de sesion con las propiedades configuradas
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            //Contenedor del mail
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email.emisor()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.destinatario()));
            message.setSubject(email.asunto());
            message.setText(email.cuerpo());

            Transport.send(message);
            System.out.println("El mensaje se envió correctamente");

        } catch (MessagingException e) {
            //Si falla el envio
            throw new RuntimeException(e);
        }
    }
}
