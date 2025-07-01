package ejercito;

import java.util.Scanner;
import java.util.Date;
import java.io.File;

public class Suboficial extends Usuario implements Menu,CapacidadServicios{
    private Scanner scanner;

    public Suboficial(Scanner scanner, int codigo, String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart, Gestion DB) {
        super(codigo, nombre, tipoCuerpo, comp, cuart, DB);
        this.scanner = scanner;
    }
    
    
    
    @Override
    public Servicios AgregarServicios(Servicios s) {
        // Implementación básica - retorna el servicio sin modificar
        return s;
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
                this.getDb().mostrarTodosLosUsuarios();
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine(); // Esperar Enter
                scanner.nextLine(); // Esperar Enter
                break;
            case 2:
                System.out.print("Ingrese el código del usuario a buscar: ");
                int codigo = scanner.nextInt();
                this.getDb().buscarYMostrarUsuarioPorCodigo(codigo);
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine(); // Limpiar buffer
                scanner.nextLine(); // Esperar Enter
                break;
            case 3:
                ConsolaUtil.limpiar();
                asignarServicioASoldado();
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
    
    // Método auxiliar para asignar servicio a soldado
    private void asignarServicioASoldado() {
        System.out.print("Ingrese el código del soldado: ");
        int codSoldado = scanner.nextInt();
        Usuario usuario = this.getDb().buscarUsuarioPorCodigo(codSoldado);
        
        if (usuario == null || !(usuario instanceof Soldado)) {
            System.out.println("No se encontró un soldado con ese código.");
            return;
        }
        
        // Buscar servicios dinámicamente
        Class<?>[] servicios = obtenerServicios();
        if (servicios.length == 0) {
            System.out.println("No hay servicios disponibles.");
            return;
        }
        
        // Mostrar menú dinámico
        System.out.println("Seleccione el servicio:");
        for (int i = 0; i < servicios.length; i++) {
            System.out.println((i+1) + ". " + servicios[i].getSimpleName());
        }
        
        int opcion = scanner.nextInt();
        if (opcion < 1 || opcion > servicios.length) {
            System.out.println("Opción inválida.");
            return;
        }
        
        System.out.print("Ingrese el código del servicio: ");
        int codServicio = scanner.nextInt();
        
        // Crear servicio dinámicamente
        Servicios servicio = crearServicio(servicios[opcion-1], codServicio);
        if (servicio != null) {
            ((Soldado)usuario).asignarServicio(servicio);
            System.out.println("Servicio asignado correctamente.");
        }
    }
    
    private Class<?>[] obtenerServicios() {
        File dir = new File("src/ejercito");
        File[] files = dir.listFiles((d, name) -> name.endsWith(".java") && !name.equals("Servicios.java"));
        Class<?>[] servicios = new Class<?>[files.length];
        int idx = 0;
        
        for (File f : files) {
            String className = f.getName().replace(".java", "");
            try {
                Class<?> clazz = Class.forName("ejercito." + className);
                if (Servicios.class.isAssignableFrom(clazz) && !clazz.equals(Servicios.class)) {
                    servicios[idx++] = clazz;
                }
            } catch (Exception e) { /* ignorar */ }
        }
        
        Class<?>[] resultado = new Class<?>[idx];
        System.arraycopy(servicios, 0, resultado, 0, idx);
        return resultado;
    }
    
    private Servicios crearServicio(Class<?> clase, int codigo) {
        try {
            // Constructor estándar: (int codigo, Date fecha, String nombre)
            return (Servicios) clase.getConstructor(int.class, Date.class, String.class)
                .newInstance(codigo, new Date(), "Servicio " + clase.getSimpleName());
        } catch (Exception e) {
            System.out.println("Error: No se pudo crear el servicio " + clase.getSimpleName());
            return null;
        }
    }
}
