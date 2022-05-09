/**
 * First View for the POS (Point of Sale), where we can select which worker are we
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class usersView {
    public static void main(String[] args){

        JFrame jf = new JFrame();


/****************************************************
 * 						    *
 * 		  Panel Creation                    *
 * 						    *
*****************************************************/



//	userViewPanel

        GridBagLayout glUsersView = new GridBagLayout();
        GridBagConstraints cUsersView = new GridBagConstraints();
        cUsersView.fill = GridBagConstraints.NONE;
        cUsersView.insets = new Insets(50, 50, 50, 50);
        JPanel usersViewPanel = new JPanel(glUsersView);

        jf.setContentPane(usersViewPanel);


//	mapViewPanel 
		
        BorderLayout blMapView = new BorderLayout();
        blMapView.setHgap(20);
        blMapView.setVgap(20);

        JPanel mapViewPanel = new JPanel(blMapView);


//	reservationTablesPanel
		
        BorderLayout blReservationTables = new BorderLayout();
        blReservationTables.setHgap(20);
        blReservationTables.setVgap(20);

        JPanel reservationTablesPanel = new JPanel(blReservationTables);


//	chooseDayPanel
		
        BorderLayout blChooseDay = new BorderLayout();
        blChooseDay.setHgap(20);
        blChooseDay.setVgap(20);

        JPanel chooseDayPanel = new JPanel(blChooseDay);



        /****************************************************
         * 						    *
         * 		     Users View                     *
         * 						    *
        *****************************************************/
        
        
//      Leer de la base de datos para crear los trabajadores necesarios
        readDB readDBUsersView = new readDB();
        Vector dataUsersView = readDBUsersView.readDBdata("name");
        int nWorkersUsersView = dataUsersView.size();
        int indexUsersView = 0;

//      Establecemos el fondo de pantalla
        usersViewPanel.setBackground(new Color(73,115,203));

        if (nWorkersUsersView % 2 == 0){

                int auxUsersView = nWorkersUsersView / 2;
                for (int i = 0; i < auxUsersView; i ++) {
                        for (int j = 0; j < 2; j ++) {

                                cUsersView.gridx = j;
                                cUsersView.gridy = i;
                        
                                String nameUsersView = (String)dataUsersView.elementAt(indexUsersView);
                                JButton buttonUsersView = new JButton(nameUsersView);
                                buttonUsersView.addActionListener(new usersViewListener(jf, mapViewPanel));
                                buttonUsersView.setForeground(Color.WHITE);
                                buttonUsersView.setPreferredSize(new Dimension(350, 100));
                                //button.setBorder(new ButtonStyle(40));
                                buttonUsersView.setBackground(new Color(97,104,135));
                                usersViewPanel.add(buttonUsersView,cUsersView);
                                indexUsersView++;
                                
                        }
                }
        }else{
                int auxIUsersView=0, auxJUsersView=0;
                int auxUsersView = nWorkersUsersView / 2;
                for (int i = 0; i < auxUsersView; i ++) {
                        for (int j = 0; j < 2; j ++) {

                                cUsersView.gridx = j;
                                cUsersView.gridy = i;

                                String nameUsersView = (String)dataUsersView.elementAt(indexUsersView);
                                JButton buttonUsersView = new JButton(nameUsersView);
                                buttonUsersView.addActionListener(new usersViewListener(jf, mapViewPanel));
                                buttonUsersView.setForeground(Color.WHITE);
                                buttonUsersView.setPreferredSize(new Dimension(350, 100));
                                //button.setBorder(new ButtonStyle(40));
                                buttonUsersView.setBackground(new Color(97,104,135));
                                
                                usersViewPanel.add(buttonUsersView,cUsersView);
                                indexUsersView++;
                                auxIUsersView = i;
                                auxJUsersView = j;
                        }
                }
               
                auxJUsersView--;
                auxIUsersView++;

                cUsersView.gridx = auxJUsersView;
                cUsersView.gridy = auxIUsersView;

                String nameUsersView = (String)dataUsersView.elementAt(indexUsersView);
                JButton buttonUsersView = new JButton(nameUsersView);
                buttonUsersView.addActionListener(new usersViewListener(jf, mapViewPanel));
                buttonUsersView.setForeground(Color.WHITE);
                buttonUsersView.setPreferredSize(new Dimension(350, 100));
                buttonUsersView.setBackground(new Color(97,104,135));
                usersViewPanel.add(buttonUsersView,cUsersView);

        }




