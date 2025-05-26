package Ejercicios.POO2_VEHICULOS;

public abstract class Vehiculo implements Comparable {
    protected String marca;
    protected String modelo;
    protected double velocidadActual;
    protected double velocidadMaxima;

    public Vehiculo(String marca, String modelo, double velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = 0;
        this.velocidadMaxima = velocidadMaxima;
    }

    abstract public void acelerar(double aceleracion);

    @Override
    public String toString() {
        return "Vehiculo{" + "marca= " + marca + ", modelo= " + modelo + ", Velocidad Máxima= " + velocidadMaxima + '}';
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
}
