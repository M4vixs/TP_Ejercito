package ejercito;

import java.util.ArrayList;

public class Gestion {
    private ArrayList<Usuario> users;
    private ArrayList<Compania> companias;
    private ArrayList<Cuartel> cuarteles;
    private ArrayList<Cuerpo> cuerpos;

    public Gestion(ArrayList<Usuario> users, ArrayList<Compania> companias, ArrayList<Cuartel> cuarteles, ArrayList<Cuerpo> cuerpos) {
        this.users = users;
        this.companias = companias;
        this.cuarteles = cuarteles;
        this.cuerpos = cuerpos;
    }
    
    // Método para agregar un usuario a la base de datos
    public void agregarUsuario(Usuario usuario) {
        users.add(usuario);
    }
    
    public void agregarCuartel(Cuartel cuartel) {
        cuarteles.add(cuartel);
    }
    public void agregarCuerpo(Cuerpo cuerpo1) {
        cuerpos.add(cuerpo1);
    }
    public void agregarCompania(Compania compania) {
        companias.add(compania);
    }
   
    
    // Método para obtener todos los usuarios
    public ArrayList<Usuario> obtenerTodosLosUsuarios() {
        return users;
    }
    public Cuartel buscarCuartelPorCodigo(int codigo) {
        for (Cuartel cuart1 : cuarteles) {
            if ((cuart1.getCodigo()) == codigo) {
                return cuart1;
            }
        }
        return null; // Cuartel no encontrado
    }

    
    // Método para buscar usuario por código
    public Usuario buscarUsuarioPorCodigo(int codigo) {
        for (Usuario usuario : users) {
            if (usuario.getCodigo() == codigo) {
                return usuario;
            }
        }
        return null; // Usuario no encontrado
    }
    
    // Método para buscar usuario por código
    public Cuerpo buscarCuerpoPorCodigo(int codigo) {
        for (Cuerpo cuerpo : cuerpos) {
            if (cuerpo.getCodigo() == codigo) {
                return cuerpo;
            }
        }
        return null; // Usuario no encontrado
    }
    
     public Compania buscarCompaniaPorCodigo(int codigo) {
        for (Compania comp : companias) {
            if ((comp.getCodigo()) == codigo) {
                return comp;
            }
        }
        return null; // Usuario no encontrado
    }
    
    // Método para mostrar todos los usuarios
    public void mostrarTodosLosUsuarios() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados en la base de datos.");
            return;
        }
        
        System.out.println("\n=== LISTA DE TODOS LOS USUARIOS ===");
        System.out.println("Total de usuarios: " + users.size());
        System.out.println("----------------------------------------");
        
        for (Usuario usuario : users) {
            System.out.println("Código: " + usuario.getCodigo());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Cuerpo: " + usuario.getTipoCuerpo().getDenominacion_cuerpo());
            System.out.println("Compañía: " + usuario.getComp().getDenominacion_compania());
            System.out.println("Cuartel: " + usuario.getCuart().getNombre_cuartel());
            System.out.println("Tipo: " + usuario.getClass().getSimpleName());
            System.out.println("----------------------------------------");
        }
    }
    
    // Método para buscar y mostrar usuario por código
    public void buscarYMostrarUsuarioPorCodigo(int codigo) {
        Usuario usuario = buscarUsuarioPorCodigo(codigo);
        if (usuario != null) {
            System.out.println("\n=== USUARIO ENCONTRADO ===");
            usuario.MostrarDatos();
            System.out.println("Tipo: " + usuario.getClass().getSimpleName());
        } else {
            System.out.println("No se encontró ningún usuario con el código: " + codigo);
        }
    }
    
    @Override
    public String toString() {
        return "Gestion{" + "users=" + users + ", companias=" + companias + ", cuarteles=" + cuarteles + '}';
    }
}
