package Ejercicios.UD7_Repaso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UD7_EJ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce los números separados por espacios: ");
        String listanumeros = sc.nextLine();
        System.out.print("Introduce el divisor: ");
        int divisor = sc.nextInt();

        List<Integer> listaOrganizada = reorganizarPorMultiplos(listanumeros, divisor);
        System.out.println("Lista reorganizada: " + listaOrganizada);
    }

    public static List<Integer> reorganizarPorMultiplos(String listanumeros, int divisor){
        String [] listnumeros = listanumeros.split(", ");
        int [] numeros = new int[listnumeros.length];
        List<Integer> listaorganizada = new ArrayList<>();
        List<Integer> listanodivisor = new ArrayList<>();
        for (int i = 0; i < listnumeros.length; i++){
            listnumeros[i] = listnumeros[i].trim();
        }

        for (int i = 0; i < listnumeros.length; i++){
            numeros[i] = Integer.parseInt(listnumeros[i]);
        }
        for (int num : numeros){
            if (num % divisor == 0){
                listaorganizada.add(num);
            } else {
                listanodivisor.add(num);
            }
        }
        listaorganizada.addAll(listanodivisor);
        return listaorganizada;
    }
}
