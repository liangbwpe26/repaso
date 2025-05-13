package Ejercicios.UD7_Repaso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UD7_EJ5 {

    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        palabras.add("auto");
        palabras.add("elefante");
        palabras.add("iglesia");
        palabras.add("oso");
        palabras.add("uva");
        palabras.add("abeja");

        Map<Character, List<String>> palabrasFiltradas = filtrarPorVocal(palabras);

        for (Map.Entry<Character, List<String>> mapa : palabrasFiltradas.entrySet()) {
            System.out.println(mapa.getKey() + ": " + mapa.getValue());
        }
    }

    public static Map<Character, List<String>> filtrarPorVocal (List<String> palabras) {
        Map<Character, List<String>> mapaVocal = new HashMap<>();
        mapaVocal.put('a', new ArrayList<>());
        mapaVocal.put('e', new ArrayList<>());
        mapaVocal.put('i', new ArrayList<>());
        mapaVocal.put('o', new ArrayList<>());
        mapaVocal.put('u', new ArrayList<>());

        for (String palabra : palabras) {
            char letra = palabra.toLowerCase().charAt(0);
            if (mapaVocal.containsKey(letra)) {
                mapaVocal.get(letra).add(palabra);
            }
        }
        return mapaVocal;
    }
}
