package Ejercicios.POO2;

public class Portatil implements Dispositivo {
    private String modelo;
    private estado estadoDispositivo;

    public Portatil() {
    }

    public Portatil(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void encender() {
        this.estadoDispositivo = estado.encendido;
    }

    @Override
    public void apagar() {
        this.estadoDispositivo = estado.apagado;
    }

    @Override
    public estado estadoDispositivo() {
        return estadoDispositivo;
    }

    @Override
    public boolean equals(Object obj) {
        Portatil portatil = (Portatil) obj;
        return modelo.equals(portatil.getModelo());
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
