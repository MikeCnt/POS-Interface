import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
public class menuButtonListener implements ActionListener{

    private String item;
    private JPanel centralPanel;
    private JPanel oldPanel;
    private JPanel newPanel;
    private JFrame frame;
    
    public menuButtonListener(String code, String name){

        addItem(code);
        addItem(name);

    }

    public menuButtonListener(String item, JPanel centralPanel, JPanel oldPanel, JPanel newPanel, JFrame frame){
        this.item = item;
        this.centralPanel = centralPanel;
        this.oldPanel = oldPanel;
        this.newPanel = newPanel;
        this.frame = frame;
    }

    public void addItem(String item){

        File f = null;
        FileWriter fw = null;
        PrintWriter pw = null;

        try{

            f = new File("bill.txt");
            fw = new FileWriter(f, true);
            pw = new PrintWriter(fw);

            pw.print(item + ",");

        }catch(Exception exc){
            exc.printStackTrace();
        }finally{
            try{
                if(fw != null){
                    fw.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){

        addItem(item);
    }
}
