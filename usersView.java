/**
 * First View for the POS (Point of Sale), where we can select which worker are we
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class usersView {
    public static void main(String[] args){

        JFrame jf = new JFrame();

        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(50, 50, 50, 50);
        JPanel jp = new JPanel(gl);

//      Leer de la base de datos para crear los trabajadores necesarios
        readDB readDB = new readDB();
        Vector data = readDB.readDBdata("name");
        int nWorkers = data.size();
        int index = 0;

//      Establecemos el fondo de pantalla
        jp.setBackground(new Color(73,115,203));

        if (nWorkers % 2 == 0){

                int aux = nWorkers / 2;
                for (int i = 0; i < aux; i ++) {
                        for (int j = 0; j < 2; j ++) {

                                c.gridx = j;
                                c.gridy = i;
                        
                                String name = (String)data.elementAt(index);
                                JButton button = new JButton(name);
                                button.setForeground(Color.WHITE);
                                button.setPreferredSize(new Dimension(350, 100));
                                //button.setBorder(new ButtonStyle(40));
                                button.setBackground(new Color(97,104,135));
                                jp.add(button,c);
                                index++;
                                
                        }
                }
        }else{
                int auxI=0, auxJ=0;
                int aux = nWorkers / 2;
                for (int i = 0; i < aux; i ++) {
                        for (int j = 0; j < 2; j ++) {

                                c.gridx = j;
                                c.gridy = i;

                                String name = (String)data.elementAt(index);
                                JButton button = new JButton(name);
                                button.setForeground(Color.WHITE);
                                button.setPreferredSize(new Dimension(350, 100));
                                //button.setBorder(new ButtonStyle(40));
                                button.setBackground(new Color(97,104,135));
                                
                                jp.add(button,c);
                                index++;
                                auxI = i;
                                auxJ = j;
                        }
                }
               
                auxJ--;
                auxI++;

                System.out.println(auxJ);
                System.out.println(auxI);

                c.gridx = auxJ;
                c.gridy = auxI;

                String name = (String)data.elementAt(index);
                JButton button = new JButton(name);
                button.setForeground(Color.WHITE);
                button.setPreferredSize(new Dimension(350, 100));
                button.setBackground(new Color(97,104,135));
                jp.add(button,c);

        }

        jf.add(jp); 
        
        jf.setSize(1920, 1080);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}