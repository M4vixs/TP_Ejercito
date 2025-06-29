package ejercito;

import java.util.Scanner;

public class Oficial extends Usuario implements Menu{
    private Scanner scanner;
    private Gestion gestion;

    public Oficial(String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart, Gestion gestion) {
        super(nombre, tipoCuerpo, comp, cuart);
        this.scanner = new Scanner(System.in);
        this.gestion = gestion;
    }

    
    @Override
    public void MostrarDatos(){
        super.MostrarDatos();
        
    }

    @Override
    public void consultar() {
        super.consultar(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public void mostrarMenu() {
        boolean continuar = true;
        
        while (continuar) {
            ConsolaUtil.limpiar();
            System.out.println("\n=== MENÚ OFICIAL ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Ver todos los usuarios");
            System.out.println("3. Buscar usuario por código");
            System.out.println("4. Salir");
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
                    ConsolaUtil.limpiar();
                    gestion.mostrarTodosLosUsuarios();
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
                    break;
                case 3:
                    ConsolaUtil.limpiar();
                    System.out.print("Ingrese el código del usuario a buscar: ");
                    int codigo = scanner.nextInt();
                    gestion.buscarYMostrarUsuarioPorCodigo(codigo);
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
                    break;
                case 4:
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
