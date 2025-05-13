package Ejercicios.UD7_Repaso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UD7_EJ3 {
    static Scanner sc = new Scanner(System.in);
    static List<String> lista = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            opcion  = menuHistorial();
            switch (opcion) {
                case 1 -> anadirAccion();
                case 2 -> deshacerAccion();
                case 3 -> mostrarHistorial();
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }

    public static int menuHistorial () {
        System.out.println("--- Menú Historial de Acciones ---");
        System.out.println("1. Añadir acción");
        System.out.println("2. Deshacer última acción");
        System.out.println("3. Mostrar historial");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
        return sc.nextInt();
    }
    public static void anadirAccion () {
        System.out.print("Introduce la acción: ");
        String opcion = sc.nextLine();
        lista.add(opcion);
        System.out.println("Acción añadida.");
    }
    public static void deshacerAccion () {
        System.out.println("Se ha deshecho: " + lista.getLast());
        lista.removeLast();
    }
    public static void mostrarHistorial () {
        System.out.println("Historial: " + lista.toString());
    }
}
