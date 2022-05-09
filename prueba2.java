

import javax.swing.*;
import java.io.File;
import java.awt.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class prueba2 {
	public static void main(String[] args) {

//	Main JFrame
		
		JFrame jf = new JFrame("Reservas");


//	BorderLayout for the main panel and main JPanel 
		
		BorderLayout bl = new BorderLayout();
		bl.setHgap(20);
		bl.setVgap(20);

		JPanel chooseDayPanel = new JPanel(bl);

		jf.setContentPane(chooseDayPanel);
		


//		Invisible panel for north separation

		FlowLayout flNorth = new FlowLayout();

		flNorth.setAlignment(FlowLayout.CENTER);
		flNorth.setHgap(5);
		flNorth.setVgap(5);

		JPanel north = new JPanel(flNorth);

		JButton invNorth = new JButton();
		invNorth.setOpaque(false);
		invNorth.setContentAreaFilled(false);
		invNorth.setBorderPainted(false);
		invNorth.setPreferredSize(new Dimension(50, 150));
		north.add(invNorth);

		north.setOpaque(false);


//	GridLayout for the center

		BorderLayout blCenter = new BorderLayout();

		blCenter.setHgap(20);
		blCenter.setVgap(50);

		JPanel center = new JPanel(blCenter);


//		Creating components for the center panel
		JLabel res = new JLabel("Días disponibles",JLabel.CENTER);
		res.setFont(new Font("Sans", Font.BOLD, 40));

		FlowLayout daysLayout = new FlowLayout();
		daysLayout.setAlignment(FlowLayout.CENTER);

		JPanel centerInnerPanel = new JPanel(daysLayout);
		centerInnerPanel.setOpaque(false);


		try {
			File reservationsTemp = new File("reservationsTemp.txt");
			Scanner reservationsTempReader = new Scanner(reservationsTemp);

			String data = reservationsTempReader.nextLine();
			String[] tokens = data.split(",", 2); 
			String days = tokens[1];

			String[] day = days.split(",");

			for(int i = 0; i < day.length; i++) {
				
				JButton dayBtn = new JButton(day[i]);
				dayBtn.setPreferredSize(new Dimension(70,70));
				dayBtn.addActionListener(new selectDayListener());
				centerInnerPanel.add(dayBtn);
				
			}

			reservationsTempReader.close();
		
		} catch (FileNotFoundException exc) {
    
			System.out.println("File Not Found.");
			exc.printStackTrace();

		}
		
//		Adding all the components in order to the GridLayout


		center.setOpaque(false);
		center.add(res, BorderLayout.NORTH);
		center.add(centerInnerPanel, BorderLayout.CENTER);



//		FlowLayout for the back button

		FlowLayout flSouth = new FlowLayout();

		flSouth.setAlignment(FlowLayout.RIGHT);
		flSouth.setHgap(20);
		flSouth.setVgap(20);

		JPanel south = new JPanel(flSouth);

		JButton back = new JButton("Atras");
		back.setPreferredSize(new Dimension(100,50));
		back.addActionListener(new mapViewListener());
		
		south.add(back);

		south.setOpaque(false);


//		Invisible panel for restaurant bar

		BorderLayout flEast = new BorderLayout();

		JPanel east = new JPanel(flEast);

		JButton invEast = new JButton();
		invEast.setOpaque(false);
		invEast.setContentAreaFilled(false);
		invEast.setBorderPainted(false);
		invEast.setPreferredSize(new Dimension(20, 20));


		east.add(invEast, BorderLayout.CENTER);

		east.setOpaque(false);
		


//		Invisible panel for west separation

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

		west.setOpaque(false);


//		Añadimos los sub-paneles al panel principal de BorderLayout
		
		chooseDayPanel.add(north, BorderLayout.NORTH);
		chooseDayPanel.add(center, BorderLayout.CENTER);
		chooseDayPanel.add(south, BorderLayout.SOUTH);
		chooseDayPanel.add(east, BorderLayout.EAST);
		chooseDayPanel.add(west, BorderLayout.WEST);
		chooseDayPanel.setOpaque(false);



		jf.setBackground(new Color(90,142,253));

		jf.revalidate();
		jf.repaint();

		jf.setSize(1920, 1080);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);		
	}
}