/****************************************************
 * 						    *
 *                Map View Panel                    *
 * 					            *
*****************************************************/
		


//	Panel for north label

        FlowLayout flNorthMapView = new FlowLayout();

        flNorthMapView.setAlignment(FlowLayout.CENTER);

        JPanel northMapView = new JPanel(flNorthMapView);

        ImageIcon imageCalendarMapView = new ImageIcon("images/Calendar.png");
        JButton jbNorthMapView = new JButton("Reservas", imageCalendarMapView);
        
        jbNorthMapView.setContentAreaFilled(false);
        jbNorthMapView.setBorderPainted(false);
        jbNorthMapView.setFont(new Font("Sans", Font.PLAIN, 20));
        jbNorthMapView.addActionListener(new mapViewListener(jf, reservationTablesPanel));
        northMapView.add(jbNorthMapView);
        northMapView.setOpaque(false);


//      GridLayout for the map in the center

        GridLayout glMapView = new GridLayout(3,5);

        glMapView.setHgap(20);
        glMapView.setVgap(20);

        JPanel centerMapView = new JPanel(glMapView);


//	Numbered Buttons

        ImageIcon table1MapView = new ImageIcon("images/table1.png");
        JButton button1MapView = new JButton("1",table1MapView);
        button1MapView.addActionListener(new mapViewListener());
        button1MapView.setFont(new Font("Arial", Font.PLAIN, 1));
        button1MapView.setContentAreaFilled(false);
        button1MapView.setBorderPainted(false);

        ImageIcon table2MapView = new ImageIcon("images/table2.png");
        JButton button2MapView = new JButton("2",table2MapView);
        button2MapView.addActionListener(new mapViewListener());
        button2MapView.setFont(new Font("Arial", Font.PLAIN, 1));
        button2MapView.setContentAreaFilled(false);
        button2MapView.setBorderPainted(false);

        ImageIcon table3MapView = new ImageIcon("images/table3.png");
        JButton button3MapView = new JButton("3",table3MapView);
        button3MapView.addActionListener(new mapViewListener());
        button3MapView.setFont(new Font("Arial", Font.PLAIN, 1));
        button3MapView.setContentAreaFilled(false);
        button3MapView.setBorderPainted(false);

        ImageIcon table4MapView = new ImageIcon("images/table4.png");
        JButton button4MapView = new JButton("4",table4MapView);
        button4MapView.addActionListener(new mapViewListener());
        button4MapView.setFont(new Font("Arial", Font.PLAIN, 1));
        button4MapView.setContentAreaFilled(false);
        button4MapView.setBorderPainted(false);

        ImageIcon table5MapView = new ImageIcon("images/table5.png");
        JButton button5MapView = new JButton("5",table5MapView);
        button5MapView.addActionListener(new mapViewListener());
        button5MapView.setFont(new Font("Arial", Font.PLAIN, 1));
        button5MapView.setContentAreaFilled(false);
        button5MapView.setBorderPainted(false);

        ImageIcon table6MapView = new ImageIcon("images/table6.png");
        JButton button6MapView = new JButton("6",table6MapView);
        button6MapView.addActionListener(new mapViewListener());
        button6MapView.setFont(new Font("Arial", Font.PLAIN, 1));
        button6MapView.setContentAreaFilled(false);
        button6MapView.setBorderPainted(false);

        ImageIcon table7MapView = new ImageIcon("images/table7.png");
        JButton button7MapView = new JButton("7",table7MapView);
        button7MapView.addActionListener(new mapViewListener());
        button7MapView.setFont(new Font("Arial", Font.PLAIN, 1));
        button7MapView.setContentAreaFilled(false);
        button7MapView.setBorderPainted(false);

        ImageIcon table8MapView = new ImageIcon("images/table8.png");
        JButton button8MapView = new JButton("8",table8MapView);
        button8MapView.addActionListener(new mapViewListener());
        button8MapView.setFont(new Font("Arial", Font.PLAIN, 1));
        button8MapView.setContentAreaFilled(false);
        button8MapView.setBorderPainted(false);


