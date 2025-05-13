package Ejercicios.POO1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JsonUtil {
    private static final String rutaFicheros = Paths.get("src", "main", "java","Ejercicios","POO1").toString();
    private static final String JSON = "datos_banco.json";

    public static void guardarDatos(List<Cliente> clientes, List<CuentaBancaria> cuentas, List<String> correos) {
        DatosBanco datos = new DatosBanco(clientes, cuentas, correos);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(new File(rutaFicheros,JSON), datos);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public static DatosBanco cargarDatos() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File archivo = new File(rutaFicheros,JSON);
            if (archivo.exists()) {
                return mapper.readValue(archivo, DatosBanco.class);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
        return new DatosBanco();
    }
}
