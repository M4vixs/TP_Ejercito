package ejercito;

import java.util.ArrayList;

public class Cuartel extends Identificable{
    private String nombre_cuartel;
    private String ubicacion;
    private ArrayList<Usuario>UsuarioCuartel;

    public Cuartel( int codigo,String nombre_cuartel, String ubicacion) {
        super(codigo);
        this.nombre_cuartel = nombre_cuartel;
        this.ubicacion = ubicacion;
        this.UsuarioCuartel = new ArrayList();
    }



    public Cuartel(int codigo) {
        super(codigo);
    }

    public String getNombre_cuartel() {
        return nombre_cuartel;
    }

    public String getUbicacion() {
        return ubicacion;
    }


    public ArrayList<Usuario> getUsuarioCuartel() {
        return UsuarioCuartel;
    }
    public void MostrarUsuariosAsignados(){
        for (Usuario usuario : UsuarioCuartel) {
            usuario.MostrarDatos();
        }
    }
}
