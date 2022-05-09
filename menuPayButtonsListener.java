/*
    Listener para los botones de pago del menu
*/

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class menuPayButtonsListener implements ActionListener{
	
	int code;
    JFrame frame;

    public menuPayButtonsListener(int code, JFrame frame) {
        this.code = code;
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //This if is accessed if you press cancel
        if (e.getActionCommand().equals("CANCELAR CUENTA") || e.getActionCommand().equals("CANCEL BILL")) {

            int ret = JOptionPane.showConfirmDialog(frame, "¡¡CUIDADO!!\nEsta accion borrara TODA la cuenta de la mesa.\n¿Quieres continuar?", "¡CUIDADO!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (ret == 0) {

                try {

                    File temp = new File("bill.txt");
                    File output = new File("temp.txt"); // SOBREESCRIBIREMOS ESTE
                    FileReader fr = new FileReader(temp);
                    BufferedReader br = new BufferedReader(fr);

                    FileWriter fw1 = new FileWriter(temp, true);
                    FileWriter fw2 = new FileWriter(output, true);
                    BufferedWriter bw1 = new BufferedWriter(fw1);
                    BufferedWriter bw2 = new BufferedWriter(fw2);

                    String line;
                    while((line = br.readLine()) != null){
                        String[] token = line.split(",");

                        if(Integer.toString(code) != token[0]){
                            // BORRAMOS EL QUE COINCIDA CON EL CODIGO
                            bw2.write(line);
                        }
                    }

                    bw1.write(""); // VACIAMOS EL PPAL
                    String aux;
                    while((aux = br.readLine()) != null){
                        bw1.write(aux);
                    }
                    
                    output.delete();

                    fr.close();
                    bw1.close();
                    bw2.close();

                } catch (IOException io) {
                    System.out.println("An error occurred.");
                    io.printStackTrace();
                }
            }
        }

        //This if is accessed if you press selected
        else if (e.getActionCommand().equals("PAGAR SELECCIONADOS") || e.getActionCommand().equals("PAY SELECTED")) {

            int ret = JOptionPane.showConfirmDialog(frame, "¿Estás seguro?\nSi seleciona \"Si\" parasará directamente a la pantalla de pago", "¡CUIDADO!",
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
        else if (e.getActionCommand().equals("PAGAR TODO") || e.getActionCommand().equals("PAY ALL")) {

            int ret = JOptionPane.showConfirmDialog(frame, "¿Estás seguro?\nSi seleciona \"Si\" parasará directamente a la pantalla de pago", "¡CUIDADO!",
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
