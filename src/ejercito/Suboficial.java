
package ejercito;

import java.util.Scanner;

public class Suboficial extends Usuario implements Menu,CapacidadServicios{
    private Scanner scanner;
    private Gestion gestion;

    public Suboficial(String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart, Gestion gestion) {
        super(nombre, tipoCuerpo, comp, cuart);
        this.scanner = new Scanner(System.in);
        this.gestion = gestion;
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

    @Override
    public void mostrarMenu() {
        boolean continuar = true;

        while (continuar) {
        ConsolaUtil.limpiar();
        System.out.println("\n=== MENÚ SUBOFICIAL ===");
        System.out.println("1. Ver todos los usuarios");
        System.out.println("2. Buscar usuario por código");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch(opcion) {
            case 1:
                gestion.mostrarTodosLosUsuarios();
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine(); // Esperar Enter
                scanner.nextLine(); // Esperar Enter
                break;
            case 2:
                System.out.print("Ingrese el código del usuario a buscar: ");
                int codigo = scanner.nextInt();
                gestion.buscarYMostrarUsuarioPorCodigo(codigo);
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine(); // Limpiar buffer
                scanner.nextLine(); // Esperar Enter
                break;
            case 3:
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
