

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
        else if (e.getActionCommand().equals("1") || e.getActionCommand().equals("2") || e.getActionCommand().equals("3") || e.getActionCommand().equals("4")
                || e.getActionCommand().equals("5") || e.getActionCommand().equals("6") || e.getActionCommand().equals("7") || e.getActionCommand().equals("8")){
            

            try {

                File tables = new File("tables.txt");
                Scanner tablesReader = new Scanner(tables);
                File temp = new File("temp.txt");
                Scanner tempReader = new Scanner(temp);
                String toFile = "";
    
                while (tablesReader.hasNextLine()) {
                    String data = tablesReader.nextLine();
                    String[] table = data.split(",", 3);         
    
                    if (table[0].equals(e.getActionCommand())) {
                        
                        toFile = data;
                        break;
                    }
                }
                
                tablesReader.close();

                String worker = tempReader.nextLine();
                tempReader.close();
                

                BufferedWriter out = new BufferedWriter(new FileWriter("temp.txt"));
                out.write(worker);
                out.write("\n");
                out.write(toFile);
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
