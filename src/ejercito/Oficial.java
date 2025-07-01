package ejercito;

import java.util.Scanner;
import java.util.Date;
import java.io.File;

public class Oficial extends Usuario implements Menu,CapacidadOficial {
    private Scanner scanner;

    
    
    public Oficial(Scanner scanner, int codigo, String nombre, Cuerpo tipoCuerpo, Compania comp, Cuartel cuart, Gestion DB) {
        super(codigo, nombre, tipoCuerpo, comp, cuart, DB);
        this.scanner = scanner;
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
            System.out.println("\n=== MENÚ OFICIAL ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Ver todos los usuarios");
            System.out.println("3. Buscar usuario por código");
            System.out.println("4. Asignar servicio a soldado");
            System.out.println("5. Asignar Usuario a cuartel");
            System.out.println("6. Asignar Usuario a Cuerpo");
            System.out.println("7. Asignar Usuario a Compania");
            System.out.println("8. Salir");
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
                    this.getDb().mostrarTodosLosUsuarios();
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
                    break;
                case 3:
                    ConsolaUtil.limpiar();
                    System.out.print("Ingrese el código del usuario a buscar: ");
                    int codigo = scanner.nextInt();
                    this.getDb().buscarYMostrarUsuarioPorCodigo(codigo);
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
                    break;
                case 4:
                    ConsolaUtil.limpiar();
                    asignarServicioASoldado();
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
                    break;
                case 5:
                    ConsolaUtil.limpiar();
                    System.out.print("Ingrese el código del usuario: ");
                    int codSoldadoCua = scanner.nextInt();
                    System.out.print("Ingrese el código del cuartel: ");
                    int codCuartel = scanner.nextInt();
                    AsignarUsuarioCuartel(codSoldadoCua, codCuartel);
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
                    break;
                case 6:
                    ConsolaUtil.limpiar();
                    System.out.print("Ingrese el código del usuario: ");
                    int codUsuarioCuerpo = scanner.nextInt();
                    System.out.print("Ingrese el código del cuerpo: ");
                    int codCuerpo = scanner.nextInt();
                    AsignarUsuarioCuerpo(codUsuarioCuerpo, codCuerpo);
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
                    break;
                case 7:
                    ConsolaUtil.limpiar();
                    System.out.print("Ingrese el código del usuario: ");
                    int codUsuarioComp = scanner.nextInt();
                    System.out.print("Ingrese el código de la compañía: ");
                    int codCompania = scanner.nextInt();
                    AsignarUsuarioCompania(codUsuarioComp, codCompania);
                    System.out.println("\nPresione Enter para continuar...");
                    scanner.nextLine(); // Limpiar buffer
                    scanner.nextLine(); // Esperar Enter
                    break;
                case 8:
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



    @Override
    public void AsignarUsuarioCuartel(int codigoUser, int codigoCuartel) {
        Usuario usuario1 = this.getDb().buscarUsuarioPorCodigo(codigoUser);
        Cuartel cuart1 = this.getDb().buscarCuartelPorCodigo(codigoCuartel);
        
        if (usuario1 != null && cuart1 != null) {
            // Verificar si el usuario ya está asignado al cuartel destino
            boolean usuarioYaEnCuartelDestino = cuart1.getUsuarioCuartel().stream()
                .anyMatch(u -> u.getCodigo() == codigoUser);
            
            if (usuarioYaEnCuartelDestino) {
                System.out.println("Error: El usuario con código " + codigoUser + " ya está asignado a este cuartel.");
                System.out.println("Usuario: " + usuario1.getNombre() + " (Código: " + usuario1.getCodigo() + ")");
                System.out.println("Cuartel: " + cuart1.getNombre_cuartel() + " (Código: " + cuart1.getCodigo() + ")");
            } else {
                // Remover al usuario de cualquier otro cuartel antes de asignarlo al nuevo
                for (int i = 101; i <= 200; i++) {
                    Cuartel cuartel = this.getDb().buscarCuartelPorCodigo(i); //busca el cuartel por codigo
                    if (cuartel != null) { // si el cuartel no es nulo
                        cuartel.getUsuarioCuartel().removeIf(u -> u.getCodigo() == codigoUser); //remueve el usuario del cuartel
                    }
                }
                
                cuart1.getUsuarioCuartel().add(usuario1);
                System.out.println("Usuario asignado correctamente al cuartel.");
                cuart1.MostrarUsuariosAsignados();
            }
        } else {
            if (usuario1 == null) {
                System.out.println("No se encontró el usuario con código: " + codigoUser);
            }
            if (cuart1 == null) {
                System.out.println("No se encontró el cuartel con código: " + codigoCuartel);
            }
        }
    }

    @Override
    public void AsignarUsuarioCompania(int codigoUser, int codigoCompania) {
        Usuario usuario1 = this.getDb().buscarUsuarioPorCodigo(codigoUser);
        Compania compania1 = this.getDb().buscarCompaniaPorCodigo(codigoCompania);
        
        if (usuario1 != null && compania1 != null) {
            // Verificar si el usuario ya está asignado a alguna compañía
            boolean usuarioYaAsignado = false;
            Compania companiaActual = null;
            
            // Buscar en todas las compañías si el usuario ya está asignado
            for (int i = 1; i <= 100; i++) {
                Compania compania = this.getDb().buscarCompaniaPorCodigo(i);
                if (compania != null && compania.getUserCompania().stream().anyMatch(u -> u.getCodigo() == codigoUser)) {
                    usuarioYaAsignado = true;
                    companiaActual = compania;
                    break;
                }
            }
            
            if (usuarioYaAsignado) {
                System.out.println("Error: El usuario con código " + codigoUser + " ya está asignado a una compañía.");
                System.out.println("Usuario: " + usuario1.getNombre() + " (Código: " + usuario1.getCodigo() + ")");
                System.out.println("Compañía actual: " + companiaActual.getDenominacion_compania() + " (Código: " + companiaActual.getCodigo() + ")");
                System.out.println("Compañía destino: " + compania1.getDenominacion_compania() + " (Código: " + compania1.getCodigo() + ")");
                System.out.println("Un soldado solo puede pertenecer a una compañía durante todo el servicio militar.");
            } else {
                compania1.getUserCompania().add(usuario1);
                System.out.println("Usuario asignado correctamente a la compañía.");
                compania1.MostrarUsuariosAsignados();
            }
        } else {
            if (usuario1 == null) {
                System.out.println("No se encontró el usuario con código: " + codigoUser);
            }
            if (compania1 == null) {
                System.out.println("No se encontró la compañía con código: " + codigoCompania);
            }
        }
    }

        @Override
    public void AsignarUsuarioCuerpo(int codigoUser, int codigoCuerpo) {
        Usuario usuario1 = this.getDb().buscarUsuarioPorCodigo(codigoUser);
        Cuerpo cuerpo1 = this.getDb().buscarCuerpoPorCodigo(codigoCuerpo);
        
        if (usuario1 != null && cuerpo1 != null) {
            // Verificar si el usuario ya está asignado a algún cuerpo
            boolean usuarioYaAsignado = false;
            Cuerpo cuerpoActual = null;
            
            // Buscar en todos los cuerpos si el usuario ya está asignado
            for (int i = 101; i <= 200; i++) {
                Cuerpo cuerpo = this.getDb().buscarCuerpoPorCodigo(i);
                if (cuerpo != null && cuerpo.getUsuarioAsignado().stream().anyMatch(u -> u.getCodigo() == codigoUser)) {
                    usuarioYaAsignado = true;
                    cuerpoActual = cuerpo;
                    break;
                }
            }
            
            if (usuarioYaAsignado) {
                System.out.println("Error: El usuario con código " + codigoUser + " ya está asignado a un cuerpo.");
                System.out.println("Usuario: " + usuario1.getNombre() + " (Código: " + usuario1.getCodigo() + ")");
                System.out.println("Cuerpo actual: " + cuerpoActual.getDenominacion_cuerpo() + " (Código: " + cuerpoActual.getCodigo() + ")");
                System.out.println("Cuerpo destino: " + cuerpo1.getDenominacion_cuerpo() + " (Código: " + cuerpo1.getCodigo() + ")");
                System.out.println("Un soldado solo puede pertenecer a un cuerpo durante todo el servicio militar.");
            } else {
                cuerpo1.getUsuarioAsignado().add(usuario1);
                System.out.println("Usuario asignado correctamente al cuerpo.");
            }
        } else {
            if (usuario1 == null) {
                System.out.println("No se encontró el usuario con código: " + codigoUser);
            }
            if (cuerpo1 == null) {
                System.out.println("No se encontró el cuerpo con código: " + codigoCuerpo);
            }
        }
    }

    @Override
    public void CrearCuartel(Cuartel cua) {
        this.getDb().agregarCuartel(cua);
    }

    @Override
    public void CrearCuerpo(Cuerpo cuerpo1) {
        this.getDb().agregarCuerpo(cuerpo1);
    }

    @Override
    public void CrearCompania(Compania comp1) {
        this.getDb().agregarCompania(comp1);
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
            return (Servicios) clase.getConstructor(int.class, Date.class, String.class)
                .newInstance(codigo, new Date(), "Servicio " + clase.getSimpleName());
        } catch (Exception e) {
            System.out.println("Error: No se pudo crear el servicio " + clase.getSimpleName());
            return null;
        }
    }
    
}


    

    
    