//	Invisible buttons

        JButton inv1MapView = new JButton();
        inv1MapView.setOpaque(false);
        inv1MapView.setContentAreaFilled(false);
        inv1MapView.setBorderPainted(false);
        JButton inv2MapView = new JButton();
        inv2MapView.setOpaque(false);
        inv2MapView.setContentAreaFilled(false);
        inv2MapView.setBorderPainted(false);
        JButton inv3MapView = new JButton();
        inv3MapView.setOpaque(false);
        inv3MapView.setContentAreaFilled(false);
        inv3MapView.setBorderPainted(false);
        JButton inv4MapView = new JButton();
        inv4MapView.setOpaque(false);
        inv4MapView.setContentAreaFilled(false);
        inv4MapView.setBorderPainted(false);
        JButton inv5MapView = new JButton();
        inv5MapView.setOpaque(false);
        inv5MapView.setContentAreaFilled(false);
        inv5MapView.setBorderPainted(false);
        JButton inv6MapView = new JButton();
        inv6MapView.setOpaque(false);
        inv6MapView.setContentAreaFilled(false);
        inv6MapView.setBorderPainted(false);
        JButton inv7MapView = new JButton();
        inv7MapView.setOpaque(false);
        inv7MapView.setContentAreaFilled(false);
        inv7MapView.setBorderPainted(false);
        
        
//	Adding all the buttons in order to the GridLayout

        centerMapView.add(button1MapView);
        centerMapView.add(inv1MapView);
        centerMapView.add(button2MapView);
        centerMapView.add(inv2MapView);
        centerMapView.add(button3MapView);
        centerMapView.add(inv3MapView);
        centerMapView.add(button4MapView);
        centerMapView.add(inv4MapView);
        centerMapView.add(button5MapView);
        centerMapView.add(inv5MapView);
        centerMapView.add(button6MapView);
        centerMapView.add(inv6MapView);
        centerMapView.add(button7MapView);
        centerMapView.add(inv7MapView);
        centerMapView.add(button8MapView);

        centerMapView.setOpaque(false);



//	FlowLayout for the back button

        FlowLayout flSouthMapView = new FlowLayout();

        flSouthMapView.setAlignment(FlowLayout.RIGHT);
        flSouthMapView.setHgap(20);
        flSouthMapView.setVgap(20);

        JPanel southMapView = new JPanel(flSouthMapView);

        JButton backMapView = new JButton("Atras");
        backMapView.setPreferredSize(new Dimension(100,50));
        backMapView.addActionListener(new mapViewListener());
        backMapView.setBackground(new Color(97,104,135));
        
        southMapView.add(backMapView);

        southMapView.setOpaque(false);


//	Invisible panel for restaurant bar

        BorderLayout blEastMapView = new BorderLayout();

        JPanel eastMapView = new JPanel(blEastMapView);

        JButton invEastMapView = new JButton();
        invEastMapView.setOpaque(false);
        invEastMapView.setContentAreaFilled(false);
        invEastMapView.setBorderPainted(false);
        invEastMapView.setPreferredSize(new Dimension(300, 100));

        JButton invBarLeftMapView = new JButton();
        invBarLeftMapView.setPreferredSize(new Dimension(50,10));
        invBarLeftMapView.setContentAreaFilled(false);
        invBarLeftMapView.setBorderPainted(false);
        JPanel barLeftMapView = new JPanel(new FlowLayout());
        barLeftMapView.setBackground(new Color(206,152,67));
        barLeftMapView.add(invBarLeftMapView);

        JButton invBarBottomMapView = new JButton();
        invBarBottomMapView.setPreferredSize(new Dimension(10,50));
        invBarBottomMapView.setContentAreaFilled(false);
        invBarBottomMapView.setBorderPainted(false);
        JPanel barBottomMapView = new JPanel(new FlowLayout());
        barBottomMapView.setBackground(new Color(206,152,67));
        barBottomMapView.add(invBarBottomMapView);



        eastMapView.add(invEastMapView, BorderLayout.CENTER);
        eastMapView.add(barLeftMapView, BorderLayout.WEST);
        eastMapView.add(barBottomMapView, BorderLayout.SOUTH);

        eastMapView.setOpaque(false);
        


