package Ejercicios.POO2;

import java.util.Comparator;

public class ComparaSalario implements Comparator<Empleado> {
    @Override
    public int compare(Empleado e1, Empleado e2) {
        return Double.compare(e1.getSalarioBase(), e2.getSalarioBase());
    }
}
