/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

/**
 *
 * @author enzol
 */
public class Oficial extends UsuarioAdmin{

    public Oficial(Gestion DB, String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart) {
        super(DB, nombre, tipoCuerpo, comp, cuart);
    }

    
    @Override
    public void MostrarDatos(){
        super.MostrarDatos();
        
    }

    @Override
    public void consultar() {
        super.consultar(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
   
    
}
