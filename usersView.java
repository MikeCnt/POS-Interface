/**
 * First View for the POS (Point of Sale), where we can select which worker are we
 */

import javax.swing.*;
import java.awt.*;

public class usersView {
    public static void main(String[] args){

        JFrame jf = new JFrame();
        GridBagLayout gl = new GridBagLayout();

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(50, 50, 50, 50);
        
//      Crear JPanel con la estructura de GridLayout
        JPanel jp = new JPanel(gl);

//      Leer de la base de datos para crear los trabajadores necesarios
        int nWorkers = 6;
        
        if (nWorkers % 2 == 0){

                int aux = nWorkers / 2;
                for (int i = 0; i < aux; i ++) {
                        for (int j = 0; j < 2; j ++) {

                                c.gridx = j;
                                c.gridy = i;
                                
                                JButton button = new JButton("WORKER");
                                button.setForeground(Color.WHITE);
                                button.setPreferredSize(new Dimension(350, 100));
                                button.setBackground(new Color(97,104,135));
                                jp.add(button,c);
                                
                        }
                }
        }

        jp.setBackground(new Color(73,115,203));
        jf.add(jp);

        jf.setSize(1920, 1080);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
