

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class mapViewListener implements ActionListener{
    
    JFrame jf;
    JPanel jp;
    JMenuItem calendar;
    
    public mapViewListener(JFrame jf, JPanel jp) {

        this.jf = jf;
        this.jp = jp;
    }
    
    public mapViewListener() {

        this(null, null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Atras") || e.getActionCommand().equals("Back")) {
            System.out.println("Atras");
        }
        else if (e.getActionCommand().equals("Reservas") || e.getActionCommand().equals("Bookings")) {

			jp.setVisible(true); //Panel visible
			jf.setContentPane(jp); //Indicar panel como principal
			jf.revalidate();
        }
        else if (e.getActionCommand().equals("1") || e.getActionCommand().equals("2") || e.getActionCommand().equals("3") || e.getActionCommand().equals("4")
                || e.getActionCommand().equals("5") || e.getActionCommand().equals("6") || e.getActionCommand().equals("7") || e.getActionCommand().equals("8")){
            

            try {

                File temp = new File("temp.txt");
                Scanner tempReader = new Scanner(temp);

                String worker = tempReader.nextLine();
                tempReader.close();
                

                BufferedWriter out = new BufferedWriter(new FileWriter("temp.txt"));
                out.write(e.getActionCommand());
                out.write(",");
                out.write(worker);
                out.close();
    
            } catch (FileNotFoundException exc) {
    
                System.out.println("File Not Found.");
                exc.printStackTrace();
    
            } catch (IOException io) {
                System.out.println("An error occurred.");
                io.printStackTrace();
            } 
        }
        
        
    }
}
