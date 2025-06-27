
package ejercito;

import java.util.ArrayList;

public class Gestion {
    private ArrayList<Usuario> users;
    private ArrayList<Compania> companias;
    private ArrayList<Cuartel> cuarteles;
    private ArrayList<Cuerpo> cuerpos;

    public Gestion(ArrayList<Usuario> users, ArrayList<Compania> companias, ArrayList<Cuartel> cuarteles, ArrayList<Cuerpo> cuerpos) {
        this.users = users;
        this.companias = companias;
        this.cuarteles = cuarteles;
        this.cuerpos = cuerpos;
    }
    @Override
    public String toString() {
        return "Gestion{" + "users=" + users + ", companias=" + companias + ", cuarteles=" + cuarteles + '}';
    }
    
   
}
