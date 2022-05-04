import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class allListener implements ActionListener{
	
	Container cp;
    
    public allListener(Container cp) {
        this.cp = cp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int ret = JOptionPane.showConfirmDialog(cp, "¿Estas seguro?\nSi seleccionas \"Si\" irás directamente a la pantalla de pago", "¿Estas seguro?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
        if (ret == 0) {
            System.out.println("SI");
        }
        else {
            System.out.println("NO");
        }
    }
}