//	Invisible panel for west separation

        FlowLayout flWestMapView = new FlowLayout();

        flWestMapView.setAlignment(FlowLayout.CENTER);
        flWestMapView.setHgap(5);
        flWestMapView.setVgap(5);

        JPanel westMapView = new JPanel(flWestMapView);

        JButton invWestMapView = new JButton();
        invWestMapView.setOpaque(false);
        invWestMapView.setContentAreaFilled(false);
        invWestMapView.setBorderPainted(false);
        invWestMapView.setPreferredSize(new Dimension(20, 20));
        westMapView.add(invWestMapView);

        westMapView.setOpaque(false);


//	Añadimos los sub-paneles al panel principal de BorderLayout
        
        mapViewPanel.add(northMapView, BorderLayout.NORTH);
        mapViewPanel.add(centerMapView, BorderLayout.CENTER);
        mapViewPanel.add(southMapView, BorderLayout.SOUTH);
        mapViewPanel.add(eastMapView, BorderLayout.EAST);
        mapViewPanel.add(westMapView, BorderLayout.WEST);

        mapViewPanel.setBackground(Color.green);

        mapViewPanel.setOpaque(false);
        
        
        
        
/****************************************************
 * 					            *
 * 	      Reservation Tables Panel 	            *
 * 						    *
*****************************************************/


//	GridLayout for the map in the center

        GridLayout glReservationTables = new GridLayout(3,5);

        glReservationTables.setHgap(20);
        glReservationTables.setVgap(20);

        JPanel centerReservationTables = new JPanel(glReservationTables);


//	Numbered Buttons

        ImageIcon table1ReservationTables = new ImageIcon("images/table1.png");
        JButton button1ReservationTables = new JButton("1",table1ReservationTables);
        button1ReservationTables.addActionListener(new ReservationsListener(jf, chooseDayPanel));
        button1ReservationTables.setFont(new Font("Arial", Font.PLAIN, 1));
        button1ReservationTables.setContentAreaFilled(false);
        button1ReservationTables.setBorderPainted(false);

        ImageIcon table2ReservationTables = new ImageIcon("images/table2.png");
        JButton button2ReservationTables = new JButton("2",table2ReservationTables);
        button2ReservationTables.addActionListener(new ReservationsListener(jf, chooseDayPanel));
        button2ReservationTables.setFont(new Font("Arial", Font.PLAIN, 1));
        button2ReservationTables.setContentAreaFilled(false);
        button2ReservationTables.setBorderPainted(false);

        ImageIcon table3ReservationTables = new ImageIcon("images/table3.png");
        JButton button3ReservationTables = new JButton("3",table3ReservationTables);
        button3ReservationTables.addActionListener(new ReservationsListener(jf, chooseDayPanel));
        button3ReservationTables.setFont(new Font("Arial", Font.PLAIN, 1));
        button3ReservationTables.setContentAreaFilled(false);
        button3ReservationTables.setBorderPainted(false);

        ImageIcon table4ReservationTables = new ImageIcon("images/table4.png");
        JButton button4ReservationTables = new JButton("4",table4ReservationTables);
        button4ReservationTables.addActionListener(new ReservationsListener(jf, chooseDayPanel));
        button4ReservationTables.setFont(new Font("Arial", Font.PLAIN, 1));
        button4ReservationTables.setContentAreaFilled(false);
        button4ReservationTables.setBorderPainted(false);

        ImageIcon table5ReservationTables = new ImageIcon("images/table5.png");
        JButton button5ReservationTables = new JButton("5",table5ReservationTables);
        button5ReservationTables.addActionListener(new ReservationsListener(jf, chooseDayPanel));
        button5ReservationTables.setFont(new Font("Arial", Font.PLAIN, 1));
        button5ReservationTables.setContentAreaFilled(false);
        button5ReservationTables.setBorderPainted(false);

        ImageIcon table6ReservationTables = new ImageIcon("images/table6.png");
        JButton button6ReservationTables = new JButton("6",table6ReservationTables);
        button6ReservationTables.addActionListener(new ReservationsListener(jf, chooseDayPanel));
        button6ReservationTables.setFont(new Font("Arial", Font.PLAIN, 1));
        button6ReservationTables.setContentAreaFilled(false);
        button6ReservationTables.setBorderPainted(false);

        ImageIcon table7ReservationTables = new ImageIcon("images/table7.png");
        JButton button7ReservationTables = new JButton("7",table7ReservationTables);
        button7ReservationTables.addActionListener(new ReservationsListener(jf, chooseDayPanel));
        button7ReservationTables.setFont(new Font("Arial", Font.PLAIN, 1));
        button7ReservationTables.setContentAreaFilled(false);
        button7ReservationTables.setBorderPainted(false);

        ImageIcon table8ReservationTables = new ImageIcon("images/table8.png");
        JButton button8ReservationTables = new JButton("8",table8ReservationTables);
        button8ReservationTables.addActionListener(new ReservationsListener(jf, chooseDayPanel));
        button8ReservationTables.setFont(new Font("Arial", Font.PLAIN, 1));
        button8ReservationTables.setContentAreaFilled(false);
        button8ReservationTables.setBorderPainted(false);


