package peces;

/**
 * Clase Arfil
 * 
 * @author Joan Martorell Coll
 */
public class Arfil extends Peça {
    
    @Override
    public int[][] getMoviments() {
        int[][] moviments = {{1, -1}, {1, 1}, {-1, -1}, {-1, 1}};
        return moviments;
    }
}
