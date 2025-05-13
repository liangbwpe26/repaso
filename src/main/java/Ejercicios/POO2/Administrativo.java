package Ejercicios.POO2;

public class Administrativo extends Empleado {
    public Administrativo(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    @Override
    public double calcularsalario() {
        return 0;
    }
}
