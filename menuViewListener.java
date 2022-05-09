import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class menuViewListener implements ActionListener{
    
    private JPanel centralPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JFrame frame;

    public menuViewListener(JPanel centralPanel, JPanel leftPanel, JPanel rightPanel, JFrame frame){
        this.centralPanel = centralPanel;
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;
        this.frame = frame;
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // ACCION para añadir items a la cuenta

        if(e.getActionCommand().equals("BEBIDAS") || e.getActionCommand().equals("DRINKS")){
            
            JPanel newPanel = new JPanel();
            newPanel.setBackground(new Color(73,115,203));

            GridBagLayout gl = new GridBagLayout();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(50, 50, 50, 50);
            newPanel.setLayout(gl);

            c.gridx = 0;
            c.gridy = 0;

            JButton button = new JButton("COCA-COLA");
            button.setForeground(Color.WHITE);
            button.setPreferredSize(new Dimension(350, 100));
            button.setBackground(new Color(97,104,135));
            newPanel.add(button,c);

            c.gridx = 1;
            c.gridy = 0;

            JButton button1 = new JButton("COCA-COLA LIGHT");
            button1.setForeground(Color.WHITE);
            button1.setPreferredSize(new Dimension(350, 100));
            button1.setBackground(new Color(97,104,135));
            newPanel.add(button1,c);

            c.gridx = 0;
            c.gridy = 1;

            JButton button2 = new JButton("FANTA");
            button2.setForeground(Color.WHITE);
            button2.setPreferredSize(new Dimension(350, 100));
            button2.setBackground(new Color(97,104,135));
            newPanel.add(button2,c);

            c.gridx = 1;
            c.gridy = 1;

            JButton button3 = new JButton("AGUA");
            button3.setForeground(Color.WHITE);
            button3.setPreferredSize(new Dimension(350, 100));
            button3.setBackground(new Color(97,104,135));
            newPanel.add(button3,c);

            menuButtonListener listener1 = new menuButtonListener("COCA-COLA",centralPanel,rightPanel,newPanel,frame);
            button.addActionListener(listener1);

            menuButtonListener listener2 = new menuButtonListener("COCA-COLA LIGHT",centralPanel,rightPanel,newPanel,frame);
            button1.addActionListener(listener2);

            menuButtonListener listener3 = new menuButtonListener("FANTA",centralPanel,rightPanel,newPanel,frame);
            button2.addActionListener(listener3);

            menuButtonListener listener4 = new menuButtonListener("AGUA",centralPanel,rightPanel,newPanel,frame);
            button3.addActionListener(listener4);

            centralPanel.remove(rightPanel);
            centralPanel.add(newPanel);

            frame.revalidate();

        }else if(e.getActionCommand().equals("ENTRANTES") || e.getActionCommand().equals("STARTERS")){
            
            JPanel newPanel = new JPanel();
            newPanel.setBackground(new Color(73,115,203));

            GridBagLayout gl = new GridBagLayout();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(50, 50, 50, 50);
            newPanel.setLayout(gl);

            c.gridx = 0;
            c.gridy = 0;

            JButton button = new JButton("CROQUETAS");
            button.setForeground(Color.WHITE);
            button.setPreferredSize(new Dimension(350, 100));
            button.setBackground(new Color(97,104,135));
            newPanel.add(button,c);

            c.gridx = 1;
            c.gridy = 0;

            JButton button1 = new JButton("RACION JAMON");
            button1.setForeground(Color.WHITE);
            button1.setPreferredSize(new Dimension(350, 100));
            button1.setBackground(new Color(97,104,135));
            newPanel.add(button1,c);

            c.gridx = 0;
            c.gridy = 1;

            JButton button2 = new JButton("PAN CON ALIOLI");
            button2.setForeground(Color.WHITE);
            button2.setPreferredSize(new Dimension(350, 100));
            button2.setBackground(new Color(97,104,135));
            newPanel.add(button2,c);

            c.gridx = 1;
            c.gridy = 1;

            menuButtonListener listener1 = new menuButtonListener("CROQUETAS",centralPanel,rightPanel,newPanel,frame);
            button.addActionListener(listener1);

            menuButtonListener listener2 = new menuButtonListener("RACION JAMON",centralPanel,rightPanel,newPanel,frame);
            button1.addActionListener(listener2);

            menuButtonListener listener3 = new menuButtonListener("PAN CON ALIOLI",centralPanel,rightPanel,newPanel,frame);
            button2.addActionListener(listener3);

            centralPanel.remove(rightPanel);
            centralPanel.add(newPanel);

            frame.revalidate();
        }else if(e.getActionCommand().equals("ENSALADAS") || e.getActionCommand().equals("SALADS")){
            
            JPanel newPanel = new JPanel();
            newPanel.setBackground(new Color(73,115,203));

            GridBagLayout gl = new GridBagLayout();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(50, 50, 50, 50);
            newPanel.setLayout(gl);

            c.gridx = 0;
            c.gridy = 0;

            JButton button = new JButton("ENSALADA MIXTA");
            button.setForeground(Color.WHITE);
            button.setPreferredSize(new Dimension(350, 100));
            button.setBackground(new Color(97,104,135));
            newPanel.add(button,c);

            c.gridx = 1;
            c.gridy = 0;

            JButton button1 = new JButton("ENSALADA CESAR");
            button1.setForeground(Color.WHITE);
            button1.setPreferredSize(new Dimension(350, 100));
            button1.setBackground(new Color(97,104,135));
            newPanel.add(button1,c);

            c.gridx = 0;
            c.gridy = 1;

            JButton button2 = new JButton("ENSALADA DE LA CASA");
            button2.setForeground(Color.WHITE);
            button2.setPreferredSize(new Dimension(350, 100));
            button2.setBackground(new Color(97,104,135));
            newPanel.add(button2,c);

            c.gridx = 1;
            c.gridy = 1;

            menuButtonListener listener1 = new menuButtonListener("ENSALADA MIXTA",centralPanel,rightPanel,newPanel,frame);
            button.addActionListener(listener1);

            menuButtonListener listener2 = new menuButtonListener("ENSALADA CESAR",centralPanel,rightPanel,newPanel,frame);
            button1.addActionListener(listener2);

            menuButtonListener listener3 = new menuButtonListener("ENSALADA DE LA CASA",centralPanel,rightPanel,newPanel,frame);
            button2.addActionListener(listener3);

            centralPanel.remove(rightPanel);
            centralPanel.add(newPanel);

            frame.revalidate();
        }else if(e.getActionCommand().equals("PESCADOS") || e.getActionCommand().equals("FISHES")){
            
            JPanel newPanel = new JPanel();
            newPanel.setBackground(new Color(73,115,203));

            GridBagLayout gl = new GridBagLayout();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(50, 50, 50, 50);
            newPanel.setLayout(gl);

            c.gridx = 0;
            c.gridy = 0;

            JButton button = new JButton("MERLUZA");
            button.setForeground(Color.WHITE);
            button.setPreferredSize(new Dimension(350, 100));
            button.setBackground(new Color(97,104,135));
            newPanel.add(button,c);

            c.gridx = 1;
            c.gridy = 0;

            JButton button1 = new JButton("ATUN PLANCHA");
            button1.setForeground(Color.WHITE);
            button1.setPreferredSize(new Dimension(350, 100));
            button1.setBackground(new Color(97,104,135));
            newPanel.add(button1,c);

            c.gridx = 0;
            c.gridy = 1;

            JButton button2 = new JButton("SALMON");
            button2.setForeground(Color.WHITE);
            button2.setPreferredSize(new Dimension(350, 100));
            button2.setBackground(new Color(97,104,135));
            newPanel.add(button2,c);
            
            c.gridx = 1;
            c.gridy = 1;

            JButton button3 = new JButton("CALAMARES");
            button3.setForeground(Color.WHITE);
            button3.setPreferredSize(new Dimension(350, 100));
            button3.setBackground(new Color(97,104,135));
            newPanel.add(button3,c);


            menuButtonListener listener1 = new menuButtonListener("MERLUZA",centralPanel,rightPanel,newPanel,frame);
            button.addActionListener(listener1);

            menuButtonListener listener2 = new menuButtonListener("ATUN PLANCHA",centralPanel,rightPanel,newPanel,frame);
            button1.addActionListener(listener2);

            menuButtonListener listener3 = new menuButtonListener("SALMON",centralPanel,rightPanel,newPanel,frame);
            button2.addActionListener(listener3);

            menuButtonListener listener4 = new menuButtonListener("CALAMARES",centralPanel,rightPanel,newPanel,frame);
            button3.addActionListener(listener4);


            centralPanel.remove(rightPanel);
            centralPanel.add(newPanel);

            frame.revalidate();
        }else if(e.getActionCommand().equals("CARNES") || e.getActionCommand().equals("MEATS")){
            
            JPanel newPanel = new JPanel();
            newPanel.setBackground(new Color(73,115,203));

            GridBagLayout gl = new GridBagLayout();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(50, 50, 50, 50);
            newPanel.setLayout(gl);

            c.gridx = 0;
            c.gridy = 0;

            JButton button = new JButton("ENTRECOT");
            button.setForeground(Color.WHITE);
            button.setPreferredSize(new Dimension(350, 100));
            button.setBackground(new Color(97,104,135));
            newPanel.add(button,c);

            c.gridx = 1;
            c.gridy = 0;

            JButton button1 = new JButton("POLLO ASADO");
            button1.setForeground(Color.WHITE);
            button1.setPreferredSize(new Dimension(350, 100));
            button1.setBackground(new Color(97,104,135));
            newPanel.add(button1,c);

            c.gridx = 0;
            c.gridy = 1;

            JButton button2 = new JButton("CHURRASCO");
            button2.setForeground(Color.WHITE);
            button2.setPreferredSize(new Dimension(350, 100));
            button2.setBackground(new Color(97,104,135));
            newPanel.add(button2,c);
            
            c.gridx = 1;
            c.gridy = 1;

            JButton button3 = new JButton("PLUMA");
            button3.setForeground(Color.WHITE);
            button3.setPreferredSize(new Dimension(350, 100));
            button3.setBackground(new Color(97,104,135));
            newPanel.add(button3,c);


            menuButtonListener listener1 = new menuButtonListener("ENTRECOT",centralPanel,rightPanel,newPanel,frame);
            button.addActionListener(listener1);

            menuButtonListener listener2 = new menuButtonListener("POLLO ASADO",centralPanel,rightPanel,newPanel,frame);
            button1.addActionListener(listener2);

            menuButtonListener listener3 = new menuButtonListener("CHURRASCO",centralPanel,rightPanel,newPanel,frame);
            button2.addActionListener(listener3);

            menuButtonListener listener4 = new menuButtonListener("PLUMA",centralPanel,rightPanel,newPanel,frame);
            button3.addActionListener(listener4);

            
            centralPanel.remove(rightPanel);
            centralPanel.add(newPanel);

            frame.revalidate();
        }else if(e.getActionCommand().equals("POSTRES") || e.getActionCommand().equals("DESSERTS")){
            
            JPanel newPanel = new JPanel();
            newPanel.setBackground(new Color(73,115,203));

            GridBagLayout gl = new GridBagLayout();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(50, 50, 50, 50);
            newPanel.setLayout(gl);

            c.gridx = 0;
            c.gridy = 0;

            JButton button = new JButton("NATILLAS");
            button.setForeground(Color.WHITE);
            button.setPreferredSize(new Dimension(350, 100));
            button.setBackground(new Color(97,104,135));
            newPanel.add(button,c);

            c.gridx = 1;
            c.gridy = 0;

            JButton button1 = new JButton("FLAN DE HUEVO");
            button1.setForeground(Color.WHITE);
            button1.setPreferredSize(new Dimension(350, 100));
            button1.setBackground(new Color(97,104,135));
            newPanel.add(button1,c);

            c.gridx = 0;
            c.gridy = 1;

            JButton button2 = new JButton("ARROZ CON LECHE");
            button2.setForeground(Color.WHITE);
            button2.setPreferredSize(new Dimension(350, 100));
            button2.setBackground(new Color(97,104,135));
            newPanel.add(button2,c);
            
            
            menuButtonListener listener1 = new menuButtonListener("NATILLAS",centralPanel,rightPanel,newPanel,frame);
            button.addActionListener(listener1);

            menuButtonListener listener2 = new menuButtonListener("FLAN DE HUEVO",centralPanel,rightPanel,newPanel,frame);
            button1.addActionListener(listener2);

            menuButtonListener listener3 = new menuButtonListener("ARROZ CON LECHE",centralPanel,rightPanel,newPanel,frame);
            button2.addActionListener(listener3);

            
            centralPanel.remove(rightPanel);
            centralPanel.add(newPanel);

            frame.revalidate();
        }else if(e.getActionCommand().equals("MENU NIÑOS") || e.getActionCommand().equals("FOR KIDS")){
            
            JPanel newPanel = new JPanel();
            newPanel.setBackground(new Color(73,115,203));

            GridBagLayout gl = new GridBagLayout();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(50, 50, 50, 50);
            newPanel.setLayout(gl);

            c.gridx = 0;
            c.gridy = 0;

            JButton button = new JButton("MENU NIÑOS");
            button.setForeground(Color.WHITE);
            button.setPreferredSize(new Dimension(350, 100));
            button.setBackground(new Color(97,104,135));
            newPanel.add(button,c);

            c.gridx = 1;
            c.gridy = 0;

            JButton button1 = new JButton("HAMBURGUESA");
            button1.setForeground(Color.WHITE);
            button1.setPreferredSize(new Dimension(350, 100));
            button1.setBackground(new Color(97,104,135));
            newPanel.add(button1,c);

            c.gridx = 0;
            c.gridy = 1;

            JButton button2 = new JButton("FILETE EMPANADO");
            button2.setForeground(Color.WHITE);
            button2.setPreferredSize(new Dimension(350, 100));
            button2.setBackground(new Color(97,104,135));
            newPanel.add(button2,c);
            
            
            menuButtonListener listener1 = new menuButtonListener("MENU NIÑOS",centralPanel,rightPanel,newPanel,frame);
            button.addActionListener(listener1);

            menuButtonListener listener2 = new menuButtonListener("HAMBURGUESA",centralPanel,rightPanel,newPanel,frame);
            button1.addActionListener(listener2);

            menuButtonListener listener3 = new menuButtonListener("FILETE EMPANADO",centralPanel,rightPanel,newPanel,frame);
            button2.addActionListener(listener3);

            
            centralPanel.remove(rightPanel);
            centralPanel.add(newPanel);

            frame.revalidate();
        }else if(e.getActionCommand().equals("COMBINADOS") || e.getActionCommand().equals("COMBINED MEALS")){
            
            JPanel newPanel = new JPanel();
            newPanel.setBackground(new Color(73,115,203));

            GridBagLayout gl = new GridBagLayout();
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(50, 50, 50, 50);
            newPanel.setLayout(gl);

            c.gridx = 0;
            c.gridy = 0;

            JButton button = new JButton("HUEVOS PATATAS Y PIMIENTOS");
            button.setForeground(Color.WHITE);
            button.setPreferredSize(new Dimension(350, 100));
            button.setBackground(new Color(97,104,135));
            newPanel.add(button,c);

            c.gridx = 1;
            c.gridy = 0;

            JButton button1 = new JButton("COMBINADO DE CARNES");
            button1.setForeground(Color.WHITE);
            button1.setPreferredSize(new Dimension(350, 100));
            button1.setBackground(new Color(97,104,135));
            newPanel.add(button1,c);

            c.gridx = 0;
            c.gridy = 1;

            JButton button2 = new JButton("PLATO CAMPERO");
            button2.setForeground(Color.WHITE);
            button2.setPreferredSize(new Dimension(350, 100));
            button2.setBackground(new Color(97,104,135));
            newPanel.add(button2,c);
            
            
            menuButtonListener listener1 = new menuButtonListener("HUEVOS PATATAS Y PIMIENTOS",centralPanel,rightPanel,newPanel,frame);
            button.addActionListener(listener1);

            menuButtonListener listener2 = new menuButtonListener("COMBINADO DE CARNES",centralPanel,rightPanel,newPanel,frame);
            button1.addActionListener(listener2);

            menuButtonListener listener3 = new menuButtonListener("PLATO CAMPERO",centralPanel,rightPanel,newPanel,frame);
            button2.addActionListener(listener3);

            
            centralPanel.remove(rightPanel);
            centralPanel.add(newPanel);

            frame.revalidate();
        }
    }
}