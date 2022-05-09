


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class ReservationsListener implements ActionListener{
    
    JFrame jf;
    JPanel jp;
    JPanel sub;
    JPanel newjp;
    
    public ReservationsListener(JFrame jf, JPanel jp, JPanel sub, JPanel newjp) {

        this.jf = jf;
        this.jp = jp;
        this.sub = sub;
        this.newjp = newjp;
    }
    
    public ReservationsListener(JFrame jf, JPanel jp) {

        this(jf, jp, null, null);
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

            sub.removeAll();


//	        Creating components for the center panel

            String text = "Días disponibles Mesa ".concat(e.getActionCommand());

            JLabel jlChooseDay = new JLabel(text,JLabel.CENTER);
            jlChooseDay.setFont(new Font("Sans", Font.BOLD, 40));

            FlowLayout flChooseDay = new FlowLayout();
            flChooseDay.setAlignment(FlowLayout.CENTER);
            flChooseDay.setVgap(50);

            JPanel centerInnerPanelChooseDay = new JPanel(flChooseDay);
            centerInnerPanelChooseDay.setOpaque(false);

            try {
                    File reservationsTempChooseDay = new File("reservationsTemp.txt");
                    Scanner reservationsTempReaderChooseDay = new Scanner(reservationsTempChooseDay);

                    String dataChooseDay = reservationsTempReaderChooseDay.nextLine();
                    String[] tokensChooseDay = dataChooseDay.split(",", 2); 
                    String daysChooseDay = tokensChooseDay[1];

                    String[] dayChooseDay = daysChooseDay.split(",");

                    for(int i = 0; i < dayChooseDay.length; i++) {
                            
                            JButton dayBtnChooseDay = new JButton(dayChooseDay[i]);
                            dayBtnChooseDay.setPreferredSize(new Dimension(70,70));
                            dayBtnChooseDay.addActionListener(new selectDayListener(jf, newjp));
                            dayBtnChooseDay.setBackground(new Color(97,104,135));
                            centerInnerPanelChooseDay.add(dayBtnChooseDay);
                            
                    }

                    reservationsTempReaderChooseDay.close();
            
            } catch (FileNotFoundException exc) {

                    System.out.println("File Not Found.");
                    exc.printStackTrace();

            }


            sub.add(jlChooseDay, BorderLayout.NORTH);
            sub.add(centerInnerPanelChooseDay, BorderLayout.CENTER);

			jp.setVisible(true); //Panel visible
			jf.setContentPane(jp); //Indicar panel como principal
			jf.revalidate();
        }
        
        
    }
}
