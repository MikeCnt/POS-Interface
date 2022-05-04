/**
	Second View for the POS (Point of Sale), where we can select which table are we working with and make reservations
 */

import javax.swing.*;
import java.awt.*;

public class mapView {
	public static void main(String[] args) {

		JFrame jf = new JFrame("Mapa");
		
		BorderLayout bl = new BorderLayout();
		bl.setHgap(20);
		bl.setVgap(20);

		JPanel jp = new JPanel(bl);

		jf.setContentPane(jp);


		//FlowLayout for the top panel

		FlowLayout flNorth = new FlowLayout();

		flNorth.setAlignment(FlowLayout.CENTER);
		flNorth.setHgap(5);
		flNorth.setVgap(5);

		JPanel north = new JPanel(flNorth);

		JButton calendar = new JButton("c");
		calendar.setPreferredSize(new Dimension(50, 50));

		north.add(calendar);


		//GridLayout for the map in the center

		GridLayout gl = new GridLayout(3,5);

		gl.setHgap(20);
		gl.setVgap(20);

		JPanel center = new JPanel(gl);

		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		
		JButton inv1 = new JButton();
		inv1.setOpaque(false);
		inv1.setContentAreaFilled(false);
		inv1.setBorderPainted(false);
		JButton inv2 = new JButton();
		inv2.setOpaque(false);
		inv2.setContentAreaFilled(false);
		inv2.setBorderPainted(false);
		JButton inv3 = new JButton();
		inv3.setOpaque(false);
		inv3.setContentAreaFilled(false);
		inv3.setBorderPainted(false);
		JButton inv4 = new JButton();
		inv4.setOpaque(false);
		inv4.setContentAreaFilled(false);
		inv4.setBorderPainted(false);
		JButton inv5 = new JButton();
		inv5.setOpaque(false);
		inv5.setContentAreaFilled(false);
		inv5.setBorderPainted(false);
		JButton inv6 = new JButton();
		inv6.setOpaque(false);
		inv6.setContentAreaFilled(false);
		inv6.setBorderPainted(false);
		JButton inv7 = new JButton();
		inv7.setOpaque(false);
		inv7.setContentAreaFilled(false);
		inv7.setBorderPainted(false);
		
		center.add(button1);
		center.add(inv1);
		center.add(button2);
		center.add(inv2);
		center.add(button3);
		center.add(inv3);
		center.add(button4);
		center.add(inv4);
		center.add(button5);
		center.add(inv5);
		center.add(button6);
		center.add(inv6);
		center.add(button7);
		center.add(inv7);
		center.add(button8);



		//FlowLayout for the back button

		FlowLayout flSouth = new FlowLayout();

		flSouth.setAlignment(FlowLayout.RIGHT);
		flSouth.setHgap(20);
		flSouth.setVgap(20);

		JPanel south = new JPanel(flSouth);

		JButton back = new JButton("Atras");
		
		south.add(back);


		//Invisible panel for restaurant bar

		FlowLayout flEast = new FlowLayout();

		flEast.setAlignment(FlowLayout.CENTER);
		flEast.setHgap(5);
		flEast.setVgap(5);

		JPanel east = new JPanel(flSouth);

		JButton invEast = new JButton();
		invEast.setOpaque(false);
		invEast.setContentAreaFilled(false);
		invEast.setBorderPainted(false);
		invEast.setPreferredSize(new Dimension(350, 100));

		east.add(invEast);
		


		//Invisible panel for west separation

		FlowLayout flWest = new FlowLayout();

		flWest.setAlignment(FlowLayout.CENTER);
		flWest.setHgap(5);
		flWest.setVgap(5);

		JPanel west = new JPanel(flWest);

		JButton invWest = new JButton();
		invWest.setOpaque(false);
		invWest.setContentAreaFilled(false);
		invWest.setBorderPainted(false);
		invWest.setPreferredSize(new Dimension(20, 20));
		west.add(invWest);


		//Añadimos los sub-paneles al panel principal de BorderLayout

		jp.add(north, BorderLayout.NORTH);
		jp.add(center, BorderLayout.CENTER);
		jp.add(south, BorderLayout.SOUTH);
		jp.add(east, BorderLayout.EAST);
		jp.add(west, BorderLayout.WEST);


        
		jf.setSize(1920, 1080);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);		
	}
}