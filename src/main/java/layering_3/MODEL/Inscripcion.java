package layering_3.MODEL;

public class Inscripcion {

    private Participante participante;
    private int idConcurso;

    public Inscripcion(Participante participante, int idConcurso) {
        this.participante = participante;
        this.idConcurso = idConcurso;
    }

    public Participante participante() {
        return participante;
    }

    public int idConcurso() {
        return idConcurso;
    }
}
