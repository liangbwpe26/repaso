package Ejercicios.POO2_VEHICULOS;

public class Avion extends Vehiculo {
    private double altitudMaxima;

    public Avion(String marca, String modelo, double velocidadMaxima, double altitudMaxima) {
        super(marca, modelo, velocidadMaxima);
        this.altitudMaxima = altitudMaxima;
    }

    @Override
    public void acelerar(double aceleracion) {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
