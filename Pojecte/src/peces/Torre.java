package peces;

/**
 * Clase Torre
 *
 * @author Joan Martorell Coll
 */
public class Torre extends Peça {

    @Override
    public int[][] getMoviments() {
        int[][] moviments = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        return moviments;
    }

}
