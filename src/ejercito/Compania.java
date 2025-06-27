
package ejercito;

public class Compania {
    private int contador_compania;
    private String denominacion_compania;

    public Compania(String denominacion_compania) {
        this.contador_compania++;
        this.denominacion_compania = denominacion_compania;
    }

    public int getContador_compania() {
        return contador_compania;
    }

    public String getDenominacion_compania() {
        return denominacion_compania;
    }
    
    
}
