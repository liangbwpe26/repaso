package Ejercicios.POO1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CuentaBancaria {
    protected String IBAN = crearIBAN();
    protected Cliente titular;
    protected double saldo;
    protected List<String> movimientos;

    public CuentaBancaria() {
        movimientos = new ArrayList<>();
    }

    public CuentaBancaria(Cliente titular) throws IllegalArgumentException {
        if (titular == null) {
            throw new IllegalArgumentException("Tienes que poner un cliente.");
        }
        this.titular = titular;
        this.saldo = 0;
        this.movimientos = new ArrayList<>();
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public List<String> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<String> movimientos) {
        this.movimientos = movimientos;
    }

    public void setMovimiento(String movimiento) {
        movimientos.add(movimiento);
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresarDinero (double importe) {
        if (importe > 3000) {
            System.out.println("AVISO: Reportar a Hacienda");
        }
        if (importe <= 0) {
            throw new IllegalArgumentException("El importe debe ser mayor que 0.");
        }
        this.saldo += importe;
    }

    public void retiradaDinero (double importe) {
        double saldonuevo = this.saldo - importe;
        if (saldonuevo < -50) {
            throw new IllegalArgumentException("No tiene esa cantidad de dinero disponible.");
        } else {
            this.saldo = saldonuevo;
        }
    }

    public static String crearIBAN() {
        Random rand = new Random();
        String pais = "ES";
        StringBuilder cuenta = new StringBuilder();
        for (int i = 0; i < 22; i++) {
            cuenta.append(rand.nextInt(10));
        }
        return pais + cuenta;
    }
}
