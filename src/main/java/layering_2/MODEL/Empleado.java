package layering_2.MODEL;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Objects;

public class Empleado {

    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;

    public Empleado(String apellido, String nombre, LocalDate fechaNacimiento, String email) {

        validarCampos(apellido, nombre, fechaNacimiento, email);

        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    private void validarCampos(String apellido, String nombre, LocalDate fechaNacimiento, String email) {

        if (apellido.isBlank() || apellido.equals(" ")) {
            throw new RuntimeException("El apellido no es valido");
        }

        if (nombre.isBlank() || nombre.equals(" ")) {
            throw new RuntimeException("El nombre no es valido");
        }

        if (fechaNacimiento == null) {              //verificar que no sea una fecha futura
            throw new RuntimeException("La fecha de nacimiento no es valida");
        }

        if (email.isBlank() || email.equals(" ")) {
            throw new RuntimeException("La direccion de email no es valida");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(apellido, empleado.apellido) && Objects.equals(nombre, empleado.nombre) && Objects.equals(fechaNacimiento, empleado.fechaNacimiento) && Objects.equals(email, empleado.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellido, nombre, fechaNacimiento, email);
    }

    public boolean esCumpleaños(LocalDate fechaActual){
        return MonthDay.from(this.fechaNacimiento).equals(MonthDay.from(fechaActual));
    }

    public String apellido() {
        return apellido;
    }

    public String nombre() {
        return nombre;
    }

    public LocalDate fechaNacimiento() {
        return fechaNacimiento;
    }

    public String email() {
        return email;
    }
}
