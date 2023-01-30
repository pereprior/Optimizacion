package HundirLaFlota;

/**
 * Clase que instancia el tablero de juego
 * @author pprior
 * @version v1.0
 * @since 25/01/2023
 */

public class Tablero {

    /**
     * Este es el constructor de la clase Tablero
     * El constructor llama a los metodos que inician el tablero y crean los barcos
     * Metodo main: {@link HundirLaFlota}
     */

    public Tablero(){
        iniciaTablero();
        crearBarcos();
    }

    /**
     * Metodo que construye el tablero de juego
     * Utiliza un bucle for para rellenar el array bidimensional que funciona como tablero de juego.
     */
    private void iniciaTablero(){
        for (int i=0; i<tablero.length; i++){
            for (int col=0; col<tablero[0].length; col++){
                tablero[i][col]=SIMBOLO_VACIO;
            }
        }
    }

    /**
     * Metodo que crea los barcos y los añade los barcos al tablero de juego
     * Utilizamos un bucle while que se ejecuta hasta que se hayan creado todos los barcos que creamos.
     * Cada vez que ejecutemos el bucle, creamos dos numeros aleatorios que sirven como coordenadas para el nuevo barco.
     */
    private void crearBarcos(){
        int numeroBarcos = 0;
        int randFila, randCol;
        while (numeroBarcos<NUMERO_BARCOS){
            randFila = (int)(Math.random()*NUMERO_FILAS);
            randCol = (int)(Math.random()*NUMERO_COLUMNAS);
            //Se crea el barco si las coordenadas no estan repetidas
            if (tablero[randFila][randCol] != SIMBOLO_BARCO){
                tablero[randFila][randCol] = SIMBOLO_BARCO;
                numeroBarcos++;
            }
        }
    }

    /**
     * Metodo para  mostrar el tablero creado por pantalla
     * Mediante una concatenacion de bucles for, mostramos el tablero por lineas, de forma que se vean las letras de cada fila
     * Si el parametro es true, los barcos se mostraran en el tablero
     * @param mostrarBarcos
     */
    public void mostrarTablero(boolean mostrarBarcos){
        muestraPrimeraLinea();
        char letra='A';
        for (int fila=0; fila<tablero.length;fila++){
            System.out.print(letra+" ");
            letra++;
            for (int col=0; col<tablero[0].length; col++){
                StringBuilder celda = new StringBuilder(" ");
                if (!mostrarBarcos && tablero[fila][col] == SIMBOLO_BARCO){
                    celda.insert(0, SIMBOLO_VACIO);
                } else {
                    celda.insert(0, tablero[fila][col]);
                }
                System.out.print(celda);
            }
            System.out.println();
        }
    }

    /**
     * Metodo que muestra el numero de cada columna del tablero
     */
    private void muestraPrimeraLinea(){
        StringBuilder primera = new StringBuilder("  ");
        for (int i=1; i<=NUMERO_COLUMNAS; i++){
            primera.append(i + " ");
        }
        System.out.println(primera);
    }

    /**
     * Metodo que muestras las estadisticas del jugador
     * Muestra los tiros efectuados y los barcos restantes
     */
    public void mostrarEstadistica(){
        System.out.println("Tiros efectuados: " + numeroTiros);
        System.out.println("Barcos restantes: " + (NUMERO_BARCOS - barcosHundidos));
    }

    /**
     * Metodo que se efectua cada vez que el jugador hace una jugada
     * Si hay un barco en la posicion señalada por el jugador, cuenta como barco hundido
     * @param fila
     * @param col
     */
    public void tiro(int fila, int col){
        numeroTiros++;
        if (tablero[fila][col] == SIMBOLO_BARCO){
            tablero[fila][col] = SIMBOLO_TOCADO;
            barcosHundidos++;
        } else {
            if (tablero[fila][col] != SIMBOLO_TOCADO){
                tablero[fila][col] = SIMBOLO_AGUA;
            }
        }
    }

    /**
     * Metodo que marca el final de la partida
     * @return true cuando el numero de barcos hundidos sea igual al numero de barcos creados
     */
    public boolean finPartida(){
        return barcosHundidos == NUMERO_BARCOS;
    }

    public static final char SIMBOLO_AGUA = 'O';
    public static final char SIMBOLO_TOCADO = 'X';
    public static final char SIMBOLO_BARCO = 'B';
    public static final char SIMBOLO_VACIO = '.';
    public static final int NUMERO_BARCOS = 3;
    public static final int NUMERO_FILAS = 8;
    public static final int NUMERO_COLUMNAS = 8;
    private char[][] tablero = new char[NUMERO_FILAS][NUMERO_COLUMNAS];
    private int numeroTiros = 0;
    private int barcosHundidos = 0;
}
