
package ejercito;

public class UsuarioAdmin extends Usuario{
    private Gestion DB;

    public UsuarioAdmin(Gestion DB, String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart) {
        super(nombre, tipoCuerpo, comp, cuart);
        this.DB = DB;
    }

    
    
    
}
