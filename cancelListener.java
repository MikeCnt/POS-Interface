import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class cancelListener implements ActionListener{
	
	Container cp;
    
    public cancelListener(Container cp) {
        this.cp = cp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int ret = JOptionPane.showConfirmDialog(cp, "¡¡CUIDADO!!\nEsta accion borrara TODA la cuenta de la mesa.\n¿Quieres continuar?", "¡CUIDADO!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);  
                
        if (ret == 0) {
            System.out.println("SI");
        }
        else {
            System.out.println("NO");
        }
    }
}
