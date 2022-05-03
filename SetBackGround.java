import java.awt.*;
import javax.swing.*;
public class SetBackGround extends JFrame
{
	public SetBackGround() 
	{	
		setTitle("Primera Vista");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PaintBackGround pb = new PaintBackGround();// Crear una instancia de un objeto
		
        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(50, 50, 50, 50);

		JPanel jp = new JPanel(gl);

        int nWorkers = 6;
        
        if (nWorkers % 2 == 0){

                int aux = nWorkers / 2;
                for (int i = 0; i < aux; i ++) {
                        for (int j = 0; j < 2; j ++) {

                                c.gridx = j;
                                c.gridy = i;
                                
                                JButton button = new JButton("PUTA");
                                button.setPreferredSize(new Dimension(350, 100));
                                jp.add(button,c);
                                
                        }
                }
        }

		setContentPane(jp);
        jp.add(pb);
		jp.setSize(1920, 1080);
		
		
	}

	public static void main(String[] args){
		new SetBackGround();
	}
}
class PaintBackGround extends JPanel
{
	public PaintBackGround() 
	{
		super();
		setLayout(null);
	}
	public void paintComponent(Graphics g1) 
	{
		Graphics2D g= (Graphics2D)g1;
		super.paintComponent(g);
		int width= getWidth();// Establecer el ancho al ancho establecido
		int height=getHeight();// Controla la altura a la altura establecida
		GradientPaint paint=new GradientPaint(0,0,Color.cyan,0,height,Color.blue);// Crear una instancia de un objeto degradado
		g.setPaint(paint);// Agregar modo de relleno de dibujo
		g.fillRect(0, 0, width, height);// Establecer la interfaz de relleno del rectángulo
		
	}
}
