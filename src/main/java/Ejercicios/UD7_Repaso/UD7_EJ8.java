package Ejercicios.UD7_Repaso;

import java.util.ArrayList;
import java.util.List;

public class UD7_EJ8 {
    public static void main(String[] args) {
        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            lista1.add(i);
        }
        for (int i = 3; i <= 6; i++) {
            lista2.add(i);
        }
        List<Integer> unicosLista1 = buscarUnicos(lista1, lista2);
        System.out.println("Elementos solo en lista 1: " + unicosLista1);
        List<Integer> unicosLista2 = buscarUnicos(lista2, lista1);
        System.out.println("Elementos solo en lista 2: " + unicosLista2);
    }

    public static List<Integer> buscarUnicos (List<Integer> lista1, List<Integer> lista2) {
        List<Integer> unicos1 = new ArrayList<>();
        unicos1.addAll(lista1);
        unicos1.removeAll(lista2);
        return unicos1;
    }
}
