package Ejercicios.UD7;

import java.util.*;

public class EJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<>();
        System.out.print("Ingrese las temperaturas: ");
        for (int i = 0; i <= 5; i++) {
            double temperatura = sc.nextDouble();
            temperaturas.add(temperatura);
        }
        Map<String, List<String>> map = clasificarTemperatura(temperaturas);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static Map<String, List<String>> clasificarTemperatura (List<Double> temperaturas) {
        Map<String, List<String>> clasificacion = new HashMap<>();
        clasificacion.put("Temperaturas Frias", new ArrayList<>());
        clasificacion.put("Temperaturas Calientes", new ArrayList<>());
        clasificacion.put("Temperaturas Templadas", new ArrayList<>());
        for (Double temp : temperaturas) {
            if (temp < 10) {
                clasificacion.get("Temperaturas Frias").add((temp.toString()) + "ºC");
            } else if (temp < 25) {
                clasificacion.get("Temperaturas Templadas").add((temp.toString()) + "ºC");
            } else if (temp > 25) {
                clasificacion.get("Temperaturas Calientes").add((temp.toString()) + "ºC");
            }
        }
        return clasificacion;
    }
}
