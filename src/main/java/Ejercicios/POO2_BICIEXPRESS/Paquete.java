package Ejercicios.POO2_BICIEXPRESS;

import java.time.LocalDate;

public class Paquete {
    protected int idPaquete;
    protected double peso;
    protected LocalDate fechaEstimada;
    protected EstadoEnvio estado;

    public Paquete(int idPaquete, double peso) throws IllegalArgumentException {
        if (peso <= 0 || peso > 20) {
            throw new IllegalArgumentException("El peso no puede ser negativo o superar los 20 KG.");
        }
        this.idPaquete = idPaquete;
        this.peso = peso;
        this.estado = EstadoEnvio.PENDIENTE;
        if (peso > 1 && peso < 5) {
            this.fechaEstimada = LocalDate.now().plusDays(1);
        } else if (peso > 5 && peso < 10) {
            this.fechaEstimada = LocalDate.now().plusDays(2);
        } else if (peso > 10 && peso < 15) {
            this.fechaEstimada = LocalDate.now().plusDays(4);
        } else if (peso > 15 && peso < 20) {
            this.fechaEstimada = LocalDate.now().plusDays(5);
        }
    }

    public void estaRetrasado() {
        if (LocalDate.now().isAfter(fechaEstimada) && estado != EstadoEnvio.ENTREGADO) {
            setEstado(EstadoEnvio.RETRASADO);
        }
    }

    public void entregar() throws IllegalArgumentException {
        if (estado == EstadoEnvio.ENTREGADO) {
            throw new IllegalArgumentException("El paquete ya ha sido entregado.");
        }
        setEstado(EstadoEnvio.ENTREGADO);
    }

    @Override
    public String toString() {
        return "Paquete número " + idPaquete + ", con un peso de " + peso
                + "KG, tiene el estado de " + estado.toString();
    }

    public LocalDate getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(LocalDate fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public EstadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
