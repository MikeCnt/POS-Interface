import javax.swing.*;
import java.awt.*;

/**
 * Menu view for the POS (Point of Sale), where we can select the items of the costumer's menu
 */

public class menuView {
    public static void main(String[] args){

        JFrame jf = new JFrame();
        jf.setTitle("Vista Menu");

//      Añadimos la bara del menu superior y las acciones que la controlan
        JMenuBar menubar = new JMenuBar();
        JMenuItem calculator = new JMenuItem();

        Image image = new ImageIcon("images/Calculator.png").getImage();
        calculator.setHorizontalTextPosition(SwingConstants.CENTER);
        calculator.setVerticalTextPosition(SwingConstants.BOTTOM);
        calculator.setIcon(new ImageIcon(image));

        menubar.add(calculator);

        MyJMenuListener jmListener = new MyJMenuListener(calculator);

        calculator.addActionListener(jmListener);

//      Creamos la primera division en dos del frame
        GridLayout gl = new GridLayout(1,2);
        JPanel centralPanel = new JPanel(gl);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();

        jp1.setBackground(Color.WHITE);
        jp2.setBackground(new Color(73,115,203));

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

        JButton paySelectedButton = new JButton("PAGAR SELECCIONADOS");
        paySelectedButton.setForeground(Color.WHITE);
        paySelectedButton.setPreferredSize(new Dimension(250, 100));
        paySelectedButton.setBackground(Color.green);

        JButton payAllButton = new JButton("PAGAR TODO");
        payAllButton.setForeground(Color.WHITE);
        payAllButton.setPreferredSize(new Dimension(250, 100));
        payAllButton.setBackground(Color.green);

//      Añadimos cada elemento a su panel
        jp4.add(cancelButton);
        jp4.add(paySelectedButton);
        jp4.add(payAllButton);

        bottomPanel.add(jp3);
        bottomPanel.add(jp4);

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
