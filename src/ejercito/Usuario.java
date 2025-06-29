package ejercito;

import javax.swing.JOptionPane;


public class Usuario  {
    private static int contadorCodigo = 1; // Contador estático para generar códigos únicos
    private int codigo;
    private String nombre;
    private Cuerpo tipoCuerpo;
    private Compania comp;
    private Cuartel cuart;

    public Usuario( String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart) {
        this.codigo = contadorCodigo++; // Asignar código único y incrementar contador
        this.nombre = nombre;
        this.tipoCuerpo = tipoCuerpo;
        this.comp = comp;
        this.cuart = cuart;
    }

    // Métodos getter para acceder a los atributos privados
    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public Cuerpo getTipoCuerpo() {
        return tipoCuerpo;
    }
    
    public Compania getComp() {
        return comp;
    }
    
    public Cuartel getCuart() {
        return cuart;
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
