package pojecte;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * Clase Tauler
 *
 * @author Joan Martorell Coll
 */
public class Tauler extends JPanel {
    
    private static final int N = 8;
    private Casella[][] caselles;
    
    /**
     * Mètode Constructor
     * @param ml manipulador del ratolí
     */
    public Tauler(MouseListener ml) {
        
        this.setBackground(new Color(255,255,255));
        this.setLayout(new GridLayout(N, N, 0, 0));
        
        caselles = new Casella[N][N];
        
        //Cream el tauler
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                caselles[y][x] = new Casella(x, y);
                this.add(caselles[y][x]);
                caselles[y][x].addMouseListener(ml);
            }
            Casella.canviColor();
        }
    }
    
    /**
     * Mètode que retorn la casella seleccionada amb el ratolí
     * 
     * @param evento event del ratolí
     * @return casella
     */
    public Casella casellaSeleccionada(MouseEvent evento) {
        
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                if(evento.getSource() == caselles[y][x]) {
                    return caselles[y][x];
                }
            }
        }
        
        return null;
    }
    
    /**
     * Mètode que retorna la casella segons les coordenades
     * 
     * @param x coordenada x
     * @param y coordenada y
     * @return casella
     */
    public Casella getCasella(int x, int y) {
        return caselles[y][x];
    }
    
    /**
     * Mètode que reinicia el tauler
     */
    public void reinicia() {
        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                caselles[y][x].setNum(0);
            }
        }
    }
}
