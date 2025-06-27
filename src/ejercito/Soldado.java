
package ejercito;


public class Soldado extends UsuarioBasico{

    
    @Override
    public void MostrarDatos(){
        super.MostrarDatos();
    }

    public Soldado(String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart) {
        super(nombre, tipoCuerpo, comp, cuart);
    }

    

   
    
}
