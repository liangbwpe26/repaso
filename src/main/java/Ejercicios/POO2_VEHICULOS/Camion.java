package Ejercicios.POO2_VEHICULOS;

public class Camion extends Vehiculo {
    private double capacidadMaxima;
    private double capacidadActual;
    private double acelaracionAdicional;

    public Camion(String marca, String modelo, double velocidadMaxima, double capacidadMaxima) {
        super(marca, modelo, velocidadMaxima);
        this.capacidadMaxima = capacidadMaxima;
        if (capacidadActual > (capacidadMaxima / 2)) {
            this.acelaracionAdicional = 0;
        } else {
            this.acelaracionAdicional = 5;
        }
    }


    @Override
    public void acelerar(double aceleracion) {
        if (velocidadActual + aceleracion + acelaracionAdicional > velocidadMaxima) {
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
