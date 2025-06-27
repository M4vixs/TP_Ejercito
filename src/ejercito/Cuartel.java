
package ejercito;

public class Cuartel {
    private int codigo_cuartel;
    private String nombre_cuartel;
    private String ubicacion;

    public Cuartel( String nombre_cuartel, String ubicacion) {
        this.codigo_cuartel++;
        this.nombre_cuartel = nombre_cuartel;
        this.ubicacion = ubicacion;
    }

    public int getCodigo_cuartel() {
        return codigo_cuartel;
    }

    public String getNombre_cuartel() {
        return nombre_cuartel;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
    
    
    
}
