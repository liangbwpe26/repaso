package Ejercicios.POO1;

import java.util.List;

public class DatosBanco {
    private List<Cliente> clientes;
    private List<CuentaBancaria> cuentas;
    private List<String> correos;

    public DatosBanco() {
    }

    public DatosBanco(List<Cliente> clientes, List<CuentaBancaria> cuentas, List<String> correos) {
        this.clientes = clientes;
        this.cuentas = cuentas;
        this.correos = correos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }
    public void setCuentas(List<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    public List<String> getCorreos() {
        return correos;
    }
    public void setCorreos(List<String> correos) {
        this.correos = correos;
    }
}
