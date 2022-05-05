/**
	Last View for the POS (Point of Sale), payment frame
 */

import javax.swing.*;
import java.awt.*;

public class payView {
	public static void main(String[] args) {

//	Main JFrame
		
		JFrame jf = new JFrame("Payment");


//	JPanel with BorderLayout to put the white square on the center of the blue backgroud

		JPanel outter = new JPanel(new BorderLayout());

		jf.setContentPane(outter);
		

//	JPanel with GridLayout to put on the text and buttons

		JPanel jp = new JPanel();

		GridLayout gl = new GridLayout(7,1);
		gl.setHgap(5);
		gl.setVgap(5);

		jp.setLayout(gl);


//		JLabels with payment info

		String text = "A PAGAR\n";

		float value = 00.00f;
		String valueText = String.format("%.02f", value);
		String aux = valueText.concat(" €");

		JLabel first = new JLabel(text,JLabel.CENTER);
		first.setFont(new Font("Sans", Font.BOLD, 40));

		JLabel second = new JLabel(aux, JLabel.CENTER);
		second.setFont(new Font("Sans", Font.BOLD, 40));


//		Invisible JButton to separate price from buttons

		JButton inv = new JButton();
		inv.setOpaque(false);
		inv.setContentAreaFilled(false);
		inv.setBorderPainted(false);


//		Buttons for payment methods

		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		fl.setHgap(200);
		JPanel inner = new JPanel(fl);
		JButton cash = new JButton("EFECTIVO");
		cash.setPreferredSize(new Dimension(250,70));
		cash.addActionListener(new payViewListener(inner));
		JButton card = new JButton("TARJETA");
		card.setPreferredSize(new Dimension(250,70));
		card.addActionListener(new payViewListener(inner));
		inner.add(cash);
		inner.add(card);
		


//	Adding all the components to the GridLayout JPanel

		jp.add(first);
		jp.add(second);
		jp.add(inv);
		jp.add(inner);


//		Creating invisible buttons to separate the white box from the borders

		JButton northInv = new JButton();
		northInv.setPreferredSize(new Dimension(80,80));
		northInv.setOpaque(false);
		northInv.setContentAreaFilled(false);
		northInv.setBorderPainted(false);
		JButton southInv = new JButton();
		southInv.setPreferredSize(new Dimension(80,80));
		southInv.setOpaque(false);
		southInv.setContentAreaFilled(false);
		southInv.setBorderPainted(false);
		JButton eastInv = new JButton();
		eastInv.setPreferredSize(new Dimension(100,100));
		eastInv.setOpaque(false);
		eastInv.setContentAreaFilled(false);
		eastInv.setBorderPainted(false);
		JButton westInv = new JButton();
		westInv.setPreferredSize(new Dimension(100,100));
		westInv.setOpaque(false);
		westInv.setContentAreaFilled(false);
		westInv.setBorderPainted(false);

	
//	Adding all the components to the BorderLayout JPanel
		
		outter.add(jp, BorderLayout.CENTER);
		outter.add(northInv, BorderLayout.NORTH);
		outter.add(southInv, BorderLayout.SOUTH);
		outter.add(eastInv, BorderLayout.EAST);
		outter.add(westInv, BorderLayout.WEST);



		jf.setSize(1920, 1080);
		jf.getContentPane().setBackground(Color.BLUE);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);


	}
}
