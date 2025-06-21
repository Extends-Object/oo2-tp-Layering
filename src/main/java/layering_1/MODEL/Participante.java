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

    private void validarCampos(String nombre, String telefono, String region) {
        // Validar nombre
        if (nombre == null || nombre.isBlank()) {
            throw new RuntimeException("Debe cargar un nombre");
        }

        // Validar teléfono
        if (telefono == null || telefono.isBlank()) {
            throw new RuntimeException("Debe cargar un telefono");
        }

        if (!validarTelefono(telefono)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }

        // Validar región
        if (region == null || region.isBlank()) {
            throw new RuntimeException("La region no es valida");
        }

        if (!validarRegion(region)) {
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        }
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    private boolean validarRegion(String region) {
        return region.equals("China") || region.equals("US") || region.equals("Europa");
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
