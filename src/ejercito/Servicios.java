package ejercito;

import java.util.Date;

public abstract class Servicios extends Identificable{
    private Date fecha_realizacion;
    private String nombre;

    public Servicios(int codigo) {
        super(codigo);
    }

    public Servicios(Date fecha_realizacion, String nombre, int codigo) {
        super(codigo);
        this.fecha_realizacion = fecha_realizacion;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Date getFechaRealizacion() {
        return fecha_realizacion;
    }
    
    public abstract void ejecutarServicio();

    public String mostrarDatos() {
        return "Servicio: " + nombre + " | Código: " + this.codigo + " | Fecha: " + fecha_realizacion;
    }
}
