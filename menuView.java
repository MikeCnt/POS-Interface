import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Menu view for the POS (Point of Sale), where we can select the items of the costumer's menu
 */

public class menuView {
    public static void main(String[] args){

        JFrame jf = new JFrame();
        jf.setTitle("Vista Menu");
        String code = "1";
        String name = "Antonio";

        menuButtonListener init = new menuButtonListener(code, name);

//      Añadimos la bara del menu superior y las acciones que la controlan
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu();
        JMenuItem calculator = new JMenuItem("Calculadora");
        JMenuItem personalInfo = new JMenuItem("Informacion");
        JMenuItem calendar = new JMenuItem("Calendario");
        JMenuItem languaje = new JMenuItem("Idioma");

        Image image = new ImageIcon("images/Options.png").getImage();
        menu.setIcon(new ImageIcon(image));

        Image image2 = new ImageIcon("images/Calculator.png").getImage();
        calculator.setIcon(new ImageIcon(image2));

        Image image4 = new ImageIcon("images/Calendar.png").getImage();
        calendar.setIcon(new ImageIcon(image4));

        Image image3 = new ImageIcon("images/PersonalInfo.png").getImage();
        personalInfo.setIcon(new ImageIcon(image3));

        Image image5 = new ImageIcon("images/Languaje.png").getImage();
        languaje.setIcon(new ImageIcon(image5));


        menu.add(calculator);
        menu.add(calendar);
        menu.add(personalInfo);
        menu.add(languaje);
        menubar.setLayout(new GridBagLayout());
        menubar.add(menu);

        MyJMenuListener jmListener = new MyJMenuListener(calculator, personalInfo, calendar);
        calculator.addActionListener(jmListener);

//      Creamos la primera division en dos del frame
        GridLayout gl = new GridLayout(1,2);
        JPanel centralPanel = new JPanel(gl);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();

        jp1.setBackground(Color.WHITE);
        jp2.setBackground(new Color(73,115,203));

//      Creamos los botones del panel derecho
        GridBagLayout p2gl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(50, 50, 50, 50);
        jp2.setLayout(p2gl);

//      Creamos una division del panel inferior para coger las 3/4 partes del panel izquierdo
        GridLayout gl2 = new GridLayout(2,1);
        jp1.setLayout(gl2);
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setBackground(Color.WHITE);

        GridLayout gl3 = new GridLayout(2,1);
        bottomPanel.setLayout(gl3);
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();

        jp3.setBackground(Color.WHITE);
        jp4.setBackground(new Color(73,115,203));

        c.gridx = 0;
        c.gridy = 0;

        JButton button = new JButton("BEBIDAS");
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(350, 100));
        //button.setBorder(new ButtonStyle(40));
        button.setBackground(new Color(97,104,135));
        jp2.add(button,c);
        menuViewListener listener1 = new menuViewListener(centralPanel,topPanel,jp2,jf);
        button.addActionListener(listener1);

        c.gridx = 1;
        c.gridy = 0;

        JButton button2 = new JButton("ENTRANTES");
        button2.setForeground(Color.WHITE);
        button2.setPreferredSize(new Dimension(350, 100));
        //button2.setBorder(new ButtonStyle(40));
        button2.setBackground(new Color(97,104,135));
        jp2.add(button2,c);
        menuViewListener listener2 = new menuViewListener(centralPanel,topPanel,jp2,jf);
        button2.addActionListener(listener2);

        c.gridx = 0;
        c.gridy = 1;

        JButton button3 = new JButton("ENSALADAS");
        button3.setForeground(Color.WHITE);
        button3.setPreferredSize(new Dimension(350, 100));
        //button3.setBorder(new ButtonStyle(40));
        button3.setBackground(new Color(97,104,135));
        jp2.add(button3,c);
        menuViewListener listener3 = new menuViewListener(centralPanel,topPanel,jp2,jf);
        button3.addActionListener(listener3);

        c.gridx = 1;
        c.gridy = 1;

