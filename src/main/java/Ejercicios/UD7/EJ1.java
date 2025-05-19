package Ejercicios.UD7;

import java.util.*;

public class EJ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> enteros = new ArrayList<>();
        System.out.print("Ingrese un número: ");
        for (int i = 0; i <= 10; i++) {
            int numero = sc.nextInt();
            enteros.add(numero);
        }
        Map<String, ArrayList<Integer>> map = agruparPorParidad(enteros);
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static Map<String, ArrayList<Integer>> agruparPorParidad (List<Integer> enteros) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        map.put("Números pares: ", new ArrayList<>());
        map.put("Números impares", new ArrayList<>());
        for (Integer entero : enteros) {
            if (entero % 2 == 0) {
                map.get("pares").add(entero);
            } else {
                map.get("impares").add(entero);
            }
        }
        return map;
    }
}
