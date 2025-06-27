
package ejercito;

import javax.swing.JOptionPane;


public class Usuario  {
    private int codigo;
    private String nombre;
    private Cuerpo tipoCuerpo;
    private Compania comp;
    private Cuartel cuart;

    public Usuario( String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipoCuerpo = tipoCuerpo;
        this.comp = comp;
        this.cuart = cuart;
    }

    public void MostrarDatos(){
        System.out.println("Codigo Usuario: " + this.codigo);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Cuerpo: " + this.tipoCuerpo.getDenominacion_cuerpo()); // Suponiendo que Cuerpo tiene getNombre()
        System.out.println("Compania: " + this.comp.getDenominacion_compania()); // Suponiendo que Compania tiene getDenominacion()
        System.out.println("Cuartel: " + this.cuart.getNombre_cuartel()); 
    }
   public void consultar() {
          
    }
    
  
}
