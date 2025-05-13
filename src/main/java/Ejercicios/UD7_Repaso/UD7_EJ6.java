package Ejercicios.UD7_Repaso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UD7_EJ6 {
    public static void main(String[] args) {
        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            lista1.add(i);
        }
        for (int i = 3; i <= 6; i++) {
            lista2.add(i);
        }

        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Intersección: " + calcularInterseccion(lista1, lista2));
        System.out.println("Unión: " + calcularUnion(lista1, lista2));
    }

    public static List<Integer> calcularInterseccion (List<Integer> lista1, List<Integer> lista2) {
        List<Integer> interseccion = new ArrayList<>();
        for (int num : lista1) {
            for (int num2 : lista2) {
                if (num == num2) {
                    interseccion.add(num);
                }
            }
        }
        return interseccion;
    }

    public static List<Integer> calcularUnion (List<Integer> lista1, List<Integer> lista2) {
        List<Integer> union = new ArrayList<>();
        union.addAll(lista1);
        for (int num : lista2) {
            if (!union.contains(num)) {
                union.add(num);
            }
        }
        Collections.sort(union);
        return union;
    }
}
