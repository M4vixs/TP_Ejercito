package ejercito;

import java.util.Scanner;

public class Soldado extends Usuario implements Menu{
    private Scanner scanner;
    private Gestion gestion;

    public Soldado(String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart, Gestion gestion) {
        super(nombre, tipoCuerpo, comp, cuart);
        this.scanner = new Scanner(System.in);
        this.gestion = gestion;
    }
    
    @Override
    public void MostrarDatos(){
        super.MostrarDatos();
    }

    @Override
    public void mostrarMenu() {
        boolean continuar = true;
        
        while (continuar) {
            ConsolaUtil.limpiar();
            System.out.println("\n=== MENÚ SOLDADO ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();

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
