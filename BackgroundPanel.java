import javax.swing.*;
import java.awt.*;

class BackgroundPanel extends JPanel {

    BufferedImage image;

    public BackgroundPanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();

        int w = d.width > image.getWidth() ? d.width : image.getWidth();
        int h = d.height > image.getHeight() ? d.height : image.getHeight();

        return new Dimension(w, h);
    }
}
