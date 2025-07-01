package ejercito;

import java.util.ArrayList;

public class Cuerpo extends Identificable{
    private String denominacion_cuerpo;
    private ArrayList<Usuario>usuarioAsignado;

    public Cuerpo(int codigo,String denominacion_cuerpo) {
        super(codigo);
        this.denominacion_cuerpo = denominacion_cuerpo;
        this.usuarioAsignado = new ArrayList();
    }

    public Cuerpo(int codigo) {
        super(codigo);
    }

    public ArrayList<Usuario> getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public String getDenominacion_cuerpo() {
        return denominacion_cuerpo;
    }
}
