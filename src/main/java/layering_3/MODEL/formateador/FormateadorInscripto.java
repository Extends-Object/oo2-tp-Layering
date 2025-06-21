package layering_3.MODEL.formateador;

import layering_3.MODEL.Inscripcion;

public class FormateadorInscripto implements Formateador<Inscripcion> {

    @Override
    public String formatear(Inscripcion inscripcion) {

        return inscripcion.participante().apellido() + ", " +
                inscripcion.participante().nombre() + ", " +
                inscripcion.participante().telefono() + ", " +
                inscripcion.participante().email() + ", " +
                inscripcion.idConcurso();
    }
}
