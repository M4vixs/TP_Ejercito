package ejercito;

import java.util.Date;

public class Limpiar extends Servicios {
    public Limpiar(Date fecha_realizacion, int codigo_servicio) {
        super(fecha_realizacion, codigo_servicio, "Limpiar");
    }

    @Override
    public void ejecutarServicio() {
        System.out.println("Ejecutando servicio de limpieza.");
    }
} 