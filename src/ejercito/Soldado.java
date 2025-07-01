/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

/**
 *
 * @author enzol
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Soldado extends Usuario implements Menu{
    private Scanner scanner;
    private List<Servicios> serviciosAsignados = new ArrayList<>();

    
    
    
    
    public Soldado(Scanner scanner, int codigo, String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart, Gestion DB) {
        super(codigo, nombre, tipoCuerpo, comp, cuart, DB);
        this.scanner = scanner;
    }

    public Soldado(Scanner scanner, int codigo) {
        super(codigo);
        this.scanner = scanner;
    }

    


   
    
    @Override
    public void MostrarDatos(){
        super.MostrarDatos();
    }

    public void asignarServicio(Servicios servicio) {
        serviciosAsignados.add(servicio);
    }

    public void verServiciosAsignados() {
        if (serviciosAsignados.isEmpty()) {
            System.out.println("No tiene servicios asignados.");
        } else {
            System.out.println("Servicios asignados:");
            for (Servicios s : serviciosAsignados) {
                System.out.println(s.mostrarDatos());
            }
        }
    }

    @Override
    public void mostrarMenu() {
        boolean continuar = true;
        
        while (continuar) {
            ConsolaUtil.limpiar();
            System.out.println("\n=== MENÚ SOLDADO ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Ver mis servicios asignados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = this.scanner.nextInt();

            switch(opcion) {
                case 1:
                    ConsolaUtil.limpiar();
                    System.out.println("\n=== MIS DATOS ===");
                    MostrarDatos();
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
                    break;
                case 2:
                    ConsolaUtil.limpiar();
                    verServiciosAsignados();
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
                    break;
                case 3:
                    System.out.println("Sesión cerrada.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    System.out.println("Presione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
            }
        }
    }
}
