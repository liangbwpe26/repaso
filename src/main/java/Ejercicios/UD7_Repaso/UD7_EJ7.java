package Ejercicios.UD7_Repaso;

import java.util.*;

public class UD7_EJ7 {
    public static void main(String[] args) {
                /*"Uvas",15,
                "",-5,
                "Peras",101,
                "Naranjas",-10,
                "Manzanas",50*/
                /*"",15,
                "Plátanos",0,
                "Peras",30,
                "Naranjas",-10,
                "Manzanas",50*/
        Map<String, Integer> mapa = Map.of(
                "Uvas",15,
                "",-5,
                "Peras",101,
                "Naranjas",-10,
                "Manzanas",50
        );

        List<String> errores = validarInventario(mapa);
        if (errores.isEmpty()) {
            System.out.println("El inventario ha sido correctamente validado.");
        } else {
            System.out.println("El inventario contiene los siguientes errores: ");
            for (String error : errores) {
                System.out.println(error);
            }
        }
    }

    public static List<String> validarInventario (Map<String, Integer> mapa) {
        List<String> errores = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            if (entry.getKey().isEmpty()) {
                errores.add("-> Nombre inválido para un producto con cantidad: " + entry.getValue());
            }
            if (entry.getValue() > 100 || entry.getValue() < 0) {
                errores.add("-> Cantidad inválida para el producto: " + "'" + entry.getKey() + "'");
            }
        }
        return errores;
    }
}
