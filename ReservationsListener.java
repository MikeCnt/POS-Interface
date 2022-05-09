


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class ReservationsListener implements ActionListener{
    
    JFrame jf;
    JPanel jp;
    
    public ReservationsListener(JFrame jf, JPanel jp) {

        this.jf = jf;
        this.jp = jp;
    }
    
    public ReservationsListener() {

        this(null, null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Atras") || e.getActionCommand().equals("Back")) {
            
			jp.setVisible(true); //Panel visible
			jf.setContentPane(jp); //Indicar panel como principal
			jf.revalidate();
        }
        else if (e.getActionCommand().equals("1") || e.getActionCommand().equals("2") || e.getActionCommand().equals("3") || e.getActionCommand().equals("4")
                || e.getActionCommand().equals("5") || e.getActionCommand().equals("6") || e.getActionCommand().equals("7") || e.getActionCommand().equals("8")){
            
			try {

				File reservations = new File("reservations.txt");
				Scanner reservationsReader = new Scanner(reservations);
	
				while (reservationsReader.hasNextLine()) {
					String data = reservationsReader.nextLine();
					String[] table = data.split(",", 2);         
	
					if (table[0].equals(e.getActionCommand())) {

						BufferedWriter out = new BufferedWriter(new FileWriter("reservationsTemp.txt"));
                		out.write(data);
						out.close();
						break;
					}
				}
				
				reservationsReader.close();

			} catch (FileNotFoundException exc) {
    
                System.out.println("File Not Found.");
                exc.printStackTrace();
    
            } catch (IOException io) {
                System.out.println("An error occurred.");
                io.printStackTrace();
            }

			jp.setVisible(true); //Panel visible
			jf.setContentPane(jp); //Indicar panel como principal
			jf.revalidate();
        }
        
        
    }
}
