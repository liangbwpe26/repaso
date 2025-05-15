package Ejercicios.POO2;

public class Programador extends Empleado implements TrabajadorRemoto {
    private double bono;
    private estadoVPN estadoDelVPN;
    private String valorCategoria;

    public Programador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
        this.salarioBase = sueldoBase;
        this.bono = 10;
        this.valorCategoria = "Programador";
    }

    public Programador(String nombre, double sueldoBase, Dispositivo dispositivo) {
        super(nombre, sueldoBase, dispositivo);
        this.salarioBase = sueldoBase;
        this.bono = 10;
        this.valorCategoria = "Programador";
    }

    @Override
    public double calcularsalario() {
        return super.salarioBase = (super.salarioBase * bono / 100) + super.salarioBase;
    }

    @Override
    public String toString() {
        return super.toString() + " / Categoría: " + valorCategoria;
    }

    @Override
    public void conectarVPN() {
        this.estadoDelVPN = estadoVPN.conectado;
    }

    @Override
    public void desconectarVPN() {
        this.estadoDelVPN = estadoVPN.desconectado;
    }

    @Override
    public estadoVPN estadoConexionVPN() {
        return this.estadoDelVPN;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public estadoVPN getEstadoDelVPN() {
        return estadoDelVPN;
    }

    public void setEstadoDelVPN(estadoVPN estadoDelVPN) {
        this.estadoDelVPN = estadoDelVPN;
    }

    public String getValorCategoria() {
        return valorCategoria;
    }

    public void setValorCategoria(String valorCategoria) {
        this.valorCategoria = valorCategoria;
    }
}
