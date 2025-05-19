package Ejercicios.POO2_BICIEXPRESS;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Repartidor {
    private String nombre;
    private String dni;
    private static List<Paquete> listaDePaquetes = new ArrayList();

    public Repartidor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarPaquete(Paquete p) throws Exception {
        if (listaDePaquetes.size() == 10) {
            throw new Exception("La lista de paquetes del repartidor esta llena!");
        } else {
            listaDePaquetes.add(p);
        }
    }

    public void entregarPaquete(Paquete p) throws NoSuchElementException {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public static List<Paquete> getListaDePaquetes() {
        return listaDePaquetes;
    }

    public static void setListaDePaquetes(List<Paquete> listaDePaquetes) {
        Repartidor.listaDePaquetes = listaDePaquetes;
    }
}
