package Ejercicios.POO2;

public class Administrativo extends Empleado {
    private String valorCategoria;

    public Administrativo(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
        this.valorCategoria = "Administrativo";
    }

    public Administrativo(String nombre, double sueldoBase, Dispositivo dispositivo) {
        super(nombre, sueldoBase, dispositivo);
        this.valorCategoria = "Administrativo";
    }

    @Override
    public double calcularsalario() {
        return super.salarioBase;
    }

    @Override
    public String toString() {
        return super.toString() + " / Categoría: " + valorCategoria;
    }

    public String getValorCategoria() {
        return valorCategoria;
    }

    public void setValorCategoria(String valorCategoria) {
        this.valorCategoria = valorCategoria;
    }
}
