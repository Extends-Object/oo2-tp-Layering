package layering_3.MODEL;

public class Participante {

    private String nombre;
    private String apellido;
    //private String dni;
    private String email;
    private String telefono;

    public Participante() { }

    public Participante(String apellido, String nombre, String telefono, String email) {

        validations(apellido, nombre, telefono, email);

        this.apellido = apellido;
        this.nombre = nombre;
        //this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    private void validations(String apellido, String nombre, String telefono, String email){

        if (apellido.isBlank() || apellido.equals(" ")) {
            throw new RuntimeException("El apellido no puede ser vacio");
        }
        if (nombre.isBlank() || nombre.equals(" ")) {
            throw new RuntimeException("El nombre no puede ser vacio");
        }
//        if (dni.isBlank() || dni.equals(" ")) {
//            throw new RuntimeException("El dni no puede ser vacio");
//        }
        if (!checkEmail(email)) {
            throw new RuntimeException("El email no es valido");
        }
        if (!checkPhone(telefono)) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public String email() {
        return email;
    }

    public String telefono() {
        return telefono;
    }
}