//	Invisible buttons

        JButton inv1ReservationTables = new JButton();
        inv1ReservationTables.setOpaque(false);
        inv1ReservationTables.setContentAreaFilled(false);
        inv1ReservationTables.setBorderPainted(false);
        JButton inv2ReservationTables = new JButton();
        inv2ReservationTables.setOpaque(false);
        inv2ReservationTables.setContentAreaFilled(false);
        inv2ReservationTables.setBorderPainted(false);
        JButton inv3ReservationTables = new JButton();
        inv3ReservationTables.setOpaque(false);
        inv3ReservationTables.setContentAreaFilled(false);
        inv3ReservationTables.setBorderPainted(false);
        JButton inv4ReservationTables = new JButton();
        inv4ReservationTables.setOpaque(false);
        inv4ReservationTables.setContentAreaFilled(false);
        inv4ReservationTables.setBorderPainted(false);
        JButton inv5ReservationTables = new JButton();
        inv5ReservationTables.setOpaque(false);
        inv5ReservationTables.setContentAreaFilled(false);
        inv5ReservationTables.setBorderPainted(false);
        JButton inv6ReservationTables = new JButton();
        inv6ReservationTables.setOpaque(false);
        inv6ReservationTables.setContentAreaFilled(false);
        inv6ReservationTables.setBorderPainted(false);
        JButton inv7ReservationTables = new JButton();
        inv7ReservationTables.setOpaque(false);
        inv7ReservationTables.setContentAreaFilled(false);
        inv7ReservationTables.setBorderPainted(false);
        
        
//	Adding all the buttons in order to the GridLayout

        centerReservationTables.add(button1ReservationTables);
        centerReservationTables.add(inv1ReservationTables);
        centerReservationTables.add(button2ReservationTables);
        centerReservationTables.add(inv2ReservationTables);
        centerReservationTables.add(button3ReservationTables);
        centerReservationTables.add(inv3ReservationTables);
        centerReservationTables.add(button4ReservationTables);
        centerReservationTables.add(inv4ReservationTables);
        centerReservationTables.add(button5ReservationTables);
        centerReservationTables.add(inv5ReservationTables);
        centerReservationTables.add(button6ReservationTables);
        centerReservationTables.add(inv6ReservationTables);
        centerReservationTables.add(button7ReservationTables);
        centerReservationTables.add(inv7ReservationTables);
        centerReservationTables.add(button8ReservationTables);

        centerReservationTables.setOpaque(false);



//	FlowLayout for the back button

        FlowLayout flSouthReservationTables = new FlowLayout();

        flSouthReservationTables.setAlignment(FlowLayout.RIGHT);
        flSouthReservationTables.setHgap(20);
        flSouthReservationTables.setVgap(20);

        JPanel southReservationTables = new JPanel(flSouthReservationTables);

        JButton backReservationTables = new JButton("Atras");
        backReservationTables.setPreferredSize(new Dimension(100,50));
        backReservationTables.addActionListener(new ReservationsListener(jf, mapViewPanel));
        backReservationTables.setBackground(new Color(97,104,135));
        
        southReservationTables.add(backReservationTables);

        southReservationTables.setOpaque(false);


