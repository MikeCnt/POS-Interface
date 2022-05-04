/*
    Listener para los botones de pago del menu
*/

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class menuPayButtonsListener implements ActionListener{
	
	Container cp;
    
    public menuPayButtonsListener(Container cp) {
        this.cp = cp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int ret = JOptionPane.showConfirmDialog(cp, "¡¡CUIDADO!!\nEsta accion borrara TODA la cuenta de la mesa.\n¿Quieres continuar?", "¡CUIDADO!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);


        //This if is accessed if you press cancel
        if (e.getActionCommand() == "Cancelar") {
            if (ret == 0) {
                System.out.println("Cancelar Si");
            }
            else {
                System.out.println("Cancelar No");
            }
        }

        //This if is accessed if you press selected
        else if (e.getActionCommand() == "Seleccionados") {
            if (ret == 0) {
                System.out.println("Seleccionados Si");
            }
            else {
                System.out.println("Seleccionados No");
            }
        }

        //This if is accessed if you press All
        else if (e.getActionCommand() == "Todos") {
            if (ret == 0) {
                System.out.println("Todos Si");
            }
            else {
                System.out.println("Todos No");
            }
        }
                
        
    }
}
