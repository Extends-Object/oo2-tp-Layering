package layering_3.MODEL;

public class Participante {

    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;


    public Participante(String nombre, String apellido, String dni, String email, String telefono) {

        validations(nombre, apellido, dni, email, telefono);

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    private void validations(String nombre, String apellido, String dni, String email, String telefono){
        if (nombre.isBlank() || nombre.equals(" ")) {
            throw new RuntimeException("El nombre no puede ser vacio");
        }

        if (apellido.isBlank() || apellido.equals(" ")) {
            throw new RuntimeException("El apellido no puede ser vacio");
        }

        if (dni.isBlank() || dni.equals(" ")) {
            throw new RuntimeException("El dni no puede ser vacio");
        }

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


    /*
    private boolean validationss() {
        if ("".equals(txtName.getText())) {
            JOptionPane.showMessageDialog(this.contentPane, "Nombre no puede ser vacio");
            return false;
        }
        if ("".equals(txtLastName.getText())) {
            JOptionPane.showMessageDialog(this.contentPane,
                    "apellido no puede ser vacio");
            return false;
        }
        if ("".equals(txtId.getText())) {
            JOptionPane.showMessageDialog(this.contentPane, "dni no puede ser vacio");
            return false;
        }
        if (!checkEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this.contentPane,
                    "email debe ser válido");
            return false;
        }
        if (!checkPhone(txtPhone.getText())) {
            JOptionPane.showMessageDialog(this.contentPane,
                    "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
            return false;
        }

        return true;
    }
    */

}
