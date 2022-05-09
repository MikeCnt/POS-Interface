

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class usersViewListener implements ActionListener{
    
    JFrame jf;
    JPanel jp;
    JMenuItem calendar;
    
    public usersViewListener(JFrame jf, JPanel jp) {

        this.jf = jf;
        this.jp = jp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
		try {

			BufferedWriter out = new BufferedWriter(new FileWriter("temp.txt"));

			out.write(e.getActionCommand());
			out.close();

		} catch (IOException io) {
			System.out.println("An error occurred.");
			io.printStackTrace();
		}

		jp.setVisible(true); //Panel visible
		jf.setContentPane(jp); //Indicar panel como principal
		jf.revalidate();
		jf.repaint();
    }
}
