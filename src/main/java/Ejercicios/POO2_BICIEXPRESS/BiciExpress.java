package Ejercicios.POO2_BICIEXPRESS;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BiciExpress {
    static Scanner sc = new Scanner(System.in);
    static int idPaquete = 0;
    static List<Paquete> lista_paquetes_no_asignados = new ArrayList<>();
    static List<Repartidor> lista_repartidores = new ArrayList<>();
    static List<Paquete> lista_paquetes_asignados = new ArrayList<>();
    static List<Paquete> lista_paquetes_entregados = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int opcion;

        do {
            opcion = menuBiciExpress();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> crearRepartidor();
                case 2 -> crearPaqueteNormal();
                case 3 -> crearEnvioUrgente();
                case 4 -> mostrarPaquetesNoAsignados();
                case 5 -> asignarPaqueteARepartidor();
                case 6 -> entregarPaqueteACliente();
                case 7 -> mostrarRepartidoresYPaquetesAsignados();
                case 8 -> mostrarPaquetesRetrasados();
                case 9 -> mostrarPaquetesEntregados();
                case 0 -> System.out.println("Saliendo de la mensajería...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    public static int menuBiciExpress() {
        System.out.println("--- MENSAJERÍA BICI-EXPRESS ---");
        System.out.println("1. Crear repartidor");
        System.out.println("2. Crear paquete normal");
        System.out.println("3. Crear envío urgente");
        System.out.println("4. Mostrar paquetes no asignados");
        System.out.println("5. Asignar paquete a repartidor");
        System.out.println("6. Entregar paquete a cliente");
        System.out.println("7. Mostrar repartidores y paquetes asignados");
        System.out.println("8. Mostrar paquetes retrasados");
        System.out.println("9. Mostrar paquetes entregados");
        System.out.println("0. Salir");
        System.out.print("Ingresa la opción: ");
        return sc.nextInt();
    }

    public static void crearRepartidor() {
        System.out.println("--- CREAR REPARTIDOR ---");
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingresa su DNI: ");
        String dni = sc.nextLine();
        Repartidor repartidor = new Repartidor(nombre, dni);
        lista_repartidores.add(repartidor);
    }

    public static void crearPaqueteNormal() {
        try {
            System.out.println("--- CREAR PAQUETE NORMAL ---");
            System.out.print("Ingresa el peso del paquete: ");
            double peso = sc.nextDouble();
            sc.nextLine();
            Paquete nuevoPaquete = new Paquete(idPaquete++, peso);
            lista_paquetes_no_asignados.add(nuevoPaquete);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void crearEnvioUrgente() {
        try {
            System.out.println("--- CREAR ENVÍO URGENTE ---");
            System.out.print("Ingresa el peso del paquete: ");
            double peso = sc.nextDouble();
            sc.nextLine();
            Paquete nuevoPaquete = new EnvioUrgente(idPaquete++, peso);
            lista_paquetes_no_asignados.add(nuevoPaquete);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarPaquetesNoAsignados() {
        System.out.println("--- PAQUETES NO ASIGNADOS ---");
        if (lista_paquetes_no_asignados.isEmpty()) {
            System.out.println("No hay paquetes pendientes.");
        } else {
            for (Paquete paquete : lista_paquetes_no_asignados) {
                System.out.println(paquete.toString());
            }
        }
    }

    public static void asignarPaqueteARepartidor() {
        try {
            System.out.println("--- ASIGNAR PAQUETE A REPARTIDOR ---");
            if (lista_repartidores.isEmpty()) {
                System.out.println("No hay repartidores registrados.");
                return;
            }
            if (lista_paquetes_no_asignados.isEmpty()) {
                System.out.println("No hay paquetes para asignar.");
                return;
            }

            System.out.print("Ingresa el DNI del repartidor: ");
            String dni = sc.nextLine();

            Repartidor repartidor = buscarRepartidorPorDNI(dni);
            if (repartidor == null) {
                System.out.println("El DNI del repartidor no existe.");
                return;
            }

            System.out.print("Ingresa el ID del paquete: ");
            int id = sc.nextInt();
            sc.nextLine();

            Paquete paquete = buscarPaquetePorID(id, lista_paquetes_no_asignados);
            if (paquete == null) {
                System.out.println("ID de paquete no encontrado.");
                return;
            }
            repartidor.asignarPaquete(paquete);
            lista_paquetes_asignados.add(paquete);
            lista_paquetes_no_asignados.remove(paquete);
            System.out.println("Paquete asignado con éxito.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void entregarPaqueteACliente() {
        try {
            System.out.println("--- ENTREGAR PAQUETE AL CLIENTE ---");
            if (lista_paquetes_asignados.isEmpty()) {
                System.out.println("No hay paquetes asignados.");
                return;
            }

            System.out.print("Ingresa el DNI del repartidor: ");
            String dni = sc.nextLine();

            Repartidor repartidor = buscarRepartidorPorDNI(dni);
            if (repartidor == null) {
                System.out.println("Repartidor no encontrado.");
                return;
            }

            System.out.print("Ingresa el ID del paquete: ");
            int id = sc.nextInt();
            sc.nextLine();

            Paquete paquete = buscarPaquetePorID(id, repartidor.getListaDePaquetes());
            if (paquete == null) {
                System.out.println("El paquete no está asignado a este repartidor.");
                return;
            }

            paquete.entregar();
            repartidor.entregarPaquete(id);
            lista_paquetes_entregados.add(paquete);
            lista_paquetes_asignados.remove(paquete);

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarRepartidoresYPaquetesAsignados() {
        System.out.println("--- REPARTIDORES Y PAQUETES ASIGNADOS ---");
        if (lista_repartidores.isEmpty()) {
            System.out.println("No hay repartidores.");
        } else {
            for (Repartidor repartidor : lista_repartidores) {
                System.out.println(repartidor.toString());
            }
        }
    }

    public static void mostrarPaquetesRetrasados() {
        System.out.println("--- PAQUETES RETRASADOS ---");
        boolean hayRetrasados = false;
        for (Paquete paquete : lista_paquetes_asignados) {
            if (paquete.estado == EstadoEnvio.RETRASADO) {
                System.out.println(paquete);
                hayRetrasados = true;
            }
        }
        if (!hayRetrasados) {
            System.out.println("No hay paquetes retrasados.");
        }
    }

    public static void mostrarPaquetesEntregados() {
        System.out.println("--- PAQUETES ENTREGADOS ---");
        if (lista_paquetes_entregados.isEmpty()) {
            System.out.println("No hay paquetes entregados.");
        } else {
           for (Paquete paquete : lista_paquetes_entregados) {
               System.out.println(paquete.toString());
           }
        }
    }

    public static Repartidor buscarRepartidorPorDNI(String dni) {
        for (Repartidor repartidor1 : lista_repartidores) {
            if (repartidor1.getDni().equals(dni)) {
                return repartidor1;
            }
        }
        return null;
    }

    public static Paquete buscarPaquetePorID(int id, List<Paquete> lista) {
        for (Paquete paquete : lista) {
            if (paquete.getIdPaquete() == id) return paquete;
        }
        return null;
    }
}
