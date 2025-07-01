/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercito;

/**
 *
 * @author enzol
 */
public class ConsolaUtil {
     /**
     * Limpia la consola usando comandos del sistema operativo
     * Equivalente a system("cls") en C
     */
    public static void limpiar() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Fallback: imprimir líneas en blanco si falla el comando
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
}
