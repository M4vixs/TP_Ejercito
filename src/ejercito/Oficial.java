package ejercito;

import ejercito.Servicios;

import java.util.Scanner;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Date;

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
            System.out.println("4. Asignar servicio a soldado");
            System.out.println("5. Salir");
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
                    ConsolaUtil.limpiar();
                    System.out.print("Ingrese el código del soldado: ");
                    int codSoldado = scanner.nextInt();
                    Usuario usuario = gestion.buscarUsuarioPorCodigo(codSoldado);
                    // Verifica que el usuario sea un soldado
                    if (usuario != null && usuario instanceof Soldado) {
                        // 1. Busca todos los archivos .java en el paquete ejercito, excepto Servicios.java
                        File dir = new File("src/ejercito");
                        File[] files = dir.listFiles((d, name) -> name.endsWith(".java") && !name.equals("Servicios.java")); // Busca todos los archivos .java en el paquete ejercito, excepto Servicios.java

                        // 2. Crea un array para guardar las clases de servicios encontradas
                        Class<?>[] clasesServicios = new Class<?>[files.length];
                        // Inicializa el índice
                        int idx = 0;

                        for (File f : files) {
                            // Nombre de la clase  
                            String className = f.getName().replace(".java", "");
                            try {
                                // Carga la clase usando reflexión
                                Class<?> clazz = Class.forName("ejercito." + className);
                                // Verifica que la clase extienda de Servicios y no sea la clase abstracta
                                if (Servicios.class.isAssignableFrom(clazz) && !clazz.equals(Servicios.class)) {
                                    clasesServicios[idx++] = clazz; // Guarda la clase en el array
                                }
                            } catch (Exception e) { /* ignora errores de clases que no existen */ }
                        }

                        // 4. Muestra el menú dinámico con los nombres de las clases de servicios
                        System.out.println("Seleccione el servicio a asignar:");
                        for (int i = 0; i < idx; i++) {
                            System.out.println((i+1) + ". " + clasesServicios[i].getSimpleName());
                        }
                        int tipoServicio = scanner.nextInt();

                        // 5. Valida la opción elegida
                        if (tipoServicio < 1 || tipoServicio > idx) {
                            System.out.println("Tipo de servicio inválido.");
                            break;
                        }

                        // 6. Instancia el servicio seleccionado usando reflexión
                        Class<?> claseSeleccionada = clasesServicios[tipoServicio-1];
                        System.out.print("Ingrese el código del servicio: ");
                        int codServicio = scanner.nextInt();
                        Date fecha = new Date();
                        try {
                            // Busca el constructor adecuado (Date, int)
                            Constructor<?> cons = claseSeleccionada.getConstructor(Date.class, int.class); 
                            Servicios servicio = (Servicios) cons.newInstance(fecha, codServicio);
                            // Asigna el servicio al soldado
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
                case 5:
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
