package Ejercicios.UD7_Repaso;

import java.util.*;

public class UD7_EJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce las palabras separadas por espacios: ");
        String frase = sc.nextLine();
        String[] palabras = frase.split(" ");
        List<String> lista = new ArrayList<>(Arrays.asList(palabras));

        System.out.print("Introduce la longitud de referencia: ");
        int longitud = sc.nextInt();
        int[] longitudes = contarPorLongitud(lista, longitud);

        System.out.println("Palabras de longitud igual: " + longitudes[0]);
        System.out.println("Palabras de longitud menor: " + longitudes[1]);
        System.out.println("Palabras de longitud mayor: " + longitudes[2]);
    }
    public static int [] contarPorLongitud (List<String> palabras, int longitud) {
        int longitudmenor = 0, longitudigual = 0, longitudmayor = 0;
        int [] lista = new int[3];

        for (String palabra : palabras) {
            if (palabra.length() == longitud) {
                longitudigual++;
            }
            if (palabra.length() > longitud) {
                longitudmayor++;
            }
            if (palabra.length() < longitud) {
                longitudmenor++;
            }
        }
        lista[0] = longitudigual;
        lista[1] = longitudmenor;
        lista[2] = longitudmayor;
        return lista;
    }
}
