package ejercito;

import java.util.Date;


public abstract class Servicios {
    private Date fecha_realizacion;
    private int codigo_servicio;
    private String nombre;

    public Servicios(Date fecha_realizacion, int codigo_servicio, String nombre) {
        this.fecha_realizacion = fecha_realizacion;
        this.codigo_servicio = codigo_servicio;
        this.nombre = nombre;
    }

    public int getCodigoServicio() {
        return codigo_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaRealizacion() {
        return fecha_realizacion;
    }

    public abstract void ejecutarServicio();
    
    public String mostrarDatos() {
        return "Servicio: " + nombre + " | Código: " + codigo_servicio + " | Fecha: " + fecha_realizacion;
    }
}
