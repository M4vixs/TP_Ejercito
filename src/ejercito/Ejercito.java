/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercito;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author enzol
 */
public class Ejercito {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        
        ArrayList<Usuario>users=new ArrayList<>();
        ArrayList<Cuartel>cuarteles=new ArrayList<>();
        ArrayList<Cuerpo>cuerpos=new ArrayList<>();
        ArrayList<Compania>companias=new ArrayList<>();
        
        Gestion ges=new Gestion(users,companias,cuarteles,cuerpos);
        
       Compania comp1=new Compania(1,"Easy");
       Compania comp2=new Compania(2,"ArgArmy");
       Compania comp3=new Compania(3,"BolArmy");
       
       ges.agregarCompania(comp1);
       ges.agregarCompania(comp2);
       ges.agregarCompania(comp3);
       
       Cuartel cuar1=new Cuartel(101,"CUARTEL 1","Direccion 1");
       Cuartel cuar2=new Cuartel(102,"CUARTEL 2","Direccion 2");
       Cuartel cuar3=new Cuartel(103,"CUARTEL 3","Direccion 3");
       Cuartel cuar4=new Cuartel(104,"CUARTEL 4","Direccion 5");
       
       ges.agregarCuartel(cuar1);
       ges.agregarCuartel(cuar2);
       ges.agregarCuartel(cuar3);
       ges.agregarCuartel(cuar4);
       
       Cuerpo cuer1=new Cuerpo(101,"Infanteria");
       Cuerpo cuer2=new Cuerpo(102,"Artilleria");
       Cuerpo cuer3=new Cuerpo(103,"Caballeria");
       
       ges.agregarCuerpo(cuer1);
       ges.agregarCuerpo(cuer2);
       ges.agregarCuerpo(cuer3);
       
       Suboficial sub=new Suboficial(scanner,1,"Lautaro Fernandez",cuer1,comp1,cuar1,ges);
       Oficial ofi=new Oficial(scanner,2,"Mauro Rocha",cuer2,comp2,cuar2,ges);
       Soldado sold1=new Soldado(scanner,3,"Matias Fullana",cuer3,comp3,cuar1,ges);
       Soldado sold2=new Soldado(scanner,4,"Juan Perez",cuer3,comp3,cuar3,ges);
       Soldado sold3=new Soldado(scanner,5,"Pedro Gomez",cuer3,comp3,cuar3,ges);
       
       // Agregar usuarios a la gestión (base de datos)
       ges.agregarUsuario(sub);
       ges.agregarUsuario(ofi);
       ges.agregarUsuario(sold1);
       ges.agregarUsuario(sold2);
       ges.agregarUsuario(sold3);
       
       // Menú principal del sistema
       mostrarMenuPrincipal(ges, ofi, sold1, sold2, sold3, sub);
    }
 //PARA ACA  
    private static void mostrarMenuPrincipal(Gestion ges, Oficial ofi, Soldado sold1, Soldado sold2, Soldado sold3, Suboficial sub) {
        Scanner scanner = new Scanner(System.in);
                
        boolean continuar = true;
        
        while (continuar) {
            ConsolaUtil.limpiar();
            System.out.println("\n=== SISTEMA DE GESTIÓN DEL EJÉRCITO ===");
            System.out.println("1. Acceder como Oficial");
            System.out.println("2. Acceder como Suboficial");
            System.out.println("3. Acceder como Soldado 1");
            System.out.println("4. Acceder como Soldado 2");
            System.out.println("5. Acceder como Soldado 3");
            System.out.println("6. Salir del sistema");
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
                    sold1.mostrarMenu();
                    break;
                case 4:
                    sold2.mostrarMenu();
                    break;
                case 5:
                    sold3.mostrarMenu();
                    break;
                case 6:
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
    

