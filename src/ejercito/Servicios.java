
package ejercito;

import java.util.Date;


public abstract class Servicios {
    private Date fecha_realizacion;
    private int codigo_servicio;

    public Servicios(Date fecha_realizacion, int codigo_servicio) {
        this.fecha_realizacion = fecha_realizacion;
        this.codigo_servicio = codigo_servicio;
    }
    
    
}
