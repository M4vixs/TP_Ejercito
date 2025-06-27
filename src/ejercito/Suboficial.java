
package ejercito;


public class Suboficial extends UsuarioAdmin implements CapacidadServicios{

   

    public Suboficial(Gestion DB, String nombre, Cuerpo tipoCuerpo, Compania com1, Cuartel cuar1) {
        super(DB, nombre, tipoCuerpo, com1, cuar1);
    }

    

    @Override
    public void consultar() {
        //mostrarDatos();
    }

    @Override
    public Servicios AgregarServicios(Servicios s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void MostrarDatos(){
        super.MostrarDatos();
        
    }
    
    
    

  
}
