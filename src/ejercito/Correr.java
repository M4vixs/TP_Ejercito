package ejercito;

import java.util.Date;

public class Correr extends Servicios {
    public Correr(Date fecha_realizacion, int codigo_servicio) {
        super(fecha_realizacion, codigo_servicio, "Correr");
    }

    @Override
    public void ejecutarServicio() {
        System.out.println("Ejecutando servicio de correr.");
    }
} 