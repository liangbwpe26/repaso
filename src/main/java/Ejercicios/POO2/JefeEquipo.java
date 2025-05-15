package Ejercicios.POO2;

public class JefeEquipo extends Empleado implements TrabajadorRemoto {
    private String valorCategoria;
    private estadoVPN estadoDelVPN;
    private double bono;

    public JefeEquipo(String nombre, double sueldoBase, Dispositivo dispositivo) throws IllegalArgumentException {
        super(nombre, sueldoBase, dispositivo);
        this.valorCategoria = "Jefe de Equipo";
        this.bono = 25;
        this.salarioBase = calcularsalario();
    }

    public JefeEquipo(String nombre, double sueldoBase) throws IllegalArgumentException {
        super(nombre, sueldoBase);
        this.valorCategoria = "Jefe de Equipo";
        this.bono = 25;
        this.salarioBase = calcularsalario();
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


    public String getValorCategoria() {
        return valorCategoria;
    }

    public void setValorCategoria(String valorCategoria) {
        this.valorCategoria = valorCategoria;
    }

    public estadoVPN getEstadoDelVPN() {
        return estadoDelVPN;
    }

    public void setEstadoDelVPN(estadoVPN estadoDelVPN) {
        this.estadoDelVPN = estadoDelVPN;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }
}
