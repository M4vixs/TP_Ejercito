
package ejercito;

import java.util.ArrayList;

public class Compania extends Identificable {
    private String denominacion_compania;
    private ArrayList<Usuario>userCompania;

    public Compania(int codigo,String denominacion_compania) {
        super(codigo);
        this.denominacion_compania = denominacion_compania;
        this.userCompania = new ArrayList();
    }

    
    public Compania(int codigo) {
        super(codigo);
    }

    public ArrayList<Usuario> getUserCompania() {
        return userCompania;
    }

    public int getCodigo() {
        return codigo;
    }

    
    public String getDenominacion_compania() {
        return denominacion_compania;
    }
    
    public void MostrarUsuariosAsignados() {
        if (userCompania.isEmpty()) {
            System.out.println("No hay usuarios asignados a esta compañía.");
            return;
        }
        System.out.println("Usuarios asignados a la compañía " + denominacion_compania + ":");
        for (Usuario usuario : userCompania) {
            usuario.MostrarDatos();
            System.out.println("---");
        }
    }
}
