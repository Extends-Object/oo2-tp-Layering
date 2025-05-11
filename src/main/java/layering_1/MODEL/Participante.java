package layering_1.MODEL;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region) {

         validarCampos(nombre, telefono, region);

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private void validarCampos(String nombre, String telefono, String region){
        if (nombre.isBlank() || nombre.equals(" ")) {
            throw new RuntimeException("El nombre no es valido");
        }

        if (!(telefono.isBlank() || telefono.equals(" ")) && validarTelefono(telefono)) {
            throw new RuntimeException("El telefono no es valido");
        }

        if (region.isBlank() || region.equals(" ")) {
            throw new RuntimeException("La region no es valida");
        }
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRegion() {
        return region;
    }
}
