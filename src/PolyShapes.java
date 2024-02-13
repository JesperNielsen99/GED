import javax.swing.*;
import java.awt.*;

public class PolyShapes extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new PolyShapes();
        frame.setSize(700,700);
        frame.setTitle("PolyShapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public PolyShapes() { add(new DrawPanel()); }

    class DrawPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawLine(10,10, 100, 150);
            g.drawLine(100, 200, 200, 200);
            g.drawLine(200, 200, 200, 400);
            g.drawLine(200, 400, 100, 200);
            g.fillOval(200, 100, 3, 3);
            g.drawRect(300, 100, 50, 50);
            g.drawOval(250, 250, 100, 100);

            //Star
            g.drawLine(400, 150, 425, 75);
            g.drawLine(425, 75, 450, 150);
            g.drawLine(450, 150, 390, 105);
            g.drawLine(390, 105, 460, 105);
            g.drawLine(460, 105, 400, 150);
        }
    }
}
