package Ejercicios.POO2;

abstract class Empleado {
    protected String nombre;
    protected double salarioBase;
    protected Dispositivo dispositivo;

    public Empleado() {
    }

    public Empleado(String nombre, double salarioBase) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío");
        }
        if (salarioBase < 1100) {
            throw new IllegalArgumentException("El sueldo base del empleado no puede ser menor al sueldo mínimo");
        }
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }


    public Empleado(String nombre, double salarioBase, Dispositivo dispositivo) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío");
        }
        if (salarioBase < 1100) {
            throw new IllegalArgumentException("El sueldo base del empleado no puede ser menor al sueldo mínimo (1100)");
        }
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.dispositivo = dispositivo;
    }

    abstract double calcularsalario();

    public String toString() {
        return "Empleado: " + nombre + " / Salario: " + salarioBase + " euros";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
}
