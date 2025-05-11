package layering_2.MODEL;

public class Email {

    private String emisor;
    private String destinatario;
    private String asunto;
    private String cuerpo;


    public Email(String destinatario) {
        this.emisor = "your.recipient@email.com";
        this.destinatario = destinatario;
        this.asunto = "Mensaje de felicidades";
        this.cuerpo = "Feliz cumpleaños!!";
    }

    public String emisor() {
        return emisor;
    }

    public String destinatario() {
        return destinatario;
    }

    public String asunto() {
        return asunto;
    }

    public String cuerpo() {
        return cuerpo;
    }
}
