package peces;

/**
 * Clase abstracta peça
 *
 * @author Joan Martorell Coll
 */

public abstract class Peça {
    
    /**
     * Mètode que retona el moviments de la peça
     * Funciona de la següent manera:
     *   ------- X ----------
     * | (0, 0) (1, 0) (2, 0)
     * Y (0, 1) (1, 1) (2, 1)   (x, y)
     * | (0, 2) (1, 2) (2, 2)
     * 
     * En cas de estar situat a la coordenada (1, 1), per indicar
     * que es pot anar a la (0, 2), s'hauria de posar {-1, -1}. Com
     * es pot observar, l'eix X és negatiu perquè "va cap a l'esquerre"
     * i l'eix Y és negatiu perquè "baixa".
     * 
     * @return mooviments
     */
    public abstract int[][] getMoviments();
    
}
