package ejercito;

import java.util.Date;

public class Limpiar extends Servicios{

    public Limpiar(int codigo, Date fecha_realizacion, String nombre) {
        super(fecha_realizacion, nombre, codigo);
    }

    @Override
    public void ejecutarServicio() {
        System.out.println("Ejecutando servicio de limpieza.");
    }
}
