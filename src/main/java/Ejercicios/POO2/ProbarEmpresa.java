package Ejercicios.POO2;

import java.util.ArrayList;
import java.util.List;

public class ProbarEmpresa {
    public static void main(String[] args) {
        Dispositivo samsung = new Movil("Samsung");
        Dispositivo asus = new Portatil("Asus");
        Dispositivo iPhone = new Movil("iPhone 15");

        Programador empleado1 = new Programador("Liang", 1400, asus);
        JefeEquipo empleado2 = new JefeEquipo("Manel", 3500, asus);
        Administrativo empleado3 = new Administrativo("Alex", 1200, samsung);
        Programador empleado4 = new Programador("Elena", 2600);
        JefeEquipo empleado5 = new JefeEquipo("Luis", 2000);

        empleado1.conectarVPN();
        empleado2.desconectarVPN();
        empleado4.conectarVPN();
        empleado5.desconectarVPN();

        Empresa riotgames = new Empresa("Riot Games");
        riotgames.setEmpleados(new ArrayList<>(List.of(empleado1, empleado2, empleado3, empleado4, empleado5)));

        System.out.println("INFORMACIÓN DE EMPLEADOS:");
        System.out.println("====================================================");
        for (Empleado empleado : riotgames.getEmpleados()) {
            System.out.println(empleado.toString());
            if (empleado instanceof TrabajadorRemoto) {
                System.out.println("Estado VPN: " + ((TrabajadorRemoto) empleado).estadoConexionVPN());
            }
            System.out.println("----------------------------------------------------");
        }

        empleado1.desconectarVPN();
        empleado2.conectarVPN();
        empleado4.desconectarVPN();
        empleado5.conectarVPN();

        System.out.println("INFORMACIÓN DE EMPLEADOS:");
        System.out.println("====================================================");
        for (Empleado empleado : riotgames.getEmpleados()) {
            System.out.println(empleado.toString());
            if (empleado instanceof TrabajadorRemoto) {
                System.out.println("Estado VPN: " + ((TrabajadorRemoto) empleado).estadoConexionVPN());
            }
            System.out.println("----------------------------------------------------");
        }

        System.out.println("\nRANKING POR SALARIO:");
        System.out.println("====================================================");
        List<Empleado> copiadeEmpleados = new ArrayList<>(riotgames.getEmpleados());
        copiadeEmpleados.sort(new ComparaSalario());
        int pos = 1;
        for (Empleado e : copiadeEmpleados) {
            System.out.printf("%d -> Empleado: %s / Salario: %.1f euros%n",
                    pos++, e.getNombre(), e.getSalarioBase());
        }


    }
}
