/*
    Listener for the menu pay buttons
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class payViewListener implements ActionListener{
	
	private int code;
	private JFrame jf;
	private JPanel jp;
    
    public payViewListener(int code, JFrame jf, JPanel jp) {
        
		this.code = code;
		this.jf = jf;
		this.jp = jp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("EFECTIVO") || e.getActionCommand().equals("CASH") 
			|| e.getActionCommand().equals("TARJETA") || e.getActionCommand().equals("CARD")) {

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

			jp.setVisible(true); //Panel visible
			jf.setContentPane(jp); //Indicar panel como principal
			jf.revalidate();
			
		}
        
    }
}
