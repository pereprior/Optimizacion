package HundirLaFlota;

/**
 * Clase main que ejecuta el programa
 * @author pprior
 * @version v1.0
 * @since 25/01/2023
 */

public class HundirLaFlota {
    private static int fila, columna;
    private static boolean finJuego=false;
    private static Tablero tablero = new Tablero();
    private static InterfazUsuario iu = new InterfazUsuario();

    /**
     * Metodo main que ejecuta el programa
     * Mediante un bucle while, el programa se ejecutara hasta que el jugador elimine todos los barcos
     * Primero muestra las estadisticas del usuario y el tablero
     * Luego recoge los parametros del usuario y efectua el disparo en las coordenadas que especifica
     * @param args
     */
    public static void main(String[] args){
        while (!finJuego){
            tablero.mostrarEstadistica();
            tablero.mostrarTablero(false);
            fila = iu.inputFila();
            columna = iu.inputColumna();
            tablero.tiro(fila, columna);
            finJuego = tablero.finPartida();
        }
    }
}
