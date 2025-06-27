
package ejercito;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ejercito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Usuario>users=new ArrayList<>();
        ArrayList<Cuartel>cuarteles=new ArrayList<>();
        ArrayList<Cuerpo>cuerpos=new ArrayList<>();
        ArrayList<Compania>companias=new ArrayList<>();
        
        Gestion ges=new Gestion(users,companias,cuarteles,cuerpos);
        
       Compania comp1=new Compania("Easy");
       Compania comp2=new Compania("ArgArmy");
       Compania comp3=new Compania("BolArmy");
       
       Cuartel cuar1=new Cuartel("CUARTEL 1","Direccion 1");
       Cuartel cuar2=new Cuartel("CUARTEL 2","Direccion 2");
       Cuartel cuar3=new Cuartel("CUARTEL 3","Direccion 3");
       
       Cuerpo cuer1=new Cuerpo("Infanteria");
       Cuerpo cuer2=new Cuerpo("Artilleria");
       Cuerpo cuer3=new Cuerpo("Caballeria");
       
       Suboficial sub=new Suboficial(ges,"Lautaro Fernandez",cuer1,comp1,cuar1);
       Oficial ofi=new Oficial(ges,"Mauro Rocha",cuer2,comp2,cuar2);
       Soldado sold=new Soldado("Matias Fullana",cuer3,comp3,cuar3);
       
 
       ofi.MostrarDatos();
    }
    
}
