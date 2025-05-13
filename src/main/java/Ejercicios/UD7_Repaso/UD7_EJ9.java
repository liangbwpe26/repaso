package Ejercicios.UD7_Repaso;

import java.util.ArrayList;
import java.util.List;

public class UD7_EJ9 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("ana");
        lista.add("oso");
        lista.add("programa");
        lista.add("radar");
        lista.add("java");

        System.out.println("Palabras palíndromas: " + encontrarPalindromas(lista));

    }
    public static List<String> encontrarPalindromas (List<String> palabras) {
        List<String> palindromas = new ArrayList<>();
        for (String palabra : palabras) {
            if (esPalindroma(palabra)) {
                palindromas.add(palabra);
            }
        }
        return palindromas;
    }
    public static boolean esPalindroma (String palabra) {
        char [] palabraArray = palabra.toCharArray();
        StringBuilder palabranueva = new StringBuilder();
        for (int i = palabraArray.length - 1; i >= 0; i--) {
            palabranueva.append(palabraArray[i]);
        }
        return palabranueva.toString().equals(palabra);
    }
}
