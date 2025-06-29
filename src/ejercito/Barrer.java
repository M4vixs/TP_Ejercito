package ejercito;

import java.util.Date;

public class Barrer extends Servicios {
    public Barrer(Date fecha_realizacion, int codigo_servicio) {
        super(fecha_realizacion, codigo_servicio, "Barrer");
    }

    @Override
    public void ejecutarServicio() {
        System.out.println("Ejecutando servicio de barrido.");
    }
} 