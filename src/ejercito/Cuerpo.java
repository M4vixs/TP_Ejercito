
package ejercito;

public class Cuerpo {
    private int codigo_Cuerpo;
    private String denominacion_cuerpo;

    public Cuerpo(String denominacion_cuerpo) {
        this.codigo_Cuerpo++;
        this.denominacion_cuerpo = denominacion_cuerpo;
    }

    public int getCodigo_Cuerpo() {
        return codigo_Cuerpo;
    }

    public String getDenominacion_cuerpo() {
        return denominacion_cuerpo;
    }
    
}
