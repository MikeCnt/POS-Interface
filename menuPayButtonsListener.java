/*
    Listener para los botones de pago del menu
*/

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

public class menuPayButtonsListener implements ActionListener{
	
	Container cp;
    
    public menuPayButtonsListener(Container cp) {
        this.cp = cp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        


        //This if is accessed if you press cancel
        if (e.getActionCommand().equals("Cancelar") || e.getActionCommand().equals("Cancel")) {

            int ret = JOptionPane.showConfirmDialog(cp, "¡¡CUIDADO!!\nEsta accion borrara TODA la cuenta de la mesa.\n¿Quieres continuar?", "¡CUIDADO!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (ret == 0) {

                String text = "1,0,order\n2,0,order\n3,0,order\n4,0,order\n5,0,order\n6,0,order\n7,0,order\n8,0,order";

                try {
                    BufferedWriter tablesWriter = new BufferedWriter(new FileWriter("tables.txt"));

                    tablesWriter.write(text);
                    tablesWriter.close();

                    File temp = new File("temp.txt");
                    Scanner tempReader = new Scanner(temp);

				    String worker = tempReader.nextLine();
                    String table = tempReader.nextLine();

                    String[] tokens = table.split(",",3);

                    String newTable = tokens[0].concat(",0,order");

                    tempReader.close();

                    BufferedWriter tempWriter = new BufferedWriter(new FileWriter("temp.txt"));

                    tempWriter.write(worker);
                    tempWriter.write("\n");
                    tempWriter.write(newTable);
                    tempWriter.close();

                } catch (IOException io) {
                    System.out.println("An error occurred.");
                    io.printStackTrace();
                }
            }
            else {
                System.out.println("Cancelar No");
            }
        }

        //This if is accessed if you press selected
        else if (e.getActionCommand().equals("Seleccionados") || e.getActionCommand().equals("Selected")) {

            int ret = JOptionPane.showConfirmDialog(cp, "¿Estás seguro?\nSi seleciona \"Si\" parasará directamente a la pantalla de pago", "¡CUIDADO!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (ret == 0) {

                String option = e.getActionCommand();
                Float value = 50.00f;
                String valueString = String.format("%.02f", value);


                try {

                    BufferedWriter tempWriter = new BufferedWriter(new FileWriter("temp.txt", true));

                    tempWriter.write("\n");
                    tempWriter.write(option);
                    tempWriter.write("\n");
                    tempWriter.write(valueString);
                    tempWriter.close();
                
                } catch (IOException io) {
                    System.out.println("An error occurred.");
                    io.printStackTrace();
                }

            }
            else {
                System.out.println("Seleccionados No");
            }
        }

        //This if is accessed if you press All
        else if (e.getActionCommand().equals("Todos") || e.getActionCommand().equals("All")) {

            int ret = JOptionPane.showConfirmDialog(cp, "¿Estás seguro?\nSi seleciona \"Si\" parasará directamente a la pantalla de pago", "¡CUIDADO!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (ret == 0) {
                
                String option = e.getActionCommand();


                try {

                    BufferedWriter tempWriter = new BufferedWriter(new FileWriter("temp.txt", true));

                    tempWriter.write("\n");
                    tempWriter.write(option);
                    tempWriter.close();
                
                } catch (IOException io) {
                    System.out.println("An error occurred.");
                    io.printStackTrace();
                }
            }
            else {
                System.out.println("Todos No");
            }
        }
                
        
    }
}
