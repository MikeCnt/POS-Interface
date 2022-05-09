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
    JPanel jp;

    public menuPayButtonsListener(int code, JFrame frame, JPanel jp) {
        this.code = code;
        this.frame = frame;
        this.jp = jp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //This if is accessed if you press cancel
        if (e.getActionCommand().equals("CANCELAR CUENTA") || e.getActionCommand().equals("CANCEL BILL")) {

            int ret = JOptionPane.showConfirmDialog(frame, "¡¡CUIDADO!!\nEsta accion borrara TODA la cuenta de la mesa.\n¿Quieres continuar?", "¡CUIDADO!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (ret == 0) {

                try {

                    File f = new File("bill.txt");
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);

                    FileWriter fw = new FileWriter(f,true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    File temp = new File("temp.txt");
                    FileWriter fw2 = new FileWriter(temp, true);
                    BufferedWriter bw2 = new BufferedWriter(fw2);

                    String line;
                    while((line = br.readLine()) != null){
                        String[] token = line.split(",");

                        if(!Integer.toString(code).equals(token[0])){
                            // BORRAMOS EL QUE COINCIDA CON EL CODIGO
                            bw2.write(line);
                        }
                    }

                    f.delete();
                    temp.renameTo(f);
                    
                    fr.close();
                    bw.close();
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
                
                try {

                    File f = new File("bill.txt");
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    String finalPrice = null;

                    String line;
                    while((line = br.readLine()) != null){

                        String[] token = line.split(",");

                        if(Integer.toString(code).equals(token[0])){

                            finalPrice = token[(token.length)-1];
                        }
                    }
                    System.out.println(finalPrice);
                    br.close();
                
                } catch (IOException io) {
                    System.out.println("An error occurred.");
                    io.printStackTrace();
                }
            }
        }
            
        jp.setVisible(true); //Panel visible
        frame.setContentPane(jp); //Indicar panel como principal
        frame.revalidate();
    }
}
