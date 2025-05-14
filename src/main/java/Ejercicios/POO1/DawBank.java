package Ejercicios.POO1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DawBank {
    static List<Cliente> clientes = new ArrayList<>();
    static List<CuentaBancaria> cuentas = new ArrayList<>();
    static List<String> correos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String admin = "admin";
    static String pass = "123456";

    public static void main(String[] args) {
        DatosBanco datos = JsonUtil.cargarDatos();
        clientes = datos.getClientes() != null ? datos.getClientes() : new ArrayList<>();
        cuentas = datos.getCuentas() != null ? datos.getCuentas() : new ArrayList<>();
        correos = datos.getCorreos() != null ? datos.getCorreos() : new ArrayList<>();
        int intentos = 0;
        String usuario, contrasena;
        boolean ingreso = false;

        while (intentos < 3) {
            System.out.println("--- INGRESO A DAWBANK ---");
            System.out.print("Ingresa el usuario: ");
            usuario = sc.nextLine();
            System.out.print("Ingresa la contraseña: ");
            contrasena = sc.nextLine();
            if (login(usuario, contrasena)) {
                ingreso = true;
                break;
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
                intentos++;
            }
        }
        if (ingreso) {
            int opcion;
            do {
                opcion  = menuBanco();
                sc.nextLine();
                switch (opcion) {
                    case 1 -> {
                        nuevoCliente();
                    }
                    case 2 -> {
                        crearCuenta();
                    }
                    case 3 -> {
                        consultarCliente();
                    }
                    case 4 -> {
                        consultarCuenta();
                    }
                    case 5 -> {
                        consultarMovimientos();
                    }
                    case 6 -> {
                        operaciones();
                    }
                    case 7 -> {
                        JsonUtil.guardarDatos(clientes,cuentas,correos);
                        System.out.println("Gracias por usar nuestro banco ;)");
                    }
                    default -> System.out.println("Opción no válida");
                }
            } while (opcion != 7);
        } else {
            System.out.println("Se acabaron tus intentos.");
        }
    }

    public static boolean login (String usuario, String contrasena) {
        return usuario.equals(admin) && contrasena.equals(pass);
    }

    public static int menuBanco () {
        System.out.println("--- DAWBANK ---");
        System.out.println("1. Nuevo cliente");
        System.out.println("2. Crear cuenta");
        System.out.println("3. Consultar cliente");
        System.out.println("4. Consultar cuenta");
        System.out.println("5. Consutar movimientos");
        System.out.println("6. Operaciones");
        System.out.println("7. Salir");
        System.out.print("Elige una opción: ");
        return sc.nextInt();
    }
    public static void nuevoCliente() {
        try {
            System.out.println("--- Creación de cliente ---");
            System.out.print("Ingresa el DNI del cliente: ");
            String dni = sc.nextLine();
            System.out.print("Ingresa el nombre del cliente: ");
            String nombre = sc.nextLine();
            System.out.print("Ingresa el apellido del cliente: ");
            String apellido = sc.nextLine();
            System.out.print("Ingresa el correo del cliente: ");
            String correo = sc.nextLine();
            boolean clientevalido = true;
            boolean correovalido = true;

            for (Cliente cliente1 : clientes) {
                if (dni.equals(cliente1.getDni())) {
                    clientevalido = false;
                    break;
                }
            }
            for (String correo1 : correos) {
                if (correo.equals(correo1)) {
                    correovalido = false;
                    break;
                }
            }
            if (clientevalido && correovalido) {
                Cliente cliente = new Cliente(dni, nombre, apellido, correo);
                clientes.add(cliente);
                correos.add(correo);
                System.out.println("Cliente creado correctamente.");
            } else {
                System.out.println("El DNI o el correo del cliente ya están en uso.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void crearCuenta() {
        try {
            System.out.println("--- Creación de cuenta ---");
            System.out.print("Ingresa el DNI del cliente: ");
            String dni = sc.nextLine();
            boolean clientevalido = true;
            for (Cliente cliente1 : clientes) {
                clientevalido = dni.equals(cliente1.getDni());
                if (clientevalido) {
                    CuentaBancaria cuenta = new CuentaBancaria(cliente1);
                    cuentas.add(cuenta);
                    System.out.println("Cuenta bancaria creada.");
                }
            }
            if (!clientevalido) {
                System.out.println("El cliente no existe.");
                nuevoCliente();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void consultarCliente() {
        System.out.println("--- Consulta de cliente ---");
        System.out.print("Ingresa el DNI del cliente: ");
        String dni = sc.nextLine();
        boolean encontrado = false;

        for (Cliente cliente1 : clientes) {
            if (cliente1.getDni().equals(dni)) {
                System.out.println(cliente1.mostrarCliente());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El cliente no existe.");
            return;
        }

        for (CuentaBancaria cuenta1 : cuentas) {
            if (cuenta1.getTitular().getDni().equals(dni)) {
                System.out.println("IBAN: " + cuenta1.getIBAN());
            }
        }
    }

    public static void consultarCuenta() {
        System.out.println("--- Consulta de cuenta ---");
        System.out.print("Ingresa el IBAN del cliente: ");
        String iban = sc.nextLine();
        CuentaBancaria cuenta = getCuenta(iban);
        if (cuenta.getIBAN().equals(iban)) {
            System.out.println("Cliente: " + cuenta.getTitular().mostrarCliente());
            System.out.println("Saldo: " + cuenta.getSaldo());
            System.out.println("Fecha de consulta: " + LocalDate.now());
        }
    }

    public static void consultarMovimientos() {
        System.out.println("--- Consulta de movimientos ---");
        System.out.print("Ingresa el IBAN del cliente: ");
        String iban = sc.nextLine();
        boolean clientevalido = false;
        CuentaBancaria cuenta = getCuenta(iban);

        if (cuenta.getIBAN().equals(iban)) {
            clientevalido = true;
            List<String> movimientos = cuenta.getMovimientos();
            Collections.reverse(movimientos);
            if (movimientos.isEmpty()) {
                System.out.println("El cliente no tiene movimientos hechos.");
            } else {
                System.out.println("Movimientos:");
                for (int i = 0, num = movimientos.size(); i < movimientos.size(); i++, num--) {
                    System.out.println("#" + (num) + " " + movimientos.get(i));
                }
            }
        }

        if (!clientevalido) {
            System.out.println("El IBAN no existe.");
        }
    }

    public static void operaciones () {
        int opcion;
        try {
            System.out.println("--- Operaciones ---");
            System.out.print("Ingresa el IBAN del cliente: ");
            String iban = sc.nextLine();
            CuentaBancaria cuentaSeleccionada = getCuenta(iban);

            if (cuentaSeleccionada == null) {
                System.out.println("El IBAN no existe.");
                return;
            }

            do {
                System.out.println("1. Ingreso");
                System.out.println("2. Retirada");
                System.out.println("3. Cancelar operación");
                System.out.print("Ingresa una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Ingresa el concepto: ");
                        String concepto = sc.nextLine();
                        System.out.println("Ingresa el monto: ");
                        double monto = sc.nextDouble();
                        CuentaBancaria cuenta = getCuenta(iban);
                        cuenta.ingresarDinero(monto);
                        cuenta.setMovimiento(concepto + "\t\t\t\t\t\t\t\t| +" + monto + "€" + "      |  Saldo: " + cuenta.getSaldo());
                    }
                    case 2 -> {
                        System.out.print("Ingresa el concepto: ");
                        String concepto = sc.nextLine();
                        System.out.print("Ingresa el monto: ");
                        double monto = sc.nextDouble();
                        CuentaBancaria cuenta = getCuenta(iban);
                        cuenta.retiradaDinero(monto);
                        cuenta.setMovimiento(concepto + "\t\t\t\t\t\t\t\t| -" + monto + "€" + "      |  Saldo: " + cuenta.getSaldo());
                    }
                    case 3 -> {
                    }
                    default -> System.out.println("Opción no valida");
                }
            } while (opcion != 3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static CuentaBancaria getCuenta(String iban) {
        CuentaBancaria cuenta = null;
        for (CuentaBancaria cuenta1 : cuentas) {
            if (cuenta1.getIBAN().equals(iban)) {
                cuenta = cuenta1;
            }
        }
        return cuenta;
    }
}
