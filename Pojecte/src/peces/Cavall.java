package peces;

/**
 * Clase Cavall
 *
 * @author Joan Martorell Coll
 */
public class Cavall extends Peça {

    @Override
    public int[][] getMoviments() {
        int[][] moviments = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        return moviments;
    }

}
