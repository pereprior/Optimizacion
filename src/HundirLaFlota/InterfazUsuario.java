package HundirLaFlota;

import java.util.Scanner;

/**
 * Clase que recoge e interpreta los parametros introducidos por el usuario
 * @author pprior
 * @version v1.0
 * @since 25/01/2023
 */
public class InterfazUsuario {
    private static Scanner entradaTeclado = new Scanner(System.in);;

    /**
     * Metodo que recoge la fila donde quiere disparar el usuario
     * @return fila
     * <pre>
     * Ejemplo de metodo privado
     * {@code private int inputFila(){
     *    System.out.print("Fila: ");
     *    String texto = entradaTeclado.next().toUpperCase();
     *    char letraFila = texto.charAt(0);
     *    int fila = letraFila -'A';
     *    return fila;
     *  }}
     * </pre>
     */
    public int inputFila(){
        System.out.print("Fila: ");
        String texto = entradaTeclado.next().toUpperCase();
        char letraFila = texto.charAt(0);
        int fila = letraFila -'A';
        return fila;
    }

    /**
     * Metodo que recoge la columna donde quiere disparar el usuario
     * @return columna
     * @see HundirLaFlota
     */
    public int inputColumna(){
        System.out.print("Columna: ");
        int columna = entradaTeclado.nextInt();
        return columna-1;
    }
}
