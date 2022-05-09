


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class selectDayListener implements ActionListener{
    
    public JFrame jf;
    public JPanel jp;
    
    public selectDayListener(JFrame jf, JPanel jp) {

        this.jf = jf;
        this.jp = jp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Atras") || e.getActionCommand().equals("Back")) {

			jp.setVisible(true); //Panel visible
			jf.setContentPane(jp); //Indicar panel como principal
			jf.revalidate();
        }
        else if (!e.getActionCommand().equals("")){
            
			try {

				File reservationsTemp = new File("reservationsTemp.txt");
				Scanner reservationsTempReader = new Scanner(reservationsTemp);

				String data = reservationsTempReader.nextLine();
				String[] table = data.split(",", 2);
				
				String tableNumber = table[0];
				String[] days = table[1].split(",");

				String toAdd = tableNumber;

				for(int i = 0; i < days.length; i++) {
					
					if (!days[i].equals(e.getActionCommand())) {

						toAdd = toAdd.concat(",");
						toAdd = toAdd.concat(days[i]);
					}

				}

				reservationsTempReader.close();


				File reservations = new File("reservations.txt");
				Scanner reservationsReader = new Scanner(reservations);

				BufferedWriter reservationsAuxWritter = new BufferedWriter(new FileWriter("reservationsAux.txt"));

				while(reservationsReader.hasNextLine()) {

					String line = reservationsReader.nextLine();
					String[] tokens = line.split(",", 2);

					if (tokens[0].equals(tableNumber)) {

						reservationsAuxWritter.write(toAdd);
					}
					else {
						reservationsAuxWritter.write(line);
					}

					if(reservationsReader.hasNextLine()) {
						reservationsAuxWritter.write("\n");
					}
				}

				reservationsReader.close();
				reservationsAuxWritter.close();


				File reservationsAux = new File("reservationsAux.txt");
				Scanner reservationsAuxReader = new Scanner(reservationsAux);

				BufferedWriter reservationsWritter = new BufferedWriter(new FileWriter("reservations.txt"));

				while(reservationsAuxReader.hasNextLine()) {

					String lineAux = reservationsAuxReader.nextLine();

					reservationsWritter.write(lineAux);

					if(reservationsAuxReader.hasNextLine()) {
						reservationsWritter.write("\n");
					}
				}

				reservationsAuxReader.close();
				reservationsWritter.close();

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
			jf.repaint();
        }
        
        
    }
}
