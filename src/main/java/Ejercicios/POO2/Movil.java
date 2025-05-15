package Ejercicios.POO2;

public class Movil implements Dispositivo {
    private String modelo;
    private estado estadoDispositivo;

    public Movil() {
    }

    public Movil(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void encender() {
    }

    @Override
    public void apagar() {
    }

    @Override
    public estado estadoDispositivo() {
        return this.estadoDispositivo;
    }

    @Override
    public boolean equals(Object obj) {
        Movil movil = (Movil) obj;
        return modelo.equals(movil.getModelo());
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public estado getEstadoDispositivo() {
        return estadoDispositivo;
    }

    public void setEstadoDispositivo(estado estadoDispositivo) {
        this.estadoDispositivo = estadoDispositivo;
    }
}
