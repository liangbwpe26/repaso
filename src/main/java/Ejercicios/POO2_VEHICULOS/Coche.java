package Ejercicios.POO2_VEHICULOS;

public class Coche extends Vehiculo {
    private int numeroPuertas;
    private double aceleracionAdicional;

    public Coche(String marca, String modelo, double velocidadMaxima, int numeroPuertas) {
        super(marca, modelo, velocidadMaxima);
        this.numeroPuertas = numeroPuertas;
        this.aceleracionAdicional = 15;
    }

    @Override
    public void acelerar(double aceleracion) throws IllegalArgumentException {
        if (velocidadActual + aceleracion + aceleracionAdicional > velocidadMaxima) {
            throw new IllegalArgumentException("Estas sobrepasando la velocidad máxima.");
        } else {
            this.velocidadActual += aceleracion;
        }
    }

    @Override
    public int compareTo(Object obj) {
        if (this.velocidadActual < ((Vehiculo) obj).velocidadActual) //this va antes que obj
            return -1; // devolvemos cualquier número negativo
        else if (this.velocidadActual > ((Vehiculo) obj).velocidadActual) // this va después que obj
            return 1; // devolvemos cualquier número positivo
        else // this es igual que obj
            return 0;
    }
}