        JButton button4 = new JButton("PESCADOS");
        button4.setForeground(Color.WHITE);
        button4.setPreferredSize(new Dimension(350, 100));
        //button4.setBorder(new ButtonStyle(40));
        button4.setBackground(new Color(97,104,135));
        jp2.add(button4,c);
        menuViewListener listener4 = new menuViewListener(centralPanel,topPanel,jp2,jf);
        button4.addActionListener(listener4);

        c.gridx = 0;
        c.gridy = 2;

        JButton button5 = new JButton("CARNES");
        button5.setForeground(Color.WHITE);
        button5.setPreferredSize(new Dimension(350, 100));
        //button5.setBorder(new ButtonStyle(40));
        button5.setBackground(new Color(97,104,135));
        jp2.add(button5,c);
        menuViewListener listener5 = new menuViewListener(centralPanel,topPanel,jp2,jf);
        button5.addActionListener(listener5);

        c.gridx = 1;
        c.gridy = 2;

        JButton button6 = new JButton("POSTRES");
        button6.setForeground(Color.WHITE);
        button6.setPreferredSize(new Dimension(350, 100));
        //button6.setBorder(new ButtonStyle(40));
        button6.setBackground(new Color(97,104,135));
        jp2.add(button6,c);
        menuViewListener listener6 = new menuViewListener(centralPanel,topPanel,jp2,jf);
        button6.addActionListener(listener6);

        c.gridx = 0;
        c.gridy = 3;

        JButton button7 = new JButton("MENU NIÑOS");
        button7.setForeground(Color.WHITE);
        button7.setPreferredSize(new Dimension(350, 100));
        //button7.setBorder(new ButtonStyle(40));
        button7.setBackground(new Color(97,104,135));
        jp2.add(button7,c);
        menuViewListener listener7 = new menuViewListener(centralPanel,topPanel,jp2,jf);
        button7.addActionListener(listener7);

        c.gridx = 1;
        c.gridy = 3;

        JButton button8 = new JButton("COMBINADOS");
        button8.setForeground(Color.WHITE);
        button8.setPreferredSize(new Dimension(350, 100));
        //button8.setBorder(new ButtonStyle(40));
        button8.setBackground(new Color(97,104,135));
        jp2.add(button8,c);
        menuViewListener listener8 = new menuViewListener(centralPanel,topPanel,jp2,jf);
        button8.addActionListener(listener8);

//      Creamos los botones que van en el inferior del panel
        FlowLayout fl = new FlowLayout();

        fl.setAlignment(FlowLayout.CENTER);
        fl.setHgap(5);
        fl.setVgap(100);

        jp4.setLayout(fl);

        JButton cancelButton = new JButton("CANCELAR CUENTA");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setPreferredSize(new Dimension(250, 100));
        cancelButton.setBackground(Color.red);
        menuPayButtonsListener cancelListener = new menuPayButtonsListener(1,jf);
        cancelButton.addActionListener(cancelListener);

        JButton paySelectedButton = new JButton("PAGAR SELECCIONADOS");
        paySelectedButton.setForeground(Color.WHITE);
        paySelectedButton.setPreferredSize(new Dimension(250, 100));
        paySelectedButton.setBackground(Color.green);

        JButton payAllButton = new JButton("PAGAR TODO");
        payAllButton.setForeground(Color.WHITE);
        payAllButton.setPreferredSize(new Dimension(250, 100));
        payAllButton.setBackground(Color.green);
        menuPayButtonsListener payAllListener = new menuPayButtonsListener(2,jf);
        payAllButton.addActionListener(payAllListener);

//      Añadimos cada elemento a su panel
        jp4.add(cancelButton);
        jp4.add(paySelectedButton);
        jp4.add(payAllButton);

        bottomPanel.add(jp3);
        bottomPanel.add(jp4);

//      LEEMOS DE LA BASE DE DATOS LO QUE LLEVA EN LA CUENTA Y LO PONEMOS EN EL PANEL SUPERIOR BLANCO

        jp1.add(topPanel);
        jp1.add(bottomPanel);

        centralPanel.add(jp1);
        centralPanel.add(jp2);

        jf.add(centralPanel);
        jf.setSize(1920,1080);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        jf.setJMenuBar(menubar);
        jf.validate();
        jf.repaint();

    }
}
