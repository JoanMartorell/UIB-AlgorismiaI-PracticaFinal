package pojecte;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase Casella
 * 
 * @author Joan Martorell Coll
 */
public class Casella extends JPanel {
    
    private static int caselles = 0;
    private JLabel num;
    private final int x, y;
    
    /**
     * Mètode Constructor
     * 
     * @param x coordenada x
     * @param y coordenada y
     */
    public Casella(int x, int y) {
        this.x = x;
        this.y = y;
        
        caselles++;
        if((caselles % 2) == 0) {
            setBackground(new Color(255,255,255));
        } else {
            setBackground(new Color(214,214,214));
        }
        
        setPreferredSize(new Dimension(50,50));
        setLayout(new GridBagLayout());
        
        num = new JLabel("");
        add(num);
    }    

    /**
     * Mètode que obté el número de la casella
     * 
     * @return número enter
     */
    public int getNum() {
        if("".equals(num.getText())) {
            return 0;
        }
        return Integer.parseInt(num.getText());
    }
    
    /**
     * Mètode per modificar el número de la casella
     * 
     * @param n nou número
     */
    public void setNum(int n) {
        if(n == 0) {
            num.setText("");
        } else {
            num.setText(""+n);
        }
    }
    
    /**
     * Mètode que retorna les coordenades de la casella
     * 
     * @return [x, y]
     */
    public int[] getCoor() {
        int[] coor = {x, y};
        return coor;
    }
    
    /**
     * Mètode per canviar el color de les caselles
     */
    public static void canviColor() {
        if(caselles == 8) {
            caselles = 1;
        } else {
            caselles = 0;
        }
    }
}
