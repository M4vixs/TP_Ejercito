package ejercito;

import java.util.Scanner;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Date;

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
        System.out.println("3. Asignar servicio");
        System.out.println("4. Salir");
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
                ConsolaUtil.limpiar();
                System.out.print("Ingrese el código del soldado: ");
                int codSoldado = scanner.nextInt();
                Usuario usuario = gestion.buscarUsuarioPorCodigo(codSoldado);
                if (usuario != null && usuario instanceof Soldado) {
                    // Descubrir servicios dinámicamente
                    File dir = new File("src/ejercito");
                    File[] files = dir.listFiles((d, name) -> name.endsWith(".java") && !name.equals("Servicios.java"));
                    if (files == null) files = new File[0];
                    Class<?>[] clasesServicios = new Class<?>[files.length];
                    int idx = 0;
                    for (File f : files) {
                        String className = f.getName().replace(".java", "");
                        try {
                            Class<?> clazz = Class.forName("ejercito." + className);
                            if (Servicios.class.isAssignableFrom(clazz) && !clazz.equals(Servicios.class)) {
                                clasesServicios[idx++] = clazz;
                            }
                        } catch (Exception e) { /* ignorar */ }
                    }
                    // Mostrar opciones
                    System.out.println("Seleccione el servicio a asignar:");
                    for (int i = 0; i < idx; i++) {
                        System.out.println((i+1) + ". " + clasesServicios[i].getSimpleName());
                    }
                    int tipoServicio = scanner.nextInt();
                    if (tipoServicio < 1 || tipoServicio > idx) {
                        System.out.println("Tipo de servicio inválido.");
                        break;
                    }
                    Class<?> claseSeleccionada = clasesServicios[tipoServicio-1];
                    System.out.print("Ingrese el código del servicio: ");
                    int codServicio = scanner.nextInt();
                    Date fecha = new Date();
                    try {
                        Constructor<?> cons = claseSeleccionada.getConstructor(Date.class, int.class);
                        Servicios servicio = (Servicios) cons.newInstance(fecha, codServicio);
                        ((Soldado)usuario).asignarServicio(servicio);
                        System.out.println("Servicio asignado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al crear el servicio: " + e.getMessage());
                    }
                } else {
                    System.out.println("No se encontró un soldado con ese código.");
                }
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
