package peces;

/**
 * Clase Peó
 * 
 * @author Joan Martorell Coll
 */
public class Peo extends Peça {
    
    @Override
    public int[][] getMoviments() {
        int[][] moviments = {{0, -1}};
        return moviments;
    }
}
