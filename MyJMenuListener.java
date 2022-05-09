import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MyJMenuListener implements ActionListener{
    
    private JMenuItem calculator;

    public MyJMenuListener(JMenuItem calculator){
        
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(((JMenuItem)e.getSource()) == calculator){
            Calculator calc = new Calculator();
            calc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }
}
