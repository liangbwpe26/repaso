package Ejercicios.POO2_BICIEXPRESS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Repartidor {
    private String nombre;
    private String dni;
    private List<Paquete> listaDePaquetes;

    public Repartidor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.listaDePaquetes = new ArrayList<>();
    }

    public void asignarPaquete(Paquete p) throws Exception {
        if (listaDePaquetes.size() == 10) {
            throw new Exception("La lista de paquetes del repartidor esta llena!");
        } else {
            listaDePaquetes.add(p);
            System.out.println("El paquete se ha añadido a la lista de paquetes");
        }
    }

    public void entregarPaquete(int idPaquete) throws NoSuchElementException {
        // listaDePaquetes.removeIf(p -> p.getIdPaquete() == idPaquete); Otra manera de hacerlo
        Iterator<Paquete> it = listaDePaquetes.iterator();
        while (it.hasNext()) {
            Paquete p = it.next();
            if (p.getIdPaquete() == idPaquete) {
                it.remove();
                System.out.println("El paquete ha sido entregado.");
            }
        }
    }

    @Override
    public String toString() {
        return "El repartidor " + nombre + ", con DNI " + dni + ", tiene los siguientes paquetes " + getListaDePaquetes().toString() + ".";
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

    public List<Paquete> getListaDePaquetes() {
        return listaDePaquetes;
    }

    public void setListaDePaquetes(List<Paquete> listaDePaquetes) {
        this.listaDePaquetes = listaDePaquetes;
    }
}
