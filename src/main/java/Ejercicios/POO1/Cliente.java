package Ejercicios.POO1;

public class Cliente {
    protected String dni;
    protected String nombre;
    protected String apellido;
    protected String correo;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellido, String correo) throws IllegalArgumentException {
        if (dni == null || nombre == null || apellido == null || correo == null) {
            throw new IllegalArgumentException("Ningún dato puede estar vacío");
        }
        if (!validarDNI(dni)) {
            throw new IllegalArgumentException("DNI no válido");
        }
        if (!validarCorreo(correo)) {
            throw new IllegalArgumentException("Correo no válido");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String mostrarCliente() {
        return nombre + " " + apellido + ", DNI: " + dni + ", CORREO: " + correo;
    }

    public boolean validarDNI (String dni) {
        return dni.matches("^\\d{8}[A-Z]$");
    }
    public boolean validarCorreo (String correo) {
        return correo.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }
}
