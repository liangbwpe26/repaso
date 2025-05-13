package Ejercicios.POO2;

public class JefeEquipo extends Empleado {
    private String valorCategoria;
    private estadoVPN estado;
    private double bono;

    public JefeEquipo(String nombre, double sueldoBase, Dispositivo lenovo) throws IllegalArgumentException {
        super(nombre, sueldoBase);
        this.valorCategoria = "Jefe de Equipo";
        this.estado = estadoVPN.desconectado;
        this.bono = 25;
        this.salarioBase = calcularsalario();
    }

    @Override
    public double calcularsalario() {
        return super.salarioBase = (super.salarioBase * bono/100) + super.salarioBase;
    }
}
