package Ejercicios.POO2;

abstract class Empleado {
    protected String nombre;
    protected double salarioBase;
    protected Dispositivo dispositivo;

    public Empleado(String nombre, double sueldoBase) {
    }

    abstract double calcularsalario();

    @Override
    public String toString() {
        return "Empleado: " + nombre + "/ Salario: " + salarioBase + " euros";
    }
}
