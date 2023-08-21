package peces;

/**
 * Clase Rei i Reina
 * 
 * @author Joan Martorell Coll
 */
public class ReiReina extends Peça {

    @Override
    public int[][] getMoviments() {
        int[][] moviments = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {1, -1}, {1, 1}, {-1, -1}, {-1, 1}};
        return moviments;
    }

}
