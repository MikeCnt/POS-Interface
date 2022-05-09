import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MyJMenuListener implements ActionListener{
    
    private JMenuItem calculator;
    private JMenuItem personalInfo;
    private JMenuItem calendar;
    private JMenuItem languaje;

    public MyJMenuListener(JMenuItem calculator, JMenuItem personalInfo, JMenuItem calendar){
        
        this.calculator = calculator;
        this.personalInfo = personalInfo;
        this.calendar = calendar;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(((JMenuItem)e.getSource()) == calculator){
            Calculator calc = new Calculator();
            calc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }else if(((JMenuItem)e.getSource()) == personalInfo){
            // ACCION PARA INFORMACION PERSONAL
        }else if(((JMenuItem)e.getSource()) == calendar){
            // ACCION PARA CALENDARIO
        }else if(((JMenuItem)e.getSource()) == languaje){
            // ACCION PARA EL IDIOMA
        }
    }
}