//	Invisible panel for restaurant bar

        BorderLayout flEastReservationTables = new BorderLayout();

        JPanel eastReservationTables = new JPanel(flEastReservationTables);

        JButton invEastReservationTables = new JButton();
        invEastReservationTables.setOpaque(false);
        invEastReservationTables.setContentAreaFilled(false);
        invEastReservationTables.setBorderPainted(false);
        invEastReservationTables.setPreferredSize(new Dimension(300, 100));

        JButton invBarLeftReservationTables = new JButton();
        invBarLeftReservationTables.setPreferredSize(new Dimension(50,10));
        invBarLeftReservationTables.setContentAreaFilled(false);
        invBarLeftReservationTables.setBorderPainted(false);
        JPanel barLeftReservationTables = new JPanel(new FlowLayout());
        barLeftReservationTables.setBackground(new Color(206,152,67));
        barLeftReservationTables.add(invBarLeftReservationTables);

        JButton invBarBottomReservationTables = new JButton();
        invBarBottomReservationTables.setPreferredSize(new Dimension(10,50));
        invBarBottomReservationTables.setContentAreaFilled(false);
        invBarBottomReservationTables.setBorderPainted(false);
        JPanel barBottomReservationTables = new JPanel(new FlowLayout());
        barBottomReservationTables.setBackground(new Color(206,152,67));
        barBottomReservationTables.add(invBarBottomReservationTables);



        eastReservationTables.add(invEastReservationTables, BorderLayout.CENTER);
        eastReservationTables.add(barLeftReservationTables, BorderLayout.WEST);
        eastReservationTables.add(barBottomReservationTables, BorderLayout.SOUTH);

        eastReservationTables.setOpaque(false);
        


//	Invisible panel for west separation

        FlowLayout flWestReservationTables = new FlowLayout();

        flWestReservationTables.setAlignment(FlowLayout.CENTER);
        flWestReservationTables.setHgap(5);
        flWestReservationTables.setVgap(5);

        JPanel westReservationTables = new JPanel(flWestReservationTables);

        JButton invWestReservationTables = new JButton();
        invWestReservationTables.setOpaque(false);
        invWestReservationTables.setContentAreaFilled(false);
        invWestReservationTables.setBorderPainted(false);
        invWestReservationTables.setPreferredSize(new Dimension(20, 20));
        westReservationTables.add(invWestReservationTables);

        westReservationTables.setOpaque(false);
        


//	Panel for north label

        FlowLayout flNorthReservationTables = new FlowLayout();

        flNorthReservationTables.setAlignment(FlowLayout.CENTER);

        JPanel northReservationTables = new JPanel(flNorthReservationTables);

        JLabel jlNorthReservationTables = new JLabel("ELIGE UNA MESA");

        jlNorthReservationTables.setFont(new Font("Sans", Font.PLAIN, 20));
        northReservationTables.add(jlNorthReservationTables);


//	Añadimos los sub-paneles al panel principal de BorderLayout
        
        reservationTablesPanel.add(centerReservationTables, BorderLayout.CENTER);
        reservationTablesPanel.add(southReservationTables, BorderLayout.SOUTH);
        reservationTablesPanel.add(eastReservationTables, BorderLayout.EAST);
        reservationTablesPanel.add(westReservationTables, BorderLayout.WEST);
        reservationTablesPanel.add(northReservationTables, BorderLayout.NORTH);
        reservationTablesPanel.setOpaque(false);


        /****************************************************
         * 						    *
         * 	        Choose Day Panel 		    *
         * 						    *
        *****************************************************/
        


//	Invisible panel for north separation

        FlowLayout flNorthChooseDay = new FlowLayout();

        flNorthChooseDay.setAlignment(FlowLayout.CENTER);
        flNorthChooseDay.setHgap(5);
        flNorthChooseDay.setVgap(5);

        JPanel northChooseDay = new JPanel(flNorthChooseDay);

        JButton invNorthChooseDay = new JButton();
        invNorthChooseDay.setOpaque(false);
        invNorthChooseDay.setContentAreaFilled(false);
        invNorthChooseDay.setBorderPainted(false);
        invNorthChooseDay.setPreferredSize(new Dimension(50, 150));
        northChooseDay.add(invNorthChooseDay);

        northChooseDay.setOpaque(false);


//	GridLayout for the center

        BorderLayout blCenterChooseDay = new BorderLayout();

        blCenterChooseDay.setHgap(20);
        blCenterChooseDay.setVgap(20);

        JPanel centerChooseDay = new JPanel(blCenterChooseDay);


