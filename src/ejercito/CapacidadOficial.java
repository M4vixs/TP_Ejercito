/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercito;

/**
 *
 * @author enzol
 */
public interface CapacidadOficial {
    public void CrearCuartel(Cuartel cua);
    public void CrearCuerpo(Cuerpo cuerpo1);
    public void CrearCompania(Compania comp1);
    
    public void AsignarUsuarioCuartel(int codigoUser , int codigoCuartel);
    public void AsignarUsuarioCuerpo(int codigoUser , int codigoCuerpo);
    public void AsignarUsuarioCompania(int codigoUser , int codigoCompania);
}
