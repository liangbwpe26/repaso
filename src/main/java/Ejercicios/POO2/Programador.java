package Ejercicios.POO2;

public class Programador extends Empleado {
    private double bono;

    public Programador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
        this.salarioBase = calcularsalario();
    }

    @Override
    public double calcularsalario() {
        return super.salarioBase = (super.salarioBase * bono / 100) + super.salarioBase;
    }
}
