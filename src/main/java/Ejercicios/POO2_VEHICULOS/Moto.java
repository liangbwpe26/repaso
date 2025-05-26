package Ejercicios.POO2_VEHICULOS;

public class Moto extends Vehiculo {
    private double aceleracionAdicional;
    private int cilindrada;

    public Moto(String marca, String modelo, double velocidadMaxima, int cilindrada) {
        super(marca, modelo, velocidadMaxima);
        this.aceleracionAdicional = 20;
        this.cilindrada = cilindrada;
    }

    @Override
    public void acelerar(double aceleracion) {
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
