/**
	X View for the POS (Point of Sale), where we can confirm our actions
 */

import javax.swing.*;
import java.awt.*;

public class menuPayButtons {
	public static void main(String[] args) {

		
		JFrame jf = new JFrame("Botones");
    
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		JButton cancel = new JButton("Cancelar");
		cancel.addActionListener(new menuPayButtonsListener(jp));
		jp.add(cancel);
		JButton selected = new JButton("Seleccionados");
		selected.addActionListener(new menuPayButtonsListener(jp));
		jp.add(selected);
		JButton all = new JButton("Todos");
		all.addActionListener(new menuPayButtonsListener(jp));
		jp.add(all);

		
		Container cp = jf.getContentPane();
		cp.add(jp);

			
		jf.setSize(1920, 1080);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
