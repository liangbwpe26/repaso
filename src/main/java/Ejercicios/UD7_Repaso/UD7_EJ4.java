package Ejercicios.UD7_Repaso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UD7_EJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Lista 1 (separada por comas): ");
        String listauno = sc.nextLine();
        System.out.print("Lista 2 (separada por comas): ");
        String listados = sc.nextLine();

        String [] lista1 = listauno.split(",");
        String [] lista2 = listados.split(",");

        if (lista1.length != lista2.length) {
            System.out.println("Las listas deben tener el mismo tamaño.");
        } else {
            System.out.printf("Lista combinada: %s%n", combinarListas(lista1, lista2));
        }
    }
    public static List<Integer> combinarListas (String [] lista1, String [] lista2) {
        List<Integer> listaCombinada = new ArrayList<>();
        for (int i = 0; i < lista1.length; i++) {
            listaCombinada.add(Integer.parseInt(lista1[i]));
            listaCombinada.add(Integer.parseInt(lista2[i]));
        }

        return listaCombinada;
    }
}
