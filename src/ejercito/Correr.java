package ejercito;

import java.util.Date;

public class Correr extends Servicios{

    
    public Correr(int codigo,Date fecha_realizacion, String nombre) {
        super(fecha_realizacion, nombre, codigo);
    }
    

    @Override
    public void ejecutarServicio() {
        System.out.println("Ejecutando servicio de correr.");
    }
}