//	Creating components for the center panel

        JLabel jlChooseDay = new JLabel("Días disponibles",JLabel.CENTER);
        jlChooseDay.setFont(new Font("Sans", Font.BOLD, 40));

        FlowLayout flChooseDay = new FlowLayout();
        flChooseDay.setAlignment(FlowLayout.CENTER);
        flChooseDay.setVgap(50);

        JPanel centerInnerPanelChooseDay = new JPanel(flChooseDay);
        centerInnerPanelChooseDay.setOpaque(false);


        try {
                File reservationsTempChooseDay = new File("reservationsTemp.txt");
                Scanner reservationsTempReaderChooseDay = new Scanner(reservationsTempChooseDay);

                String dataChooseDay = reservationsTempReaderChooseDay.nextLine();
                String[] tokensChooseDay = dataChooseDay.split(",", 2); 
                String daysChooseDay = tokensChooseDay[1];

                String[] dayChooseDay = daysChooseDay.split(",");

                for(int i = 0; i < dayChooseDay.length; i++) {
                        
                        JButton dayBtnChooseDay = new JButton(dayChooseDay[i]);
                        dayBtnChooseDay.setPreferredSize(new Dimension(70,70));
                        dayBtnChooseDay.addActionListener(new selectDayListener(jf, mapViewPanel));
                        dayBtnChooseDay.setBackground(new Color(97,104,135));
                        centerInnerPanelChooseDay.add(dayBtnChooseDay);
                        
                }

                reservationsTempReaderChooseDay.close();
        
        } catch (FileNotFoundException exc) {

                System.out.println("File Not Found.");
                exc.printStackTrace();

        }
        

//	Adding all the components in order to the GridLayout

        centerChooseDay.setOpaque(false);
        centerChooseDay.add(jlChooseDay, BorderLayout.NORTH);
        centerChooseDay.add(centerInnerPanelChooseDay, BorderLayout.CENTER);



//      FlowLayout for the back button

        FlowLayout flSouthChooseDay = new FlowLayout();

        flSouthChooseDay.setAlignment(FlowLayout.RIGHT);
        flSouthChooseDay.setHgap(20);
        flSouthChooseDay.setVgap(20);

        JPanel southChooseDay = new JPanel(flSouthChooseDay);

        JButton backChooseDay = new JButton("Atras");
        backChooseDay.setPreferredSize(new Dimension(100,50));
        backChooseDay.addActionListener(new selectDayListener(jf, reservationTablesPanel));
        backChooseDay.setBackground(new Color(97,104,135));
        
        southChooseDay.add(backChooseDay);

        southChooseDay.setOpaque(false);


//	Invisible panel for restaurant bar

        BorderLayout flEastChooseDay = new BorderLayout();

        JPanel eastChooseDay = new JPanel(flEastChooseDay);

        JButton invEastChooseDay = new JButton();
        invEastChooseDay.setOpaque(false);
        invEastChooseDay.setContentAreaFilled(false);
        invEastChooseDay.setBorderPainted(false);
        invEastChooseDay.setPreferredSize(new Dimension(20, 20));


        eastChooseDay.add(invEastChooseDay, BorderLayout.CENTER);

        eastChooseDay.setOpaque(false);
        


//	Invisible panel for west separation

        FlowLayout flWestChooseDay = new FlowLayout();

        flWestChooseDay.setAlignment(FlowLayout.CENTER);
        flWestChooseDay.setHgap(5);
        flWestChooseDay.setVgap(5);

        JPanel westChooseDay = new JPanel(flWestChooseDay);

        JButton invWestChooseDay = new JButton();
        invWestChooseDay.setOpaque(false);
        invWestChooseDay.setContentAreaFilled(false);
        invWestChooseDay.setBorderPainted(false);
        invWestChooseDay.setPreferredSize(new Dimension(20, 20));
        westChooseDay.add(invWestChooseDay);

        westChooseDay.setOpaque(false);


//	Añadimos los sub-paneles al panel principal de BorderLayout
        
        chooseDayPanel.add(northChooseDay, BorderLayout.NORTH);
        chooseDayPanel.add(centerChooseDay, BorderLayout.CENTER);
        chooseDayPanel.add(southChooseDay, BorderLayout.SOUTH);
        chooseDayPanel.add(eastChooseDay, BorderLayout.EAST);
        chooseDayPanel.add(westChooseDay, BorderLayout.WEST);
        chooseDayPanel.setOpaque(false);


        /****************************************************
         * 						    *
         * 	        JFrame Properties		    *
         * 						    *
        *****************************************************/
        


        jf.setBackground(new Color(90,142,253));
        jf.revalidate();
        jf.repaint();

        jf.setSize(1920, 1080);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}