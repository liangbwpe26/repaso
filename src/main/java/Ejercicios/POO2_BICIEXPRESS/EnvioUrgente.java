package Ejercicios.POO2_BICIEXPRESS;

import java.time.LocalDate;

public class EnvioUrgente extends Paquete {

    public EnvioUrgente(int idPaquete, double peso) {
        super(idPaquete, peso);
        if (fechaEstimada.isAfter(LocalDate.now().plusDays(2))) {
            System.out.println("La fecha de envío del paquete ha sido cambiado a una fecha de envío urgente.");
        }
        fechaEstimada = LocalDate.now().plusDays(2);
    }

    @Override
    public void estaRetrasado() {
        super.estaRetrasado();
    }
}
