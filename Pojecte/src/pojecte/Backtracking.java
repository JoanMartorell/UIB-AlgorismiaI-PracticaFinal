package pojecte;

/**
 *
 * @author Joan Martorell Coll
 * 
 */
public class Backtracking {
    
    private static int[][] MOV;
    private static final int N = 8;
    private static boolean exit;
    
    /**
     *
     * Mètode principal que inicialitza el mètode de la solució
     * 
     * @param t tauler
     * @param x primera coordenada x
     * @param y primera coordenada y
     * @param mov possibles moviments de la peça
     * @param recursiu true si es vol utilitzar el mètode recursiu
     * @return si té solució true
     */
    public static boolean nEscacs(Tauler t, int x, int y, int[][] mov, boolean recursiu) {
        MOV = mov;
        exit = false;
        
        if(recursiu) {
            nEscacs(t, x, y, 2);
        } else {
            return nEscacsIteratiu(t, x, y);
        }        
        return exit;
    }
    
    /**
     *
     * Mètode recursiu de backtracking
     * Complexitat: O(n·2^n)
     * 
     * @param t tauler
     * @param x coordenada x
     * @param y coordenada y
     * @param i número de la casella
     */
    public static void nEscacs(Tauler t, int x, int y, int i) {
        int nx, ny;
        int k;
        
        System.out.println("i: "+i+", x: "+x+", y: "+y);
        k = 0;
        while ((k < MOV.length) && !exit) {
            nx = x + MOV[k][0];
            ny = y + MOV[k][1];
            
            if(isValid(t, nx, ny)) {
                t.getCasella(nx, ny).setNum(i);
                if (i < N * N) {
                    nEscacs(t, nx, ny, i + 1);
                    if (!exit) {
                        t.getCasella(nx, ny).setNum(0);
                    }
                } else {
                    exit = true;
                }
            }
            k++;
        }
    }
    
    /**
     * Mètode per validar una posició
     * 
     * @param t tauler
     * @param x coordenada x
     * @param y coordenada y
     * @return true si és vàlida
     */
    private static boolean isValid(Tauler t, int x, int y) {
        return (x >= 0) && (x < N) && 
                (y >= 0) && (y < N) && 
                (t.getCasella(x, y).getNum() == 0);
    }
    
    /**
     *
     * Mètode secuencial de backtracking
     * Complexitat: O(n·2^n)
     * 
     * @param t tauler
     * @param x primera coordenada x
     * @param y primera coordenada y
     * @return true si te solució
     */
    public static boolean nEscacsIteratiu(Tauler t, int x, int y) {

        int nx, ny;
        int i = 2;
        
        while(i > 0) {
        
            System.out.println("i: "+i+", x: "+x+", y: "+y);
            
            for(int k = 0; k < MOV.length; k++) {
                nx = x + MOV[k][0];
                ny = y + MOV[k][1];
                
                if(isValid(t, nx, ny)) {
                    t.getCasella(nx, ny).setNum(i);
                    x = nx;
                    y = ny;
                    
                    if(i == N*N) {
                        return true;
                    }
                    
                    i++;
                }
                
                if(k == MOV.length) {
                    t.getCasella(x, y).setNum(0);
                    i--;
                }
                
            }
        }
        
        return false;
    }
    
}
