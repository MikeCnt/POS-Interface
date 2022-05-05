import javax.swing.*;
import java.awt.*;

public class paintBackground {
    private JFrame frame;

    public JFrame create(JFrame panel) {
        frame = panel;
        frame.getContentPane().add(createContent());

        return frame;
    }

    private Component createContent() {
        final Image image = requestImage();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
                setOpaque(false);
            }
        };

        return panel;
    }

    private Image requestImage() {
        
        Image image = null;
        image = new ImageIcon("images/FondoTPV.jpg").getImage();

        return image;
    }
}
