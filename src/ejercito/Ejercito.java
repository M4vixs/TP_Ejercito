package ejercito;

import java.util.ArrayList;
import java.util.Scanner;
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
       
       Suboficial sub=new Suboficial("Lautaro Fernandez",cuer1,comp1,cuar1, ges);
       Oficial ofi=new Oficial("Mauro Rocha",cuer2,comp2,cuar2, ges);
       Soldado sold=new Soldado("Matias Fullana",cuer3,comp3,cuar3, ges);
       
       // Agregar usuarios a la gestión (base de datos)
       ges.agregarUsuario(sub);
       ges.agregarUsuario(ofi);
       ges.agregarUsuario(sold);
       
       // Menú principal del sistema
       mostrarMenuPrincipal(ges, ofi, sold, sub);
    }
    
    private static void mostrarMenuPrincipal(Gestion ges, Oficial ofi, Soldado sold, Suboficial sub) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            ConsolaUtil.limpiar();
            System.out.println("\n=== SISTEMA DE GESTIÓN DEL EJÉRCITO ===");
            System.out.println("1. Acceder como Oficial");
            System.out.println("2. Acceder como Suboficial");
            System.out.println("3. Acceder como Soldado");
            System.out.println("4. Salir del sistema");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1:
                    ofi.mostrarMenu();
                    break;
                case 2:
                    sub.mostrarMenu();
                    break;
                case 3:
                    sold.mostrarMenu();
                    break;
                case 4:
                    System.out.println("Cerrando sistema...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    System.out.println("Presione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
            }
        }
        
        scanner.close();
    }
}
