package Ejercicios.POO2_VEHICULOS;

public class Barco extends Vehiculo {
    private double metrosEslora;

    public Barco(String marca, String modelo, double velocidadMaxima, double metrosEslora) {
        super(marca, modelo, velocidadMaxima);
        this.metrosEslora = metrosEslora;
    }

    public boolean necesitaPermiso() {
        return metrosEslora > 30;
    }

    @Override
    public void acelerar(double aceleracion) {
        if (velocidadActual + aceleracion > velocidadMaxima) {
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
