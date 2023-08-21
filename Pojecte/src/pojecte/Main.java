package pojecte;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import peces.Arfil;
import peces.Arfil;
import peces.Cavall;
import peces.Cavall;
import peces.Peo;
import peces.Peo;
import peces.Peça;
import peces.Peça;
import peces.ReiReina;
import peces.ReiReina;
import peces.Torre;
import peces.Torre;
import pojecte.Backtracking;
import pojecte.Casella;
import pojecte.Tauler;

/**
 * Clase princial
 * 
 * @author Joan Martorell Coll
 */
public class Main {
    
    private final String[] peces = {"Peó", "Arfil", "Cavall", "Torre", "Rei", "Reina"};
    private String peçaSeleccionada;
    private JFrame finestra;
    private Container contingut;
    private Tauler panelTauler;
    private JPanel panelInformacio;
    private JLabel text;
    private JMenuBar barraPeces;
    private JButton reinicia;
    
    /**
     * Mètode Inicialitzador
     * @param args
     */
    public static void main(String[] args) {       
        new Main().metodoPrincipal();        
    }
    
    /**
     * Mètode Principal
     */
    private void metodoPrincipal() {
        finestra = new JFrame("Projecte Backtracking");
        contingut = finestra.getContentPane();
        contingut.setLayout(new BorderLayout());
        panelTauler = new Tauler(new manipuladorCaselles());
        crearComponents();                
    }
     
    /**
     * Mètode que crea els components
     */
    private void crearComponents() {
        
        panelTauler = new Tauler(new manipuladorCaselles());
        
        //-----------------------------------------
        panelInformacio = new JPanel();
        text = new JLabel("Tria una peça: ");
        text.setFont(new Font("arial", Font.BOLD, 13));
        
        //-----------------------------------------
        barraPeces = new JMenuBar();
        JMenu pecesMenu = new JMenu("Peces");
        
        //Peces -----------------------------------
        JMenuItem p;
        for(int i = 0; i < peces.length; i++) {
            p = new JMenuItem(peces[i]);
            p.addActionListener(new manipuladorEvents());
            pecesMenu.add(p);
        }
            
        barraPeces.add(pecesMenu);
        
        //-----------------------------------
        reinicia = new JButton("REINICIA");
        reinicia.addActionListener(new manipuladorEvents());
        
        //------------------------------------
        panelInformacio.add(text);
        panelInformacio.add(barraPeces);
        
        //-------------------------------------
        contingut.add(panelTauler, BorderLayout.CENTER);
        contingut.add(panelInformacio, BorderLayout.SOUTH);
        //--------------------------------------
        finestra.pack();
        finestra.setLocationRelativeTo(null);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setVisible(true);
    }
    
    /**
     * Mètode que manipula els botons
     */
    private class manipuladorEvents implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("REINICIA".equals(e.getActionCommand())) {
                
                panelTauler.reinicia();
                panelInformacio.remove(reinicia);
                panelInformacio.add(barraPeces);
                text.setText("Tria una peça: ");
                
            } else {
                peçaSeleccionada = e.getActionCommand();
                
                panelInformacio.remove(text);
                panelInformacio.remove(barraPeces);
                panelInformacio.add(reinicia);
                panelInformacio.add(text);
                text.setText("Pitja damunt una casella");
            }
            
            panelInformacio.updateUI();
            
        }
    }
    
    /**
     * Mètode que manipula el ratolí
     */
    private class manipuladorCaselles implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if("Pitja damunt una casella".equals(text.getText())) {
                
                text.setText("Treballant...");
                
                Peça p;
                switch(peçaSeleccionada) {
                    case "Peó": p = new Peo(); break;
                    case "Arfil": p = new Arfil(); break;
                    case "Cavall": p = new Cavall(); break;
                    case "Torre": p = new Torre(); break;
                    case "Rei": p = new ReiReina(); break;
                    case "Reina": p = new ReiReina(); break;
                    default: p = new Peo(); break;
                }
                
                Casella c = panelTauler.casellaSeleccionada(e);
                c.setNum(1);
                
                if(Backtracking.nEscacs(panelTauler, c.getCoor()[0], c.getCoor()[1], p.getMoviments(), true)) {
                    text.setText("El procés ha finalitzat. Ha trobat una solució.");
                } else {
                    text.setText("El procés ha finalitzat. No ha trobat solució.");
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        
    }
}
